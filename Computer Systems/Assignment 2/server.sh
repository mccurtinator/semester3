#!/bin/bash

serverpipe=/tmp/serverpipe

 # create server pipe if it doesn't exist 
if [[ ! -p $serverpipe ]]; then
    mkfifo $serverpipe	
fi
	
touch serverout.txt # create serverout.txt (temporary txt file to store script output)
> serverout.txt
trap "rm -f $serverpipe" EXIT # delete pipe on exit (extra challenge 3.1)

while true; do


	# read a command from the pipe
	read -a input <$serverpipe
    
	id=${input[0]}
    request=${input[1]}
    arg2=${input[2]}
    arg3=${input[3]}


	# check if $id is not empty
	if [ -n $id ]; then

		 userpipe=/tmp/pipe$id

		# clear serverout.txt
		#cat /dev/null > serverout.txt

		case $request in
			create)
				#execute the command create and send the standard output in the user $id pipe
				./create.sh $id
				;;
			add)
				#./acquire.sh $id
				./add.sh $id $arg2
				#./release.sh $id
				;;
			post)
				#./acquire.sh $id
				./post.sh $id $arg2 "$arg3"
				#./release.sh $id
				;;
			display)
				#./acquire.sh $id
				# inform the client that we will start senting the content of the wall
				echo "start_of_the_file"
				#execute the display command and save the result in a variable
				clientWall=`./display.sh $arg2`
				# send the content of the wall stored in clientWall to the client line by line
				IFS=$'\n' # changing the delimiter to a new line
				for line in $clientWall; do
					echo "$line" >> serverout.txt
				done
				IFS=$' ' # bring back the delimiter into its original state (i.e., space)
				echo "end_of_the_file" 
				#./release.sh $id
				;;

			*)
				echo "These are the only valid commands: {create|add|post|display}"
				#exit 1
		esac

		# write serverout.txt to user pipe

		while IFS= read -r line; do
			echo "$line"
    		echo "$line" >> $userpipe
		done < serverout.txt

		# clear serverout.txt again
		> serverout.txt

	fi
done
exit 0

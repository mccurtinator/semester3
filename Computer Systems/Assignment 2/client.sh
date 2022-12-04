#!/bin/bash

id=$1
while [ -n $1 ]
        do
           echo "Enter command (format: command arg2 arg3):"
           read command arg2 arg3

           # make address for user pipe
           userpipe=/tmp/pipe$id # concatenation: /tmp/pipe[id]
           
           # check here if arguments are valid (NOT IMPLEMENTED)

           trap "rm -f $userpipe" EXIT # delete pipe on exit (extra challenge 3.1)

            # create user pipe if it doesn't exist 
            if [[ ! -p $userpipe ]]; then
                mkfifo $userpipe
            fi

           serverpipe=/tmp/serverpipe

            echo "$id $command $arg2 $arg3" > $serverpipe # write arguments to server pipe

            #  read and modify server output

            while IFS= read -r line; do
                userFriendlyLine=$line

                userFriendlyLine=${userFriendlyLine//"nok"/"ERROR"}
                userFriendlyLine=${userFriendlyLine//"ok"/"SUCCESS"}

    		    echo "$userFriendlyLine" 
		    done < $userpipe


        done



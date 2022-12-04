#!/bin/bash

sender=$1
receiver=$2
message="$3"


# echo $@ # output arguments (for testing)

# set arguments as variables to make code more readable

# check if sender exists
if [ -d "$sender" ]; then

    # check if receiver exists
    if [ -d "$receiver" ]; then

        # check if sender is a friend of receiver
        if grep -q "$sender" $receiver/friends.txt || grep -q "$receiver" $sender/friends.txt; then

            # append message to wall
            echo "$sender: "$message"" >> $receiver/wall.txt          

            echo "ok: message posted!"

        else 
            echo "nok: user ’$sender’ is not a friend of ’$receiver"
        fi  

    else
        echo "nok: user ’$receiver’ does not exist"
    fi

else 
    echo "nok: user ’$sender’ does not exist"
fi

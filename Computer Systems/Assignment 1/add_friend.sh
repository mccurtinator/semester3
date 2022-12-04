#!/bin/bash

# set arguments as variables to make code more readable
user=$1
friend=$2

# check if user directory exists
if [ -d "$user" ]; then

    # check if friend to be added's directory exists
    if [ -d "$friend" ]; then

        # add user to friend list if they are not already there
        if  ! grep "$friend" $user/friends.txt; then
            echo  $friend >> $user/friends.txt
            echo "Friend added"
        else
            echo "Friendship already exists"
        fi
        
    else
        echo "Friend does not exist"
    fi
else
    echo "User does not exist"
fi
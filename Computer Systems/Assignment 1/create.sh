#!/bin/bash

# set argument as variable to make code more readable
user=$1

# check for valid input
if [ $# -ne 1 ]; then
    echo "nok: No identifier provided"
    exit 1

# check if user exists already
elif [ -d $user ]; then
    echo "nok: User exists already"
    exit 1


elif ! [ -d $user ]; then
    # create user folder and text files
    mkdir $user
    cd $user
    touch friends.txt
    touch wall.txt
    echo "User created"
fi
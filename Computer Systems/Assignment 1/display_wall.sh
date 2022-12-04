#!/bin/bash

# set argument as variable to make code more readable
id=$1

# check if user exists
if [ -d "$id" ]; then

    # display user wall
    echo "start_of_file"
    cat $id/wall.txt
    echo "end_of_file"

    else 
        echo "nok: user ’$id does not exist"
fi
#!/bin/bash

# infinite loop, exit with ^C
while true
    do

    echo "Accepted Commands: {create|add|post|display}"

    # read request as array
    read -a input

    # set arguments as variables to make code more readable
    request=${input[0]}
    id=${input[1]}
    arg2=${input[2]}
    arg3=${input[3]}


    # call the different scripts based on the request type
    case "$request" in 
        create)
            ./create.sh $id 
        ;;
        add)
            ./add_friend.sh $id $arg2
        ;;
        post)
            ./post_messages.sh $id $arg2 "$arg3"
        ;;
        display)
            ./display_wall.sh $id
        ;;
        *)

        exit 1
    esac
done
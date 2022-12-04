#!/bin/bash

if [ -z "$1" ]; then
    echo "Usage $0 mutex-name" >&1
    exit 1
else
    # the 'link' (ln) system call is supposed to be atomic on a local file system
    while ! ln -s "$1" "$2" 2>/dev/null; do
        sleep 1 # hold the lock
    done

    exit 0
fi 
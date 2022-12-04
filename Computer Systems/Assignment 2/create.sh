#!/bin/bash

#checking that there is at leat one argument
if [ $# -eq 0 ]; then
	echo "nok: no identifier provided" > serverout.txt
	exit 1
fi 

id=$1

#if the user $id does not exists
if [ -d $id ]; then
	echo "nok: user $id already exists" > serverout.txt
	exit 2
else
	#otherwise create the user account
	mkdir $id
	touch $id/wall
	touch $id/friends
	echo "ok: user $id created!" > serverout.txt
fi
exit 0

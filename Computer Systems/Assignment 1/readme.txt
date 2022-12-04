---CT213 Assignment 1: BashBook---
a program by Michael Mc Curtin and Tomasz Gruca 

Each user is represented by a directory. This directory contains their friends list (friends.txt) and their "wall" (wall.txt) where friends can post messages.

The program is run on a server (server.sh). The server is started via the bash command "./server.sh".

Note: All arguments in these examples are denoted $argument.

1.  To add a new user, type "create $username".

2.  To add a friend to a user's friend list, type "add $username $friend".

3.  To post a message on a user's wall, type "post $sender $receiver "$message"".
    Note: All words in a message must be separated by backslashes. e.g. "Hello there" becomes "Hello\ there".

4.  To display a user's wall, type display $username.

Happy bashing!
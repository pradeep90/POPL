#!/bin/bash

# The MiniJava translator source file.
prog_dir=/home/pradeep/Dropbox/Acads/POPL/Code/Mini-Java/CS09B021/

# Directory with MiniJava files to be translated.
mini_dir=/home/pradeep/Dropbox/Acads/POPL/Code/Mini-Java/Mini-Java-Code

gen_dir=$(mktemp -d)

cd $mini_dir

# BUG: These two files give NullPointerExceptions:
# TreeVisitor.java BinaryTree.java

for file in *.java; do

    name=`basename $file .java`

    cd $prog_dir

    javac P1.java

    java P1 < $mini_dir/$file > $gen_dir/$file

    cd $mini_dir
    expected=$(javac $file && java $name)

    cd $gen_dir
    actual=$(javac $file && java $name)

    echo $file
    echo "expected: " $expected
    echo "Actual: " $actual

    if [ "$expected" == "$actual" ]; then
	echo Match
    else
	echo NOT MATCHING
    fi


    # sleep 1
done

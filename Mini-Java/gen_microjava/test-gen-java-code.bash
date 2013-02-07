#!/bin/bash

mini_dir=/home/pradeep/Dropbox/Acads/POPL/Code/Mini-Java/Mini-Java-Code/

gen_dir=/home/pradeep/Dropbox/Acads/POPL/Code/Mini-Java/gen_microjava/

for file in *.java; do
    name=`basename $file .java`

    cd $mini_dir
    op1=$(javac $file && java $name)

    cd $gen_dir
    op2=$(javac $file && java $name)

    echo op1 $op1
    echo op2 $op2

    if [ "$op1" == "$op2" ]; then
	echo Match
    else
	echo NOT MATCHING
    fi
    
    
    # sleep 1
done

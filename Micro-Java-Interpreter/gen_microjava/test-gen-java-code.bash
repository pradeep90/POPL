#!/bin/bash

code_dir=/home/spradeep/Downloads/POPL/Micro-Java-Interpreter/gen_microjava/
prog_dir=/home/spradeep/Downloads/POPL/Micro-Java-Interpreter/

cd $code_dir

ctr=0
corr=0

for file in *.java; do
    name=`basename $file .java`

    echo $name

    cd $prog_dir

    actual=$(java -cp class P2 < $code_dir/$file)
    # actual=Yo

    cd $code_dir
    expected=$(javac $file && java $name)

    echo expected $expected
    echo actual $actual

    ctr=$((ctr + 1))
    if [ "$expected" == "$actual" ]; then
	corr=$((corr + 1))
	echo Match
    else
	echo $name NOT MATCHING
    fi
    
    # sleep 1
done

echo corr $corr
echo ctr $ctr

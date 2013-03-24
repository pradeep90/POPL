#!/bin/bash

root_dir=/home/pradeep/Acads/POPL/Code/CPS-Transformer

cd $root_dir

micro_dir=$root_dir/Example-Microjava

gen_dir=$root_dir/Generated-Nanojava

prog_dir=$root_dir/src

cd $micro_dir

for file in *.java TA-MicroJava-Test-Cases/*.java; do
    name=`basename $file .java`
    base_dir=`dirname $file`

    # echo $name
    echo $file
    # echo $base_dir
    

    # cd $prog_dir
    # javac P1.java
    # java P5 < $micro_dir/$file > $gen_dir/$file

    cd $micro_dir/$base_dir
    op1=$(javac $name.java && java $name)

    cd $gen_dir/$base_dir
    op2=$(javac $name.java && java $name)

    echo op1 $op1
    echo op2 $op2

    if [ "$op1" == "$op2" ]; then
    	echo Match
    else
    	echo NOT MATCHING
    fi
    
    
    # sleep 1
done

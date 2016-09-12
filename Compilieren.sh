#!/bin/sh
DIR_BIN="bin/"
DIR_SRC="src/"
TMP_FILE="sources.txt"
if [ ! -d $DIR_SRC ]
	then
		echo "There is no 'src' folder, exiting..."
		exit 1
	else
	if [ -d $DIR_BIN ]
		then
			echo "'$DIR_BIN' already exists, clean up..."
			rm -fvr $DIR_BIN
			echo "Finnished with clean up."
			mkdir $DIR_BIN
		else
			echo "'$DIR_BIN' doesn´t exist, creating..."
			mkdir $DIR_BIN
			echo "'$DIR_BIN' has been created"
	fi
	echo "fuer welche java version soll compiliert werden:"
	read ch
	echo "Scanning for java source code..."
	find -name *.java > $TMP_FILE
	echo "Finnished with scanning for java source code."
	echo "copy recources to '$DIR_BIN'"
	echo "copy recources to '$DIR_BIN'"
	cp -fr $DIR_SRC* $DIR_BIN
	cd $DIR_BIN
	find -iname "*.java" -exec rm {} \;
	cd ..
	echo "Finnished with copy recources to '$DIR_BIN'"
	echo "Start compiling..."
	javac -verbose -source "$ch" -target "$ch" -d $DIR_BIN @$TMP_FILE
	echo "Finnished with compiling."
	echo "clean up..."
	rm -fv $TMP_FILE
	echo "Finnished clean up."
fi
echo "Done."


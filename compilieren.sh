#!/bin/sh
DIR_BIN="bin/"
DIR_SRC="src/"
TMP_FILE="sources.txt"
if [ ! -d $DIR_SRC ]
	then
		echo -e "\E[31mThere is no 'src' folder, exiting...\e[0m"
		exit 1
	else
	if [ -d $DIR_BIN ]
		then
			echo -e "\E[33m'$DIR_BIN' already exists, clean up...\e[31m"
			rm -fvr $DIR_BIN
			echo -e "\e[0mFinnished with clean up."
			mkdir $DIR_BIN
		else
			echo -e "\E[33m'$DIR_BIN' doesn´t exist, creating...\E[0m"
			mkdir $DIR_BIN
			echo "'$DIR_BIN' has been created."
	fi
	echo "für welche java version soll compiliert werden:"
	read ch
	echo "Scanning for java source code..."
	cd $DIR_SRC
	find -name *.java > $TMP_FILE
	cd ..
	echo "Finnished with scanning for java source code."
	echo -e "copy recources to '$DIR_BIN'\e[32m"
	cp -fr $DIR_SRC* $DIR_BIN
	echo -e "\e[0m"
	cd $DIR_BIN
	find -iname "*.java" -exec rm {} \;
	cd ..
	echo "Finnished with copy recources to '$DIR_BIN'"
	echo "Start compiling..."
	cd $DIR_SRC
	echo -e "\E[36m"
	javac -verbose -encoding "ISO-8859-1" -source "$ch" -target "$ch" -d "../$DIR_BIN" @$TMP_FILE
	echo -e "\e[0m"
	cd ..
	echo "Finnished with compiling."
	echo "clean up..."
	rm -fv $DIR_SRC/$TMP_FILE
	rm -fv $DIR_BIN/$TMP_FILE
	echo "Finnished clean up."
fi
echo -e "\e[32mDone.\e[0m"
#echo -e "\E[32m\e[0m"
#echo -e '\E[30m black \E[31mred \E[32mgreen \E[33myellow \E[34mblue \E[35mmagenta \E[36mcyan \E[37mwhite'


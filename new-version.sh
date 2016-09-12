#!/bin/sh
DIR_BKP=$(date +%Y.%m.%d-%H%M)
DIR_SUB="Version/"
DIR_FULLBKP=$DIR_SUB$DIR_BKP
DIR_BIN="bin/"
DIR_SRC="src/"
DIR_DIST="dist/"
DIR_DOC="doc/"
if [ ! -d $DIR_SRC ] 
then
	echo "There is no 'src' folder, exiting..."
	exit 1
else
	if [ ! -d $DIR_SUB ] 
	then
		mkdir $DIR_SUB
	fi
	if [ -d $DIR_FULLBKP ] 
	then
		echo "Folder exists, deleting..."
		rm -rfv $DIR_FULLBKP
	fi
	if [ ! -d $DIR_FULLBKP ] 
	then
		mkdir $DIR_FULLBKP
	fi
	echo "Copy $DIR_SRC"
	mkdir $DIR_FULLBKP/$DIR_SRC
	cp -fvr $DIR_SRC $DIR_FULLBKP/$DIR_SRC
	if [ -d $DIR_BIN ] 
	then
		echo "Copy $DIR_BIN"
		cp -fvr $DIR_BIN $DIR_FULLBKP
	fi
	if [ -d $DIR_DOC ] 
	then
		echo "Copy $DIR_DOC"
		cp -fvr $DIR_DOC $DIR_FULLBKP
	fi
	if [ -d $DIR_DIST ] 
	then
		echo "Copy $DIR_DIST"
		cp -fvr $DIR_DIST $DIR_FULLBKP
	fi
fi
echo "Done."
exit

@echo off
color a
set javaVersion=5
set javaNeedVersion="jdk1.7.0_09"
set javaNeed="%javaNeedVersion% x64"
set javaNeedPathJavaC="C:\Program Files\Java\%javaNeedVersion%\bin\javac.exe"
cls
if not exist src (
	echo Der Ordner "src" existiert nicht, beende Vorgang...
	pause
	exit
)
echo HINWEIS: Benötige "%javaNeed%" installiert
echo Fuer welche java version soll compiliert werden:
if defined javaVersion (
	set ch=%javaVersion%
) else (
	set /P ch=
)
if exist bin (
	del /s /f /q bin\*
	rd /s /q bin\*
)
if not exist bin (
	mkdir bin
)
echo kopiere...
xcopy /Y /E /C src\* bin\
echo kopieren abgeschlossen.
dir /s /B "src\*.java" > sources.txt
echo kompiliere...
%javaNeedPathJavaC% -verbose -source "%ch%" -target "%ch%" -d bin\ @sources.txt
echo kompilieren abgeschlossen.
echo aufräumen...
del /s /f /q bin\*.java 1>&2>nul
del /s /f /q src\*.class 1>&2>nul
del /f /q sources.txt 1>&2>nul
echo.
echo fertig
if "%1"=="" (
	pause
)

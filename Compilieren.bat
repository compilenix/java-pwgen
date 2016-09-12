@echo off
echo Fuer welche java version soll compiliert werden:
set /P ch=
del /s /f /q bin\*
rd /s /q bin\*
xcopy /Y /E /C src\* bin\
dir /s /B "src\*.java" > sources.txt
javac -verbose -source "%ch%" -target "%ch%" -d bin\ @sources.txt
del /s /f /q bin\*.java
del /s /f /q src\*.class
del /f /q sources.txt

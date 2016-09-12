@echo off
echo Fuer welche java version soll compiliert werden:
set /P ch=
del /s /f /q bin\*
rd /s /q bin\*
xcopy /Y /E /C src\* bin\
dir /s /B "src\*.java" > sources.txt
"C:\Program Files\Java\jdk1.7.0_06\bin\javac.exe" -verbose -source "%ch%" -target "%ch%" -d bin\ @sources.txt
del /s /f /q bin\*.java
del /s /f /q src\*.class
del /f /q sources.txt

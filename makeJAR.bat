@echo off
color a
set javaNeedVersion="jdk1.7.0_09"
set javaNeed="%javaNeedVersion% x64"
set javaNeedPathJar="C:\Program Files\Java\%javaNeedVersion%\bin\jar.exe"
set jarName=PasswordGenerator.jar
cls
if not exist bin (
	echo Der Ordner "bin" existiert nicht, beende Vorgang...
	pause
	exit
)
if not exist MANIFEST.MF (
	echo Die Datei "MANIFEST.MF" existiert nicht, beende Vorgang...
	pause
	exit
)
if exist src (
	if "%1%"=="" (
		call Compilieren.bat
	)
)
dir "..\" /A:D
echo.
echo HINWEIS: Benötige "%javaNeed%" installiert
echo Name der JAR Datei:
if not defined jarName (
	set /P jarName=
)
if %jarName%=="" (
	echo Es wurde kein Name gewählt, beende Vorgang...
	pause
	exit
)
if not exist dist (
	echo Erstelle nicht existierenden Ordner "dist"; Ziel von "%jarName%"...
	mkdir dist
)
echo Jar wird erstellt...
%javaNeedPathJar% -cvfm "dist\%jarName%" MANIFEST.MF  -C bin/ .
echo erstellen abgeschlossen.
echo.
echo fertig
if "%1%"=="" (
	pause
)
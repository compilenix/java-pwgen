@echo off
REM Umlaute ä = „
REM Umlaute ö = ”
REM Umlaute ü = 
REM Umlaute Ä = 
REM Umlaute Ö = ™
REM Umlaute Ü = š
:start
cls
color a
title Neue Produktversion erstellen
REM echo Aktuelle version ist:
REM FindSTR "." vers.txt
REM SET /p vers=<vers.txt
REM echo.
REM echo Bitte neue Versions-Nummer angeben:
REM set /P vers=
REM if "%vers%"=="" (
	REM echo ERROR !
	REM echo Bitte Versions-Nummer  eingeben !!
	REM pause
	REM start new-version.bat
	REM goto end
REM )
REM if not exist "src\version\%vers%" goto copy
set vers=%DATE:~6,4%-%DATE:~3,2%-%DATE:~0,2%.%TIME:~0,2%%TIME:~3,2%
echo vers
if exist "version\%vers%" (
	cls
	echo.
	del /s /q /f "version\%vers%\*.*"
	rd /s /q "version\%vers%" 2>nul
)
:copy
echo.
xcopy "src" "version\%vers%\src" /i /y /e
xcopy "bin" "version\%vers%\bin" /i /y /e
xcopy "doc" "version\%vers%\doc" /i /y /e
xcopy "dist" "version\%vers%\dist" /i /y /e
echo.
echo Abgeschlossen !
echo press enter to finish it...
REM set /P x=
REM echo %vers% 1>vers.txt
REM exit
:end
exit

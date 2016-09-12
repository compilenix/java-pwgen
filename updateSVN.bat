@echo off
cls
color a
REM set vers=%DATE:~6,4%-%DATE:~3,2%-%DATE:~0,2%.%TIME:~0,2%%TIME:~3,2%
cls
set sourcedir="%cd%"
set backupdir="Source Forge SVN"
call Compilieren.bat "asdf"
call makeJAR.bat "asdf"
robocopy %sourcedir% %backupdir% /JOB:exclude_dirs /JOB:exclude_files /MIR /S /NDL /PURGE /R:0 /W:0 /Z /NJS /TEE
echo.
echo Abgeschlossen !
echo press enter to finish it...
exit

$javaVersion="5"
Clear-Host
if (!(Test-Path "src")) {
    Write-Error "Der Ordner ""src"" existiert nicht, beende Vorgang..."
    $exit = Read-Host
    exit
}
if (!$javaVersion) {
    Write-Warning 'Variable "$javaVersion" nicht definiert, frage...'
    Write-Host "F�r welche java version soll compiliert werden: " -NoNewline
    $javaVersion = Read-Host
}
if (!$javaVersion) {
    Write-Warning 'Variable "$javaVersion" nicht definiert, w�hle automatisch f�r version ""5""'
    $javaVersion="5"
}
if (Test-Path "bin") {
    Remove-Item "bin" -Recurse
}
if (!(Test-Path "bin")) {
    New-Item "bin" -ItemType directory
}
Write-Host "kopiere resouces..."
Copy-Item -Path "src\*" -Destination "bin\" -Recurse -Force -Verbose
Write-Host "kopieren abgeschlossen." -ForegroundColor Green
Get-ChildItem "src\*.java"
cmd /c "dir /s /B ""src\*.java"" > sources.txt"
#Get-ChildItem -Recurse -Include *.java src | where {!$_PSIsContainer} | foreach-object -process { $_.FullName } >sources.txt #sortiert f�r javac falsch -.-
Write-Host "kompiliere..."
cmd /c "javac -verbose -source $javaVersion -target $javaVersion -d bin\ -g -nowarn @sources.txt"
Write-Host  "cmd /c ""javac -verbose -source $javaVersion -target $javaVersion -d bin\ -g -nowarn @sources.txt"""
Write-Host "kompilieren abgeschlossen." -ForegroundColor Green
Write-Host "aufr�umen..." -ForegroundColor Green
cd bin
Remove-Item "*.java" -Recurse -Verbose
cd ../src
Remove-Item "*.class" -Recurse -Verbose
cd ..
Remove-Item "sources.txt" -Verbose
if (!$1) {
Write-Host "fertig."
	$exit = Read-Host
}

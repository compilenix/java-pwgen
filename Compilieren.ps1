$javaVersion="5"
Clear-Host
if (!(Test-Path "src")) {
    Write-Error "Der Ordner ""src"" existiert nicht, beende Vorgang..."
    $exit = Read-Host
    exit
}
if (!$javaVersion) {
    Write-Warning 'Variable "$javaVersion" nicht definiert, frage...'
    Write-Host "Für welche java version soll compiliert werden: " -NoNewline
    $javaVersion = Read-Host
}
if (!$javaVersion) {
    Write-Warning 'Variable "$javaVersion" nicht definiert, wähle automatisch für version ""5""'
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
cmd /c "dir /s /B ""src\*.java"" > sources.txt"
#Get-ChildItem -Recurse -Include *.java src | where {!$_PSIsContainer} | foreach-object -process { $_.FullName } >sources.txt #sortiert für javac falsch -.-
Write-Host "kompiliere..."
cmd /c "javac -verbose -encoding UTF-8 -source $javaVersion -target $javaVersion -d bin\ -g -nowarn @sources.txt"
Write-Host  "cmd /c ""javac -verbose -encoding UTF-8 -source $javaVersion -target $javaVersion -d bin\ -g -nowarn @sources.txt"""
Write-Host "kompilieren abgeschlossen." -ForegroundColor Green
Write-Host "aufräumen..." -ForegroundColor Green
gci .\bin -include *.java -Recurse -Force | Remove-Item -Recurse -Force -Verbose
gci .\src -include *.class -Recurse -Force | Remove-Item -Recurse -Force -Verbose
Remove-Item "sources.txt" -Verbose
if (!$1) {
Write-Host "fertig."
	$exit = Read-Host
}

Clear-Host
#cd C:\Dropbox\Projects\joe\java\JWecker

####################################### VARIABLES ###################################################

$jarName = "PasswordGenerator.jar"
#####################################################################################################

if (!(Test-Path "MANIFEST.MF")) {
	Write-Host 'Die Datei "MANIFEST.MF" existiert nicht, beende Vorgang...' -ForegroundColor Red
	$exit = Read-Host
	exit
}
if (Test-Path "src") {
	if (!$1) {
        if (Test-Path "Compilieren.ps1") {
            & .\Compilieren.ps1
        }
	}
}
if (!(Test-Path "bin")) {
	Write-Host 'Der Ordner "bin" existiert nicht, beende Vorgang...' -ForegroundColor Red
	$exit = Read-Host
	exit
}
if (!$jarName) {
    Write-Host
    $jarName = Read-Host 'Name der JAR Datei'
}
if (!$jarName) {
    Write-Host -ForegroundColor 'Es wurde kein Name gewählt, beende Vorgang...' Red
    $exit = Read-Host
    exit
}
if (!(Test-Path "dist")) {
    Write-Host "Erstelle nicht existierenden Ordner ""dist"", Ziel von ""$jarName""..." -ForegroundColor Green
	New-Item "dist" -Force -ItemType directory
}
Write-Host "Jar wird erstellt..." -ForegroundColor Green
jar -cvfm "dist\$jarName" MANIFEST.MF  -C bin/ .
Write-Host "erstellen abgeschlossen." -ForegroundColor Green
Write-Host "fertig."
if (!$1) {
	$exit = Read-Host
}

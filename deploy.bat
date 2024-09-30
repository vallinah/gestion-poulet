@echo off

set "working_dir=."
set "local=."
set "webapps=C:\Program Files\Apache Software Foundation\Tomcat 10.1\webapps"
set "name=bookservlet"

if "%working_dir%"=="" (
    echo Le lien vers le répertoire de travail est vide.
    goto :EOF
)
if "%local%"=="" (
    echo Le lien vers le dossier temporaire est vide.
    goto :EOF
)
if "%webapps%"=="" (
    echo Le lien vers les webapps est vide.
    goto :EOF
)
if "%name%"=="" (
    echo Le lien vers les name est vide.
    goto :EOF
)

REM Supprimer le dossier temporaire s'il existe déjà
if exist "%local%\temp" (
    rmdir /s /q "%local%\temp"
)

if exist "%local%\out" (
    rmdir /s /q "%local%\out"
)

REM Créer un nouveau dossier temporaire dans le dossier local
mkdir "%local%\temp"
mkdir "%local%\temp\WEB-INF"
mkdir "%local%\temp\WEB-INF\classes"
mkdir "%local%\temp\WEB-INF\lib"

mkdir "%local%\out"

REM Copier les fichiers et répertoires depuis working_dir vers temp
xcopy /s /e /q "%working_dir%\web\*" "%local%\temp\"
copy "%working_dir%\*.xml" "%local%\temp\WEB-INF"

REM Copier le contenu du répertoire lib vers temp/WEB-INF/lib
copy "%working_dir%\lib\*" "%local%\temp\WEB-INF\lib"

for /r "%working_dir%\src" %%f in (*.java) do copy "%%f" "%local%\out"

REM Compiler toute les classe en specifiant le classpath
javac -cp "%local%\temp\WEB-INF\lib\*" -d "%local%\temp\WEB-INF\classes" "%local%\out\*.java"

jar cvf "%local%\%name%.war" -C "%local%\temp" .
move "%local%\%name%.war" "%webapps%"

rmdir /s /q "%local%\temp"
rmdir /s /q "%local%\out"




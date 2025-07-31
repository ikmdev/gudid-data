@echo off
setlocal enabledelayedexpansion

:: Check arguments

if "%~4"=="" (

    echo Usage: run-data-pipeline.bat ["profile1|profile2"] [dataStoreLocation] [dataStore] [medicalSpecialtyFlag]
    exit /b 1
)

set "PROFILE=%~1"
set "DATA_STORE_LOCATION=%~2"
set "DATA_STORE=%~3"
set "MEDICAL_SPECIALTY_FLAG=%~4"

set "BASE_DIR=%USERPROFILE%\GIT"
set "RXNORM_DIR=%BASE_DIR%\rxnorm-data"
set "SNOMED_DIR=%BASE_DIR%\snomed-ct-loinc-data"
set "GUDID_DIR=%BASE_DIR%\gudid-data"

if /i "%PROFILE%"=="profile1" (

    echo === Running profile1 ===

    for %%M in (plugin rxnorm-origin rxnorm-pipeline rxnorm-starterdata) do (

        echo Running: rxnorm-data\%%M

        cd /d "%RXNORM_DIR%\%%M" && mvn clean install -DdataStoreLocation=%DATA_STORE_LOCATION% -DdataStore=%DATA_STORE%

    )

    for %%M in (plugin snomed-ct-loinc-origin snomed-ct-loinc-starterdata snomed-ct-loinc-pipeline) do (

        echo Running: snomed-ct-loinc-data\%%M

        cd /d "%SNOMED_DIR%\%%M" && mvn clean install -DdataStoreLocation=%DATA_STORE_LOCATION% -DdataStore=%DATA_STORE%
    )

    for %%M in (plugin gudid-origin gudid-starterdata gudid-pipeline) do (

        echo Running: gudid-data\%%M

        cd /d "%GUDID_DIR%\%%M" && mvn clean install -DdataStoreLocation=%DATA_STORE_LOCATION% -DdataStore=%DATA_STORE% -DmedicalSpecialtyFlag=%MEDICAL_SPECIALTY_FLAG% 
    )
	
) else if /i "%PROFILE%"=="profile2" (

    echo === Running profile2 ===

    for %%M in (rxnorm-owl-transform rxnorm-reasoner) do (

        echo Running: rxnorm-data\%%M

        cd /d "%RXNORM_DIR%\%%M" && mvn install -DdataStoreLocation=%DATA_STORE_LOCATION% -DdataStore=%DATA_STORE%
    )
	
) else (

    echo Invalid profile: %PROFILE%

    echo Please specify either profile1 or profile2.

    exit /b 1
)

endlocal
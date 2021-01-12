call runcrud.bat
if "%ERRORLEVEL%" == "0" goto browser
echo.
echo Something went wrong with runcrud. Check it and try again.
goto fail

:browser
explorer "http://localhost:8080/crud/v1/task/getTasks"

timeout 15

if "%ERRORLEVEL%" == "0" goto end

echo.
echo Something went wrong with open explorer. Check it and try again.
goto fail

:fail
echo.
echo Huston, we have a problem.

:end
echo.
echo Work is finished - showtasks
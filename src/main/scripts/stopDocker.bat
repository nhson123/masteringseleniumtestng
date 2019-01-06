cd C:\Users\Hoang.Son.Nguyen\OneDrive\Public\masteringseleniumtestng\src\main\scripts
for /F %%c in ('docker ps -q') do (docker stop %%c)
for /F %%c in ('docker ps -a -q') do (docker rm %%c)


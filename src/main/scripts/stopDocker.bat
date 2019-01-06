cd C:\Users\Hoang.Son.Nguyen\OneDrive\Public\masteringseleniumtestng\src\main\scripts
docker stop $(docker ps -q)
docker rm $(docker ps -qa)
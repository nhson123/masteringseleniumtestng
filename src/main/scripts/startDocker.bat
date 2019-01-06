cd C:\Users\Hoang.Son.Nguyen\OneDrive\Public\masteringseleniumtestng\src\main\scripts
docker run -d -p 4444:4444 --name selenium-hub selenium/hub
docker run -d --link selenium-hub:hub selenium/node-chrome
docker run -d --link selenium-hub:hub selenium/node-firefox


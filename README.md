# Challenge

## Prerequisites
- JDK 15+ ([Installation guide](https://docs.oracle.com/en/java/javase/17/install/overview-jdk-installation.html#GUID-8677A77F-231A-40F7-98B9-1FD0B48C346A))
- Apache Maven 3.6.3+ ([Installation guide](https://maven.apache.org/install.html))
- ChromeDriver 97 ([Release](https://chromedriver.storage.googleapis.com/index.html?path=97.0.4692.71/))
- GeckoDriver 0.30 ([Release](https://github.com/mozilla/geckodriver/releases/))
- Browsers: Chrome v97, Firefox v96


## Running Tests

### Setting up the framework environment
Open the config file `challenge_mercedes_benz\src\test\resources\config.properties` and update the following properties:
```
# The browser to use (chrome or firefox)
DEFAULT_BROWSER=chrome        

# Your chrome driver absolute path
CHROME_DRIVER_PATH=C:/path/chromedriver.exe    

# Your gecko driver absolute path
GECKO_DRIVER_PATH=C:/path/geckodriver.exe 

# Screenshot file project relative path
RESULTS_PRINT_FILE=target/public/report/filter_results_screenshot.jpg             

# Prices file project relative path
HIGHEST_LOWEST_PRICES_FILE=target/public/report/highest_and_lowest_prices.txt     
```

### Executing tests
Open the console, go to the project root folder `\challenge_mercedes_benz` and type the following command:
```
$ mvn clean install -Dbrowser=(chrome|firefox)
```






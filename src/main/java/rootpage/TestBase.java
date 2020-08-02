package rootpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static Properties prop;
    public static FileInputStream ip;
    public static WebDriver driver;


    public TestBase(){

        try{
          prop = new Properties() ;
          ip = new FileInputStream("/Users/michaelgodfrey/IdeaProjects/myTestPrep/config.Properties");
          prop.load(ip);
        }
        catch (FileNotFoundException e){
          e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void initialization(){
        String BrowserName = prop.getProperty("browser");
        String chromeDriverPath = "/Users/michaelgodfrey/IdeaProjects/myTestPrep/drivers/chromedriver";
        String firefoxDriverPath = "../drivers/geckodriver";

        if(BrowserName.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            driver = new ChromeDriver();
        }
        else if(BrowserName.equalsIgnoreCase("Firefox")){
            System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
            driver = new FirefoxDriver();
        }
        else{
            System.out.println("Browser Type Not in Use");

        }
        String url = "https://www.mail.com/#";
        driver.manage().timeouts().implicitlyWait(ConfigFiles.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(ConfigFiles.PAGE_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
    }

}

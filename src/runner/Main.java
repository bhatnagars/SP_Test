package runner;


import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import tests.PageTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Main {
    private static String browser="";
    static WebDriver page;

    public static void main(String[] args) {
        System.out.println("Starting the execution");
           for(int i=0;i<args.length;i++){
               switch (args[i].toLowerCase()){

                   case "-browser":
                       browser=args[i+1];
                       System.out.println("Starting the '"+browser+"' now");
                       initiate_browser(browser.toLowerCase());
               }
           }

           PageTest app = new PageTest();
           System.out.println("Starting the Test case execution now");
           app.openurl(getDriver());
           app.clickonLearnMore();
           Assert.isTrue(app.verify_element_and_dots(),"Test Failed");

        }

        public static void initiate_browser(String browserName){
             if(browserName.equals("chrome")) {
                 WebDriver driver = new ChromeDriver();
                 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                 driver.manage().window().maximize();
                 page = driver;
             } else if(browserName.equals("edge")){
                 WebDriver driver = new EdgeDriver();
                 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                 driver.manage().window().maximize();
                 page = driver;
                 }else{
                 System.out.println("No Browser Match Found , Please Check");
             }

            System.out.println("Started the '"+browser+"' ");
        }

        public static WebDriver getDriver(){
        return page;
        }
    }
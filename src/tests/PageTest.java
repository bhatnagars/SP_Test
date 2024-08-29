package tests;



import lib.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class PageTest {
    public Util action = new Util();
    WebDriver page;


    public void openurl(WebDriver driver){
        page=driver;
        System.out.println("Opening the url");
        page.get("https://www.brighthorizons.com/");
    }

    public boolean clickonLearnMore(){
        action.performClick(page,"//a[contains(@data-tracking-cta,'EdAssist Solutions for Employers')]");
        if (page.getCurrentUrl().contains("edassist-solutions")){
            System.out.println("Url contains edassist-solutions");
            return true;
        }else{
            return false;
        }

    }


    public boolean verify_element_and_dots(){
        int num_comments=0;
        page.get("https://www.brighthorizons.com/family-solutions");
        List<WebElement> comments = page.findElements(By.xpath("//*[@class='slick-slide'][@style='width: 1160px;']"));
        System.out.println("Number of hidden comments are"+comments.size());

        WebElement activeComment = action.pagesync(page,"//*[@class='slick-slide slick-current slick-active'][@style='width: 1160px;']");

        if(activeComment!=null) {
            num_comments = comments.size() + 1; //active comment+ hidden comments in carousal
        }
        List<WebElement> dots = page.findElements(By.xpath("//*[@class='col-xs-12']//*[@class='slick-dots']//li"));
        //comparing the dots and comments now
        if(num_comments == dots.size()){
            System.out.println("Comments and Dots are matched");
            page.close();
            return true;
        }else{
            System.out.println("Comments and Dots are not matched");
            page.close();
            return false;
        }


    }
}

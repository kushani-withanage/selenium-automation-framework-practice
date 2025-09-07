import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class BrokenImage {

    WebDriver driver;

    @BeforeMethod
    public void openPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void brokenImageCheck(){
        driver.get("https://the-internet.herokuapp.com/broken_images");
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='example']/img"));
        for (int i = 0; i < 3; i++) {
            if(elements.get(i).getAttribute("naturalWidth").equals("0")){
                System.out.println("image "+i+" is broken");
            }else {
                System.out.println("image "+i+" is not broken");
            }
        }
    }

}

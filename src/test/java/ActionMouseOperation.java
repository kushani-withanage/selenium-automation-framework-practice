import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ActionMouseOperation {

    WebDriver driver;

    @BeforeMethod
    public void openPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void mouseHandling(){
        driver.get("https://www.leafground.com/drag.xhtml");

        System.out.println("-----------Move to an element operation-----------");
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("menuform:j_idt37"))).
                moveToElement(driver.findElement(By.id("menuform:j_idt38"))).
                moveToElement(driver.findElement(By.id("menuform:j_idt39"))).
                moveToElement(driver.findElement(By.id("menuform:j_idt40"))).perform();


        System.out.println("-----------Drag & Drop operation-----------");
        //1st option
        WebElement fromelement = driver.findElement(By.id("form:drag_content"));
        WebElement tolement = driver.findElement(By.id("form:drop_content"));
       // actions.clickAndHold(fromelement).moveToElement(tolement).release(tolement).perform();

        //2nd option
        actions.dragAndDrop(fromelement,tolement).perform();

        System.out.println("-----------Slider operation-----------");
        WebElement sliderPoint1 = driver.findElement(By.xpath("//div[@id='form:j_idt125']//span[1]"));
        System.out.println("slider point 1-"+sliderPoint1.getLocation());
        actions.dragAndDropBy(sliderPoint1,50,0).perform();
        System.out.println("slider point 1-"+sliderPoint1.getLocation());


    }

}

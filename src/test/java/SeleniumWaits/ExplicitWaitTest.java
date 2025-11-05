package SeleniumWaits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExplicitWaitTest {

    WebDriver driver;

    @BeforeMethod
    public void openPage(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/waits.xhtml");
    }

    @Test
    public void explicitWaitTest(){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));

        WebElement btnelement = driver.findElement(By.id("j_idt87:j_idt89"));
        btnelement.click();

        By newBtn = By.xpath("//button[@id='j_idt87:j_idt90']/span");
        WebElement newBtnElement = wait.until(ExpectedConditions.visibilityOfElementLocated(newBtn));

        String text = newBtnElement.getText();
        System.out.println("new btn text-"+text);
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

}

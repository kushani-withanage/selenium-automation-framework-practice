import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ActionKeyboardOperation {
    WebDriver driver;

    @BeforeMethod
    public void openPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void keybordAction1() throws InterruptedException {
        driver.get("https://www.google.com/");
        WebElement q1 = driver.findElement(By.name("q"));
        q1.sendKeys("Welcome");

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();

        Thread.sleep(3000);

        actions.keyDown(Keys.SHIFT).sendKeys("Uppercase Characters").keyUp(Keys.SHIFT).
                keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).
                keyDown(Keys.CONTROL).sendKeys("X").keyUp(Keys.CONTROL).perform();
    }

    @Test
    public void keybordAction2(){

        driver.get("https://www.leafground.com/list.xhtml;jsessionid=node0l49tatdft99u19m3cjlidiudn4710866.node0");
        List<WebElement> elements = driver.findElements(By.xpath("//ul[@aria-label='From']/li"));
        System.out.println("Selected list count-"+elements.size());
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).
                click(elements.get(0)).click(elements.get(1)).click(elements.get(2)).perform();

    }

}

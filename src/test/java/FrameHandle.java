import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FrameHandle {
    WebDriver driver;

    @BeforeMethod
    public void openPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void windowHandle(){
        driver.get("https://leafground.com/frame.xhtml");

        //click me(inside frame)
        driver.switchTo().frame(0);
        WebElement clickBtn = driver.findElement(By.id("Click"));
        clickBtn.click();
        System.out.println("Btn text after click-"+clickBtn.getText());

        //click me(inside nested frame)
        driver.switchTo().defaultContent();
        driver.switchTo().frame(2);
        driver.switchTo().frame("frame2");
        WebElement element = driver.findElement(By.xpath("//button[@id='Click']"));
        element.click();
        System.out.println("Nested frame btn -"+element.getText());

        //frame count
        driver.switchTo().defaultContent();
        List<WebElement> iframe = driver.findElements(By.tagName("iframe"));
        System.out.println("iframe count-"+iframe);


    }
}

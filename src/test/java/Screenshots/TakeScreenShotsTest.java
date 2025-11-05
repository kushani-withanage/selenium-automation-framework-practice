package Screenshots;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class TakeScreenShotsTest {
    WebDriver driver;

    @BeforeMethod
    public void openPage(){
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/alert.xhtml");
    }

    @Test
    public void takeScreenshotsTests() throws IOException, AWTException {

        // folder path-D:\Projects\QA\YT-Selenium-Practice\Selenium-Automation-Framework-Practice
        //1) capture screenshot of full web page
        TakesScreenshot takeScreenShot= (TakesScreenshot) driver;
        File sourceFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
        File destination = new File(System.getProperty("user.dir") + "\\Screenshots\\" + "alert_full_of_the_page.png");
        FileUtils.copyFile(sourceFile,destination);

        //2) capture screenshot of section of a web page
        WebElement section = driver.findElement(By.xpath("//*[@id=\"j_idt88\"]/div/div[1]"));
        File source = section.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "\\Screenshots\\" + "alert_section_of_the_page.png");
        FileUtils.copyFile(source,target);

        //3) capture screenshot of an element on a web page
        WebElement element=driver.findElement(By.xpath("//*[@id=\"j_idt88\"]/div/div[1]/div[1]"));
        File source2 = element.getScreenshotAs(OutputType.FILE);
        File target2 = new File(System.getProperty("user.dir") + "\\Screenshots\\" + "alert_element_of_the_page.png");
        FileUtils.copyFile(source2,target2);

        //4) capture screenshot of full entire screen
        WebElement alertBtn = driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt91\"]"));
        alertBtn.click();

        Robot robot = new Robot();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle rectangle = new Rectangle(screenSize);
        BufferedImage screenCapture = robot.createScreenCapture(rectangle);
        File target3 = new File(System.getProperty("user.dir") + "\\Screenshots\\" + "alert_entire_page.png");
        ImageIO.write(screenCapture,"png",target3);


    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class FileUploadDownload {
    WebDriver driver;

    @BeforeMethod
    public void openPage() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void fileDownload() throws InterruptedException {
        driver.get("https://www.leafground.com/file.xhtml");
        Thread.sleep(3000);
        WebElement element = driver.findElement(By.id("j_idt93:j_idt95"));
        element.click();
        Thread.sleep(3000);

        File file = new File("G:\\Downloads");
        File[] files = file.listFiles();
        for (File f:files){
            if(f.getName().equals("TestLeaf Logo.png")){
                System.out.println("file downloaded");
                break;
            }
        }

    }

    @Test
    public void fileUpload() throws InterruptedException, AWTException {
        driver.get("https://www.leafground.com/file.xhtml");
        WebElement element = driver.findElement(By.id("j_idt88:j_idt89"));
        element.click();
        Thread.sleep(3000);

        //1st way - using Robot class
        String path="G:\\Downloads\\aaaaa.jpeg";
        StringSelection selection = new StringSelection(path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        Thread.sleep(3000);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        //2nd way- using sendKeys
        WebElement element1 = driver.findElement(By.id("j_idt88:j_idt89_input"));
        element1.sendKeys(path);


    }

}

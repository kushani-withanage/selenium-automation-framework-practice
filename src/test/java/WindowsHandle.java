import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Set;

public class WindowsHandle {
    WebDriver driver;
    @BeforeMethod
    public void openPage(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void windowHandle() throws InterruptedException {
        driver.get("https://www.leafground.com/window.xhtml");

        String oldWindow = driver.getWindowHandle();
        System.out.println("old window -"+oldWindow);

        //click and confirm new window open
        WebElement openBtn = driver.findElement(By.xpath("//span[normalize-space()='Open']"));
        openBtn.click();
        Thread.sleep(3000);

        //using for each
        Set<String> windowHandles = driver.getWindowHandles();
        for (String window:windowHandles){
            System.out.println(window);
            driver.switchTo().window(window);
            System.out.println("page title-"+driver.getTitle());
        }

        driver.close();

        driver.switchTo().window(oldWindow);
        System.out.println("open button visibility-"+openBtn.isDisplayed());

        //using list
        ArrayList<String> list = new ArrayList<>(driver.getWindowHandles());
        if(list.size()>1){
            driver.switchTo().window(list.get(1));
            System.out.println("page title-"+driver.getTitle());
            driver.close();
        }
        driver.switchTo().window(oldWindow);
        System.out.println("open button visibility-"+openBtn.isDisplayed());

        //find the no of open tabs
        WebElement multipleWindowBtn=driver.findElement(By.xpath("//span[normalize-space()='Open Multiple']"));
        multipleWindowBtn.click();
        ArrayList<String> multipleWindowList =new ArrayList<>(driver.getWindowHandles());
        System.out.println("No of windows-"+multipleWindowList.size());

        //close all window except primary
        WebElement closeWindowBtn=driver.findElement(By.xpath("//span[normalize-space()='Close Windows']"));
        closeWindowBtn.click();
        Thread.sleep(3000);
        Set<String> closeWindowsHandle = driver.getWindowHandles();
        for (String s:closeWindowsHandle){
            if(!s.equals(oldWindow)){
                driver.switchTo().window(s);
                driver.close();
            }
        }

    }


}

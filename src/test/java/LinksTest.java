import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class LinksTest {

    WebDriver driver;

    @BeforeMethod
    public void openPage(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/");
        driver.findElement(By.xpath("//i[@class='pi pi-server layout-menuitem-icon']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Hyper Link']")).click();
    }

    @Test
    public void linkTest(){
        //linkText use
        driver.findElement(By.linkText("Go to Dashboard")).click();
        driver.navigate().back();

        //partilLink Text
        driver.findElement(By.partialLinkText("Find the URL")).click();
        driver.navigate().back();

        //Broken link
        driver.findElement(By.linkText("Broken?")).click();
        String title = driver.getTitle();

        if(title.contains("404")){
            System.out.println("Broken Link");
        }else {
            System.out.println("Not Broken");
        }
        driver.navigate().back();

        //Duplicate link
        driver.findElement(By.xpath("//div[@class='layout-main-content']//div[2]//div[1]//div[1]//div[1]//a[1]")).click();
        driver.navigate().back();

        //count all links in page
        List<WebElement> allLinks= driver.findElements(By.tagName("a"));
        System.out.println("Page Links -"+allLinks.size());
        driver.navigate().back();

        //count all links in section
        WebElement section=driver.findElement(By.className("layout-main-content"));
        List<WebElement> sectionLinks= section.findElements(By.tagName("a"));
        System.out.println("Page Links -"+sectionLinks.size());
        driver.navigate().back();

    }
}

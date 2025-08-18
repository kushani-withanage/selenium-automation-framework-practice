import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropdownTest {
    WebDriver driver;
    @BeforeMethod
    public void openPage(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void dropdownTest(){

        driver.get("https://www.leafground.com/select.xhtml");
        //select value
        WebElement dropdownElement = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
        Select dropdown = new Select(dropdownElement);
        List<WebElement> options = dropdown.getOptions();
        for(WebElement e:options){
            System.out.println(e);
        }
        dropdown.selectByVisibleText("Selenium");
        dropdown.selectByIndex(2);
        //get the options count
        System.out.println("Options count-"+options.size());

        //typing & select the dropdown
        dropdownElement.sendKeys("P"+ Keys.ENTER);

        //selecting value in boostrap dropdown
        WebElement dropdown2 = driver.findElement(By.xpath("//label[@id='j_idt87:country_label']"));
        dropdown2.click();
        List<WebElement> countryElements = driver.findElements(By.xpath("//ul[@id='j_idt87:country_items']/li"));
        for (WebElement e:countryElements){
            if(e.getText().equals("USA")) {
                e.click();
                break;
            }
        }
    }


}

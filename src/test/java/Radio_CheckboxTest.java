import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Radio_CheckboxTest {

    WebDriver driver;
    @BeforeMethod
    public void openPage(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void radioTests(){
        driver.get("https://www.leafground.com/radio.xhtml");
        List<WebElement> elements = driver.findElements(By.xpath("//table[@id='j_idt87:console2']//td//input"));
        int index=-1;
        for (WebElement e:elements){
            index++;
            WebElement element = driver.findElement(By.xpath("//input[@id='j_idt87:console2:" + index + "']"));
            if(element.isSelected()){
                String text = driver.findElement(By.xpath("//label[@for='j_idt87:console2:" + index + "']")).getText();
                System.out.println("Selected Optoin-"+text);
                break;
            }
        }

        //Select the age group (only if not selected)
        WebElement element = driver.findElement(By.id("j_idt87:age:0"));
        if(!element.isSelected()){
            driver.findElement(By.xpath("//label[@for='j_idt87:age:0']")).click();
        }


    }

    @Test
    public void checkboxTests(){
        driver.get("https://www.leafground.com/checkbox.xhtml");
        List<WebElement> elements = driver.findElements(By.xpath("//table[@id='j_idt87:basic']//label"));
        for (WebElement e:elements){
            if(!e.getText().equals("Others")){
                e.click();
            }
        }

        for (int i = 0; i < elements.size(); i++) {
            WebElement element = driver.findElement(By.id("j_idt87:basic:" + i));
            if(element.isSelected()){
                WebElement selectedelement = driver.findElement(By.xpath("//table[@id='j_idt87:basic']//label[@id='j_idt87:basic:" + i + "']"));
                System.out.println(selectedelement.getText());
            }

        }
    }



}

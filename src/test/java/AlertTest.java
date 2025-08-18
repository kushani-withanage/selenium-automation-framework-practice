import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTest {
    WebDriver driver;
    @BeforeMethod
    public void openPage(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void alertsTest(){
        driver.get("https://www.leafground.com/alert.xhtml");
        //simple dialog alert
        WebElement simpleDialogBtn = driver.findElement(By.id("j_idt88:j_idt91"));
        simpleDialogBtn.click();
        Alert simpleDialogalert = driver.switchTo().alert();
        simpleDialogalert.accept();

        //confirm dialog alert
        WebElement confirmDialogBtn = driver.findElement(By.id("j_idt88:j_idt93"));
        confirmDialogBtn.click();
        driver.switchTo().alert().dismiss();

        //prompt dialog alert
        WebElement promptDialogBtn = driver.findElement(By.id("j_idt88:j_idt104"));
        promptDialogBtn.click();
        Alert alert3=driver.switchTo().alert();
        System.out.println(alert3.getText());
        alert3.sendKeys("Kushani.....");
        alert3.accept();


    }
}

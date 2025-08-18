import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxTest {
    WebDriver driver;

    @BeforeMethod
    public void openPage(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/");
        driver.findElement(By.xpath("//i[@class='pi pi-server layout-menuitem-icon']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Text Box']")).click();
    }

    @Test
    public void textBoxTest(){
        //1)Type name
        WebElement name=driver.findElement(By.id("j_idt88:name"));
        name.sendKeys("Kushani Dhanushika");

        //2)Append country to this city
        WebElement country=driver.findElement(By.id("j_idt88:j_idt91"));
        country.sendKeys("Sri Lanka");

        //3)Verify textbox disable
        WebElement checkTextBox=driver.findElement(By.id("j_idt88:j_idt93"));
        if(checkTextBox.isDisplayed()){
            System.out.println("Checkbox is Disable");
        }else{
            System.out.println("Checkbox is not Disable");
        }

        //4)clear the type text
        WebElement clearText=driver.findElement(By.id("j_idt88:j_idt97"));
        System.out.println("Tped Text before clear - "+clearText.getText());
        clearText.clear();

        //6)type email
        WebElement email=driver.findElement(By.id("j_idt88:j_idt99"));
        email.sendKeys("kushani@gmail.com"+Keys.TAB);

    }
}

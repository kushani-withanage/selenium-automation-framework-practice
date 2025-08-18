import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonsTest {
    WebDriver driver;

    @BeforeMethod
    public void openPage(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/");
        driver.findElement(By.xpath("//i[@class='pi pi-server layout-menuitem-icon']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Button']")).click();
    }

    @Test
    public void testButtons(){
        //click and confirm title
        WebElement confirmTitleBtn = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt90']"));
        confirmTitleBtn.click();
        Assert.assertEquals(driver.getTitle(),"Dashboard");
        driver.navigate().back();

        //find position
        WebElement findPositionBtn = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt94']"));
        int x=findPositionBtn.getLocation().getX();
        int y=findPositionBtn.getLocation().getY();
        System.out.println("X - "+x);
        System.out.println("Y - "+y);

        //button colour
        WebElement getColour = driver.findElement(By.id("j_idt88:j_idt96"));
        String colour = getColour.getCssValue("backgroud-colour");
        System.out.println(colour);

        //find hight & width
        WebElement findSizeBtn = driver.findElement(By.id("j_idt88:j_idt98"));
        int height = findSizeBtn.getSize().getHeight();
        int width = findSizeBtn.getSize().getWidth();
        System.out.println("Width-"+width);
        System.out.println("Height-"+height);

    }

}

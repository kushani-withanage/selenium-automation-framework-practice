import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CalanderDateOperation {

    WebDriver driver;

    @BeforeMethod
    public void openPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/datepicker/");
    }

    @Test
    public void inputDate(){

        WebDriver frame = driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
        frame.findElement(By.xpath("//input[@id='datepicker']")).click();
        //method 1
        WebElement datepicker = frame.findElement(By.id("datepicker"));
        datepicker.click();
        datepicker.sendKeys("09/10/2026");

        //method 2
        // Target year, month, and day
        String targetYear = "2026";
        String targetMonth = "October";
        String targetDay = "21";

        do {
            String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            if (currentYear.equals(targetYear)) {
                // Inner loop: check until correct month
                do {
                    String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

                    if (currentMonth.equals(targetMonth)) {
                        List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));

                        for (WebElement e : dates) {
                            if (e.getText().equals(targetDay)) {
                                e.click();
                                break; // break inner loop
                            }
                        }
                        break; // break inner loop once day selected
                    } else {
                        driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
                    }
                } while (true);
                break; // break outer loop after month/day selection
            } else {
                driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
            }

        } while (true);
    }
}

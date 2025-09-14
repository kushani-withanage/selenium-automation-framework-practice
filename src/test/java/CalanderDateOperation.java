import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
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
    public void inputDate() throws InterruptedException {

        WebDriver frame = driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
        WebElement datePicker = frame.findElement(By.xpath("//input[@id='datepicker']"));
        datePicker.click();
        //method 1
//        WebElement datepicker = frame.findElement(By.id("datepicker"));
//        datepicker.click();
//        datepicker.sendKeys("09/10/2026");

        //method 2
        datePicker.click();
        selectDate("2029","October","21");
        Thread.sleep(3000);

        datePicker.click();
        selectDate("2023","October","21");

    }

    public void selectDate(String targetYear ,String targetMonth,String targetDay){
        int year=Integer.parseInt(targetYear);
        int month = Month.valueOf(targetMonth.toUpperCase()).getValue();
        int day=Integer.parseInt(targetDay);
        LocalDate targetDate = LocalDate.of(year, month, day);

        L:do{
            //read the current year
            String currentYearStr = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
            String currentMonthStr = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

            int currentYear = Integer.parseInt(currentYearStr);
            int currentMonth = Month.valueOf(currentMonthStr.toUpperCase()).getValue();

           if(currentYear==year && currentMonth==month){
               break L;
           }

           if(targetDate.isBefore(LocalDate.of(currentYear,currentMonth,1))){
               driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click(); // previous
           }else{
               driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); // next
           }
        }while (true);

        List<WebElement> dates = driver.findElements(
                By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a")
        );
        for (WebElement e : dates) {
            if (e.getText().equals(targetDay)) {
                e.click();
                break;
            }
        }
    }

}

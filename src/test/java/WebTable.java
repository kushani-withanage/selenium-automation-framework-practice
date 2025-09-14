import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebTable {
    WebDriver driver;

    @BeforeMethod
    public void openPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
    }

    @Test
    public void webTableHandle(){

        //row and column count
        List<WebElement> column = driver.findElements(By.xpath("//table[@id='productTable']/thead/tr/th"));
        List<WebElement> row = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr"));
        System.out.println("column count-"+column.size()+"\trow count-"+ row.size());

        //get specific data
        String text = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[2]/td[2]")).getText();
        System.out.println("cell [2][2]"+text);

        //get all data from the table
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 4; j++) {
                System.out.print(driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td["+j+"]")).getText()+"\t");
            }
            System.out.println("");
        }

        //print ID and Name
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 3; j++) {
                System.out.print(driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+i+"]//td["+j+"]")).getText()+"\t");
            }
            System.out.println("");
        }

        //find product price in product 3
        for (int i = 1; i < 5; i++) {
            String product=driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+i+"]//td[1]")).getText();
            if(product.equalsIgnoreCase("Tablet")){
                System.out.print(driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+i+"]//td[2]")).getText());
            }
        }
        //select all check boxes
        List<WebElement> elements = driver.findElements(By.xpath("//ul[@id='pagination']/li"));
        int pages=elements.size();
        for (int i =0; i <pages ; i++) {
            elements.get(i).click();
                for (int k = 1; k <6 ; k++) {
                    WebElement checkBox = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr[" + k + "]//td[4]/input"));
                    boolean selected = checkBox.isSelected();
                    if(!selected){
                        checkBox.click();
                    }
                }
        }

    }
}

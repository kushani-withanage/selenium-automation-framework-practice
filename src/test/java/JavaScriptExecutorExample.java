import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutorExample {

    WebDriver driver;
    JavascriptExecutor jsExecuter;

    @BeforeMethod
    public void openPage(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
    }

    @Test
    public void jsExecutorTest() throws InterruptedException {

        jsExecuter= (JavascriptExecutor) driver;

        //1-get a alert box
//        Thread.sleep(2000);
//        jsExecuter.executeScript("alert('Welcome to Site');");


        //2-set a input value in textbox
        //2.1- using value property
        WebElement nameTextBox = driver.findElement(By.xpath("//input[@id='name']"));
        jsExecuter.executeScript("arguments[0].value='Kushani Dhanushika'",nameTextBox);
        Thread.sleep(3000);

        //2.2- using setAttribute
        jsExecuter.executeScript("arguments[0].setAttribute('value','Kushani Withanage');",nameTextBox);
        Thread.sleep(3000);

        //3-Highlight Element
        jsExecuter.executeScript("arguments[0].style.border='3px solid red';",nameTextBox);
        jsExecuter.executeScript("arguments[0].style.background='yellow';",nameTextBox);
        Thread.sleep(3000);

        //4-Click element using JSExecutor
        WebElement checkBox = driver.findElement(By.xpath("//input[@id='male']"));
        jsExecuter.executeScript("arguments[0].click();",checkBox);
        Thread.sleep(3000);

        //5- scrolling
        scrollPage();

    }

    public void scrollPage() throws InterruptedException {
        //5.1-scroll to some position
        jsExecuter.executeScript("window.scrollTo(0,1000);");
        System.out.println("current position-"+jsExecuter.executeScript("return window.pageOffset;"));
        jsExecuter.executeScript("window.scrollTo(0,-1000);");
        Thread.sleep(2000);

        //5.2-scroll to bottom of the page by pixel number
        jsExecuter.executeScript("window.scrollTo(0,document.body.scrollHeight);");

        //5.3-scroll to the top of the page
        jsExecuter.executeScript("window.scrollTo(0,0);");

        //5.4- scroll the page till element visible
        WebElement scrollItem = driver.findElement(By.xpath("//label[normalize-space()='Days:']"));
        jsExecuter.executeScript("arguments[0].scrollIntoView(true);",scrollItem);
    }

}

package ccpack;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ccclass {
	public static void main( String[] args ) throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver","C:\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
        String cartCount = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a/span")).getText();
        if (cartCount.equals("1")) {
        	System.out.println("TESTCASE_01  :  ADDED TO CART SUCCESSFULLY");
        }
        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a")).click();
        String product = "Sauce Labs Backpack";
        if(driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[2]/a/div")).getText().equals(product));
        {
        	System.out.println("TESTCASE_02  :  USER CAN VIEW THE CART");
        }
        driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
        if(driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/span")).getText().equals("Checkout: Your Information")) {
        	System.out.println("TESTCASE_03  :  FORM IS DISPLAYED");
        }
        driver.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys("ABISREE ");
        driver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys("D");
        driver.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys("641202");
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
        if(driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/span")).getText().equals("Checkout: Overview")) {
        	System.out.println("TESTCASE_04  :  PRODUCT OVERVIEW PAGE IS DISPLAYED");
        }
        System.out.println("TESTCASE_05  :  NAME OF THE PRODUCT : " + driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[2]/a/div")).getText());
        System.out.println("TESTCASE_06  :  PRICE OF THE PRODUCT : " + driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[2]/div[2]/div")).getText());
        if(driver.getTitle().equals("Swag Labs")) {
        	System.out.println("TESTCASE_04  :  TITLE OF THE GIVEN WEBSITE IS SWAG LABS ");
        }
        if(driver.getCurrentUrl().equals("https://www.saucedemo.com/checkout-step-two.html")) {
        	System.out.println("TESTCASE_07  :  URL IS MATCHED WITH THE GIVEN");
        }
    } 
}
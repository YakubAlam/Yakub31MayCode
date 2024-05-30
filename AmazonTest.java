package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AmazonTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        // Navigate to a website
        //driver.get("https://www.google.com")
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        WebElement ele=driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));
         ele.click();
        List<WebElement> li=driver.findElements(By.xpath("//div[@class=\"left-pane-results-container\"]/div"));
        for (WebElement element : li) {
            // Get the text of the element
            String text = element.getText();
            System.out.println("text"+text);
            // Check if the text contains 'pool toys'
            if (text.contains("pool toys")) {
                // Click on the element
                element.click();
                break; // No need to continue if found
            }
        }

//        WebElement dropDown=driver.findElement(By.xpath("//select[@id=\"searchDropdownBox\" and @title='Search in']"));
//        Select select=new Select(dropDown);
//
//        List<WebElement> options = select.getOptions();
//        for(WebElement option:options) {
//            if (option.getText().contains("Deals")) {
//                select.selectByVisibleText("Deals");
//                Thread.sleep(5000);
//            }
//
//        }

        driver.close();
    }
}

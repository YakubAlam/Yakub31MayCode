package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebTable {

    public static void main(String[] args) throws InterruptedException {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        // Navigate to a website
        //driver.get("https://www.google.com");

        // Print the title of the current page
        System.out.println("Page title is: " + driver.getTitle());
        driver.get("https://datatables.net/");
        driver.manage().window().maximize();
   //     driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[2]/div[4]/form/input")).sendKeys("abc");

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement table = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id='example']")));
        // Find all rows of the table
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        // Iterate through each row
        for (WebElement row : rows) {
            // Find all columns of the current row
            List<WebElement> columns = row.findElements(By.tagName("//td"));
            Thread.sleep(5000);

            // Iterate through each column and print the text
            for (WebElement column : columns) {
                System.out.print(column.getText() + "\t");

                Thread.sleep(5000);

            }

            // Close the browser
            driver.quit();
        }
    }
}



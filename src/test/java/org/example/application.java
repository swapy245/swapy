package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class application {
    @Test
    public void testing()  {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Downloads\\chromedriver_win32\\chromedriver.exe");

        // Testcase 1
        WebDriver drivgiter = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.name("user-name")).click();
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("login-button")).click();
        WebElement product1 = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/a[1]/div[1]"));
        product1.click();
        WebElement addToCartButton = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/button[1]"));
        addToCartButton.click();
        WebElement cartIcon = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/a[1]"));
        if (!cartIcon.getText().equals("1")) {
            System.out.println("Testcase 1 failed: Cart icon should show 1 item");
        }
        driver.quit();

        // Testcase 2
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.name("user-name")).click();
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("login-button")).click();
        WebElement product2 = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/a[1]/div[1]"));
        product2.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/button[1]")).click();
        WebElement product3 = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/a[1]/div[1]"));
        product3.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[2]/div[2]/button[1]")).click();
        WebElement product4 = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[2]/div[1]/a[1]/div[1]"));
        product4.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[2]/div[2]/button[1]")).click();
        cartIcon = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/a[1]"));
        int numberOfItems = Integer.parseInt(cartIcon.getText());
        if (numberOfItems == 3) {
            System.out.println("Test passed: 3 products were successfully added to cart.");
        } else {
            System.out.println("Test failed: expected 3 products to be added to cart, but got " + numberOfItems + " instead.");
        }

        // Testcase 3
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.name("user-name")).click();
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("login-button")).click();
        product1 = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/a[1]/div[1]"));
        product1.click();
        addToCartButton = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/button[1]"));
        addToCartButton.click();
        WebElement cartIcon1 = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/a[1]"));

       cartIcon1.click();
        if (!driver.getCurrentUrl().equals("https://www.saucedemo.com/checkout-step-one.html")) {
            System.out.println("Testcase 3 failed: User should be on checkout page");
        }
        driver.quit();

        //Test case 4
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.name("user-name")).click();
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("login-button")).click();

        //extra

        WebElement facebookLink = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/footer[1]/ul[1]/li[2]/a[1]"));
        facebookLink.click();
        // Wait for the new window to open
        String originalWindowHandle = driver.getWindowHandle();
        for(String windowHandle : driver.getWindowHandles()) {
            if(!windowHandle.equals(originalWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        // Navigating back to the main page
        driver.switchTo().window(originalWindowHandle);

        //2

        WebElement TwitterLink = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/footer[1]/ul[1]/li[1]/a[1]"));
        TwitterLink.click();
        // Wait for the new window to open
        originalWindowHandle = driver.getWindowHandle();
        for(String windowHandle : driver.getWindowHandles()) {
            if(!windowHandle.equals(originalWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        // Navigating back to the main page
        driver.switchTo().window(originalWindowHandle);

        //3rd link
        WebElement LinkedInLink = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/footer[1]/ul[1]/li[3]/a[1]"));
        LinkedInLink.click();
        // Wait for the new window to open
        originalWindowHandle = driver.getWindowHandle();
        for(String windowHandle : driver.getWindowHandles()) {
            if(!windowHandle.equals(originalWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        // Navigating back to the main page
        driver.switchTo().window(originalWindowHandle);


        driver.quit();

    }
}


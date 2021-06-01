package com.prathyusha.devops.project;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AppTestFirefox
{
    @Test
    public void verify()
    {
        String expectedAboutText = "This is about page. Lorem Ipsum Dipsum is simply dummy text of the printing and typesetting industry. " +
                "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. " +
                "It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. " +
                "It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
                "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. " + "" +
                "The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. " +
                "Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. " +
                "Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).";

        System.out.println("Launching the firefox browser in headless mode...");
        System.out.println("~/Documents/geckodriver");
     //   System.setProperty("webdriver.gecko.driver","/Users/prathyushatumuluri/Downloads/geckodriver");
        System.setProperty("webdriver.gecko.driver","~/Documents/geckodriver");
        System.out.println("~/Documents/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        options.addArguments("-headless");
        WebDriver driver = new FirefoxDriver(options);

        System.out.println("Opening the php website...");
        driver.get("http://localhost:8092/index.php");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        boolean isAboutButtonDisplayed = driver.findElement(By.xpath("//*[@id=\"About Us\"]")).isDisplayed();
        boolean isAboutButtonEnabled = driver.findElement(By.xpath("//*[@id=\"About Us\"]")).isEnabled();

        System.out.println("Verifying if the About button is displayed...");
        Assert.assertEquals(isAboutButtonDisplayed, true);

        System.out.println("Verifying if the About button is enabled...");
        Assert.assertEquals(isAboutButtonEnabled, true);

        System.out.println("Clicking the About button...");
        driver.findElement(By.xpath("//*[@id=\"About Us\"]")).click();

        System.out.println("Verifying the About page text...\n");

        String actualAboutText = driver.findElement(By.tagName("body")).getText();
        Assert.assertEquals(actualAboutText, expectedAboutText);

        driver.close();
    }
}

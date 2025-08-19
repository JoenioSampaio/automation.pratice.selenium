package dev.joenio.automation.pratice.selenium;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AppTest {
    public WebDriver driver;

    @Test
    public void helloSelenium() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");

        String currentUrl = driver.getCurrentUrl();
        String expected = "https://www.saucedemo.com/";

        Assertions.assertEquals(expected, currentUrl);

        driver.quit();
    }

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }
}

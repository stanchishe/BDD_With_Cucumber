package org.example;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class TestHomePage {
    public static WebDriver webDriver;
    public static HomePage homePage;

    @Before
    public static void initSetup() {
        ChromeOptions options = new ChromeOptions().addArguments("Start-Maximized");
        // options.addExtensions(new File("resources\\addBlocker.exe"));
        webDriver = new ChromeDriver(options);
        homePage = new HomePage(webDriver);
    }

    @AfterAll
    public static void closeAndQuit() {
        webDriver.close();
        webDriver.quit();
    }
    @Given("the browser is open")
    public void the_browser_is_open() {
        Assertions.assertTrue(homePage.isBrowserOpen(), "The browser is not open!");
    }
    @Given("the home page is loaded")
    public void the_home_page_is_loaded() {
        Assertions.assertTrue(homePage.isHomePageOpen(), "We are not on the expected home page!");
    }
    @Then("there are {int} sliders on the home page")
    public void there_are_sliders_on_the_home_page(Integer expectedSliderCount) {
        Assertions.assertEquals(expectedSliderCount, homePage.getSliderCount(), "Too many or too few sliders were located!");
    }
}

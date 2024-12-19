package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage {
    private static final String homePageUrl = "https://practice.automationtesting.in/";
    public HomePage(WebDriver webDriver) {
        super(webDriver, homePageUrl);
        super.load();
    }

    public boolean isHomePageOpen() {
        String realHomePage = webDriver.getCurrentUrl().trim();
        return realHomePage.equalsIgnoreCase(homePageUrl);
    }

    public int getSliderCount() {
        List<WebElement> sliderContainer = webDriver.findElements(By.xpath("//*[@id=\"n2-ss-6\"]/div[1]/div/div/div"));
        return sliderContainer.size();
    }
}

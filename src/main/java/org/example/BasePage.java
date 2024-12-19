package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

public class BasePage extends LoadableComponent {
    public WebDriver webDriver;
    private String pageUrl;
    public BasePage(WebDriver webDriver, String pageUrl) {
        this.pageUrl = pageUrl;
        this.webDriver = webDriver;
    }

    @Override
    protected void load() {
        webDriver.get(pageUrl);
    }

    @Override
    protected void isLoaded() {
        String realUrl = webDriver.getCurrentUrl().trim();
        if(!realUrl.equalsIgnoreCase(pageUrl)) {
            throw new Error ("Wrong page was loaded!");
        }
    }

    public boolean isBrowserOpen() {
        boolean browserIsOpen;
        try {
            webDriver.getWindowHandles();
            browserIsOpen = true;
        } catch (NullPointerException e) {
            browserIsOpen = false;
        }
        return browserIsOpen;
    }
}

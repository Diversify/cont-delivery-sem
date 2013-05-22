package se.diversify.webroti.acctest.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RootPage {

    private final WebDriver driver;

    public RootPage(WebDriver driver) {
        this.driver = driver;
    }

    public RootPage go() {
        driver.get("http://systest:8080/webroti/");
        return this;
    }

    public boolean isOnPage() {
        final String title = driver.getTitle();
        return "webroti".equals(title);
    }

    public void clickNewMeeting() {
        driver.findElement(By.className("create-meeting")).click();
    }
}

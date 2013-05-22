package se.diversify.webroti.acctest.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.fail;

public class MeetingPage {
    private final WebDriver driver;

    public MeetingPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOnPage() {
        final String title = driver.getTitle();
        return "meeting".equals(title);
    }

    public String getMeetingId() {
        driver.findElement(By.className("meeting-id")).getText();
    }
}

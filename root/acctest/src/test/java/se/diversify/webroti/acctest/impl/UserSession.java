package se.diversify.webroti.acctest.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.junit.Assert.assertTrue;

public class UserSession {

    WebDriver driver = new HtmlUnitDriver();
//    WebDriver driver = new FirefoxDriver();

    public boolean systemIsAlive() {
        return new RootPage(driver).go().isOnPage();
    }

    public void createNewMeeting() {
        new RootPage(driver).clickNewMeeting();
    }

    public String getMeetingId() {
        sleep(4000);
        final MeetingPage meetingPage = new MeetingPage(driver);
        assertTrue(meetingPage.isOnPage());
        return meetingPage.getMeetingId();
    }

    private void sleep(long timeMs) {
        try {
            Thread.sleep(timeMs);
        } catch (InterruptedException e) {
            // Ignore
        }
    }
}

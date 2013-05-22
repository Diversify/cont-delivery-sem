package se.diversify.webroti.acctest.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.junit.Assert.assertTrue;

public class UserSession {

    WebDriver driver = new HtmlUnitDriver();

    public boolean systemIsAlive() {
        return new RootPage(driver).go().isOnPage();
    }

    public void createNewMeeting() {
        new RootPage(driver).clickNewMeeting();
    }

    public String getMeetingId() {
        final MeetingPage meetingPage = new MeetingPage(driver);
        assertTrue(meetingPage.isOnPage());
        return meetingPage.getMeetingId();
    }
}

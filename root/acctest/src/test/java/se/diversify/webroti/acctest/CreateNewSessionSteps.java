package se.diversify.webroti.acctest;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import se.diversify.webroti.acctest.impl.FirstPage;
import se.diversify.webroti.acctest.impl.SessionRootPage;

import static org.junit.Assert.assertTrue;

public class CreateNewSessionSteps {

    FirstPage firstPage = new FirstPage();
    SessionRootPage sessionRootPage = new SessionRootPage();

    @Given("the first page is open")
    public void givenTheFirstPageIsOpen() {
        firstPage.get();
    }

    @When("I create a new session")
    public void whenICreateANewSession() {
        firstPage.createNewSession();
    }

    @Then("the session root page is opened")
    public void thenTheSessionRootPageIsOpened() {
        sessionRootPage.assertOnPage();
    }

    @Then("an id is displayed")
    public void thenAnIdIsDisplayed() {
        String sessionId = sessionRootPage.getSessionId();
        assertTrue(sessionId.length() > 0);
    }
}

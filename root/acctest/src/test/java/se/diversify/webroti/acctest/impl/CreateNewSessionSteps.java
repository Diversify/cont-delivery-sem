package se.diversify.webroti.acctest.impl;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.junit.Assert.assertTrue;

public class CreateNewSessionSteps {

    UserSession session = new UserSession();

    @Given("the system is up and running")
    public void givenTheSystemIsUpAndRunning() {
        assertTrue(session.systemIsAlive());
    }

    @When("I create a new meeting")
    public void whenICreateANewMeeting() {
        session.createNewMeeting();
    }

    @Then("a new meeting with an id is created")
    public void thenANewMeetingWithAnIdIsCreated() {
        String id = session.getMeetingId();
        assertTrue(id.length() > 0);
    }
}

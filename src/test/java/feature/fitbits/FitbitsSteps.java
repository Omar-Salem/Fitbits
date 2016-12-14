package feature.fitbits;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.omarsalem.fitbits.SoccerPitch;
import org.omarsalem.fitbits.Trainee;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FitbitsSteps {

    private SoccerPitch target;
    private String finalPosition;

    @Given("^boundaries are (\\d+),(\\d+)$")
    public void boundaries_are(int length, int width) throws Throwable {
        target = new SoccerPitch(length, width);
    }

    @And("^trainee position is (\\d+),(\\d+),\"([^\"]*)\"$")
    public void traineePositionIs(int x, int y, String heading) throws Throwable {
        Trainee trainee = new Trainee(x, y, heading);
        target.add(trainee);
    }

    @And("^coach instructs trainee$")
    public void coachInstructsTrainee(List<String> instructions) throws Throwable {
        final int count = target.getTraineesCount();
        instructions.forEach(instruction -> target.instruct(count - 1, instruction));
    }

    @When("^trainee (\\d+) is finished$")
    public void traineeIsFinished(int id) throws Throwable {
        finalPosition = target.getFinalPosition(id - 1);
    }

    @Then("^output is \"([^\"]*)\"$")
    public void outputIs(String expected) throws Throwable {
        assertEquals(expected, finalPosition);
    }
}

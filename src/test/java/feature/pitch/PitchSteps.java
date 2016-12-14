package feature.pitch;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.omarsalem.fitbits.models.SoccerPitch;
import org.omarsalem.fitbits.models.Trainee;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PitchSteps {

    private SoccerPitch target;
    private String finalPosition;

    @Given("^boundaries are (\\d+),(\\d+)$")
    public void boundaries_are(int length, int width) throws Throwable {
        target = new SoccerPitch(length, width);
    }

    @And("^trainee position is (\\d+),(\\d+),\"([^\"]*)\"$")
    public void traineePositionIs(int x, int y, String heading) throws Throwable {
        Trainee trainee = new Trainee(x, y, heading);
        target.addTrainee(trainee);
    }

    @And("^coach instructs trainee$")
    public void coachInstructsTrainee(List<String> instructions) throws Throwable {
        final int count = target.getTraineesCount();
        instructions.forEach(instruction -> target.instructTrainee(count - 1, instruction));
    }

    @When("^trainee (\\d+) is finished$")
    public void traineeIsFinished(int id) throws Throwable {
        finalPosition = target.getTraineeFinalPosition(id - 1);
    }

    @Then("^output is \"([^\"]*)\"$")
    public void outputIs(String expected) throws Throwable {
        assertEquals(expected, finalPosition);
    }

    @Then("^pitch has (\\d+) trainees$")
    public void pitchHasTrainees(int count) throws Throwable {
        assertEquals(count, target.getTraineesCount());
    }
}

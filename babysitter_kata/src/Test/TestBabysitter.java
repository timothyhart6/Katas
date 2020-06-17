package Test;

import BabySitterKata.Babysitter;
import BabySitterKata.Family;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBabysitter {

    @Test
    public void testCalculateNightlyCharge() {
        Babysitter babysitter = new Babysitter();
        Family familyA = new Family();
        familyA.setRateForARangeOfHours("5pm", "11pm", 15);
        familyA.setRateForARangeOfHours("11pm", "4am", 20);
        int nightlyCharge = babysitter.calculateNightlyCharge("5pm", "4am", familyA);
        assertEquals(190, nightlyCharge);
    }
}

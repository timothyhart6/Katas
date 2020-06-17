package Test;

import BabySitterKata.Family;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestFamily {
    Family family;

    @BeforeEach
    public void init() {
        family = new Family();
    }

    @Test
    public void testGetASpecificHourlyRate() {
        family.setHourlyRate("9pm", 15);
        assertEquals(15, family.getHourlyRate("9pm"));
    }

    @Test
    public void testAssignHourlyRatesByHourlyRange() {
        family.setRateForARangeOfHours("5pm", "11pm", 15);
        assertEquals(15, family.getHourlyRate("8pm"));
        assertNull(family.getHourlyRate("11pm"));
    }

    @Test
    public void testAMHourIsAfterPMHour() {
        family.setRateForARangeOfHours("9pm", "4am", 15);
        assertNotNull(family.getHourlyRate("3am"));
        assertNotNull(family.getHourlyRate("10pm"));
    }

    @Test
    public void testMidnightIsAM() {
        family.setRateForARangeOfHours("9pm", "4am", 15);
        assertNotNull(family.getHourlyRate("12am"));
        assertNull(family.getHourlyRate("12pm"));
    }

    @Test
    public void testSettingAllFamilyHours() {
        family.setRateForARangeOfHours("5pm", "10pm", 12);
        family.setRateForARangeOfHours("10pm", "12am", 8);
        family.setRateForARangeOfHours("1am", "4am", 16);
        assertEquals(12, family.getHourlyRate("5pm"));
        assertEquals(8, family.getHourlyRate("12am"));
        assertEquals(16, family.getHourlyRate("2am"));
    }

    @Test
    public void hourIsCaseInsensative() {
        family.setRateForARangeOfHours("10PM", "4Am", 15);
        assertNotNull(family.getHourlyRate("10pm"));
    }

    @Test
    public void updateHourlyRate() {
        family.setRateForARangeOfHours("9pm", "2am", 12);
        family.setRateForARangeOfHours("11pm", "4am", 15);
        assertEquals(15, family.getHourlyRate("1am"));
        assertEquals(15, family.getHourlyRate("3am"));
        assertEquals(12, family.getHourlyRate("10pm"));
    }
}

package no.johnsen.fredrik;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class CalendarTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testToStringArray()
    {
        String [] test = {"2020-10-12 08:00", "2020-10-12 16:00", "Jobbe", "Fri da det er helg"};
        Event testEvent = new Event("2020-10-12 08:00", "2020-10-12 16:00", "Jobbe", "Fri da det er helg");
        String[] shouldBe = testEvent.toStringArray();
        assertArrayEquals( shouldBe, test );
    }
}
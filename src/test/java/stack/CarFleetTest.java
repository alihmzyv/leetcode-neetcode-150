package stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarFleetTest {

    @Test
    void carFleet() {
        assertEquals(2, new CarFleet().carFleet(10, new int[]{6, 8}, new int[]{3, 2}));
    }
}
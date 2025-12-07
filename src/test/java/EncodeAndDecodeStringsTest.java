import arraysandhashing.EncodeAndDecodeStrings;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EncodeAndDecodeStringsTest {
    @Test
    void testEncode() {
        assertEquals("4#neet4#code4#love3#you", new EncodeAndDecodeStrings().encode(List.of("neet","code","love","you")));
    }

    @Test
    void testDecode() {
        assertEquals(List.of("neet","code","love","you"), new EncodeAndDecodeStrings().decode("4#neet4#code4#love3#you"));
    }
}
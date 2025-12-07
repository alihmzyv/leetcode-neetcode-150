import arraysandhashing.TopKFrequentElements;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TopKFrequentElementsTest {

    @Test
    void topKFrequentSorting() {
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        assertArrayEquals(new int[]{1, 2}, topKFrequentElements.topKFrequentSorting(new int[]{1, 1, 1, 2, 2, 3}, 2));
    }

    @Test
    void topKFrequentSortingTest2() {
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        assertArrayEquals(new int[]{1, 3}, topKFrequentElements.topKFrequentSorting(new int[]{5, 3, 1, 1, 1, 3, 73, 1}, 2));
    }
}
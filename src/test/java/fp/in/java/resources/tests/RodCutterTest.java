package fp.in.java.resources.tests;

import org.junit.Test;

import static fp.in.java.resources.tests.TestHelper.assertThrows;
import static java.util.Collections.emptyList;

public class RodCutterTest {
    @Test
    public void ConciseExceptionTest() {
        RodCutter rodCutter = new RodCutter();
        rodCutter.setPrices(emptyList());
        assertThrows(RodCutter.RodCutterException.class, () -> rodCutter.maxProfit(0));
    }
}

package fp.in.java.resources.tests;

import java.util.List;

public class RodCutter {
    public void setPrices(final List<Integer> prices) {}

    public int maxProfit(final int length) {
        if (length == 0) throw new RodCutterException();

        return 0;
    }

    class RodCutterException extends RuntimeException {
        private static final long serialVersionUID = 6689024698777554383L;
    }
}

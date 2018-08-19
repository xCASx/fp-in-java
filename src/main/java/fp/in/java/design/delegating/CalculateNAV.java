package fp.in.java.design.delegating;

import java.math.BigDecimal;
import java.util.function.Function;

public class CalculateNAV {
    private Function<String, BigDecimal> priceFinder;

    public CalculateNAV(final Function<String, BigDecimal> priceFinder) {
        this.priceFinder = priceFinder;
    }

    public BigDecimal computeStockWorth(final String ticker, final int shares) {
        return priceFinder.apply(ticker).multiply(BigDecimal.valueOf(shares));
    }

    public static void main(String[] args) {
        final CalculateNAV calculateNAV = new CalculateNAV(YahooFinance::getPrice);

        System.out.println(String.format("100 shares of Google worth: $%.2f", calculateNAV.computeStockWorth("GOOG", 100)));
    }
}

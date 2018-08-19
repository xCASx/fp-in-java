package fp.in.java.laziness.evaluation;

import java.util.function.Supplier;

public class Evaluation {
    public static boolean evaluate(final int value) {
        System.out.println("evaluating ..." + value);
        simulateTimeConsumingOp(2000);
        return value > 100;
    }

    private static void simulateTimeConsumingOp(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void lazyEvaluator(final Supplier<Boolean> input1, final Supplier<Boolean> input2) {
        System.out.println("lazyEvaluator called...");
        System.out.println("accept?: " + (input1.get() && input2.get()));
    }

    public static void main(String[] args) {
        lazyEvaluator(() -> evaluate(1), () -> evaluate(2));
    }
}

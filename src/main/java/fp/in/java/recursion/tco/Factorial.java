package fp.in.java.recursion.tco;

import static fp.in.java.recursion.tco.TailCalls.call;
import static fp.in.java.recursion.tco.TailCalls.done;

public class Factorial {
    public static TailCall<Integer> factorialTailRec(final int factorial, final int number) {
        return number == 1 ?
                done(factorial) :
                call(() -> factorialTailRec(factorial * number, number - 1));
    }

    public static int factorial(final int number) {
        return factorialTailRec(1, number).invoke();
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(factorial(20_000));
    }
}

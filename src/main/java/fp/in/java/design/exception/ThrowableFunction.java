package fp.in.java.design.exception;

@FunctionalInterface
public interface ThrowableFunction<R, T, X extends Throwable> {
    R apply(T t) throws X;
}

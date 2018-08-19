package fp.in.java.design.exception;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

public class HandleException {
    public static void main(String[] args) {
        ThrowableFunction<String, String, IOException> func = path -> new File(path).getCanonicalPath();
        Stream.of("/usr", "/tmp")
//                .map(func)
                .map(path -> {
                    try {
                        return new File(path).getCanonicalPath();
                    } catch (IOException e) {
                        return e.getMessage();
                    }
                })
                .forEach(System.out::println);
    }
}

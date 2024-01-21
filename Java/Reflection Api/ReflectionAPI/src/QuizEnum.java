import java.util.*;
import java.util.stream.*;
public enum QuizEnum {
    ADD(1, "add"),
    SUB(2, "sub"),
    SHOW(3, "show");
    private final Integer choice;
    private final String operation;
    QuizEnum(Integer choice, String operation) {
        this.operation = operation;
        this.choice = choice;
    }

    public static final Map<Integer, String> operations = Stream.of(values())
            .collect(Collectors.toMap(k -> k.choice, v -> v.operation));
}


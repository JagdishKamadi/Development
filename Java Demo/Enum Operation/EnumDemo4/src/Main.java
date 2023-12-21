import java.util.EnumSet;

public class Main {
    public static void main(String[] args) {

        EnumSet<Day> days = EnumSet.allOf(Day.class);
        System.out.println(days);

        days.stream()
                .filter(day -> day.getDayCode().equals("TUES"))
                .forEach(day -> System.out.println(day.getDayCode()));
    }
}
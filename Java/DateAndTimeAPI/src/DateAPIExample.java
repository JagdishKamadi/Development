

import java.time.*;
import java.util.Date;

public class DateAPIExample {
    public static void main(String[] args) {
        showDateExample();
    }
    public static void showDateExample()
    {
        // number of method to get the date is given below
        LocalDate localDate1 = LocalDate.now();
        System.out.println(localDate1);

        LocalDate localDate2 = LocalDate.from(LocalDate.now());
        System.out.println(localDate2);

        LocalDate localDate3 = LocalDate.now(Clock.system(ZoneId.systemDefault()));
        System.out.println(localDate3);

        LocalDate localDate4 = LocalDate.now(ZoneId.of("Asia/Tokyo"));
        System.out.println(localDate4);

        LocalDate localDate5 = LocalDate.of(2000, Month.NOVEMBER,3);
        System.out.println(localDate5);
        System.out.println(localDate5.getYear());
        System.out.println(localDate5.getMonth());
        System.out.println(localDate5.getDayOfMonth());

        // want to know age?
        LocalDate birthDay = LocalDate.of(2000,11,03);
        LocalDate present  = LocalDate.now();
        // calculate the age
        Period  p = Period.between(birthDay,present);
        System.out.println("Current Age "+p);



    }
}

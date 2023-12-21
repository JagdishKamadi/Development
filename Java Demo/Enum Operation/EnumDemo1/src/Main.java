public class Main {
    public static void main(String[] args) {
        Day today = Day.MONDAY;
        System.out.println(today);
        System.out.println(today.toString());
        System.out.println(today.equals("MONDAY"));
        System.out.println(today.toString().equals("MONDAY"));


        switch (today) {
            case MONDAY:
                System.out.println("It's Monday.");
                break;
            case TUESDAY:
                System.out.println("It's Tuesday.");
                break;
            default:
                System.out.println("Can't determine");
                break;
        }

        for (Day day : Day.values()) {
            System.out.println(day);
        }
    }
}
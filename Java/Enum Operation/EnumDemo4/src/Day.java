enum Day {
    SUNDAY("SUN"),
    MONDAY("MON"),
    TUESDAY("TUES"),
    WEDNESDAY("WED"),
    THURSDAY("THU"),
    FRIDAY("FRI"),
    SATURDAY("SAT");
    private String dayCode;

    Day(String dayCode) {
        this.dayCode = dayCode;
    }

    public String getDayCode() {
        return dayCode;
    }
}

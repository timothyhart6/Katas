package BabySitterKata;

public class Babysitter {

    public int calculateNightlyCharge(String startTime, String endTime, Family family) {
        int nightlyCharge = 0;

        int startTimeAsInteger = Integer.parseInt(startTime.replaceAll("[\\D]", ""));
        if (startTime.toLowerCase().endsWith("am") && (!startTime.startsWith("12"))) startTimeAsInteger += 12;
        int endTimeAsInteger = Integer.parseInt((endTime.replaceAll("[\\D]", "")));
        if (endTime.toLowerCase().endsWith("am") && (!endTime.startsWith("12"))) endTimeAsInteger += 12;

        for (int i = startTimeAsInteger; i < endTimeAsInteger; i++) {
            String stringHour = i == 12 ? String.valueOf(i).concat("am") :
                                i > 12  ? String.valueOf(i - 12).concat("am") :
                                          String.valueOf(i).concat("pm");
            nightlyCharge += family.getHourlyRate(stringHour);
        }
        return nightlyCharge;
    }
}

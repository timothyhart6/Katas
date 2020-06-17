package BabySitterKata;

import java.util.HashMap;

public class Family {

   private HashMap<String, Integer> hourlyRates = new HashMap<String, Integer>();

    public Integer getHourlyRate(String hour) {
        return hourlyRates.get(hour);
    }

    public void setHourlyRate(String hour, Integer rate) {
        hourlyRates.put(hour, rate);
    }

    public void setRateForARangeOfHours(String startTime, String endTime, Integer rate) {
        int startTimeAsInteger = Integer.parseInt(startTime.replaceAll("[\\D]", ""));
        if (startTime.toLowerCase().endsWith("am") && (!startTime.startsWith("12"))) startTimeAsInteger += 12;

        int endTimeAsInteger = Integer.parseInt(endTime.replaceAll("[\\D]", ""));
        if (endTime.toLowerCase().endsWith("am") && (!startTime.startsWith("12"))) endTimeAsInteger += 12;

        for (int i = startTimeAsInteger; i < endTimeAsInteger; i++) {
            String stringHour = i == 12 ? String.valueOf(i).concat("am") :
                                i > 12  ? String.valueOf(i - 12).concat("am") :
                                          String.valueOf(i).concat("pm");
            setHourlyRate(stringHour, rate);
        }
    }
}

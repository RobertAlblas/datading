package nl.robertalblas.datading;

import java.util.HashMap;
import java.util.Optional;
import java.util.OptionalInt;

public class Timeslot {

    private static final HashMap<String, Timeslot> TIMESLOTS = new HashMap();

    static {
        addTimeslot(new Timeslot("1", new TimeslotPeriod("4:00", "4:10")));
        addTimeslot(new Timeslot("2", new TimeslotPeriod("4:10", "4:20")));
        addTimeslot(new Timeslot("3", new TimeslotPeriod("4:20", "4:30")));
        addTimeslot(new Timeslot("4", new TimeslotPeriod("4:30", "4:40")));
        addTimeslot(new Timeslot("5", new TimeslotPeriod("4:40", "4:50")));
        addTimeslot(new Timeslot("6", new TimeslotPeriod("4:50", "5:00")));
        addTimeslot(new Timeslot("7", new TimeslotPeriod("5:00", "5:10")));
        addTimeslot(new Timeslot("8", new TimeslotPeriod("5:10", "5:20")));
        addTimeslot(new Timeslot("9", new TimeslotPeriod("5:20", "5:30")));
        addTimeslot(new Timeslot("10", new TimeslotPeriod("5:30",  "5:40")));
        addTimeslot(new Timeslot("11", new TimeslotPeriod("5:40",  "5:50")));
        addTimeslot(new Timeslot("12", new TimeslotPeriod("5:50",  "6:00")));
        addTimeslot(new Timeslot("13", new TimeslotPeriod("6:00",  "6:10")));
        addTimeslot(new Timeslot("14", new TimeslotPeriod("6:10",  "6:20")));
        addTimeslot(new Timeslot("15", new TimeslotPeriod("6:20",  "6:30")));
        addTimeslot(new Timeslot("16", new TimeslotPeriod("6:30",  "6:40")));
        addTimeslot(new Timeslot("17", new TimeslotPeriod("6:40",  "6:50")));
        addTimeslot(new Timeslot("18", new TimeslotPeriod("6:50",  "7:00")));
        addTimeslot(new Timeslot("19", new TimeslotPeriod("7:00",  "7:10")));
        addTimeslot(new Timeslot("20", new TimeslotPeriod("7:10",  "7:20")));
        addTimeslot(new Timeslot("21", new TimeslotPeriod("7:20",  "7:30")));
        addTimeslot(new Timeslot("22", new TimeslotPeriod("7:30",  "7:40")));
        addTimeslot(new Timeslot("23", new TimeslotPeriod("7:40",  "7:50")));
        addTimeslot(new Timeslot("24", new TimeslotPeriod("7:50",  "8:00")));
        addTimeslot(new Timeslot("25", new TimeslotPeriod("8:00",  "8:10")));
        addTimeslot(new Timeslot("26", new TimeslotPeriod("8:10",  "8:20")));
        addTimeslot(new Timeslot("27", new TimeslotPeriod("8:20",  "8:30")));
        addTimeslot(new Timeslot("28", new TimeslotPeriod("8:30",  "8:40")));
        addTimeslot(new Timeslot("29", new TimeslotPeriod("8:40",  "8:50")));
        addTimeslot(new Timeslot("30", new TimeslotPeriod("8:50",  "9:00")));
        addTimeslot(new Timeslot("31", new TimeslotPeriod("9:00",  "9:10")));
        addTimeslot(new Timeslot("32", new TimeslotPeriod("9:10",  "9:20")));
        addTimeslot(new Timeslot("33", new TimeslotPeriod("9:20",  "9:30")));
        addTimeslot(new Timeslot("34", new TimeslotPeriod("9:30",  "9:40")));
        addTimeslot(new Timeslot("35", new TimeslotPeriod("9:40",  "9:50")));
        addTimeslot(new Timeslot("36", new TimeslotPeriod("9:50",  "10:00")));
        addTimeslot(new Timeslot("37", new TimeslotPeriod("10:00", "10:10")));
        addTimeslot(new Timeslot("38", new TimeslotPeriod("10:10", "10:20")));
        addTimeslot(new Timeslot("39", new TimeslotPeriod("10:20", "10:30")));
        addTimeslot(new Timeslot("40", new TimeslotPeriod("10:30", "10:40")));
        addTimeslot(new Timeslot("41", new TimeslotPeriod("10:40", "10:50")));
        addTimeslot(new Timeslot("42", new TimeslotPeriod("10:50", "11:00")));
        addTimeslot(new Timeslot("43", new TimeslotPeriod("11:00", "11:10")));
        addTimeslot(new Timeslot("44", new TimeslotPeriod("11:10", "11:20")));
        addTimeslot(new Timeslot("45", new TimeslotPeriod("11:20", "11:30")));
        addTimeslot(new Timeslot("46", new TimeslotPeriod("11:30", "11:40")));
        addTimeslot(new Timeslot("47", new TimeslotPeriod("11:40", "11:50")));
        addTimeslot(new Timeslot("48", new TimeslotPeriod("11:50", "12:00")));
        addTimeslot(new Timeslot("49", new TimeslotPeriod("12:00", "12:10")));
        addTimeslot(new Timeslot("50", new TimeslotPeriod("12:10", "12:20")));
        addTimeslot(new Timeslot("51", new TimeslotPeriod("12:20", "12:30")));
        addTimeslot(new Timeslot("52", new TimeslotPeriod("12:30", "12:40")));
        addTimeslot(new Timeslot("53", new TimeslotPeriod("12:40", "12:50")));
        addTimeslot(new Timeslot("54", new TimeslotPeriod("12:50", "13:00")));
        addTimeslot(new Timeslot("55", new TimeslotPeriod("13:00", "13:10")));
        addTimeslot(new Timeslot("56", new TimeslotPeriod("13:10", "13:20")));
        addTimeslot(new Timeslot("57", new TimeslotPeriod("13:20", "13:30")));
        addTimeslot(new Timeslot("58", new TimeslotPeriod("13:30", "13:40")));
        addTimeslot(new Timeslot("59", new TimeslotPeriod("13:40", "13:50")));
        addTimeslot(new Timeslot("60", new TimeslotPeriod("13:50", "14:00")));
        addTimeslot(new Timeslot("61", new TimeslotPeriod("14:00", "14:10")));
        addTimeslot(new Timeslot("62", new TimeslotPeriod("14:10", "14:20")));
        addTimeslot(new Timeslot("63", new TimeslotPeriod("14:20", "14:30")));
        addTimeslot(new Timeslot("64", new TimeslotPeriod("14:30", "14:40")));
        addTimeslot(new Timeslot("65", new TimeslotPeriod("14:40", "14:50")));
        addTimeslot(new Timeslot("66", new TimeslotPeriod("14:50", "15:00")));
        addTimeslot(new Timeslot("67", new TimeslotPeriod("15:00", "15:10")));
        addTimeslot(new Timeslot("68", new TimeslotPeriod("15:10", "15:20")));
        addTimeslot(new Timeslot("69", new TimeslotPeriod("15:20", "15:30")));
        addTimeslot(new Timeslot("70", new TimeslotPeriod("15:30", "15:40")));
        addTimeslot(new Timeslot("71", new TimeslotPeriod("15:40", "15:50")));
        addTimeslot(new Timeslot("72", new TimeslotPeriod("15:50", "16:00")));
        addTimeslot(new Timeslot("73", new TimeslotPeriod("16:00", "16:10")));
        addTimeslot(new Timeslot("74", new TimeslotPeriod("16:10", "16:20")));
        addTimeslot(new Timeslot("75", new TimeslotPeriod("16:20", "16:30")));
        addTimeslot(new Timeslot("76", new TimeslotPeriod("16:30", "16:40")));
        addTimeslot(new Timeslot("77", new TimeslotPeriod("16:40", "16:50")));
        addTimeslot(new Timeslot("78", new TimeslotPeriod("16:50", "17:00")));
        addTimeslot(new Timeslot("79", new TimeslotPeriod("17:00", "17:10")));
        addTimeslot(new Timeslot("80", new TimeslotPeriod("17:10", "17:20")));
        addTimeslot(new Timeslot("81", new TimeslotPeriod("17:20", "17:30")));
        addTimeslot(new Timeslot("82", new TimeslotPeriod("17:30", "17:40")));
        addTimeslot(new Timeslot("83", new TimeslotPeriod("17:40", "17:50")));
        addTimeslot(new Timeslot("84", new TimeslotPeriod("17:50", "18:00")));
        addTimeslot(new Timeslot("85", new TimeslotPeriod("18:00", "18:10")));
        addTimeslot(new Timeslot("86", new TimeslotPeriod("18:10", "18:20")));
        addTimeslot(new Timeslot("87", new TimeslotPeriod("18:20", "18:30")));
        addTimeslot(new Timeslot("88", new TimeslotPeriod("18:30", "18:40")));
        addTimeslot(new Timeslot("89", new TimeslotPeriod("18:40", "18:50")));
        addTimeslot(new Timeslot("90", new TimeslotPeriod("18:50", "19:00")));
        addTimeslot(new Timeslot("91", new TimeslotPeriod("19:00", "19:10")));
        addTimeslot(new Timeslot("92", new TimeslotPeriod("19:10", "19:20")));
        addTimeslot(new Timeslot("93", new TimeslotPeriod("19:20", "19:30")));
        addTimeslot(new Timeslot("94", new TimeslotPeriod("19:30", "19:40")));
        addTimeslot(new Timeslot("95", new TimeslotPeriod("19:40", "19:50")));
        addTimeslot(new Timeslot("96", new TimeslotPeriod("19:50", "20:00")));
        addTimeslot(new Timeslot("97", new TimeslotPeriod("20:00", "20:10")));
        addTimeslot(new Timeslot("98", new TimeslotPeriod("20:10", "20:20")));
        addTimeslot(new Timeslot("99", new TimeslotPeriod("20:20", "20:30")));
        addTimeslot(new Timeslot("100", new TimeslotPeriod("20:30", "20:40")));
        addTimeslot(new Timeslot("101", new TimeslotPeriod("20:40", "20:50")));
        addTimeslot(new Timeslot("102", new TimeslotPeriod("20:50", "21:00")));
        addTimeslot(new Timeslot("103", new TimeslotPeriod("21:00", "21:10")));
        addTimeslot(new Timeslot("104", new TimeslotPeriod("21:10", "21:20")));
        addTimeslot(new Timeslot("105", new TimeslotPeriod("21:20", "21:30")));
        addTimeslot(new Timeslot("106", new TimeslotPeriod("21:30", "21:40")));
        addTimeslot(new Timeslot("107", new TimeslotPeriod("21:40", "21:50")));
        addTimeslot(new Timeslot("108", new TimeslotPeriod("21:50", "22:00")));
        addTimeslot(new Timeslot("109", new TimeslotPeriod("22:00", "22:10")));
        addTimeslot(new Timeslot("110", new TimeslotPeriod("22:10", "22:20")));
        addTimeslot(new Timeslot("111", new TimeslotPeriod("22:20", "22:30")));
        addTimeslot(new Timeslot("112", new TimeslotPeriod("22:30", "22:40")));
        addTimeslot(new Timeslot("113", new TimeslotPeriod("22:40", "22:50")));
        addTimeslot(new Timeslot("114", new TimeslotPeriod("22:50", "23:00")));
        addTimeslot(new Timeslot("115", new TimeslotPeriod("23:00", "23:10")));
        addTimeslot(new Timeslot("116", new TimeslotPeriod("23:10", "23:20")));
        addTimeslot(new Timeslot("117", new TimeslotPeriod("23:20", "23:30")));
        addTimeslot(new Timeslot("118", new TimeslotPeriod("23:30", "23:40")));
        addTimeslot(new Timeslot("119", new TimeslotPeriod("23:40", "23:50")));
        addTimeslot(new Timeslot("120", new TimeslotPeriod("23:50", "0:00")));
        addTimeslot(new Timeslot("121", new TimeslotPeriod("0:00", "0:10")));
        addTimeslot(new Timeslot("122", new TimeslotPeriod("0:10", "0:20")));
        addTimeslot(new Timeslot("123", new TimeslotPeriod("0:20", "0:30")));
        addTimeslot(new Timeslot("124", new TimeslotPeriod("0:30", "0:40")));
        addTimeslot(new Timeslot("125", new TimeslotPeriod("0:40", "0:50")));
        addTimeslot(new Timeslot("126", new TimeslotPeriod("0:50", "1:00")));
        addTimeslot(new Timeslot("127", new TimeslotPeriod("1:00", "1:10")));
        addTimeslot(new Timeslot("128", new TimeslotPeriod("1:10", "1:20")));
        addTimeslot(new Timeslot("129", new TimeslotPeriod("1:20", "1:30")));
        addTimeslot(new Timeslot("130", new TimeslotPeriod("1:30", "1:40")));
        addTimeslot(new Timeslot("131", new TimeslotPeriod("1:40", "1:50")));
        addTimeslot(new Timeslot("132", new TimeslotPeriod("1:50", "2:00")));
        addTimeslot(new Timeslot("133", new TimeslotPeriod("2:00", "2:10")));
        addTimeslot(new Timeslot("134", new TimeslotPeriod("2:10", "2:20")));
        addTimeslot(new Timeslot("135", new TimeslotPeriod("2:20", "2:30")));
        addTimeslot(new Timeslot("136", new TimeslotPeriod("2:30", "2:40")));
        addTimeslot(new Timeslot("137", new TimeslotPeriod("2:40", "2:50")));
        addTimeslot(new Timeslot("138", new TimeslotPeriod("2:50", "3:00")));
        addTimeslot(new Timeslot("139", new TimeslotPeriod("3:00", "3:10")));
        addTimeslot(new Timeslot("140", new TimeslotPeriod("3:10", "3:20")));
        addTimeslot(new Timeslot("141", new TimeslotPeriod("3:20", "3:30")));
        addTimeslot(new Timeslot("142", new TimeslotPeriod("3:30", "3:40")));
        addTimeslot(new Timeslot("143", new TimeslotPeriod("3:40", "3:50")));
        addTimeslot(new Timeslot("144", new TimeslotPeriod("3:50", "4:00")));
    }
    
    private static void addTimeslot(Timeslot timeslot) {
        TIMESLOTS.put(timeslot.id, timeslot);
    }

    private String id;
    private TimeslotPeriod timeslotPeriod;

    public Timeslot(String id, TimeslotPeriod timeslotPeriod) {
        this.id = id;
        this.timeslotPeriod = timeslotPeriod;
    }

    public static Timeslot getTimeslot(String id) {
        return TIMESLOTS.get(id);
    }

    public boolean matches(TimeslotPeriod period) {
        return period.getEndtime().isAfter(this.timeslotPeriod.getStartTime())
                && period.getStartTime().isBefore(this.timeslotPeriod.getEndtime());
    }
}

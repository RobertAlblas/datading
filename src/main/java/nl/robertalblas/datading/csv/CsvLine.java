package nl.robertalblas.datading.csv;

import nl.robertalblas.datading.Programme;
import nl.robertalblas.datading.Timeslot;
import nl.robertalblas.datading.TimeslotPeriod;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class CsvLine {

    public String respondentnr;
    public String datum;
    public String dagvandeweek;
    public String tijdvak;
    public String locatie;
    public String alg_activiteit;

    public String media_activiteit_1;
    public String apparaat_1;
    public String content_1;

    public String media_activiteit_2;
    public String apparaat_2;
    public String content_2;

    public String media_activiteit_3;
    public String apparaat_3;
    public String content_3;

    public String contains_cooking;

    public List<String> getMediaActiviteiten() {
        return asList(media_activiteit_1, media_activiteit_2, media_activiteit_3);
    }

    Set<String> getProgrammeNames() {
        Set<String> content = new HashSet<>();
        content.add(content_1);
        content.add(content_2);
        content.add(content_3);

        return content.stream()
                .flatMap(c -> Stream.of(c.split(";")))
                .map(String::trim)
                .filter(c -> !c.isEmpty())
                .filter(c -> !isNumeric(c))
                .map(c -> {
                    if (c.contains("]")) {
                        return  c.split("]", 2)[1];
                    } else {
                        return c;
                    }
                })
                .collect(Collectors.toSet());
    }

    private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    private boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }

    public void removeNonFittingProgrammes() {
        content_1 = removeNonFittingProgrammes(content_1);
        content_2 = removeNonFittingProgrammes(content_2);
        content_3 = removeNonFittingProgrammes(content_3);
    }

    private String removeNonFittingProgrammes(String content) {
        return Stream.of(content.split(";"))
                .map(String::trim)
                .filter(c -> !c.isEmpty())
                .filter(c -> !isNumeric(c))
                .filter(c -> {
                    if (c.contains("]")) {
                        String timeslot = c.substring(c.indexOf("[")+1,c.indexOf("]"));
                        String startTime = timeslot.split("-")[0];
                        String endTime = timeslot.split("-")[1];

                        TimeslotPeriod period = new TimeslotPeriod(
                                LocalTime.of(
                                        Integer.parseInt(startTime.substring(0, 2)),
                                        Integer.parseInt(startTime.substring(2, 4))
                                ),
                                LocalTime.of(
                                        Integer.parseInt(endTime.substring(0, 2)),
                                        Integer.parseInt(endTime.substring(2, 4))
                                )
                        );

                        return Timeslot.getTimeslot(this.tijdvak).matches(period);
                    } else {
                        return true;
                    }
                })
                .collect(Collectors.joining(";"));
    }
}

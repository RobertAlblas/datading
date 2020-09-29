package nl.robertalblas.datading.csv;

import nl.robertalblas.datading.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class CsvWriter {

    private static final String CSV_FILE_NAME =  "/Users/robert.alblas/Downloads/test-out.csv";

    private static final String[] HEADERS = new String[]{
            "respondentnr",
            "datum",
            "dagvandeweek",
            "tijdvak",
            "locatie",
            "alg_activiteit" ,
            "media_activiteit_1",
            "apparaat_1",
            "content_1",
            "media_activiteit_2",
            "apparaat_2",
            "content_2",
            "media_activiteit_3",
            "apparaat_3",
            "content_3",
            "contains_cooking",
            "group_id",
            "amount",
            "media_type"
    };

    @Autowired
    private RespondentService respondentService;

    @Autowired
    private ProgrammeService programmeService;

    @Autowired
    private GroupService groupService;

    public void writeCsv() {
        File csvOutputFile = new File(CSV_FILE_NAME);
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            System.out.println("Writing to file...");


            writeLine(pw, HEADERS);

            for (Group group: groupService.getGroups()) {
                Respondent respondent = respondentService.getById(group.getCsvLines().get(0).respondentnr);
                if (respondent != null) {
                    for (CsvLine csvLine: group.getCsvLines()) {

                        boolean containsCooking = csvLine.getProgrammeNames()
                                .stream()
                                .map(programmeService::findByName)
                                .anyMatch(Programme::isCooking);
                        boolean containsUnclear = csvLine.getProgrammeNames().stream()
                                .map(programmeService::findByName)
                                .anyMatch(Programme::isUnclear);

                        csvLine.contains_cooking = containsCooking ? "1" : "0";

                        if (!containsCooking && containsUnclear) {
                            csvLine.contains_cooking = "99";
                        }

                        writeLine(pw, new String[]{
                                csvLine.respondentnr,
                                csvLine.datum,
                                csvLine.dagvandeweek,
                                csvLine.tijdvak,
                                csvLine.locatie,
                                csvLine.alg_activiteit,
                                csvLine.media_activiteit_1,
                                csvLine.apparaat_1,
                                csvLine.content_1,
                                csvLine.media_activiteit_2,
                                csvLine.apparaat_2,
                                csvLine.content_2,
                                csvLine.media_activiteit_3,
                                csvLine.apparaat_3,
                                csvLine.content_3,
                                csvLine.contains_cooking,
                                group.getId(),
                                group.getCsvLines().size() + "",
                                group.getMedia().getValue()
                        });

                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeLine(PrintWriter pw, String[] line) {
        String l = convertToCSV(line);

        if(countSemicolumn(l, ';') != HEADERS.length - 1) {
            System.err.println("semicolumns " + countSemicolumn(l, ';'));
            System.err.println("HEADERS " + HEADERS.length);
            System.err.println(l);
            throw new IllegalStateException("poopsie ;");
        }

        if(count(l, '\"') != 6) {
            System.err.println(l);
            throw new IllegalStateException("poopsie \"");
        }

        pw.println(l);
    }

    private int count(String s, char c) {
        int count = 0;

        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
            }
        }

        return count;
    }

    private int countSemicolumn(String s, char c) {
        int count = 0;

        boolean escaped = false;

        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '"') {
                escaped = !escaped;
            }
            if(s.charAt(i) == c && !escaped) {
                count++;
            }
        }

        return count;
    }

    private String convertToCSV(String[] data) {
        // escape the content columns
        String[] output = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            if (i == 8 || i == 11 || i == 14) {
                output[i] = addStringEscape(data[i]);
            } else {
                output[i] = data[i];
            }
        }

        return Stream.of(output)
                .collect(Collectors.joining(";"));
    }

    private String addStringEscape(String data) {
        if (data != null) {
            return "\"" + data + "\"";
        } else {
            return "\"\"";
        }
    }
}

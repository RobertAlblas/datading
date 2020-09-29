package nl.robertalblas.datading;

import nl.robertalblas.datading.csv.CsvLine;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private static int NEXT_ID = 1;

    private static final List<String> TV_IDS = new ArrayList<>();
    static {
        TV_IDS.add("21");
        TV_IDS.add("22");
        TV_IDS.add("23");
    }
    private List<CsvLine> csvLines = new ArrayList<>();
    private final String id;

    public Group() {
        this.id = NEXT_ID + "";
        NEXT_ID++;
    }

    public void addLine(CsvLine csvLine) {
        this.csvLines.add(csvLine);
    }

    public List<CsvLine> getCsvLines() {
        return this.csvLines;
    }

    public boolean fitsInGroup(CsvLine csvLine) {
        if (this.csvLines.isEmpty()) {
            return true;
        }
        return this.csvLines.stream().anyMatch(c ->
                c.respondentnr.equals(csvLine.respondentnr)
                && c.alg_activiteit.equals(csvLine.alg_activiteit)
                && (Integer.parseInt(c.tijdvak) + 1 == Integer.parseInt(csvLine.tijdvak)
                && c.dagvandeweek.equals(csvLine.dagvandeweek))
        );
    }

    public GroupMedia getMedia() {
        GroupMedia media = GroupMedia.NONE;

        if (csvLines.stream()
                .anyMatch(l -> l.getMediaActiviteiten().stream().anyMatch(a -> !a.isEmpty()))) {
            media = GroupMedia.OTHER;
        }

        if (csvLines.stream()
                .anyMatch(l -> l.getMediaActiviteiten().stream().anyMatch(TV_IDS::contains))) {
            media = GroupMedia.TV;
        }

        return media;
    }

    public String getId() {
        return this.id;
    }

    public enum GroupMedia {

        TV(1),
        OTHER(2),
        NONE(3);

        private final int value;


        GroupMedia(int value) {
            this.value = value;
        }

        public String getValue() {
            return this.value + "";
        }
    }
}

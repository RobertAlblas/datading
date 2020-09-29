package nl.robertalblas.datading.csv;

import com.opencsv.CSVReader;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CsvReader {

    public List<CsvLine> readCsv() {
        String csvFile = "/Users/robert.alblas/Downloads/test.csv";

        List<CsvLine> csvLines = new ArrayList<>();

        try {
            System.out.println("Loading the CVS into memory");
            CSVReader reader = new CSVReader(new FileReader(csvFile));
            String[] line;

            // skip  headers
            reader.readNext();


            while ((line = reader.readNext()) != null) {
                CsvLine csvLine = getCsvLine(line);
                csvLines.add(csvLine);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return csvLines;
    }

    private CsvLine getCsvLine(String[] line) {
        CsvLine csvLine = new CsvLine();
        csvLine.respondentnr = line[0].trim();
        csvLine.datum = line[1].trim();
        csvLine.dagvandeweek = line[2].trim();
        csvLine.tijdvak = line[3].trim();
        csvLine.locatie = line[4].trim();
        csvLine.alg_activiteit = line[5].trim();

        csvLine.media_activiteit_1 = line[6].trim();
        csvLine.apparaat_1 = line[7].trim();
        csvLine.content_1 = line[8].trim();

        csvLine.media_activiteit_2  = line[9].trim();
        csvLine.apparaat_2 = line[10].trim();
        csvLine.content_2 = line[11].trim();

        csvLine.media_activiteit_3 = line[12].trim();
        csvLine.apparaat_3 = line[13].trim();
        csvLine.content_3 = line[14].trim();

        return csvLine;
    }
}

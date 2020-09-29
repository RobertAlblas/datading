package nl.robertalblas.datading;

import nl.robertalblas.datading.csv.CsvLine;
import nl.robertalblas.datading.csv.CsvMapper;
import nl.robertalblas.datading.csv.CsvReader;
import nl.robertalblas.datading.csv.CsvWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class DatadingApplication implements CommandLineRunner {

    @Autowired
    private CsvReader csvReader;

    @Autowired
    private CsvMapper csvMapper;

    @Autowired
    private CsvWriter csvWriter;

    public static void main(String[] args) {
        SpringApplication.run(DatadingApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Long millisStart = System.currentTimeMillis();

        List<CsvLine> csvLineList = csvReader.readCsv();
        csvMapper.loadIntoDomain(csvLineList);

        csvLineList.clear();
        csvLineList = null;

        csvWriter.writeCsv();

        Long millisEnd = System.currentTimeMillis();
        System.out.println("Done in " + (millisEnd - millisStart) / 1000 + " seconds");
    }
}

package nl.robertalblas.datading.csv;

import nl.robertalblas.datading.Group;
import nl.robertalblas.datading.GroupService;
import nl.robertalblas.datading.Programme;
import nl.robertalblas.datading.ProgrammeService;
import nl.robertalblas.datading.RespondentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class CsvMapper {

    @Autowired
    private GroupService groupService;

    @Autowired
    private ProgrammeService programmeService;

    @Autowired
    private RespondentService respondentService;

    public void loadIntoDomain(List<CsvLine> csvLines) {
        System.out.println("Loading programmes and respondents...");

        int counter = 0;
        Group currentGroup = null;

        for (CsvLine csvLine : csvLines) {
            csvLine.removeNonFittingProgrammes();

            if (currentGroup == null || !currentGroup.fitsInGroup(csvLine)) {
                currentGroup = new Group();
                groupService.addGroup(currentGroup);
            }

            currentGroup.addLine(csvLine);

            counter++;
            boolean containsCooking = csvLine.getProgrammeNames()
                    .stream()
                    .map(p -> programmeService.addProgramme(p))
                    .anyMatch(Programme::isCooking);
            respondentService.addRespondentResponse(csvLine.respondentnr, containsCooking);

            if (counter % 1000 == 0) {
                System.out.println(counter + "/" + csvLines.size());
            }
        }

        Set<Programme> programmes = programmeService.getProgrammes();
        programmes.forEach(programme -> {
            System.out.println(String.format("%s, cooking: %d", programme.getName(), programme.isCooking() ? 1 : programme.isUnclear() ? 99 : 0));
        });
        System.out.println("Amount of programmes loaded: " + programmes.size());
        System.out.println("Amount of respondents loaded: " + respondentService.count());

        respondentService.filterLazyRespondents();
    }
}

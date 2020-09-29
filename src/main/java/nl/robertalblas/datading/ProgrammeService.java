package nl.robertalblas.datading;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ProgrammeService {

    private Set<Programme> programmes;

    public ProgrammeService() {
        this.programmes = new HashSet<>();
    }

    public Programme addProgramme(String programmeName) {
        Optional<Programme> existingMatch = programmes.stream().filter(p -> p.getName().equals(programmeName)).findAny();

        return existingMatch.orElseGet(() -> {
            Programme programme = new Programme(programmeName);
            this.programmes.add(programme);
            return programme;
        });
    }

    public Set<Programme> getProgrammes() {
        return new HashSet<>(programmes);
    }

    public Programme findByName(String name) {
        return programmes.stream().filter(p -> p.getName().equals(name)).findFirst().orElseThrow(() -> new IllegalStateException("poep"));
    }
}

package nl.robertalblas.datading;

public class Respondent {

    private final String id;
    private int responseCount;
    private boolean hasWatchedCookingProgramme;

    public Respondent(String id) {
        this.id = id;
        this.responseCount = 0;
        this.hasWatchedCookingProgramme = false;
    }

    public void incrementResponseCount() {
        responseCount++;
    }

    public String getId() {
        return id;
    }

    public int getResponseCount() {
        return responseCount;
    }

    public boolean hasWatchedCookingProgramme() {
        return hasWatchedCookingProgramme;
    }

    public void setHasWatchedCookingProgramme(boolean hasWatchedCookingProgramme) {
        this.hasWatchedCookingProgramme = hasWatchedCookingProgramme;
    }
}

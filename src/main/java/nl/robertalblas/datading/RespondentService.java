package nl.robertalblas.datading;

import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class RespondentService {

    private static final List<String> exclusions;
    static {
        exclusions = Arrays.asList("6078","6107","6204","6217","6263","6265","6269","6334","6434","6443","6447","6486","6497","6523","6533","6569","6623","6637","6676","6677","6692","6733","6770","6815","6828","6831","6882","6889","7018","7022","7051","7060","7081","7096","7123","7136","7153","7190","7194","7217","7221","7234","7240","7242","7249","7250","7251","7258","7278","7296","7297","7301","7302","7303","7317","7332","7343","7345","7352","7382","7387","7414","7420","7432","7454","7487","7504","7508","7511","7535","7545","7566","7568","7571","7578","7604","7611","7614","7618","7619","7627","7635","7642","7644","7647","7664","7709","7713","7725","7734","7736","7741","7752","7789","7804","7807","7816","7926","7934","7948","7962","7978","7984","8002","8013","8026","8030","8040","8052","8064","8068","8075","8080","8083","8097","8113","8124","8136","8140","8150","8181","8185","8200","8221","8225","8228","8248","8252","8258","8259","8272","8277","8296","8318","8341","8355","8364","8371","8426","8428","8430","8444","8451","8500","8532","8591","8620","8632","8639","8644");
    }

    private Map<String, Respondent> respondents = new HashMap<>();

    public void addRespondentResponse(String respondentId, boolean containsCooking) {
        if (!exclusions.contains(respondentId)) {
            Respondent respondent = respondents.get(respondentId);

            if (respondent == null) {
                respondent = new Respondent(respondentId);
                respondents.put(respondentId, respondent);
            }

            if (containsCooking) {
                respondent.setHasWatchedCookingProgramme(true);
            }

            respondent.incrementResponseCount();
        }
    }

    public void filterLazyRespondents() {
        List<Respondent> lazyRespondents = respondents.values().stream().filter(r -> r.getResponseCount() < 1008).collect(Collectors.toList());
        lazyRespondents.stream()
                .map(Respondent::getId)
                .forEach(r -> respondents.remove(r));

        System.out.println("removed " + lazyRespondents.size() + " lazy respondents. " + "Only " + respondents.size() + " remain");
    }

    public void filterNonCookingRespondents() {
        List<Respondent> nonCookingRespondents = respondents.values().stream().filter(r -> !r.hasWatchedCookingProgramme()).collect(Collectors.toList());
        nonCookingRespondents.stream()
                .map(Respondent::getId)
                .forEach(r -> respondents.remove(r));

        System.out.println("removed " + nonCookingRespondents.size() + " non cooking respondents. " + "Only " + respondents.size() + " remain");
    }

    public Respondent getById(String respondentnr) {
        return this.respondents.get(respondentnr);
    }

    public int count() {
        return this.respondents.size();
    }
}

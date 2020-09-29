package nl.robertalblas.datading;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Programme {

    private static final Set<String> COOKING_PROGRAMMES = new HashSet<>();
    private static final Set<String> UNCLEAR_PROGRAMMES = new HashSet<>();
    static {
        COOKING_PROGRAMMES.addAll(Arrays.asList("24Kitchen","Bak mee met MAX","Buddy's Big Bakedown","Cake Boss","Cooking With the Stars","Cupcake Wars","Extreme Cake Wars","Foodmakers","Hidden Restaurants","Kids Baking Championship","Kook mee met MAX","MasterChef Australi","My Kitchen Rules","Nederland Proeft","Over de kook","Taarten van Abel","The Great Australian Bake Off","Wedding Cake Championship","Wie is de chef?","Bruisend horeca", "Gordon Ramsey: binnen 24 uur het roer om"));
    }

    private final String name;

    public Programme(String name) {
        this.name = name;
    }

    public boolean isCooking() {
        return COOKING_PROGRAMMES.stream().anyMatch(c -> name.contains(c));
    }

    public boolean isUnclear() {
        return name.contains("(Overige Zenders)");
    }

    public String getName() {
        return name;
    }
}

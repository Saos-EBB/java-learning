package PM;

import java.util.HashMap;
import java.util.Map;

public class PM_Appl {
    private Map<Integer ,PM> mangementsById = new HashMap<>();
    private Map<String, PM> managementsByName = new HashMap<>();

    public boolean add(String name) {
        if (name == null || name.isBlank() || managementsByName.containsKey(name.trim())) return false;
        managementsByName.put(name.trim(), new PM(name.trim()));
        return true;
    }


    public PM get(String name) {
        return (name != null) ? managementsByName.get(name.trim()) : null;
    }

    @Override
    public String toString() {
        return "Verwaltungen: " + managementsByName.keySet();
    }
}
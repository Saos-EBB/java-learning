package PM.Management;

import java.util.HashMap;
import java.util.Map;

public class PM_Appl {

    private final Map<String, PM> managementsByName = new HashMap<>();

    // Neuen Standort hinzufügen — gibt false zurück wenn Name bereits existiert
    public boolean add(String name) {
        if (name == null || name.isBlank()) return false;
        String key = name.trim();
        if (managementsByName.containsKey(key)) return false;
        managementsByName.put(key, new PM(key));
        return true;
    }

    // Standort abrufen — gibt null zurück wenn nicht gefunden
    public PM get(String name) {
        return (name != null) ? managementsByName.get(name.trim()) : null;
    }

    @Override
    public String toString() {
        return "Verwaltungen: " + managementsByName.keySet();
    }
}

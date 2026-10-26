# Ausbildungs-Übungen

Maven-Übungsprojekt aus der Ausbildung, mit JUnit-Tests. Drei Themenblöcke:

- **PM — Personenverwaltung** (`src/main/java/PM/`): Personen, Adressen und
  Gender-Enum mit eigenen Exceptions (`InvalidPersonNameException`,
  `ItemNotFoundException`) und passenden Unit-Tests.
- **Shapes** (`src/main/java/Shapes/`): Vererbung mit `Circle`, `Rectangle`,
  `Square` über eine gemeinsame `Shapes`-Basis, inkl. Tests.
- **LinkedLists** (`src/main/java/LinkedLists/`): doppelt verkettete Liste und
  Queue von Hand, mit `MyQueueTest`.

## Bauen & Testen

```bash
mvn test
```

# Java Learning

Gesammelte Java-Lernprojekte an einem Ort — von den ersten Konsolen-Gehversuchen
bis zu kleinen, in sich abgeschlossenen Programmen. Jeder Ordner ist ein eigenes
Projekt mit eigenem README; die Commit-Historie der ursprünglichen Einzel-Repos
ist beim Zusammenführen erhalten geblieben.

Alles ohne externe Frameworks — viele Datenstrukturen (Listen, Stacks) sind
bewusst von Hand gebaut, ohne die Java Collections, um zu verstehen, was
darunter passiert.

## Projekte

| Projekt | Worum es geht | README |
|---|---|---|
| **pkemn** | Rundenbasierter Pokémon-Kampfsimulator: Statuseffekte, Schadensberechnung, CSV-Daten | [README](pkemn/README.md) |
| **rpn-calculator** | Kommandozeilen-Rechner in Umgekehrter Polnischer Notation, eigener Stack & Liste | [README](rpn-calculator/RPNRechner/README.md) |
| **custom-datastructures** | Grundlegende Datenstrukturen von Hand: Speicherverwaltung, Pointer-Logik, Generics | [README](custom-datastructures/README.md) |
| **personal-management** | Personenverwaltung mit eigenen Exceptions und Java Streams | [README](personal-management/README.md) |
| **games** | Drei Terminal-Spiele: Game of Life, MasterMind, Minesweeper | [README](games/README.md) |
| **ausbildung-uebungen** | Maven-Übungen aus der Ausbildung (PM, Shapes, LinkedLists) mit JUnit-Tests | [README](ausbildung-uebungen/README.md) |
| **first-steps-in-java** | Rohe Sammlung der allerersten Konsolenprogramme — als Lern-Archiv behalten | [README](first-steps-in-java/README.md) |

## Aufbau

Jedes Projekt läuft eigenständig. Die meisten sind reine
`.java`-Dateien ohne Build-Tool (einfach die jeweilige `main` ausführen);
`ausbildung-uebungen` nutzt Maven (`mvn test`).

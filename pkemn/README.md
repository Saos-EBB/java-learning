# Pokémon Battle Simulator
> A turn-based Pokémon battle game built in Java — focused on OOP design, class architecture, and game logic.

![Java](https://img.shields.io/badge/Java-21%2B-orange?style=flat-square&logo=java)
![Status](https://img.shields.io/badge/Status-In%20Development-yellow?style=flat-square)
![OOP](https://img.shields.io/badge/Concepts-OOP%20%7C%20Enums%20%7C%20Collections-blue?style=flat-square)

---

## About the Project

This is a text-based Pokémon battle simulator written in Java.  
The main goal was to practice **object-oriented programming** — designing classes, using enums, separating concerns across packages, and parsing real data from CSV files.

The game lets you pick a Pokémon, fight against a randomly selected opponent, and experience a battle system with real status effects like Burn, Freeze, Sleep, Confusion, and more.

---

## Features

- **Pokémon selection** — choose by ID, name, or roll randomly
- **Turn-based combat** — speed stat determines who attacks first
- **2 random moves per Pokémon** — drawn from a real move pool
- **Status effects** — Burn, Poison, Freeze, Paralysis, Sleep, Confusion, Flinch
- **Damage calculation** — separate formulas for Physical and Special moves
- **Critical hits & multi-hit moves** — with randomized proc chances
- **End-of-round effects** — Burn and Poison deal damage each turn
- **Flinch mechanic** — correctly skips the affected Pokémon's turn
- **Data-driven** — Pokémon and moves are loaded from CSV files at runtime
- **Input validation** — robust handling of invalid user input throughout

---

## Project Structure

```
src/
├── Main.java                   # Entry point
├── Logik/
│   ├── GameEngine.java         # Game loop, setup, Pokémon selection
│   ├── BattleLogic.java        # Turn logic, status handling, flinch
│   ├── DmgCalc.java            # Damage formulas (Physical / Special)
│   ├── ShortTermMemory.java    # Holds current battle state
│   └── FightLogic.java         # (Planned)
├── Persistierung/
│   ├── Pokemon.java            # Pokémon data model
│   ├── Attack.java             # Move data model
│   ├── Effect.java             # Enum: all status effects + properties
│   ├── PokemonData.java        # HashMap-based data store
│   ├── PokemonRawData          # CSV: Pokémon stats
│   └── AttackRawData           # CSV: Move data
└── UI/
    ├── Menu.java               # All user input and menus
    └── Art.java                # ASCII art, colors (ANSI)
```

### Architecture Overview

The project is split into three layers:

| Layer | Package | Responsibility |
|---|---|---|
| UI | `src.UI` | User input, menus, ASCII art, color output |
| Logic | `src.Logik` | Game loop, battle turns, damage calculation |
| Data | `src.Persistierung` | Models, enums, CSV parsing, data storage |

---

## Getting Started

### Requirements

- Java **21 or higher** (project uses unnamed classes / `void main()`)
- IntelliJ IDEA recommended (project includes `.idea` config)

### Run the Project

```bash
# Clone the repository
git clone https://github.com/Saos-EBB/pkemn.git
cd pkemn

# Compile
javac -d out src/**/*.java

# Run
java -cp out Main
```

Or simply open the project in IntelliJ and run `Main.java` directly.

### Data Files

The game reads Pokémon and move data from CSV files at startup.  
Make sure the following files are present relative to your working directory:

```
Pkmn/src/Persistierung/PokemonRawData
Pkmn/src/Persistierung/AttackRawData
```

---

## How to Play

1. Enter your name
2. Choose your Pokémon (by ID, name, or random)
3. Your stats and 2 random moves are displayed
4. The opponent is selected and assigned moves randomly
5. Each turn: pick one of your 2 moves
6. The faster Pokémon attacks first
7. Battle continues until one Pokémon faints
8. You can play again or exit

---

## OOP Concepts Used

This project was built to practice core OOP principles:

- **Classes & Objects** — `Pokemon`, `Attack`, `Effect` as clean data models
- **Encapsulation** — private fields with getters/setters throughout
- **Static factory methods** — `Pokemon.read()` and `Attack.read()` parse CSV lines
- **Enums with data** — `Effect` enum stores `chance`, `duration`, and `damage` per effect
- **Package structure** — logic, data, and UI are clearly separated
- **Collections** — `HashMap<Integer, Pokemon>` for fast lookup by ID or name

---

## Known Issues / TODO

- [ ] **Type effectiveness not implemented** — `EffectivenessRawData` is loaded but not used in damage calculation yet
- [ ] No UI beyond the terminal — potential future feature: simple GUI or web frontend

---

## Author

**Kevin Schaberl** — [@Saos-EBB](https://github.com/Saos-EBB)

*Built as a learning project to practice Java OOP.*

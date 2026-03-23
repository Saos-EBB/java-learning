package src.UI;

public class Art {



    public static  void printRules() {
        System.out.println(colorr(3)+"""
                **********************************************************************************************
                                                         RULES
                **********************************************************************************************
                - Choose Your Pokémon by ID number or name.
                - The computer randomly selects its Pokémon.
                - Each Pokémon is assigned 2 random attacks.
                - Pokémon stats and attacks are displayed after selection.
                - Each Pokémon can use one attack per turn.
                - Speed determines which Pokémon attacks first.
                - Damage formula: Damage = (Move Power) * (Attacker's Attack / Defender's Defense) * (1/25)
                - If a Pokémon is defeated before its turn, its attack is skipped.
                - Some attacks may cause status effects: Burn, Freeze, Paralyze, Flinch, or Critical Hits.
                - Status effects have a chance to trigger and may last multiple turns.
                - After a battle, you can continue with the same Pokémon or choose a new one.
                - The computer always selects a Pokémon randomly for each battle.
                - You can exit the game at any time.
                - Pokémon and attacks are stored in efficient data structures for fast lookup by ID or name.
                - Keep track of HP and opponent’s HP to plan your moves.
                - Choose attacks wisely based on power and chance to cause effects.
                **********************************************************************************************
                """+RESET);
    }

    public static final String intro =colorr(3)+ """
                 Welcome to ..
            
                            ░█████████             ░██                                                       
                            ░██     ░██            ░██                                                       
                            ░██     ░██  ░███████  ░██    ░██ ░███████  ░█████████████   ░███████  ░████████ 
                            ░█████████  ░██    ░██ ░██   ░██ ░██    ░██ ░██   ░██   ░██ ░██    ░██ ░██    ░██
                            ░██         ░██    ░██ ░███████  ░█████████ ░██   ░██   ░██ ░██    ░██ ░██    ░██
                            ░██         ░██    ░██ ░██   ░██ ░██        ░██   ░██   ░██ ░██    ░██ ░██    ░██
                            ░██          ░███████  ░██    ░██ ░███████  ░██   ░██   ░██  ░███████  ░██    ░██
            
                            ...coders edition.
            
            """ ;


    public String color(int x) {
        return switch (x) {
            case 1 -> RED;
            case 2 -> YELLOW;
            case 3 -> GREEN;
            case 4 -> BLUE;
            case 5 -> PURPLE;
            case 6 -> CYAN;
            default -> RESET;
        };
    }
    public static String colorr(int x) {
        return switch (x) {
            case 1 -> RED;
            case 2 -> YELLOW;
            case 3 -> GREEN;
            case 4 -> BLUE;
            case 5 -> PURPLE;
            case 6 -> CYAN;
            default -> RESET;
        };
    }

    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String YELLOW = "\u001B[33m";
    static final String GREEN = "\u001B[32m";
    static final String BLUE = "\u001B[34m";
    static final String PURPLE = "\u001B[35m";
    static final String CYAN = "\u001B[36m";

}

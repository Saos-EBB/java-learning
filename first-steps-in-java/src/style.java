public class style {


    static void main() {


        System.out.println("""
                   ________  ________  ________  ________\s
                  ╱        ╲╱        ╲╱        ╲╱        ╲
                 ╱        _╱         ╱         ╱        _╱
                ╱-        ╱         ╱         ╱-        ╱\s
                ╲________╱╲___╱____╱╲________╱╲________╱ \s""");


        System.out.println("""
                .▄▄ ·  ▄▄▄·       .▄▄ ·\s
                ▐█ ▀. ▐█ ▀█ ▪     ▐█ ▀.\s
                ▄▀▀▀█▄▄█▀▀█  ▄█▀▄ ▄▀▀▀█▄
                ▐█▄▪▐█▐█ ▪▐▌▐█▌.▐▌▐█▄▪▐█
                 ▀▀▀▀  ▀  ▀  ▀█▄▀▪ ▀▀▀▀\s""");

        System.out.println("┌─┐┌─┐┌─┐┌─┐\n" +
                "└─┐├─┤│ │└─┐\n" +
                "└─┘┴ ┴│ │└─┘..43\n" +
                "      └─┘   \n");

                /*┌─┐┌─┐┌─┐┌─┐
                  └─┐├─┤│ │└─┐
                  └─┘┴ ┴│ │└─┘..43
                        └─┘*/

        System.out.print("\n\ncode by \n┌─┐┌─┐┌─┐┌─┐" +"\n└─┐├─┤│ │└─┐" +"\n" + "└─┘┴ ┴│ │└─┘..43\n " +"     └─┘   \n");



    }

    //cheat code 2
    static String color(int guessNumber) {
        return switch (guessNumber) {
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



    public class AnsiColors {

        // Reset all styles
        public static final String RESET = "\u001B[0m"; // Setzt alle Farben und Formatierungen zurück

        // === TEXTSTILE ===
        public static final String BOLD          = "\u001B[1m";  // Fett
        public static final String DIM           = "\u001B[2m";  // Schwach (blass)
        public static final String ITALIC        = "\u001B[3m";  // Kursiv (nicht überall unterstützt)
        public static final String UNDERLINE     = "\u001B[4m";  // Unterstrichen
        public static final String BLINK_SLOW    = "\u001B[5m";  // Blinken (langsam, selten unterstützt)
        public static final String BLINK_FAST    = "\u001B[6m";  // Blinken (schnell)
        public static final String INVERT        = "\u001B[7m";  // Farben umkehren (Hintergrund ↔ Text)
        public static final String STRIKETHROUGH = "\u001B[9m";  // Durchgestrichen

        // === TEXTFARBEN (Vordergrund) ===
        public static final String FG_BLACK   = "\u001B[30m"; // Schwarzer Text
        public static final String FG_RED     = "\u001B[31m"; // Roter Text
        public static final String FG_GREEN   = "\u001B[32m"; // Grüner Text
        public static final String FG_YELLOW  = "\u001B[33m"; // Gelber Text
        public static final String FG_BLUE    = "\u001B[34m"; // Blauer Text
        public static final String FG_MAGENTA = "\u001B[35m"; // Magentafarbener Text
        public static final String FG_CYAN    = "\u001B[36m"; // Türkiser Text
        public static final String FG_WHITE   = "\u001B[37m"; // Weißer Text

        // === HELLERE TEXTFARBEN (Vordergrund) ===
        public static final String FG_BRIGHT_BLACK   = "\u001B[90m"; // Hellgrauer Text
        public static final String FG_BRIGHT_RED     = "\u001B[91m"; // Heller Rotton
        public static final String FG_BRIGHT_GREEN   = "\u001B[92m"; // Heller Grünton
        public static final String FG_BRIGHT_YELLOW  = "\u001B[93m"; // Helles Gelb
        public static final String FG_BRIGHT_BLUE    = "\u001B[94m"; // Heller Blauton
        public static final String FG_BRIGHT_MAGENTA = "\u001B[95m"; // Helles Magenta
        public static final String FG_BRIGHT_CYAN    = "\u001B[96m"; // Helles Cyan
        public static final String FG_BRIGHT_WHITE   = "\u001B[97m"; // Hellweiß

        // === HINTERGRUNDFARBEN ===
        public static final String BG_BLACK   = "\u001B[40m"; // Schwarzer Hintergrund
        public static final String BG_RED     = "\u001B[41m"; // Roter Hintergrund
        public static final String BG_GREEN   = "\u001B[42m"; // Grüner Hintergrund
        public static final String BG_YELLOW  = "\u001B[43m"; // Gelber Hintergrund
        public static final String BG_BLUE    = "\u001B[44m"; // Blauer Hintergrund
        public static final String BG_MAGENTA = "\u001B[45m"; // Magentafarbener Hintergrund
        public static final String BG_CYAN    = "\u001B[46m"; // Türkiser Hintergrund
        public static final String BG_WHITE   = "\u001B[47m"; // Weißer Hintergrund

        // === HELLERE HINTERGRÜNDE ===
        public static final String BG_BRIGHT_BLACK   = "\u001B[100m"; // Hellgrauer Hintergrund
        public static final String BG_BRIGHT_RED     = "\u001B[101m"; // Heller roter Hintergrund
        public static final String BG_BRIGHT_GREEN   = "\u001B[102m"; // Heller grüner Hintergrund
        public static final String BG_BRIGHT_YELLOW  = "\u001B[103m"; // Heller gelber Hintergrund
        public static final String BG_BRIGHT_BLUE    = "\u001B[104m"; // Heller blauer Hintergrund
        public static final String BG_BRIGHT_MAGENTA = "\u001B[105m"; // Heller magentafarbener Hintergrund
        public static final String BG_BRIGHT_CYAN    = "\u001B[106m"; // Heller türkisfarbener Hintergrund
        public static final String BG_BRIGHT_WHITE   = "\u001B[107m"; // Hellweißer Hintergrund
    }

}

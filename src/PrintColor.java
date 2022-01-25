public class PrintColor {
    // Reset
    public static final String RESET = "\033[0m"; // Text Reset

    // Regular Colors
    public static final String BLACK = "\033[0;30m"; // BLACK
    public static final String RED = "\033[0;31m"; // RED
    public static final String GREEN = "\033[0;32m"; // GREEN
    public static final String YELLOW = "\033[0;33m"; // YELLOW
    public static final String BLUE = "\033[0;34m"; // BLUE
    public static final String PURPLE = "\033[0;35m"; // PURPLE
    public static final String CYAN = "\033[0;36m"; // CYAN
    public static final String WHITE = "\033[0;37m"; // WHITE

    // High Intensity
    public static final String BLACK_BRIGHT = "\033[0;90m"; // BLACK
    public static final String RED_BRIGHT = "\033[0;91m"; // RED
    public static final String GREEN_BRIGHT = "\033[0;92m"; // GREEN
    public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
    public static final String BLUE_BRIGHT = "\033[0;94m"; // BLUE
    public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
    public static final String CYAN_BRIGHT = "\033[0;96m"; // CYAN
    public static final String WHITE_BRIGHT = "\033[0;97m"; // WHITE


    public static void printColor(char s, String color) {
        String colorcode = "";
        switch (color) {
            case "RED":
                colorcode = RED;
                break;
            case "GREEN":
                colorcode = GREEN;
                break;
            case "YELLOW":
                colorcode = YELLOW;
                break;
            case "BLUE":
                colorcode = BLUE;
                break;
            case "PURPLE":
                colorcode = PURPLE;
                break;
            case "CYAN":
                colorcode = CYAN;
                break;
            case "WHITE":
                colorcode = WHITE;
                break;
            case "RED_BRIGHT":
                colorcode = RED_BRIGHT;
                break;
            case "GREEN_BRIGHT":
                colorcode = GREEN_BRIGHT;
                break;
            case "YELLOW_BRIGHT":
                colorcode = YELLOW_BRIGHT;
                break;
            case "BLUE_BRIGHT":
                colorcode = BLUE_BRIGHT;
                break;
            case "PURPLE_BRIGHT":
                colorcode = PURPLE_BRIGHT;
                break;
            case "CYAN_BRIGHT":
                colorcode = CYAN_BRIGHT;
                break;
            case "WHITE_BRIGHT":
                colorcode = WHITE_BRIGHT;
                break;

            default:
                break;
        }
        System.out.print(colorcode + s + RESET);
    }
}
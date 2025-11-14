package com.javahut.ui;
//TESTING TESTING
public final class Ui {
    private Ui() {}

    // ===== Optional ANSI colors (fallback-safe) =====
    public static final String RESET = "\u001B[0m";
    public static final String BOLD  = "\u001B[1m";
    public static final String CYAN  = "\u001B[36m";
    public static final String YELL  = "\u001B[33m";
    public static final String GREEN = "\u001B[32m";
    public static final String PINK  = "\u001B[35m";
    public static final String GRAY  = "\u001B[90m";

    // If your console doesn't support ANSI colors, set USE_COLOR = false
    private static final boolean USE_COLOR = true;

    private static String c(String color) { return USE_COLOR ? color : ""; }

    // ===== Clear screen (works in most terminals) =====
    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // ===== Big app logo =====
    public static void logo() {
        String art =
                "      __        __           _          _   _         _   \n" +
                        "      \\ \\      / /   __ _   | |   __ _ | | | |  _   _ | |_ \n" +
                        "       \\ \\ /\\ / /   / _` |  | |  / _` || | | | | | | || __|\n" +
                        "        \\ V  V /   | (_| |  | | | (_| || |_| | | |_| || |_ \n" +
                        "         \\_/\\_/     \\__,_|  |_|  \\__,_| \\___/   \\__,_| \\__|\n" +
                        "                     Java the Hut  ☕  🍩\n";
        System.out.println(c(CYAN) + art + c(RESET));
    }

    // ===== Section header with a donut =====
    public static void header(String title) {
        String line = "────────────────────────────────────────────────────────────";
        System.out.println(c(PINK) + "   🍩 " + title + c(RESET));
        System.out.println(c(GRAY) + line + c(RESET));
    }

    public static void footer() {
        String line = "────────────────────────────────────────────────────────────";
        System.out.println(c(GRAY) + line + c(RESET));
    }

    // Neat menu printer
    public static void menu(String... rows) {
        for (String r : rows) {
            System.out.println("  " + r);
        }
        footer();
        System.out.print(c(YELL) + "  > " + c(RESET));
    }

    // Tiny status line (e.g., item count / total)
    public static void status(String msg) {
        System.out.println(c(GREEN) + "  " + msg + c(RESET));
    }
}


package net.n39i.ltx1d1c.d20140804;

public class StrangeTry {

    public static void main(String[] args) {
        System.out.println(doit()); // java> fiction
    }

    private static String doit() {
        try {
            return "fact";
        } finally {
            return "fiction";
        }
    }

}

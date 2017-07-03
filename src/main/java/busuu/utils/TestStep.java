package busuu.utils;

public class TestStep {

    public static void GIVEN(String step) {
        System.out.println("<GIVEN> " + step);
    }

    public static void WHEN(String step) {
        System.out.println("<WHEN> " + step);
    }

    public static void THEN(String step) {
        System.out.println("<THEN> " + step);
    }

    public static void AND(String step) {
        System.out.println("<AND> " + step);
    }
}

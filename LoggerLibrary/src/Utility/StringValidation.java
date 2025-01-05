package Utility;

public class StringValidation {
    public static boolean isNotBlank(String string) {
        return string != null && !string.trim().isEmpty();
    }
}

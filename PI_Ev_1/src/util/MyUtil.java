package util;

public class MyUtil {
    
    /**
     * For testing purposes only. Can be removed after final implementation.
     * @param message
     */
    public static void unreachableCode(String message) {
        String str = "Unreachable code has been reached";
        if (message != null && message.length() != 0) {
            str += "\n Message: " + message;
        }
        throw new RuntimeException(str);
    }
}

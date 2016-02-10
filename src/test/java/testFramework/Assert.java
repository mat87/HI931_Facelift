package testFramework;


import org.testng.internal.EclipseInterface;

public class Assert {

    public Assert(){
    }

    public static boolean assertTrue(boolean condition, String message) {
        if(!condition) {
            failNotEquals(Boolean.valueOf(condition), Boolean.TRUE, message);
        }
        return condition;
    }

    public static boolean assertTrue(boolean condition) {
        assertTrue(condition, (String)null);
        return condition;
    }

    private static void failNotEquals(Object actual, Object expected, String message) {
        fail(format(actual, expected, message));
    }

    public static void fail(String message) {
        throw new AssertionError(message);
    }

    static String format(Object actual, Object expected, String message) {
        String formatted = "";
        if(null != message) {
            formatted = message + " ";
        }
        return formatted + EclipseInterface.ASSERT_LEFT + expected + EclipseInterface.ASSERT_MIDDLE + actual + EclipseInterface.ASSERT_RIGHT;
    }
}

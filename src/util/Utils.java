package util;

public class Utils {
    public static void assertTrue (Boolean value) {
        if(!value)
            System.out.println("Failed");
        else
            System.out.println("Passed");
    }

    public static void assertEquals(int i, int actual) {
        System.out.println("Computed value : "+actual);
        if(i==actual)
            System.out.println("Passed");
        else
            System.out.println("Failed");
    }
}

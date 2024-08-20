package tek.tdd.utility;

public class DataGenerator extends SeleniumUtility {

    public static String generateRandomEmail(String prefix) {
        int random = (int) (Math.random() * 100000);
        return prefix + random + "@gmail.com";
    }
}

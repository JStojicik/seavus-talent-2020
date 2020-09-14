import exceptions.InvalidZipCodeException;
import utility.Util;

public class Application {
    public static void main(String[] args) {
        try {
            Util.createAddress();
        } catch (NumberFormatException nfe) {
            System.out.println("invalid number");
            nfe.printStackTrace();
        } catch (InvalidZipCodeException izce) {
            izce.getMessage();
            izce.printStackTrace();
        }
    }
}

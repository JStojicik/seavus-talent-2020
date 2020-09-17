import exceptions.InvalidZipCodeException;
import model.Address;

public class Application {
    public static void main(String[] args) {
        try {
            Address.createAddress();
        } catch (NumberFormatException nfe) {
            System.out.println("invalid number");
            nfe.printStackTrace();
        } catch (InvalidZipCodeException izce) {
            izce.getMessage();
            izce.printStackTrace();
        }
    }
}

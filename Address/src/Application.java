import exceptions.InvalidZipCodeException;
import model.Address;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("enter a street name");
            String street = sc.nextLine();
            System.out.println("enter a street number");
            Integer streetNumber = Integer.parseInt(sc.nextLine());
            System.out.println("enter a city name");
            String city = sc.nextLine();
            System.out.println("enter the zip code");
            Integer zipCode = Integer.parseInt(sc.nextLine());
            Address address = new Address(street, streetNumber, city, zipCode);
            System.out.println(address);
        } catch (NumberFormatException nfe) {
            System.out.println("invalid number");
            nfe.printStackTrace();
        } catch (InvalidZipCodeException izce) {
            izce.getMessage();
            izce.printStackTrace();
        }
    }
}

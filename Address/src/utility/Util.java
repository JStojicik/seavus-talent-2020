package utility;

import exceptions.InvalidZipCodeException;
import model.Address;

import java.util.Scanner;

public interface Util {
    static void createAddress() throws NumberFormatException, InvalidZipCodeException {

        Scanner sc = new Scanner(System.in);

        System.out.println("enter a street name");
        String street = sc.nextLine();
        System.out.println("enter a street number");
        Integer streetNumber = Integer.parseInt(sc.nextLine());
        System.out.println("enter a city name");
        String city = sc.nextLine();
        System.out.println("enter the zip code");
        Integer zipCode = Integer.parseInt(sc.nextLine());
        if ((zipCode > 99999 || zipCode < 10000) && (zipCode > 999999999 || zipCode < 100000000)) {
            throw new InvalidZipCodeException("invalid zip code");
        }
        Address address = new Address(street, streetNumber, city, zipCode);
        System.out.println(address);
    }
}

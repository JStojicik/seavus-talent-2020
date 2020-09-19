package Main;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the dimensions of the box.");
        System.out.println("Enter height");
        double height = sc.nextDouble();
        System.out.println("Enter width");
        double width = sc.nextDouble();
        System.out.println("Enter depth");
        double depth = sc.nextDouble();
        Box box = new Box(height, width, depth);
        System.out.println("You have entered a " + box.toString()+"with volume of "+box.calcVolume());
    }
}

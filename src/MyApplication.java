import controller.Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MyApplication {
    private final Controller controller;

    Scanner scanner = new Scanner(System.in);

    public MyApplication(Controller controller) {
        this.controller = controller;
    }

    public void Start() {
        while (true) {
            System.out.println("Choose one option:\n 1) Search for any medicine by name\n " +
                    "2)Show all medicine\n " +
                    "3)Get medicine by ID\n " +
                    "4)Add medicine\n " +
                    "5)Remove the medicine by ID\n " +
                    "6)Stop choosing \n" +
                    "7) Search by price");
            int number = scanner.nextInt();
            if (number == 1) {

                System.out.println("Write the name of medicine:");
                String name = scanner.next();
                System.out.println( controller.seacrhMedByName(name));

            } else if (number == 2) {

                System.out.println(controller.ShowMed());

            } else if (number == 3) {

                System.out.println("Write the ID of medicine");
                int id = scanner.nextInt();
                System.out.println(controller.searchMedByID(id));

            } else if (number == 4) {

                System.out.println("Write the name of medicine:");
                String name = scanner.next();
                System.out.println("Write the price of medicine:");
                double price = scanner.nextDouble();
                System.out.println("Write the expiration date of medicine(format of date must to be yyyy-mm-dd):");
                String date = scanner.next();
                LocalDate expiration_date = LocalDate.parse(date);
                System.out.println("Write the manufacturer:");
                String manu = scanner.next();
                System.out.println("Write the number of medicine:");
                int num = scanner.nextInt();
                System.out.println(controller.AddMed(name,price,expiration_date,manu,num));

            } else if (number == 5) {

                System.out.println("Write the ID of medicine:");
                int id = scanner.nextInt();
                System.out.println(controller.RemoveMedByID(id));

            } else if (number == 6) {

                break;

            }else if(number == 7){
                System.out.println("Write the price of medicine");
                double price = scanner.nextDouble();
                System.out.println(controller.SearchByPrice(price));

            } else {

                System.out.println("There is no such option here");
                continue;
            }

            System.out.println("---------------------------------------------------------------");
        }
    }
}

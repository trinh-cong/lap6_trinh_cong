package lap6_mguyen_tuan;

import java.util.LinkedList;
import java.util.Scanner;

class Car {
    private String name;
    private int price;
    private String production;

    public Car(String name, int price, String production) {
        this.name = name;
        this.price = price;
        this.production = production;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getProduction() {
        return production;
    }
}

class GenericCar<T> {
    private LinkedList<T> cars;

    public GenericCar() {
        cars = new LinkedList<>();
    }

    public void add(T car) {
        cars.add(car);
        System.out.println("Car added successfully.");
    }

    public void display() {
        for (T car : cars) {
            if (car instanceof Car) {
                System.out.println(((Car) car).getName() + " " +
                        ((Car) car).getPrice() + " " +
                        ((Car) car).getProduction());
            }
        }
    }

    public int getSize() {
        return cars.size();
    }

    public boolean checkEmpty() {
        return cars.isEmpty();
    }

    public void delete() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the car name to delete: ");
        String name = scanner.nextLine();
        for (T car : cars) {
            if (car instanceof Car) {
                Car c = (Car) car;
                if (c.getName().equalsIgnoreCase(name)) {
                    cars.remove(car);
                    System.out.println("Car deleted successfully.");
                    return;
                }
            }
        }
        System.out.println("Car not found.");
    }
}

public class Main {
    public static void main(String[] args) {
        GenericCar<Car> carCollection = new GenericCar<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("---------------------");
            System.out.println("Menu");
            System.out.println("---------------------");
            System.out.println("1. Add");
            System.out.println("2. Display");
            System.out.println("3. GetSize");
            System.out.println("4. CheckEmpty");
            System.out.println("5. Grad");
            System.out.println("6. Exit");
            System.out.print("Your choice: ");

            String input = scanner.nextLine();
            if (!input.matches("[1-6]")) {
                System.out.println("Invalid input.");
                continue;
            }

            int choice = Integer.parseInt(input);
            switch (choice) {
                case 1:
                    System.out.print("Enter car name: ");
                    String name = scanner.nextLine();
                    if (name.matches(".*\\d.*")) {
                        System.out.println("Invalid name: contains numeric character.");
                        continue;
                    }

                    System.out.print("Enter car price: ");
                    String priceString = scanner.nextLine();
                    if (!priceString.matches("\\d+")) {
                        System.out.println("Invalid price: contains non-numeric character.");
                        continue;
                    }
                    int price = Integer.parseInt(priceString);

                    System.out.print("Enter production: ");
                    String production = scanner.nextLine();

                    Car car = new Car(name, price, production);
                    carCollection.add(car);
                    break;
                case 2:
                    carCollection.display();
                    break;
                case 3:
                    System.out.println("Size: " + carCollection.getSize());
                    break;
                case 4:
                    System.out.println("Empty: " + carCollection.checkEmpty());
                    break;
                case 5:
                    System.out.println("Grad");
                    carCollection.delete();
                    break;
                case 6:
                    System.out.println("Exit");
                    return;
            }
        }
    }
}

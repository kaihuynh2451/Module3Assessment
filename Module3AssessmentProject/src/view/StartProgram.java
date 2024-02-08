package view;

/**
 * @author minh2 - meruse
 * CIS175 - Fall 2023
 * Feb 1, 2024
 */

import controller.CarController;
import model.Car;

import java.util.Scanner;

public class StartProgram {

    static Scanner in = new Scanner(System.in);
    static CarController carController = new CarController();

    public static void main(String[] args) {
        runMenu();
    }

    public static void runMenu() {
        boolean goAgain = true;
        while (goAgain) {
            System.out.println("1 -- Add a car");
            System.out.println("2 -- Edit a car");
            System.out.println("3 -- Delete a car");
            System.out.println("4 -- View all cars");
            System.out.println("5 -- Exit");

            System.out.print("Your selection: ");
            int selection = in.nextInt();
            in.nextLine();

            switch (selection) {
                case 1:
                    addCar();
                    break;
                case 2:
                    editCar();
                    break;
                case 3:
                    deleteCar();
                    break;
                case 4:
                    viewAllCars();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    goAgain = false;
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
                    break;
            }
        }
    }

    private static void addCar() {
        System.out.print("Enter make: ");
        String make = in.nextLine();
        System.out.print("Enter model: ");
        String model = in.nextLine();
        Car newCar = new Car();
        newCar.setMake(make);
        newCar.setModel(model);
        carController.addCar(newCar);
        System.out.println("Car added successfully!");
    }

    private static void editCar() {
        System.out.print("Enter car ID to edit: ");
        int carId = in.nextInt();
        in.nextLine();
        System.out.print("Enter new make: ");
        String make = in.nextLine();
        System.out.print("Enter new model: ");
        String model = in.nextLine();
        Car updatedCar = new Car();
        updatedCar.setId(carId);
        updatedCar.setMake(make);
        updatedCar.setModel(model);
        carController.editCar(updatedCar);
        System.out.println("Car edited successfully!");
    }

    private static void deleteCar() {
        System.out.print("Enter car ID to delete: ");
        int carId = in.nextInt();
        in.nextLine();
        carController.deleteCar(carId);
        System.out.println("Car deleted successfully!");
    }

    private static void viewAllCars() {
        carController.viewAllCars();
    }
}


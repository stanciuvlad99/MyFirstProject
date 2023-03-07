package ro.mycode.controllers;

import ro.mycode.models.Car;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlCar {
    private ArrayList<Car> cars;

    public ControlCar(){
        this.cars=new ArrayList<>();
        load();
    }

    private void load(){
        try {
            File file = new File("C:\\mycode\\OOP\\Incapsularea\\MyProject3\\src\\ro\\mycode\\data\\cars.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String text = scanner.nextLine();
                Car car =new Car(text);
                this.cars.add(car);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void read(){
        for (int i=0; i<cars.size(); i++){
            System.out.println(cars.get(i).descriere());
        }
    }
}

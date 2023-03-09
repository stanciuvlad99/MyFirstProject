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

    //todo: functie ce afiseaza toate masinile
    public void read(){
        for (int i=0; i<cars.size(); i++){
            System.out.println(cars.get(i).descriere());
        }
    }

    //todo: functie ce returneaza masina dupa nume, primeste model ca paramametru
    public Car findByName(String carModel){
        for (int i=0; i<cars.size(); i++){
            if (cars.get(i).getModel().equals(carModel)){
                return cars.get(i);
            }
        }
        return null;
    }

    //todo: functie ce returneaza un id valabil
    public int nextId(){
        if (cars.size()==0){
            return -1;
        }
        return cars.get(cars.size()-1).getCarId()+1;
    }

    //todo: functie ce creaza o noua masina, primeste constructor ca parametru
    public void add(Car car){
        this.cars.add(car);
    }
}

package ro.mycode.controllers;

import ro.mycode.models.Car;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlCar {
    private ArrayList<Car> cars;
    private final String FINAL_URL="C:\\mycode\\OOP\\Incapsularea\\MyProject3\\src\\ro\\mycode\\data\\cars.txt";

    public ControlCar(){
        this.cars=new ArrayList<>();
        load();
    }

    private void load(){
        try {
            File file = new File(FINAL_URL);
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
    public Car findByModel(String carModel){
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

    //todo: funtie ce returnaza lita de masini, primeste racer id ca parametru
    public ArrayList<Car> listaMasiniPersonale(int racerId){
        ArrayList<Car> list = new ArrayList<>();
        for (int i=0; i<cars.size(); i++){
            if (cars.get(i).getRacerId()==racerId){
                list.add(cars.get(i));
            }
        }
        return list;
    }

    //todo: functie ce returneaza masina, primeste car id ca parametru
    public Car findById(int carId){
        for (int i=0; i<cars.size(); i++){
            if (cars.get(i).getCarId()==carId){
                return cars.get(i);
            }
        }
        return null;
    }

    //todo: functie ce returnaza masina, primeste ca parametru racer id si model masina
    public Car findByRacerIdModel(int racerId, String model){
        for (int i=0; i<cars.size(); i++){
            if (cars.get(i).getRacerId()==racerId && cars.get(i).getModel().equals(model)){
                return cars.get(i);
            }
        }
        return null;
    }

    //todo: functie ce elimina masina din baza de date, primeste constructor ca parametru
    public void removeCar(Car car){
        this.cars.remove(car);
    }

    //todo: functie ce face update masinii, primeste constructor ca parametru
    public void update(Car car){
        Car update = findByModel(car.getModel());
        if (car.getBrand().equals("")==false){
            update.setBrand(car.getBrand());
        }
        if ((car.getNumber()==0)==false){
            update.setNumber(car.getNumber());
        }
    }

    //todo: functie ce returneaza masina, primeste ca paramertru racerId
    public Car findByRacerId(int racerId){
        for (int i=0; i<cars.size(); i++){
            if (cars.get(i).getRacerId()==racerId){
                return cars.get(i);
            }
        }
        return null;
    }

    //todo: functie ce returneaza toate masinile
    public String toSave(){
        int i=0;
        String save="";
        for (i=0; i<cars.size()-1; i++){
            save+=cars.get(i).toSave()+"\n";
        }
        save+=cars.get(i).toSave();
        return save;
    }

    //todo: functie ce salveaza fisier text cars
    public void save(){
        try {
            File file = new File(FINAL_URL);
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(toSave());
            printWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

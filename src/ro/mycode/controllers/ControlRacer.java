package ro.mycode.controllers;

import ro.mycode.models.Racer;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlRacer {
    private ArrayList<Racer> racers;

    public ControlRacer(){
        this.racers=new ArrayList<>();
        load();
    }

    private void load(){
        try {

            File file = new File("C:\\mycode\\OOP\\Incapsularea\\MyProject3\\src\\ro\\mycode\\data\\racer.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String linie = scanner.nextLine();
                Racer racer = new Racer(linie);
                racers.add(racer);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void read(){
        for (int i=0; i<racers.size(); i++){
            System.out.println(racers.get(i).descriere());
        }
    }
}


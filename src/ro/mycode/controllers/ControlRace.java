package ro.mycode.controllers;

import ro.mycode.models.Race;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlRace {
    private ArrayList<Race> races;

    public ControlRace(){
        this.races= new ArrayList<>();
        load();
    }

    private void load(){
        try {
            File file = new File("C:\\mycode\\OOP\\Incapsularea\\MyProject3\\src\\ro\\mycode\\data\\race.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String text = scanner.nextLine();
                Race race = new Race(text);
                races.add(race);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //todo: functie ce afiseaza toate cursele
    public void read(){
        for (int i=0; i<races.size(); i++){
            System.out.println(races.get(i).descriere());
        }
    }

    //todo: functie ce returnaza cursa, primeste racer id ca parametru
    public Race findByRaceId(int raceId){
        for (int i=0; i<races.size(); i++){
            if (races.get(i).getRaceId()==raceId){
                return races.get(i);
            }
        }
        return null;
    }
}

package ro.mycode.controllers;

import ro.mycode.models.Race;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlRace {
    private ArrayList<Race> races;
    public final String FINAL_RACE="C:\\mycode\\OOP\\Incapsularea\\MyProject3\\src\\ro\\mycode\\data\\race.txt";

    public ControlRace(){
        this.races= new ArrayList<>();
        load();
    }

    private void load(){
        try {
            File file = new File(FINAL_RACE);
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

    //todo: functie ce returneaza cursa, primeste race name
    public Race findByName(String numeCurs){
        for (int i=0; i<races.size(); i++){
            if (races.get(i).getName().equals(numeCurs)){
                return races.get(i);
            }
        }
        return null;
    }

    //todo: functie ce limina o cursa din lista, primeste constructor ca parametru
    public void removeRace(Race race){
        this.races.remove(race);
    }

    //todo: functie ce returneaza cursa, primeste tipul cursei ca parametru
    public Race findByType(int raceId){
        for (int i=0; i<races.size(); i++){
            if (races.get(i).getRaceId()==raceId){
                return races.get(i);
            }
        }
        return null;
    }

    //todo: functie ce fadce update numelui cursei, primeste constructor ca parametru
    public void updateName(Race race){
        Race update=findByRaceId(race.getRaceId());
        if (race.getName().equals("")==false){
            update.setName(race.getName());
        }
    }

    //todo: functie ce face update id-ului cursei si tipului cursei, primeste constructor ca parametru
    public void updateIdRaceType(Race race){
        Race update=findByName(race.getName());
        if (race.getRaceType().equals("")==false){
            update.setRaceType(race.getRaceType());
        }
        if ((race.getRaceId()==0)==false){
            update.setRaceId(race.getRaceId());
        }
    }

    //todo: functie ce returneaza un id valid
    public int nextId(){
        if (races.size()==0){
            return -1;
        }
        return races.get(races.size()-1).getRaceId()+1;
    }

    //todo: functie ce creazau o noua cursa, primeste constructor ca parametru
    public void add(Race race){
        this.races.add(race);
    }

    //todo: functie ce returneaza toate cursele
    public String toSave(){
        String save="";
        for (int i=0; i<races.size(); i++){
            save+=races.get(i).toSave()+"\n";
        }
        return save;
    }

    //todo: functie ce salveaza fisier text race
    public void save(){
        try {
            File file = new File(FINAL_RACE);
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(toSave());
            printWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

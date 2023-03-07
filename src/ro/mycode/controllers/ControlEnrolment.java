package ro.mycode.controllers;

import ro.mycode.models.Enrolmet;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlEnrolment {

    private ArrayList<Enrolmet> enrolmets;

    public ControlEnrolment(){
        this.enrolmets=new ArrayList<>();
        load();
    }

    private void load(){
        try {
            File file = new File("C:\\mycode\\OOP\\Incapsularea\\MyProject3\\src\\ro\\mycode\\data\\enrolment.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String text = scanner.nextLine();
                Enrolmet enrolmet = new Enrolmet(text);
                enrolmets.add(enrolmet);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void read(){
        for (int i=0; i<enrolmets.size(); i++){
            System.out.println(enrolmets.get(i).descriere());
        }
    }
}

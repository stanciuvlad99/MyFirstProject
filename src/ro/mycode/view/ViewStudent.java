package ro.mycode.view;

import ro.mycode.controllers.ControlRace;
import ro.mycode.models.Race;
import ro.mycode.models.Racer;

import java.util.Scanner;

public class ViewStudent {

    private Racer racer;
    private ControlRace controlRace;

    public ViewStudent(){
        this.controlRace=new ControlRace();
        play();
    }

    private void menu(){
        System.out.println("Apasati tasta 1 pentru a vedea toate cursele");
    }

    private void play(){
        menu();
        boolean running=true;
        while (running){
            Scanner scanner = new Scanner(System.in);
            int alegere=Integer.parseInt(scanner.nextLine());
            switch (alegere){
                case 1:
            }
        }
    }
}

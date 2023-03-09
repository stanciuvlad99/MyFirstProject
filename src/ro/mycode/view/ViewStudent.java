package ro.mycode.view;

import ro.mycode.controllers.ControlEnrolment;
import ro.mycode.controllers.ControlRace;
import ro.mycode.models.Enrolmet;
import ro.mycode.models.Race;
import ro.mycode.models.Racer;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewStudent {

    private Racer racer;
    private ControlRace controlRace;
    private ControlEnrolment controlEnrolment;

    public ViewStudent() {
        this.controlRace = new ControlRace();
        this.controlEnrolment = new ControlEnrolment();
        this.racer = new Racer("2,Alexandru,Radu,30,alexandru.radu@yahoo.com,Password456");
        play();
    }

    private void menu() {
        System.out.println("Apasati tasta 1 pentru a vedea toate cursele");
        System.out.println("Apasati tasta 2 pentru a vedea curslele la care sunteti inscris");
    }

    private void play() {
        menu();
        boolean running = true;
        while (running) {
            Scanner scanner = new Scanner(System.in);
            int alegere = Integer.parseInt(scanner.nextLine());
            switch (alegere) {
                case 1:
                    afisareCurse();
                    break;
                case 2:afisreInscrieri();
                break;
                default:
                    break;

            }
        }
    }

    private void afisareCurse() {
        controlRace.read();
    }

    private void afisreInscrieri() {
        ArrayList<Enrolmet> lista=controlEnrolment.listaInscrieri(racer.getRacerId());
        for (int i=0; i<lista.size(); i++){
            Race race = controlRace.findByRaceId(lista.get(i).getRaceId());
            System.out.println(race.descriere());
        }
    }
}

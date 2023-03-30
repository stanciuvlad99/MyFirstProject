package ro.mycode.view;

import ro.mycode.controllers.ControlCar;
import ro.mycode.controllers.ControlRace;
import ro.mycode.controllers.ControlRacer;
import ro.mycode.models.Admin;
import ro.mycode.models.Car;
import ro.mycode.models.Race;
import ro.mycode.models.Racer;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewAdmin {
    private Admin admin;
    private ControlCar controlCar;
    private ControlRacer controlRacer;
    private ControlRace controlRace;

    public ViewAdmin(Admin admin) {
        this.admin=admin;
        this.controlCar = new ControlCar();
        this.controlRace = new ControlRace();
        this.controlRacer = new ControlRacer();
        play();
    }

    private void menu() {
        System.out.println("Bine ai venit" + admin.getFirstName() + " " + admin.getLastName() + "!");
        System.out.println("");
        System.out.println("Apasati tasta 1 pentru a vedea toti pilotii de curse");
        System.out.println("Apasati tasta 2 pentru a elimina un pilot de curse din baza de date");
        System.out.println("Apasati tasta 3 pentru a vedea toate cursele");
        System.out.println("Apasati tasta 4 pentru a elimina o cursa");
        System.out.println("Apasati tasta 5 pentru a face update unei curse");
        System.out.println("Apasati tasta 6 pentru a adauga o cursa in baza de date");
        System.out.println("Apasati tasta 7 pentru a adauga un pilot");
        System.out.println("Aapsati tasta 8 pentru a vedea masinile unui pilot");

    }

    private void play() {
        menu();
        boolean running = true;
        while (running) {
            Scanner scanner = new Scanner(System.in);
            int alegere = Integer.parseInt(scanner.nextLine());
            switch (alegere) {
                case 1:
                    afisarePiloti();
                    break;
                case 2:
                    eliminarePilot();
                    break;
                case 3:
                    afisareCurse();
                    break;
                case 4:
                    eliminareCursa();
                    break;
                case 5:
                    update();
                    break;
                case 6:
                    adugareCursa();
                    break;
                case 7:
                    adaugarePilot();
                    break;
                case 8:
                    masiniPilot();
                    break;
                default:
                    break;
            }
        }
    }

    private void afisarePiloti() {
        controlRacer.read();
    }

    private void eliminarePilot() {
        System.out.println("Inreoduceti numele de familie al pilotului");
        Scanner scanner = new Scanner(System.in);
        String nume = scanner.nextLine();
        System.out.println("Introduceti prenumele pilotului");
        String prenume = scanner.nextLine();
        Racer racer = controlRacer.findByFirstNameLastname(prenume, nume);
        if (racer != null) {
            controlRacer.removeRacer(racer);
            System.out.println("Pilotul de curse a fost eliminat din baza de date");
        } else {
            System.out.println(prenume + " " + nume + " nu exista in baza de date ");
        }
    }

    private void afisareCurse() {
        controlRace.read();
    }

    private void eliminareCursa() {
        System.out.println("Introduceti numele cursei");
        Scanner scanner = new Scanner(System.in);
        String numeCursa = scanner.nextLine();
        Race race = controlRace.findByName(numeCursa);
        if (race != null) {
            controlRace.removeRace(race);
            System.out.println("Cursa a fost eliminata din lista");
        } else {
            System.out.println(numeCursa + " nu exista in baza de date");
        }
    }

    private void update() {
        System.out.println("Introduceti numele cursei");
        Scanner scanner = new Scanner(System.in);
        String numeCursa = scanner.nextLine();
        Race race = controlRace.findByName(numeCursa);
        if (race != null) {
            System.out.println("Inroducerti noul nume al cursei");
            String numeNou = scanner.nextLine();
            controlRace.updateName(new Race(race.getRaceId(), numeNou, race.getRaceType()));
            System.out.println("Introduceti id-ul cursei");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.println("Introduceti tipul cursei");
            String raceType = scanner.nextLine();
            controlRace.updateIdRaceType(new Race(id, race.getName(), raceType));
            System.out.println("Cursei i s-a facut update cu succes");
        } else {
            System.out.println(numeCursa + " nu exista");
        }
    }

    public void adugareCursa() {
        System.out.println("Introduceti numele curseri");
        Scanner scanner = new Scanner(System.in);
        String numeCursa = scanner.nextLine();
        Race race = controlRace.findByName(numeCursa);
        if (race == null) {
            System.out.println("Introduceti tipul cursei");
            String racetype = scanner.nextLine();
            controlRace.add(new Race(controlRace.nextId(), numeCursa, racetype));
            System.out.println("Cursa a fost adugata");
        } else {
            System.out.println(numeCursa + " exista deja in baza de date");
        }
    }

    public void adaugarePilot() {
        System.out.println("Introduceti prenumele pilotului");
        Scanner scanner = new Scanner(System.in);
        String prenume = scanner.nextLine();
        System.out.println("Introduceti numele de familie");
        String nume = scanner.nextLine();
        Racer racer = controlRacer.findByFirstNameLastname(prenume, nume);
        if (racer == null) {
            System.out.println("Introducrti email-ul pilotului");
            String email = scanner.nextLine();
            System.out.println("Introduceti parola");
            String parola = scanner.nextLine();
            System.out.println("Introduceti varsta");
            int varsta = Integer.parseInt(scanner.nextLine());
            Racer racer1 = new Racer(controlRacer.nextId(), prenume, nume, varsta, email, parola);
            controlRacer.add(racer1);
            System.out.println("Pilotul a fost adaugat in baza de date");
        } else {
            System.out.println(prenume + " " + nume + " exista deja in baza de date");
        }
    }

    private void masiniPilot() {
        System.out.println("Introduceti prenumele pilotului");
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine();
        System.out.println("Introduceti numele de familie");
        String lastName = scanner.nextLine();
        Racer racer = controlRacer.findByFirstNameLastname(firstName, lastName);
        if (racer != null) {
            ArrayList<Car> cars = controlCar.listaMasiniPersonale(controlRacer.returnIdRacer(firstName, lastName));
            for (int i = 0; i < cars.size(); i++) {
                Car car = controlCar.findByRacerId(controlRacer.returnIdRacer(firstName, lastName));
                System.out.println(car.descriere());
            }
        }else {
            System.out.println(firstName + " " + lastName + " nu exista in baza de date");
        }
    }

}
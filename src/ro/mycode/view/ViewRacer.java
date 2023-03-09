package ro.mycode.view;

import ro.mycode.controllers.ControlCar;
import ro.mycode.controllers.ControlEnrolment;
import ro.mycode.controllers.ControlRace;
import ro.mycode.models.Car;
import ro.mycode.models.Enrolmet;
import ro.mycode.models.Race;
import ro.mycode.models.Racer;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewRacer {

    private Racer racer;
    private ControlCar controlCar;
    private ControlRace controlRace;
    private ControlEnrolment controlEnrolment;

    public ViewRacer() {
        this.controlCar = new ControlCar();
        this.controlRace = new ControlRace();
        this.controlEnrolment = new ControlEnrolment();
        this.racer = new Racer("2,Alexandru,Radu,30,alexandru.radu@yahoo.com,Password456");
        play();
    }

    private void menu() {
        System.out.println("Apasati tasta 1 pentru a vedea toate cursele");
        System.out.println("Apasati tasta 2 pentru a vedea curslele la care sunteti inscris");
        System.out.println("Apasati tasta 3 pentru a va inscrie la o cursa");
        System.out.println("Apasati tasta 4 pentru a renunta la o inscriere");
        System.out.println("Apasati tasta 5 pentru a vedea toate masinile");
        System.out.println("Apasati tasta 6 pentru a vedea masinile dumneavoastra");
        System.out.println("Apasati tasta 7 pentru a addauga o masina in baza de date");
        System.out.println("Apasati tasta 8 pentru a elimina o masina");
        System.out.println("Apasati tasta 9 pentru a face update masinii");
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
                case 2:
                    afisreInscrieri();
                    break;
                case 3:
                    inscriereCursa();
                    break;
                case 4:
                    renuntareInscriere();
                    break;
                case 5:
                    afisareMasini();
                    break;
                case 6:
                    afisareMasiniPersonale();
                    break;
                case 7:
                    adaugareMasina();
                    break;
                case 8:
                    eliminareMasina();
                    break;
                case 9:updateMasina();
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
        ArrayList<Enrolmet> lista = controlEnrolment.listaInscrieri(racer.getRacerId());
        for (int i = 0; i < lista.size(); i++) {
            Race race = controlRace.findByRaceId(lista.get(i).getRaceId());
            System.out.println(race.descriere());
        }
    }

    private void inscriereCursa() {
        System.out.println("Introduceti numele cursei");
        Scanner scanner = new Scanner(System.in);
        String numeCursa = scanner.nextLine();
        Race race = controlRace.findByName(numeCursa);
        if (race != null) {
            Enrolmet enrolmet = new Enrolmet(controlEnrolment.nextId(), racer.getRacerId(), race.getRaceId());
            this.controlEnrolment.add(enrolmet);
            System.out.println("V-ati inscris cu succes la curs" + numeCursa);
        } else {
            System.out.println(numeCursa + " nu exista");
        }
    }

    private void renuntareInscriere() {
        System.out.println("Introduceti numele cursei la care doriti sa renuntatai");
        Scanner scanner = new Scanner(System.in);
        String numeCursa = scanner.nextLine();
        Race race = controlRace.findByName(numeCursa);
        if (race != null) {
            Enrolmet enrolmet = controlEnrolment.findByRaceIdRacerId(race.getRaceId(), this.racer.getRacerId());
            if (enrolmet != null) {
                this.controlEnrolment.removeEnrolment(enrolmet);
                System.out.println("Ati renunta cu succes la cursa " + numeCursa);
            } else {
                System.out.println("Nu sunteti inscris la cursa " + numeCursa);
            }
        } else {
            System.out.println("Nu exista cursa " + numeCursa);
        }
    }

    private void afisareMasini() {
        controlCar.read();
    }

    private void afisareMasiniPersonale() {
        ArrayList<Car> cars = controlCar.listaMasiniPersonale(racer.getRacerId());
        for (int i = 0; i < cars.size(); i++) {
            Car car = controlCar.findById(cars.get(i).getCarId());
            System.out.println(car.descriere());
        }

    }

    private void adaugareMasina() {
        System.out.println("Introduceti modelul masinii");
        Scanner scanner = new Scanner(System.in);
        String model = scanner.nextLine();
        Car car = controlCar.findByModel(model);
        if (car == null) {
            System.out.println("Introduceti numarul masinii");
            int numar = Integer.parseInt(scanner.nextLine());
            System.out.println("Introduceti marca masinii");
            String marca = scanner.nextLine();

            Car car1 = new Car(controlCar.nextId(), this.racer.getRacerId(), numar, marca, model);
            this.controlCar.add(car1);
            System.out.println("Masina a fost adugata in baza de date");
        } else {
            System.out.println(model + " exista deja in lista");
        }
    }

    private void eliminareMasina() {
        System.out.println("Introduceti numele masinii");
        Scanner scanner = new Scanner(System.in);
        String model = scanner.nextLine();
        Car car = controlCar.findByModel(model);
        if (car != null) {
            Car car1 = controlCar.findByRacerIdModel(racer.getRacerId(), model);
            if (car1 != null) {
                controlCar.removeCar(car1);
                System.out.println("Masina a fost eliminata din baza de date");
            } else {
                System.out.println(model + " nu este a dumneavoastra");
            }
        } else {
            System.out.println(model + " nu exista in basa de date");
        }
    }

    private void updateMasina() {
        System.out.println("Introduceti modelul masinii");
        Scanner scanner = new Scanner(System.in);
        String model = scanner.nextLine();
        Car car = controlCar.findByModel(model);
        if (car != null) {
            Car car1 = controlCar.findByRacerIdModel(racer.getRacerId(),model);
            if (car1!=null){
                System.out.println("Introduceti numarul masinii");
                int number=Integer.parseInt(scanner.nextLine());
                System.out.println("Introduceti marca masinii");
                String brand=scanner.nextLine();
                controlCar.update(new Car(car.getCarId(), car.getRacerId(),number,brand, car.getModel()));
                System.out.println("Masinii i s-a facut update cu succes");
            }else {
                System.out.println(model + " nu va apartine");
            }
        }else {
            System.out.println(model + " nu exista in baza de date");
        }
    }
}

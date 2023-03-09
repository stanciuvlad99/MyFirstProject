package ro.mycode;

import ro.mycode.controllers.ControlCar;
import ro.mycode.controllers.ControlEnrolment;
import ro.mycode.controllers.ControlRace;
import ro.mycode.controllers.ControlRacer;
import ro.mycode.view.ViewStudent;

public class Main {
    public static void main(String[] args) {
//        ControlRacer controlRacer = new ControlRacer();
//        controlRacer.read();

//        ControlRace controlRace = new ControlRace();
//        controlRace.read();

//        ControlCar controlCar = new ControlCar();
//        controlCar.read();

//        ControlEnrolment controlEnrolment = new ControlEnrolment();
//        controlEnrolment.read();

        ViewStudent viewStudent = new ViewStudent();
        System.out.println(viewStudent);

    }
}
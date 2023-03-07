package ro.mycode.models;

public class Car {
    private int carId = 0;
    private int racerId = 0;
    private int number = 0;
    private String brand = "";
    private String model = "";

    public Car(String text) {
        String[] split = text.split(",");
        this.carId = Integer.parseInt(split[0]);
        this.racerId = Integer.parseInt(split[1]);
        this.number = Integer.parseInt(split[2]);
        this.brand = split[3];
        this.model = split[4];
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getCarId() {
        return carId;
    }

    public void setRacerId(int racerId) {
        this.racerId = racerId;
    }

    public int getRacerId() {
        return racerId;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setModel() {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public String descriere() {
        String descriere = "Id-ul masinii este " + carId + ", id-ul pilotului de curse este " + racerId +
                " numarul masinii este " + number + ", iar marca si modelul masinii sunt " + brand + " " + model;
        return descriere;
    }
}

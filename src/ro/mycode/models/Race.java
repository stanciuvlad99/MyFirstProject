package ro.mycode.models;

public class Race {
    private int raceId = 0;
    private String name = "";
    private String department = "";

    public Race(String text) {
        String[] split = text.split(",");
        this.raceId = Integer.parseInt(split[0]);
        this.name = split[1];
        this.department = split[2];
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }

    public int getRaceId() {
        return raceId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public String descriere() {
        String descriere = "Id-ul cursei este " + raceId + ", numele cursei este " + name + " iar departamentul este " +
                department;
        return descriere;
    }
}

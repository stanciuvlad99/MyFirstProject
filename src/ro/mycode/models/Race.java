package ro.mycode.models;

public class Race {
    private int raceId = 0;
    private String name = "";
    private String raceType = "";

    public Race(int raceId, String name, String raceType) {
        this.raceId = raceId;
        this.name = name;
        this.raceType = raceType;
    }

    public Race(String text) {
        String[] split = text.split(",");
        this.raceId = Integer.parseInt(split[0]);
        this.name = split[1];
        this.raceType = split[2];
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

    public void setRaceType(String raceType) {
        this.raceType = raceType;
    }

    public String getRaceType() {
        return raceType;
    }

    public String descriere() {
        String descriere = "Id-ul cursei este " + raceId + ", numele cursei este " + name + " iar tipul cursei este " +
                raceType;
        return descriere;
    }
}

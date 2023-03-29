package ro.mycode.models;

public class Enrolmet {
    private int enrolemntId = 0;
    private int racerId = 0;
    private int raceId = 0;

    public Enrolmet(String text) {
        String[] split = text.split(",");
        this.enrolemntId = Integer.parseInt(split[0]);
        this.racerId = Integer.parseInt(split[1]);
        this.raceId = Integer.parseInt(split[2]);
    }

    public Enrolmet(int enrolemntId, int racerId, int raceId){
        this.enrolemntId=enrolemntId;
        this.racerId=racerId;
        this.raceId=raceId;
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }

    public int getRaceId() {
        return raceId;
    }

    public void setRacerId(int racerid) {
        this.racerId = racerid;
    }

    public int getRacerId() {
        return racerId;
    }

    public void setEnrolemntId(int enrolemntId) {
        this.enrolemntId = enrolemntId;
    }

    public int getEnrolemntId() {
        return enrolemntId;
    }

    public String descriere() {
        String descriere = "Id-ul enrolemtului este " + enrolemntId + ", id-ul pilotului de curse este " + racerId +
                ", id-ul cursei este " + raceId;
        return descriere;
    }

    public String toSave(){
        return this.enrolemntId+","+this.racerId+","+this.raceId;
    }
}

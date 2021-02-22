package DBTabels;

import java.util.Date;

public class Produkt {
    private int produktId;
    private String farg;
    private int storlek;
    private double pris;
    private int märkeid;
    private int antalskor;
    private Date createddate,lastuppdated;

    public Produkt(int produktId, String farg, int storlek, double pris, int märkeid, int antalskor, Date createddate, Date lastuppdated) {
        this.produktId = produktId;
        this.farg = farg;
        this.storlek = storlek;
        this.pris = pris;
        this.märkeid = märkeid;
        this.antalskor = antalskor;
        this.createddate = createddate;
        this.lastuppdated = lastuppdated;
    }

    public int getProduktId() {
        return produktId;
    }

    public String getFarg() {
        return farg;
    }

    public int getStorlek() {
        return storlek;
    }

    public double getPris() {
        return pris;
    }

    public int getMärkeid() {
        return märkeid;
    }

    public int getAntalskor() {
        return antalskor;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public Date getLastuppdated() {
        return lastuppdated;
    }
}

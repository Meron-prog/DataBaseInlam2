package DBTabels;

import java.util.Date;

public class Tillhör {
    private int tillhörId,produktId,katagorieId;
    private Date createddate,lastuppdated;

    public Tillhör(int tillhörId, int produktId, int katagorieId, Date createddate, Date lastuppdated) {
        this.tillhörId = tillhörId;
        this.produktId = produktId;
        this.katagorieId = katagorieId;
        this.createddate = createddate;
        this.lastuppdated = lastuppdated;
    }

    public int getTillhörId() {
        return tillhörId;
    }

    public int getProduktId() {
        return produktId;
    }

    public int getKatagorieId() {
        return katagorieId;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public Date getLastuppdated() {
        return lastuppdated;
    }
}

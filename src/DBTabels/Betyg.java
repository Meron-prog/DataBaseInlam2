package DBTabels;

import java.util.Date;

public class Betyg {

    private int betygId, betygvärdeId,produktId,kundId;
    private String komment;
    private Date createddate,lastuppdated;

    public Betyg(int betygId, int betygvärdeId, int produktId, int kundId, String komment, Date createddate, Date lastuppdated) {
        this.betygId = betygId;
        this.betygvärdeId = betygvärdeId;
        this.produktId = produktId;
        this.kundId = kundId;
        this.komment = komment;
        this.createddate = createddate;
        this.lastuppdated = lastuppdated;
    }

    public int getBetygId() {
        return betygId;
    }

    public int getBetygvärdeId() {
        return betygvärdeId;
    }

    public int getProduktId() {
        return produktId;
    }

    public int getKundId() {
        return kundId;
    }

    public String getKomment() {
        return komment;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public Date getLastuppdated() {
        return lastuppdated;
    }
}

package DBTabels;

import java.util.Date;

public class Betygvärde {
    private int betygvärdeId,sifferVärde;
    private String värde;
    private Date createddate,lastuppdated;

    public Betygvärde(int betygvärdeId, int sifferVärde, String värde, Date createddate, Date lastuppdated) {
        this.betygvärdeId = betygvärdeId;
        this.sifferVärde = sifferVärde;
        this.värde = värde;
        this.createddate = createddate;
        this.lastuppdated = lastuppdated;
    }

    public int getBetygvärdeId() {
        return betygvärdeId;
    }

    public int getSifferVärde() {
        return sifferVärde;
    }

    public String getVärde() {
        return värde;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public Date getLastuppdated() {
        return lastuppdated;
    }
}

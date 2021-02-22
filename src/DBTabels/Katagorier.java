package DBTabels;

import java.util.Date;

public class Katagorier {

    private int katagorierId;
    private String namn;
    private Date createddate,lastuppdated;

    public Katagorier(int katagorierId, String namn, Date createddate, Date lastuppdated) {
        this.katagorierId = katagorierId;
        this.namn = namn;
        this.createddate = createddate;
        this.lastuppdated = lastuppdated;
    }

    public int getKatagorierId() {
        return katagorierId;
    }

    public String getNamn() {
        return namn;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public Date getLastuppdated() {
        return lastuppdated;
    }
}

package DBTabels;

import java.util.Date;

public class Märke {
    private int märkeId;
    private String namn;
    private Date createddate,lastuppdated;

    public Märke(int märkeId, String namn, Date createddate, Date lastuppdated) {
        this.märkeId = märkeId;
        this.namn = namn;
        this.createddate = createddate;
        this.lastuppdated = lastuppdated;
    }

    public int getMärkeId() {
        return märkeId;
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

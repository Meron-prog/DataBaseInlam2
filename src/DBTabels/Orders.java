package DBTabels;

import java.util.Date;

public class Orders {
    private int ordersId;
    private int kundId;
    private Date datum,createddate,lastuppdated;

    public Orders(int ordersId, int kundId, Date datum, Date createddate, Date lastuppdated) {
        this.ordersId = ordersId;
        this.kundId = kundId;
        this.datum = datum;
        this.createddate = createddate;
        this.lastuppdated = lastuppdated;
    }

    public int getOrdersId() {
        return ordersId;
    }

    public int getKundId() {
        return kundId;
    }

    public Date getDatum() {
        return datum;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public Date getLastuppdated() {
        return lastuppdated;
    }
}


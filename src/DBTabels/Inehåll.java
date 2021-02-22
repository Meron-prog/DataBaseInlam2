package DBTabels;

import java.util.Date;

public class Inehåll {
    private int inehållId;
    private int produktId;
    private int ordersId;
    private Date createddate,lastuppdated;

    public Inehåll(int inehållId, int produktId, int ordersId, Date createddate, Date lastuppdated) {
        this.inehållId = inehållId;
        this.produktId = produktId;
        this.ordersId = ordersId;
        this.createddate = createddate;
        this.lastuppdated = lastuppdated;
    }

    public int getInehållId() {
        return inehållId;
    }

    public int getProduktId() {
        return produktId;
    }

    public int getOrdersId() {
        return ordersId;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public Date getLastuppdated() {
        return lastuppdated;
    }
}

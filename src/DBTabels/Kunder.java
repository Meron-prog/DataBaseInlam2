package DBTabels;

import java.util.Date;

public class Kunder {
    private int kunderId;
    private String förNamn;
    private String efterNamn;
    private String ort;
    private String använderNamn;
    private String lösenord;
    private Date createddate,lastuppdated;

    public Kunder(int kunderId, String förNamn, String efterNamn, String ort, String använderNamn, String lösenord,
                  Date createddate, Date lastuppdated) {
        this.kunderId = kunderId;
        this.förNamn = förNamn;
        this.efterNamn = efterNamn;
        this.ort = ort;
        this.använderNamn = använderNamn;
        this.lösenord = lösenord;
        this.createddate = createddate;
        this.lastuppdated = lastuppdated;
    }

    public int getKunderId() {
        return kunderId;
    }

    public String getFörNamn() {
        return förNamn;
    }

    public String getEfterNamn() {
        return efterNamn;
    }

    public String getOrt() {
        return ort;
    }

    public String getAnvänderNamn() {
        return använderNamn;
    }

    public String getLösenord() {
        return lösenord;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public Date getLastuppdated() {
        return lastuppdated;
    }
}

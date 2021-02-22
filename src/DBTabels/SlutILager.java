package DBTabels;

import java.util.Date;

public class SlutILager {
    private int slutILager,produktId;
    private Date datumProduktSlut;

    public SlutILager(int slutILager, int produktId, Date datumProduktSlut) {
        this.slutILager = slutILager;
        this.produktId = produktId;
        this.datumProduktSlut = datumProduktSlut;
    }

    public int getSlutILager() {
        return slutILager;
    }

    public int getProduktId() {
        return produktId;
    }

    public Date getDatumProduktSlut() {
        return datumProduktSlut;
    }
}

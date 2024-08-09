package app.starcraft.buldings.terrans;
import app.starcraft.units.terrans.barracks.Marauder;
import app.starcraft.units.terrans.barracks.Marine;
import org.springframework.beans.factory.annotation.Autowired;
public class Barracks {
    @Autowired
    private Marine marine;
    @Autowired
    private Marauder marauder;

    public void createUnit () {
        marine.craft();
        marauder.craft();
    }

    public Marine getMarine() {
        return marine;
    }

    public void setMarine(Marine marine) {
        this.marine = marine;
    }

    public Marauder getMarauder() {
        return marauder;
    }

    public void setMarauder(Marauder marauder) {
        this.marauder = marauder;
    }
}

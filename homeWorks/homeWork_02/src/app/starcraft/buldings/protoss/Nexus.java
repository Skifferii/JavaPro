package app.starcraft.buldings.protoss;

import app.starcraft.units.protoss.nexus.Probe;
import org.springframework.beans.factory.annotation.Autowired;

public class Nexus {
    @Autowired
    private Probe probe;

    public void createUnit (){
        probe.craft();
    }

    public Probe getProbe() {
        return probe;
    }

    public void setProbe(Probe probe) {
        this.probe = probe;
    }
}

package app.starcraft;

import app.starcraft.buldings.protoss.Nexus;
import app.starcraft.buldings.protoss.Stargate;
import org.springframework.beans.factory.annotation.Autowired;

public class Player {

    @Autowired
    Nexus nexus;
    @Autowired
    Stargate stargate;
    @Autowired
    Commandor commandor;

    public  void playGame() {
        nexus.createUnit();
        stargate.createUnit();
        commandor.bulding();
        commandor.message();
    }

    public Nexus getNexus() {
        return nexus;
    }

    public void setNexus(Nexus nexus) {
        this.nexus = nexus;
    }

    public Stargate getStargate() {
        return stargate;
    }

    public void setStargate(Stargate stargate) {
        this.stargate = stargate;
    }

    public Commandor getCommandor() {
        return commandor;
    }

    public void setCommandor(Commandor commandor) {
        this.commandor = commandor;
    }
}

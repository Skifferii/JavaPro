package app.starcraft.buldings.protoss;

import app.starcraft.units.protoss.stargate.Oracle;
import app.starcraft.units.protoss.stargate.Phoenix;
import org.springframework.beans.factory.annotation.Autowired;

public class Stargate {
    @Autowired
    private Oracle oracle;
    @Autowired
    private Phoenix phoenix;

    public void createUnit () {
        oracle.craft();
        phoenix.craft();
    }
}

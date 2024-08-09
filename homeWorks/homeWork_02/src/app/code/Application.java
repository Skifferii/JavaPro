package app.code;

import app.starcraft.Commandor;
import app.starcraft.Player;
import app.starcraft.buldings.protoss.Nexus;
import app.starcraft.buldings.protoss.Stargate;
import app.starcraft.buldings.terrans.Barracks;
import app.starcraft.units.protoss.nexus.Probe;
import app.starcraft.units.protoss.stargate.Oracle;
import app.starcraft.units.protoss.stargate.Phoenix;
import app.starcraft.units.terrans.barracks.Marauder;
import app.starcraft.units.terrans.barracks.Marine;

public class Application {
    public static void main(String[] args) {
        Probe probe = new Probe();
        Oracle oracle = new Oracle();
        Phoenix phoenix = new Phoenix();
        Marauder marauder = new Marauder();
        Marine marine = new Marine();

        Nexus nexus = new Nexus();
        nexus.setProbe(probe);

        Stargate stargate = new Stargate();
        stargate.setOracle(oracle);
        stargate.setPhoenix(phoenix);

        Barracks barracks = new Barracks();
        barracks.setMarauder(marauder);
        barracks.setMarine(marine);

        Commandor commandor = new Commandor();
        commandor.setBarracks(barracks);

        Player player = new Player();
        player.setNexus(nexus);
        player.setCommandor(commandor);
        player.setStargate(stargate);

        System.out.println("-------Game start-----------");
        player.playGame();
        System.out.println("-------Game endet-----------");

    }

}


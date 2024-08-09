package app.config;


import app.starcraft.Commandor;
import app.starcraft.Player;
import app.starcraft.buldings.protoss.Nexus;
import app.starcraft.buldings.terrans.Barracks;
import app.starcraft.units.protoss.nexus.Probe;
import app.starcraft.units.protoss.stargate.Oracle;
import app.starcraft.units.protoss.stargate.Phoenix;
import app.starcraft.units.terrans.barracks.Marauder;
import app.starcraft.units.terrans.barracks.Marine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class AppConfig {


    //Spring context

    @Bean
    public Player getPlayer() { return new Player();
    }

    @Bean
    public Commandor getCommandor(){
        return new Commandor();
    }
    @Bean
    public Barracks  getBarracks(){
        return new Barracks();
    }
    @Bean
    public Nexus getNexus(){
        return new Nexus();
    }
    @Bean
    public Marine getMarine(){
        return new Marine();
    }
    @Bean
    public Marauder getMarauder(){
        return new Marauder();
    }
    @Bean
    public Phoenix getPhoenix(){
        return new Phoenix();
    }
    @Bean
    public Oracle getOracle(){
        return new Oracle();
    }
    @Bean
    public Probe getProbe(){
        return new Probe();
    }


}

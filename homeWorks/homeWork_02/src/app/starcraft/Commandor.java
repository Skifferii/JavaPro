package app.starcraft;

import app.starcraft.buldings.terrans.Barracks;
import org.springframework.beans.factory.annotation.Autowired;

public class Commandor {
    @Autowired
    Barracks barracks;

    public void bulding() {
        barracks.createUnit();
    }

    public void message() {
        System.out.println("Commandor: We need more syply depots");
    }

    public Barracks getBarracks() {
        return barracks;
    }

    public void setBarracks(Barracks barracks) {
        this.barracks = barracks;
    }
}

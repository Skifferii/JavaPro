package app.code;


import app.configuration.AppConfiguration;
import app.starcraft.Player;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class ApplicationWithSpring {
    public static void main(String[] args) {
        //start with Spring
        AbstractApplicationContext  context =
        new AnnotationConfigApplicationContext("app.configuration");
        // from context kommt player

        Player player = context.getBean(Player.class);
        player.playGame();

    }

    }


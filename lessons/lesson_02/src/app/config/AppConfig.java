package app.config;

import app.staff.administration.Director;
import app.staff.administration.ProductionChef;
import app.staff.administration.SalesChef;
import app.staff.specialists.Secretary;
import app.staff.specialists.productions.MachineOperator;
import app.staff.specialists.productions.StoreKeeper;
import app.staff.specialists.sales.Merchandiser;
import app.staff.specialists.sales.SalesManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration

public class AppConfig {


    //Spring context

    @Bean
    public Director getDirector() {
        return new Director();
    }

    @Bean
    public ProductionChef getProdactionChef(){
        return new ProductionChef();
    }

    @Bean
    public SalesChef getSalesChef(){
        return new SalesChef();
    }

    @Bean
    public MachineOperator getMachineOperator(){
        return new MachineOperator();
    }

    @Bean
    public StoreKeeper getStoreKeeper(){
        return new StoreKeeper();
    }

    @Bean
    public Secretary getSecretary(){
        return new Secretary();
    }

    @Bean
    public Merchandiser getMerchandiser(){
        return new Merchandiser();
    }

    @Bean
    public SalesManager getSalesManager(){
        return new SalesManager();
    }


}

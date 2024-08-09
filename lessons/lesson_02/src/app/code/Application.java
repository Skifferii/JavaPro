package app.code;

import app.staff.administration.Director;
import app.staff.administration.ProductionChef;
import app.staff.administration.SalesChef;
import app.staff.specialists.Secretary;
import app.staff.specialists.productions.MachineOperator;
import app.staff.specialists.productions.StoreKeeper;
import app.staff.specialists.sales.Merchandiser;
import app.staff.specialists.sales.SalesManager;

public class Application {
    public static void main(String[] args) {
        MachineOperator machineOperator = new MachineOperator();
        StoreKeeper storeKeeper = new StoreKeeper();

        Merchandiser merchandiser = new Merchandiser();
        SalesManager salesManager = new SalesManager();
        Secretary secretary = new Secretary();

        ProductionChef productionChef = new ProductionChef();
        productionChef.setMachineOperator(machineOperator);
        productionChef.setStoreKeeper(storeKeeper);

        SalesChef salesChef= new SalesChef();
        salesChef.setSalesManager(salesManager);
        salesChef.setMerchandiser(merchandiser);


        Director director= new Director();
        director.setSecretary(secretary);
        director.setProductionChef(productionChef);
        director.setSalesChef(salesChef);


        director.manageCompany();
    }

    }


package Controller;

import Model.App;

public class AppController {

    private App applicatie;

    public  AppController(){

        applicatie = new App();

        System.out.println("so far..");

        String[] vormen = applicatie.getData();

        for(int i = 0; i < vormen.length; i++){
            System.out.println(vormen[i]);
        }


    }



}

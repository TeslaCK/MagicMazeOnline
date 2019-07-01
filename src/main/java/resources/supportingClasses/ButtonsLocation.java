package resources.supportingClasses;


import javafx.scene.control.Button;

public class ButtonsLocation {

    private Location locations;
    private int id;
    private String status;
    ButtonsLocation[][] buttonsLocations;
    Buttons buttonsClass = new Buttons();

    public ButtonsLocation() {



    }
     public void generateId(){

        if ( id == 1){
            status = "Door";
        }else if (id == 2){
            status = "Wall";

        }
     }

}

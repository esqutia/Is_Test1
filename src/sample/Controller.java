package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class Controller {
    @FXML
    TextField cad_warm1,cad_warm2;
    @FXML
    Label reWarm1,reWarm2;


    public void last3(KeyEvent keyEvent) {
        Warmup1 obj=new Warmup1();
        String texto=obj.conversion(cad_warm1.getText());
        reWarm1.setText(texto);
    }

    public void yak(){
        Warmup2 obj=new Warmup2();
        String cadena=obj.stringYak(cad_warm2.getText());
        reWarm2.setText(cadena);
    }
}

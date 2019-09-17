package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    TextField cad_warm1,cad_warm2,A1,A2,B1,B2,cad_warmup2,RR1,RR2,R3,ioq1,ioq2,ioq3,arraygm;
    @FXML
    Label reWarm1,reIoq, labelgm;
    @FXML
    Button btnGO,btnYAK,gogm;


    public void last3(KeyEvent keyEvent) {
        Warmup1 obj=new Warmup1();
        String texto=obj.conversion(cad_warm1.getText());
        reWarm1.setText(texto);
    }


    EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            if(event.getSource() == btnGO){
                GO();
            }
            if(event.getSource() == btnYAK){
                yak();
            }
        }
    };

    public void yak(){
        Warmup2 obj=new Warmup2();
        String cadena=obj.stringYak(cad_warm2.getText());
        cad_warmup2.setText(cadena);
    }

    public void GO(){
            int[] a = {Integer.parseInt(A1.getText()),Integer.parseInt(A2.getText())};
            int[] b = {Integer.parseInt(B1.getText()),Integer.parseInt(B2.getText())};
            Array1 obj=new Array1();
            int[] R = obj.biggerTwo(a,b);
            RR1.setText(String.valueOf(R[0]));
            RR2.setText(String.valueOf(R[1]));
            R3.setText(String.valueOf(R[0]+R[1]));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnYAK.setOnAction(handler);
        btnGO.setOnAction(handler);
    }

    public void logic1(ActionEvent actionEvent) {
        int x=Integer.parseInt(ioq1.getText());
        int y=Integer.parseInt(ioq1.getText());
        int z=Integer.parseInt(ioq1.getText());
        Logic1 obj=new Logic1();
        boolean texto=obj.inOrderEqual(x,y,z,true);
        String re=String.valueOf(texto);
        reIoq.setText(re);
    }

    public void gogm(){
        String aux = arraygm.getText();
        int[] entrada = new int[aux.length()];

        for (int i = 0; i<entrada.length;i++){
            entrada[i] = Integer.parseInt(aux.substring(i,i+1));
        }
        Warmup2 wu = new Warmup2();
        labelgm.setText(""+wu.array667(entrada));
    }
}

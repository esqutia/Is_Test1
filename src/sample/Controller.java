package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    TextField cad_warm1,cad_warm2,A1,A2,B1,B2,cad_warmup2,RR1,RR2,R3,ioq1,ioq2,ioq3,arraygm, A, AB, B, teen1, teen2, res_teenSum;
    @FXML
    Label reWarm1,reIoq, labelgm;
    @FXML
    Button btnGO,btnYAK,gogm, btnMap, btnTeen,solWarm,solYak,solArra;


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
            if(event.getSource() == btnMap){
                mapAB();
            }
            if(event.getSource() == btnTeen){
                teenSum();
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

    public void teenSum(){
        int a=Integer.parseInt(teen1.getText());
        int b=Integer.parseInt(teen2.getText());
        if(a>=13 && a<=19 || b>=13 && b<=19){
            res_teenSum.setText("19");
        }else{
            res_teenSum.setText((a+b)+"");
        }
    }

    public void mapAB(){
        MapAB mapa=new MapAB();
        Map<String, String> map = new HashMap<String, String>();
        String a, b;
        a=this.A.getText();
        b=this.B.getText();
        if (a.length()>0)
            map.put("a", a);
        if (b.length()>0)
            map.put("b", b);
        map=mapa.mapAB(map);
        this.A.setText(map.get("a"));
        this.B.setText(map.get("b"));
        this.AB.setText(map.get("ab"));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnYAK.setOnAction(handler);
        btnGO.setOnAction(handler);
        btnMap.setOnAction(handler);
        btnTeen.setOnAction(handler);
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

    public void solucion(ActionEvent actionEvent) {
        Button boton=(Button)(actionEvent.getSource());
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Solution");
        dialog.setHeaderText("Comparacion de soluciones\nCodingBat|OpenessTeam");
        dialog.setWidth(600);
        dialog.setHeight(250);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        Separator sep = new Separator();
        sep.setOrientation(Orientation.VERTICAL);

        ButtonType Acept = new ButtonType("Aceptar", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(Acept, ButtonType.CANCEL);

        Label lblcb = new Label();
        Label lblot = new Label();

        switch(boton.getId()) {
            case "solWarm":
                lblcb.setText("public String endUp(String str) {\n" +
                        "  if (str.length() <= 3) return str.toUpperCase();\n" +
                        "  int cut = str.length() - 3;\n" +
                        "  String front = str.substring(0, cut);\n" +
                        "  String back  = str.substring(cut);  // this takes from cut to the end\n" +
                        "  \n" +
                        "  return front + back.toUpperCase();\n" +
                        "}");
                lblot.setText("public String conversion(String str) {\n" +
                        "        if (str.length() <= 3) return str.toUpperCase();\n" +
                        "        int cut = str.length() - 3;\n" +
                        "        String front = str.substring(0, cut);\n" +
                        "        String back  = str.substring(cut);\n" +
                        "        return front + back.toUpperCase();\n" +
                        "    }");
                grid.add(lblcb,0,0);
                grid.add(sep,1,0);
                grid.add(lblot,2,0);
                dialog.getDialogPane().setContent(grid);
                dialog.show();
                break;
            case "solYak":
                lblcb.setText("public String stringYak(String str) {\n" +
                        "  String result = \"\";\n" +
                        "  \n" +
                        "  for (int i=0; i<str.length(); i++) {\n" +
                        "    // Look for i starting a \"yak\" -- advance i in that case\n" +
                        "    if (i+2<str.length() && str.charAt(i)=='y' && str.charAt(i+2)=='k') {\n" +
                        "      i =  i + 2;\n" +
                        "    } else { // Otherwise do the normal append\n" +
                        "      result = result + str.charAt(i);\n" +
                        "    }\n" +
                        "  }\n" +
                        "  \n" +
                        "  return result;\n" +
                        "}");
                lblot.setText("public String stringYak(String str) {\n" +
                        "        String tmp=\"\";\n" +
                        "        int i=0;\n" +
                        "        while(i<str.length()){\n" +
                        "            if(i+2<str.length() && str.charAt(i)=='y' && str.charAt(i+1)=='a' && str.charAt(i+2)=='k'){\n" +
                        "                i=i+3;\n" +
                        "            }else{\n" +
                        "                tmp=tmp+str.charAt(i);\n" +
                        "                i++;\n" +
                        "            }\n" +
                        "        }\n" +
                        "        return tmp;\n" +
                        "    }");
                grid.add(lblcb,0,0);
                grid.add(sep,1,0);
                grid.add(lblot,2,0);
                dialog.getDialogPane().setContent(grid);
                dialog.show();
                break;
            case "solArra":
                lblcb.setText("public int array667(int[] nums) {\n" +
                        "  int count = 0;\n" +
                        "  // Note: iterate to length-1, so can use i+1 in the loop\n" +
                        "  for (int i=0; i < (nums.length-1); i++) {\n" +
                        "    if (nums[i] == 6) {\n" +
                        "      if (nums[i+1] == 6 || nums[i+1] == 7) {\n" +
                        "        count++;\n" +
                        "      }\n" +
                        "    }\n" +
                        "  }\n" +
                        "  return count;\n" +
                        "}");
                lblot.setText("public int array667(int[] nums) {\n" +
                        "        int count = 0;\n" +
                        "        for (int i=0; i < (nums.length-1); i++) {\n" +
                        "            if (nums[i] == 6) {\n" +
                        "                if (nums[i+1] == 6 || nums[i+1] == 7) {\n" +
                        "                    count++;\n" +
                        "                    System.out.println(nums[i]);\n" +
                        "                    System.out.println(nums[i+1]);\n" +
                        "                    System.out.println(nums[count]);\n" +
                        "                }\n" +
                        "            }\n" +
                        "        }\n" +
                        "        return count;\n" +
                        "    }");
                grid.add(lblcb,0,0);
                grid.add(sep,1,0);
                grid.add(lblot,2,0);
                dialog.getDialogPane().setContent(grid);
                dialog.show();
                break;
        }
    }
}

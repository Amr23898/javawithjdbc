/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javawithjdbc.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javawithjdbc.controler.Userconnection;
import javawithjdbc.model.User;

/**
 *
 * @author ElAbd
 */
public class Leftpane extends VBox{
    
   Label titlelab =new Label("Add New User");
   Label  labname =new Label("Add Your  Name :");
   Label labage =new Label("Add Your Age :");
   Label  labyear =new Label("Add Your Year :");
    TextField tname=new TextField();
    TextField tage=new TextField();
    TextField tyear=new TextField();
    Button bt1= new Button("Save");
    Button bt2= new Button("Update");
    Button bt3= new Button("Delete");
    Userconnection ucon=new Userconnection();
    int tempid;
          public Leftpane(){
        tname.setFont(new Font(15));
        tage.setFont(new Font(15));
        tyear.setFont(new Font(15));
        bt1.setPrefWidth(150);
        bt2.setPrefWidth(150);
        bt3.setPrefWidth(150);
        
       bt1.setStyle("-fx-background-color:#2ecc71;-fx-font-size:18px;-fx-text-fill:#fff");
       bt2.setStyle("-fx-background-color:#2ecc71;-fx-font-size:18px;-fx-text-fill:#fff");
       bt3.setStyle("-fx-background-color:#2ecc71;-fx-font-size:18px;-fx-text-fill:#fff");
        titlelab.setStyle("-fx-font-size:25px;-fx-text-fill:#fff");
        this.setStyle("-fx-background-color:#3498db");
        this.setSpacing(15);
        this.setPadding(new Insets(20));
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(titlelab,labname,tname,labage,tage,labyear,tyear,bt1,bt2,bt3);
        
        
        
        // action to buutom
        bt1.setOnMouseClicked(e->{
            User us=new User();
            us.setName(tname.getText());
            us.setAge(Integer.parseInt(tage.getText()));
            us.setYear(Integer.parseInt(tyear.getText()));
            ucon.insert(us);
            JavaWithJdbc.rpane.table.setItems(ucon.getalluser());
            tname.setText("");
            tage.setText("");
            tyear.setText("");
        });
        
        bt2.setOnMouseClicked(e->{
             User us=new User();
             us.setId(tempid);
            us.setName(tname.getText());
            us.setAge(Integer.parseInt(tage.getText()));
            us.setYear(Integer.parseInt(tyear.getText()));
            ucon.update(us);
            JavaWithJdbc.rpane.table.setItems(ucon.getalluser());
          tname.setText("");
            tage.setText("");
            tyear.setText("");
                });
        
        bt3.setOnMouseClicked(e->{
         ucon.delete(tempid);
         JavaWithJdbc.rpane.table.setItems(ucon.getalluser());
          tname.setText("");
            tage.setText("");
            tyear.setText("");
        });
    }
      
    
    
}

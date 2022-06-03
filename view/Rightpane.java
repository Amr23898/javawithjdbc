/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javawithjdbc.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javawithjdbc.controler.Userconnection;
import javawithjdbc.model.User;


/**
 *
 * @author ElAbd
 */
public class Rightpane extends VBox{
    TableView <User> table = new TableView();
    HBox searchpane=new HBox();
    TextField tsearch=new TextField();
    Button btsearch= new  Button("Search");
    Userconnection uscon= new Userconnection();
    
    public Rightpane(){
        TableColumn<User , Integer> Id= new TableColumn<>("ID");
        TableColumn<User , String> name= new TableColumn<>("U_Name");
        TableColumn<User , Integer> age= new TableColumn<>("U_Age");
        TableColumn<User , Integer> year= new TableColumn<>("U_Year");
        
        Id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        age.setCellValueFactory(new PropertyValueFactory<>("age"));
        year.setCellValueFactory(new PropertyValueFactory<>("year"));
        
       Id.prefWidthProperty().bind(table.widthProperty().divide(4));
       name.prefWidthProperty().bind(table.widthProperty().divide(4));
       age.prefWidthProperty().bind(table.widthProperty().divide(4));
       year.prefWidthProperty().bind(table.widthProperty().divide(4));

       table.getColumns().addAll(Id,name,age,year);
       table.setItems(uscon.getalluser());
        
        searchpane.getChildren().addAll(tsearch,btsearch);
        searchpane.setSpacing(20);
        searchpane.setPadding(new Insets(20));
        searchpane.setAlignment(Pos.CENTER);
        tsearch.setPrefWidth(200);
        tsearch.setFont(new Font(15));
       btsearch.setStyle("-fx-background-color:#2ecc71;-fx-font-size:18px;-fx-text-fill:#fff");
        this.setPadding(new Insets(20));
        this.getChildren().addAll(searchpane,table);
        table.setOnMouseClicked(e->{
        User user=table.getSelectionModel().getSelectedItem();
        JavaWithJdbc.lfpane.tname.setText(user.getName());
        JavaWithJdbc.lfpane.tage.setText(user.getAge()+"");
        JavaWithJdbc.lfpane.tyear.setText(user.getYear()+"");
        JavaWithJdbc.lfpane.tempid=user.getId();

        
        
        });
        btsearch.setOnMouseClicked(e->{ 
                this.table.setItems( uscon.search(Integer.parseInt(tsearch.getText())));
        tsearch.setText(" ");
        });
        
    
    }
}

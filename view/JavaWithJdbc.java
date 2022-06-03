/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javawithjdbc.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author ElAbd
 */
public class JavaWithJdbc extends Application {
    static Leftpane lfpane=new Leftpane();
    static Rightpane rpane= new Rightpane();
    @Override
    public void start(Stage primaryStage) {
        HBox main =new HBox();
        lfpane.prefWidthProperty().bind(main.widthProperty().divide(3));
        rpane.prefWidthProperty().bind(main.widthProperty().divide(1.5));

        main.getChildren().addAll(lfpane,rpane);
        Scene s1=new Scene(main,800,600);
        primaryStage.setScene(s1);
        primaryStage.show();
    }

        public static void main(String[] args) {
        launch(args);
    }
    
}
 
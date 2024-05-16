package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //making player
        Rectangle player = new Rectangle(50 , 100) ;
        player.setLayoutY(100);
        player.setLayoutX(225);
        player.setFill(Color.PURPLE);

        //making jump button
        Button jumpButton = new Button("Jump") ;
        jumpButton.setPrefWidth(100);
        jumpButton.setPrefHeight(100);
        jumpButton.setLayoutX(200);
        jumpButton.setLayoutY(400);

        //making ground
        Group root1 = new Group() ;
        for (int row = 0; row < 5 ; row++) {

            Random random = new Random();
            int randomNum = random.nextInt(5);
            System.out.println(randomNum);

            if (row >= 3 && (randomNum == 1 || randomNum == 3)){
                Rectangle randomSquare = new Rectangle(row*101, 200 , 100 , 50);
                randomSquare.setFill(Color.RED);
                root1.getChildren().add(randomSquare) ;
            }
            else {
                Rectangle square = new Rectangle(row*101, 200 , 100 , 100);
                square.setFill(Color.BLUE);
                root1.getChildren().add(square) ;
            }

        }
        Group root2 = new Group() ;
        for (int row = 0; row < 5 ; row++) {

            Random random = new Random();
            int randomNum = random.nextInt(5);
            System.out.println(randomNum);

            if (randomNum == 0 || randomNum == 2){
                Rectangle randomSquare = new Rectangle(row*101, 200 , 100 , 50);
                randomSquare.setFill(Color.RED);
                root2.getChildren().add(randomSquare) ;
            }
            else {
                Rectangle square = new Rectangle(row*101+501, 200 , 100 , 100);
                square.setFill(Color.BLUE);
                root2.getChildren().add(square) ;
            }


        }

        //jump button settings
        jumpButton.setOnMouseClicked(mouseEvent -> {
            Double xPos1 = root1.getLayoutX() ;
            root1.setLayoutX(xPos1-101);
            Double xPos2 = root2.getLayoutX() ;
            root2.setLayoutX(xPos2-101);

            if (xPos1 == -404.0) {
                root1.setLayoutX(505);
            }
            if (xPos2 == -909.0) {
                root2.setLayoutX(0);
            }
        });





        // final setting and show on screen
        Group group = new Group(player , root1 , root2 , jumpButton) ;
        Scene scene = new Scene(group , 500, 500);
        stage.setTitle("HopenHelm!");
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {
        launch();
    }
}

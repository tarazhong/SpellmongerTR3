package sample;

import com.sun.javafx.util.TempState;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by antho on 19/10/2016.
 * Do for the board
 */
public class V_BoardCard {

    public static void display(Image img, Image img2, Image img3, Image img3_2, Image img3_3, Image img3_4, Image img3_5){

        Stage board = new Stage();
        board.getIcons().add(new Image("/lofo_esilv.png"));
        board.initModality(Modality.APPLICATION_MODAL);
        board.setMinHeight(500);
        board.setMinWidth(1000);
        board.setTitle("SpellMonger");




        //Set 3 button with image
        Button button_img1 = new Button("",new ImageView(img));

        Button btnLeft = new Button();
        btnLeft.setGraphic(new ImageView(img2));


        //Set button at middle
        Button button_center = new Button();
        Button btnPlay = new Button("Play");
/*
        button.setOnAction(e-> System.out.println("Draw a card"));
*/
//set a grip pane not use for moment
        /*GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);*/


//set Hbox for both top and bottom
        HBox topMenu = new HBox();
        Button button_card1 = new Button("", new ImageView(img));
        Button button_card2 = new Button("",new ImageView(img));
        Button button_card3 = new Button("",new ImageView(img));
        Button button_card4 = new Button("",new ImageView(img));
        Button button_card5 = new Button("",new ImageView(img));
        topMenu.getChildren().addAll(button_card1,button_card2,button_card3,button_card4,button_card5);

        HBox botMenu = new HBox();
        Button button_card6 = new Button("", new ImageView(img3));
        Button button_card7 = new Button("", new ImageView(img3_2));
        Button button_card8 = new Button("", new ImageView(img3_3));
        Button button_card9 = new Button("", new ImageView(img3_4));
        Button button_card10 = new Button("", new ImageView(img3_5));
        botMenu.getChildren().addAll(button_card6,button_card7,button_card8,button_card9,button_card10);



//Set layout

        BorderPane layout =  new BorderPane();

        layout.setTop(topMenu);
        BorderPane.setAlignment(topMenu, Pos.TOP_CENTER);

        layout.setBottom(botMenu);
        BorderPane.setAlignment(botMenu, Pos.BOTTOM_CENTER);

        layout.setCenter(button_center);

        layout.setLeft(btnLeft);
        BorderPane.setAlignment(btnLeft, Pos.CENTER);

        layout.setRight(btnPlay);
        BorderPane.setAlignment(btnPlay, Pos.CENTER);



        //set Action
        button_card1.setOnAction(e->{
            Button Temps = new Button();
//set temps as button 2
            Temps.setText(button_center.getText());
            Temps.setGraphic(button_center.getGraphic());
            //Set button 2 as button press
            button_center.setGraphic(button_card1.getGraphic());
//set button 1
            button_card1.setGraphic(Temps.getGraphic());
        });

        button_card2.setOnAction(e->{
            Button Temps = new Button();
            Temps.setText(button_center.getText());
            Temps.setGraphic(button_center.getGraphic());
            button_center.setGraphic(button_card2.getGraphic());
            button_card2.setGraphic(Temps.getGraphic());
        });

        button_card3.setOnAction(e->{
            Button Temps = new Button();
            Temps.setText(button_center.getText());
            Temps.setGraphic(button_center.getGraphic());
            button_center.setGraphic(button_card3.getGraphic());
            button_card3.setGraphic(Temps.getGraphic());
        });

        button_card4.setOnAction(e->{
            Button Temps = new Button();
            Temps.setText(button_center.getText());
            Temps.setGraphic(button_center.getGraphic());
            button_center.setGraphic(button_card4.getGraphic());
            button_card4.setGraphic(Temps.getGraphic());
        });

        button_card5.setOnAction(e->{
            Button Temps = new Button();
            Temps.setText(button_center.getText());
            Temps.setGraphic(button_center.getGraphic());
            button_center.setGraphic(button_card5.getGraphic());
            button_card5.setGraphic(Temps.getGraphic());
        });
        button_card6.setOnAction(e->{
            Button Temps = new Button();
            Temps.setText(button_center.getText());
            Temps.setGraphic(button_center.getGraphic());
            button_center.setGraphic(button_card6.getGraphic());
            button_card6.setGraphic(Temps.getGraphic());
        });
        button_card7.setOnAction(e->{
            Button Temps = new Button();
            Temps.setText(button_center.getText());
            Temps.setGraphic(button_center.getGraphic());
            button_center.setGraphic(button_card7.getGraphic());
            button_card7.setGraphic(Temps.getGraphic());
        });
        button_card8.setOnAction(e->{
            Button Temps = new Button();
            Temps.setText(button_center.getText());
            Temps.setGraphic(button_center.getGraphic());
            button_center.setGraphic(button_card8.getGraphic());
            button_card8.setGraphic(Temps.getGraphic());
        });
        button_card9.setOnAction(e->{
            Button Temps = new Button();
            Temps.setText(button_center.getText());
            Temps.setGraphic(button_center.getGraphic());
            button_center.setGraphic(button_card9.getGraphic());
            button_card9.setGraphic(Temps.getGraphic());
        });
        button_card10.setOnAction(e->{
            Button Temps = new Button();
            Temps.setText(button_center.getText());
            Temps.setGraphic(button_center.getGraphic());
            button_center.setGraphic(button_card10.getGraphic());
            button_card10.setGraphic(Temps.getGraphic());
        });

        btnPlay.setOnAction(e->{
            if(button_center.getGraphic()!=null){
            btnLeft.setGraphic(button_center.getGraphic());
            button_center.setGraphic(null);}
            else AlertBox.display("Invalide","Please select a card");
        });




        //Set scene and show it
        Scene scene = new Scene(layout);
        board.setScene(scene);
        board.showAndWait();

    }

    //idée pour changer la récurrence de traitement des bouttons
   /* public void PressButton(Button FromThere, Button WhereToGo){
        Button temps = new Button();
        temps.setGraphic(WhereToGo.getGraphic());
        WhereToGo.setGraphic(FromThere.getGraphic());
        FromThere.setGraphic(temps.getGraphic());
        System.out.println(FromThere.getGraphic());
        System.out.println(WhereToGo.getGraphic());
    }*/
}
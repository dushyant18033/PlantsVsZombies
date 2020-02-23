package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.*;
import java.util.HashMap;

public class Main extends Application {

    public static Stage mainStage;
    public static Scene Menu;
    public static Scene LevelSelect;
    public static Scene Help;

    public static User curUser=new User();


    @Override
    public void start(Stage primaryStage) throws Exception
    {
        mainStage=primaryStage; /////DON'T TOUCH THIS
        mainStage.setTitle("PLANTS VS ZOMBIES");

        init_help();
        init_menu();
        init_levelselect();

        //AUDIO FOR ENTIRE GAME
        Media Clip=new Media(new File("E:\\JavaProjects\\PlantsVsZombies\\src\\audio\\gta4_bg.mp3").toURI().toString());//"E:\\Downloads\\CSGO Music Kit - Michael Bross - Invasion.mp3"
        MediaPlayer mp1=new MediaPlayer(Clip);
        mp1.setCycleCount(AudioClip.INDEFINITE); //repeat
        MediaView mv1=new MediaView(mp1);


        //PLAYING INTRO VIDEO
        Media clip=new Media(new File("E:\\JavaProjects\\PlantsVsZombies\\src\\vids\\Intro.mp4").toURI().toString());
        MediaPlayer mp=new MediaPlayer(clip);
        mp.setAutoPlay(true);
        MediaView mv=new MediaView(mp);
        mp.setOnStopped(() -> {
            loadMenu();
            mp1.play();
        }); //On skipping video manually
        mp.setOnEndOfMedia(() -> {
            loadMenu();
            mp1.play();
        }); //On ending video automatically

        //Button to skip video
        Button bt=new Button("");
        bt.setOnKeyPressed(e->
        {
            if(e.getCode().equals(KeyCode.ENTER))
                mp.stop();
        });


        //stackpane containing mediaviews and skipping button
        StackPane sp=new StackPane();
        sp.getChildren().addAll(bt,mv,mv1);

        //Activate the scene
        mainStage.setScene(new Scene(sp,1920,1080));
        mainStage.show();
        mainStage.setFullScreen(true);
    }

    public void loadMenu()
    {
        mainStage.setScene(Menu);
        mainStage.setFullScreen(true);
        mainStage.show();
    }

    public void init_menu() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("mainmenu.fxml"));
        Menu=new Scene(root, 1920, 1080);
    }

    public void init_help() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("help.fxml"));
        Help=new Scene(root,1920,1080);
    }

    public void init_levelselect() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("levelselect.fxml"));
        LevelSelect=new Scene(root,1920,1080);
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}

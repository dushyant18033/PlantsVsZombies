package app;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.effect.Glow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import javax.swing.text.html.ImageView;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController
{
    @FXML
    private TextField username;
    @FXML
    public VBox menuButtons;
    @FXML
    public AnchorPane login;


    public void backtoMenu()
    {
        Main.mainStage.setScene(Main.Menu);
        Main.mainStage.setFullScreen(true);
        Main.mainStage.show();
        closeLoginBox();
    }

    public void loginBox()
    {
        menuButtons.setVisible(false);
        login.setVisible(true);
    }

    public void closeLoginBox()
    {
        menuButtons.setVisible(true);
        login.setVisible(false);
    }

    public void openLevelSelect()
    {
        closeLoginBox();

        String name=username.getText();
        Main.curUser.setUsername(name);

        Main.mainStage.setScene(Main.LevelSelect);
        Main.mainStage.show();
        Main.mainStage.setFullScreen(true);
    }

/*
    public void resume()
    {
        System.out.println("Resume button.");
        Main.mainStage.setScene(Main.LevelSelect);
        Main.mainStage.setFullScreen(true);
        Main.mainStage.show();
    }
*/
    public void help()
    {
        System.out.println("This is help button.");
        Main.mainStage.setScene(Main.Help);
        Main.mainStage.setFullScreen(true);
        Main.mainStage.show();
    }
    public void exit()
    {
        System.out.println("Terminating...");
        System.exit(0);
    }


}

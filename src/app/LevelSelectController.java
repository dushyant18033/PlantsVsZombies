package app;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.Glow;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class LevelSelectController implements Initializable
{
    @FXML
    private AnchorPane levels;

    private void loadLevel(int lev) throws Exception
    {
        if(Main.curUser.getLevelUnlocked()<lev)
            return;

        Parent root = FXMLLoader.load(getClass().getResource("game"+lev+".fxml"));
        Scene game=new Scene(root,1920,1080);
        Main.mainStage.setScene(game);
        Main.mainStage.show();
        Main.mainStage.setFullScreen(true);
    }

    public void loadLevel1() throws Exception
    {
        loadLevel(1);
    }
    public void loadLevel2() throws Exception
    {
        loadLevel(2);
    }
    public void loadLevel3() throws Exception
    {
        loadLevel(3);
    }
    public void loadLevel4() throws Exception
    {
        loadLevel(4);
    }
    public void loadLevel5() throws Exception
    {
        loadLevel(5);
    }

    public void backtoMenu()
    {
        Main.mainStage.setScene(Main.Menu);
        Main.mainStage.setFullScreen(true);
        Main.mainStage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        for(Node node:levels.getChildren())
        {
            node.setOnMouseEntered(e->
            {
                node.setEffect(new Glow(0.5f));
            });
            node.setOnMouseExited(e->
            {
                node.setEffect(null);
            });
        }
    }
}

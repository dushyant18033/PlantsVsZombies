package app;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;


public class GameController5 implements Initializable
{
    @FXML
    private AnchorPane win;
    @FXML
    private AnchorPane lose;

    @FXML
    private ImageView ProgressBar;

    @FXML
    private VBox inGameMenu;
    @FXML
    private AnchorPane lawn;
    @FXML
    private Label time;
    @FXML
    private Label suns;

    @FXML
    private GridPane lawnGrid;
    @FXML
    private VBox plantIcons;

    @FXML
    private ImageView sun1;
    @FXML
    private ImageView sun2;
    @FXML
    private ImageView sun3;

    @FXML
    private ImageView pea1;
    @FXML
    private ImageView pea2;
    @FXML
    private ImageView pea3;
    @FXML
    private ImageView pea4;
    @FXML
    private ImageView pea5;
    @FXML
    private ImageView pea11;
    @FXML
    private ImageView pea21;
    @FXML
    private ImageView pea31;
    @FXML
    private ImageView pea41;
    @FXML
    private ImageView pea51;

    @FXML
    private ImageView zom11;
    @FXML
    private ImageView zom12;
    @FXML
    private ImageView zom21;
    @FXML
    private ImageView zom22;
    @FXML
    private ImageView zom31;
    @FXML
    private ImageView zom32;
    @FXML
    private ImageView zom41;
    @FXML
    private ImageView zom42;
    @FXML
    private ImageView zom51;
    @FXML
    private ImageView zom52;

    @FXML
    private VBox LMs;

    private int zombie_kill_left =10;
    private final int tot_zombies=10;

    public ImageView[][] plantGrid=new ImageView[9][5];
    private Plants[][] myPlants=new Plants[9][5];

    private ImageView[] peas=new ImageView[10];
    private boolean[] peaInUse=new boolean[10];
    private double[] peaLocation=new double[10];
    //private int[] peaInUseRow;

    private ImageView[] zombies;

    public int sunMoney=100;

    private Image peaShooter=new Image(new File("E:\\JavaProjects\\PlantsVsZombies\\src\\imgs\\Peashooter_Idle.gif").toURI().toString());
    //private Image tallNut=new Image(new File("E:\\JavaProjects\\PlantsVsZombies\\src\\imgs\\Tallnut_Idle.gif").toURI().toString());
    private Image potatoMine=new Image(new File("E:\\JavaProjects\\PlantsVsZombies\\src\\imgs\\PotatoMine_Activated.gif").toURI().toString());
    private Image walnut=new Image(new File("E:\\JavaProjects\\PlantsVsZombies\\src\\imgs\\Wallnut_Idle.gif").toURI().toString());
    private Image sunFlower=new Image(new File("E:\\JavaProjects\\PlantsVsZombies\\src\\imgs\\Sunflower_Idle.gif").toURI().toString());

    private Image curPlant=null;
    private int plantCost=0;

    private HashMap<PeaShooter,Integer> peaIndex= new HashMap<>();
    private HashMap<Node,Boolean> LM_Used=new HashMap<>();

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        sunMoney=100;
        final Image lawnMowerActive=new Image(new File("E:\\JavaProjects\\PlantsVsZombies\\src\\imgs\\Lawnmower_Activated.gif").toURI().toString());
        peas[0]=pea1;
        peas[1]=pea11;
        peas[2]=pea2;
        peas[3]=pea21;
        peas[4]=pea3;
        peas[5]=pea31;
        peas[6]=pea4;
        peas[7]=pea41;
        peas[8]=pea5;
        peas[9]=pea51;
        zombies=new ImageView[]{zom11,zom12,zom21,zom22,zom31,zom32,zom41,zom42,zom51,zom52};



        Zombie[] myZombie=new Zombie[10];
        for(int i=0;i<10;i++){
            if(i%2==0)
                myZombie[i]=new Zombie(100,20,0,true,0,0);
            else
                myZombie[i]=new Zombie(150,30,0,true,0,0);
        }


        //peaInUseRow=new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
        suns.setText(Integer.toString(sunMoney));

        ////////////////////////////ZOMBIE /////////////////////////////////////


        TranslateTransition[] trans=new TranslateTransition[10];
        trans[0]=new TranslateTransition();
        trans[0].setDuration(Duration.seconds(270));
        trans[0].setNode(zom11);
        trans[0].setToX(-10000);
        trans[0].setCycleCount(1);
        trans[0].play();


        trans[1]=new TranslateTransition();
        trans[1].setDuration(Duration.seconds(270));
        trans[1].setNode(zom12);
        trans[1].setToX(-10000);
        trans[1].setCycleCount(1);
        trans[1].play();

        trans[2]=new TranslateTransition();
        trans[2].setDuration(Duration.seconds(270));
        trans[2].setNode(zom21);
        trans[2].setToX(-10000);
        trans[2].setCycleCount(1);
        trans[2].play();

        trans[3]=new TranslateTransition();
        trans[3].setDuration(Duration.seconds(270));
        trans[3].setNode(zom22);
        trans[3].setToX(-10000);
        trans[3].setCycleCount(1);
        trans[3].play();

        trans[4]=new TranslateTransition();
        trans[4].setDuration(Duration.seconds(270));
        trans[4].setNode(zom31);
        trans[4].setToX(-10000);
        trans[4].setCycleCount(1);
        trans[4].play();

        trans[5]=new TranslateTransition();
        trans[5].setDuration(Duration.seconds(270));
        trans[5].setNode(zom32);
        trans[5].setToX(-10000);
        trans[5].setCycleCount(1);
        trans[5].play();


        trans[6]=new TranslateTransition();
        trans[6].setDuration(Duration.seconds(270));
        trans[6].setNode(zom41);
        trans[6].setToX(-10000);
        trans[6].setCycleCount(1);
        trans[6].play();

        trans[7]=new TranslateTransition();
        trans[7].setDuration(Duration.seconds(270));
        trans[7].setNode(zom42);
        trans[7].setToX(-10000);
        trans[7].setCycleCount(1);
        trans[7].play();

        trans[8]=new TranslateTransition();
        trans[8].setDuration(Duration.seconds(270));
        trans[8].setNode(zom51);
        trans[8].setToX(-10000);
        trans[8].setCycleCount(1);
        trans[8].play();

        trans[9]=new TranslateTransition();
        trans[9].setDuration(Duration.seconds(270));
        trans[9].setNode(zom52);
        trans[9].setToX(-10000);
        trans[9].setCycleCount(1);
        trans[9].play();



        //////////////////////////////////////////////////////////////////////////////



        final long[] initial = {0};
        final boolean[] begun = {false};

        final long[] lastPeaShot={0};
        final long[] lastCheck={0};
        final long[] plantTimer={0};

        final int[] plantAvailable=new int[]{0,0,0,0};    //pea,sun,wal,pot


        AnimationTimer at=new AnimationTimer() {
            @Override
            public void handle(long now)
            {
                if(!begun[0])
                {
                    initial[0] =now;
                    begun[0] =true;
                }

                if((now-lastPeaShot[0])/1000000000>5)   //PeaShooting
                {
                    for(int i=0; i<10; i++)
                    {
                        if(peaInUse[i])
                        {
                            peas[i].setTranslateX(0);
                            peas[i].setVisible(true);
                            TranslateTransition trans=new TranslateTransition();
                            trans.setDuration(Duration.seconds(10));
                            trans.setNode(peas[i]);
                            trans.setToX(1500);
                            trans.setCycleCount(1);
                            trans.play();
                        }
                    }
                    lastPeaShot[0]=now;
                }

                if((now - plantTimer[0])/1000000000 >=1) //Plant timer
                {
                    for(int i=0; i<4; i++)
                    {
                        if(plantAvailable[i]>0)
                            plantAvailable[i]--;
                        else{
                            if(i==0)
                                plantIcons.getChildren().get(1).setOpacity(1.0);
                            else if(i==1)
                                plantIcons.getChildren().get(0).setOpacity(1.0);
                            else if(i==2)
                                plantIcons.getChildren().get(3).setOpacity(1.0);
                            else
                                plantIcons.getChildren().get(2).setOpacity(1.0);
                        }
                    }
                    plantTimer[0]=now;
                }

                if((now-lastCheck[0])/1000000 >= 1) //Collisions Handling
                {
                    double prog=(1 - ((double) zombie_kill_left /tot_zombies));
                    ProgressBar.setTranslateX(245 * prog);
                    ProgressBar.setScaleX(prog);

                    /////////PEA-ZOMBIE COLLISION/////////////////////
                    for(int i=0;i<10;i++) {
                        for (int j = 0; j < 10; j++) {

                            double x_p = peas[i].getLayoutX();
                            double x_z = zombies[j].getLayoutX();
                            double del_x_p = peas[i].getTranslateX();
                            double del_x_z = zombies[j].getTranslateX();
                            double y_p = peas[i].getLayoutY();
                            double y_z = zombies[j].getLayoutY();

                            boolean checkY = Math.abs(y_p - y_z) < 90;
                            double diffX = (x_z + del_x_z) - (x_p + del_x_p);
                            boolean checkX = diffX > 0 && diffX < 15;

                            //System.out.print(peas[i].getLayoutX()-zombies[i].getLayoutX());
                            if (checkX && checkY) {
                                peas[i].setVisible(false);
                                myZombie[j].setHP(myZombie[j].getHP()-10);
                                if(myZombie[j].getHP()<0) {
                                    zombies[j].setTranslateX(0);
                                    myZombie[j].setHP(100);
                                    zombie_kill_left--;
                                }
                                //System.out.println("Collide "+i+" "+j);
                            }
                        }
                    }

                    ////////PLANT-ZOMBIE COLLISION////////////////////
                    for(int i=0; i<9; i++) {
                        for (int j = 0; j < 5; j++) {
                            for (int k = 0; k < 10; k++) {
                                if (plantGrid[i][j].getImage() != null && myPlants[i][j]!=null && zombies[k]!=null) {
                                    double x_p = plantGrid[i][j].getLayoutX() + lawnGrid.getLayoutX();
                                    double x_z = zombies[k].getLayoutX();

                                    double del_x_z = zombies[k].getTranslateX();

                                    double y_p = plantGrid[i][j].getLayoutY() + lawnGrid.getLayoutY();
                                    double y_z = zombies[k].getLayoutY();

                                    boolean checkY = Math.abs(y_p - y_z) < 100;

                                    double diffX = x_z + del_x_z - x_p;

                                    boolean checkX = diffX > 0 && diffX < 10;

                                    if (checkX && checkY) {
                                        myPlants[i][j].setHP(myPlants[i][j].getHP()-4);
                                        trans[k].pause();
                                        if(myPlants[i][j] instanceof potatoMine){
                                            myPlants[i][j]=null;
                                            plantGrid[i][j].setImage(null);
                                            zombie_kill_left--;
                                            trans[k].stop();
                                            zombies[k].setTranslateX(0);
                                        }

                                        if(myPlants[i][j].getHP()<0){
                                            plantGrid[i][j].setImage(null);
                                            if(myPlants[i][j] instanceof PeaShooter)
                                            {
                                                int ind = peaIndex.get((PeaShooter) myPlants[i][j]);
                                                peaInUse[ind]=false;
                                                peas[ind].setVisible(false);
                                            }
                                            myPlants[i][j]=null;
                                            trans[k].play();

                                        }

                                    }
                                }
                            }
                        }
                    }

                    ////////LAWNMOWER-ZOMBIE COLLISION////////////////
                    for(Node node:LMs.getChildren())
                    {
                        LM_Used.put(node,false);
                    }
                    for(Node node:LMs.getChildren())
                    {
                        double x_lm=node.getLayoutX()+LMs.getLayoutX();
                        double del_x_lm=node.getTranslateX();
                        double y_lm=node.getLayoutY()+LMs.getLayoutY();

                        for(int i=0; i<10; i++)
                        {
                            double x_z = zombies[i].getLayoutX();
                            double del_x_z = zombies[i].getTranslateX();
                            double y_z = zombies[i].getLayoutY();


                            boolean checkY = Math.abs(y_lm - y_z) < 100;
                            double diffX = x_z + del_x_z - x_lm - del_x_lm;

                            boolean checkX1=diffX>0 && diffX<100;
                            boolean checkX2=diffX>0 && diffX<50;

                            if(checkY && (!LM_Used.get(node)))
                            {
                                if(checkX1)
                                {
                                    ImageView LMcur=((ImageView)node);
                                    LMcur.setImage(lawnMowerActive);
                                    TranslateTransition t = new TranslateTransition();
                                    t.setDuration(Duration.seconds(5));
                                    t.setNode(node);
                                    t.setToX(1300);
                                    t.setCycleCount(1);
                                    t.play();
                                    LM_Used.replace(node,false,true);
                                    t.setOnFinished(e->
                                    {
                                        //LMcur.setVisible(false);
                                        LMcur.setTranslateX(-100000);
                                    });
                                }

                                if(checkX2)
                                {
                                    trans[i].stop();
                                    zombies[i].setTranslateX(0);
                                    zombie_kill_left--;
                                    myZombie[i].setHP(100);
                                }
                            }

                        }
                    }


                    /////ZOMBIE Reaches House//////
                    for(int i=0; i<10; i++)
                    {
                        double x=zombies[i].getTranslateX()+zombies[i].getLayoutX();
                        if(x<=100)
                        {
                            lose.setVisible(true);
                        }
                    }

                    if(zombie_kill_left ==0)
                    {
                        win.setVisible(true);
                    }
                    //System.out.print("Win");

                    lastCheck[0]=now;
                }

                time.setText("Time: "+(now - initial[0])/1000000000);


            }
        };
        at.start();


        int i=0,j=0;

        for(Node node : lawnGrid.getChildren())
        {
            plantGrid[i][j]=(ImageView)node;

            node.setOnMouseClicked(e->
            {
                ImageView img=(ImageView)e.getSource();
                /*int i=0,j=0;
                if(GridPane.getColumnIndex(rect)!=null)
                    i=GridPane.getColumnIndex(rect);
                if(GridPane.getRowIndex(rect)!=null)
                    j=GridPane.getRowIndex(rect);

                double gridWidth=lawnGrid.getWidth()/9.0;
                double gridHeight=lawnGrid.getHeight()/5.0;
                double gridX=lawnGrid.getLayoutX();
                double gridY=lawnGrid.getLayoutY();
                double x=gridX + gridWidth*i;
                double y=gridY + gridHeight*j;

                test.setLayoutX(x);
                test.setLayoutY(y);*/

                boolean isPlantAvail=false;
                if(curPlant!=null)
                {
                    if(curPlant==peaShooter)
                        isPlantAvail=(plantAvailable[0]==0);
                    else if(curPlant==sunFlower)
                        isPlantAvail=(plantAvailable[1]==0);
                    else if(curPlant==walnut)
                        isPlantAvail=(plantAvailable[2]==0);
                    else
                        isPlantAvail=(plantAvailable[3]==0);
                }
                if(curPlant !=null && plantCost<=sunMoney && isPlantAvail)
                {
                    img.setImage(curPlant);
                    sunMoney-=plantCost;
                    plantCost=0;
                    suns.setText(Integer.toString(sunMoney));
                    int p=0,q=0;
                    if(GridPane.getColumnIndex(img)!=null)
                        p=GridPane.getColumnIndex(img);
                    if(GridPane.getRowIndex(img)!=null)
                        q=GridPane.getRowIndex(img);
                    if(curPlant==peaShooter)
                    {
                        myPlants[p][q]=new PeaShooter(100,5,100,0,0,false,0,0);
                        plantAvailable[0]=5;
                        plantIcons.getChildren().get(1).setOpacity(0.5);
                        double x=img.getLayoutX()+lawnGrid.getLayoutX();
                        double y=img.getLayoutY()+lawnGrid.getLayoutY();
                        //System.out.println(x+" "+y);
                        ImageView peaToUse=null;
                        for(int a=0; a<10; a++)
                        {
                            if(!peaInUse[a])
                            {
                                peaToUse=peas[a];
                                peaInUse[a]=true;
                                /*peaInUseRow[a]=GridPane.getRowIndex(img);
                                System.out.println(peaInUseRow[a]);*/
                                peaLocation[a]=x+50;
                                peaIndex.put((PeaShooter) myPlants[p][q],a);
                                break;
                            }
                        }
                        //System.out.println(peaToUse);
                        if(peaToUse!=null)
                        {
                            peaToUse.setLayoutX(x+50);
                            peaToUse.setLayoutY(y+25);
                        }
                    }
                    else if(curPlant==sunFlower){
                        myPlants[p][q]=new Sunflower(100,5,100,0,0,false,0,0);
                        plantAvailable[1]=5;
                        plantIcons.getChildren().get(0).setOpacity(0.5);
                    }
                    else if(curPlant==walnut){
                        myPlants[p][q]=new Walnut(100,5,1000,0,0,false,0,0);
                        plantAvailable[2]=5;
                        plantIcons.getChildren().get(3).setOpacity(0.5);
                    }
                    else {
                        myPlants[p][q] = new potatoMine(25, 5, 100, 0, 0, false, 0, 0);
                        plantAvailable[3]=5;
                        plantIcons.getChildren().get(2).setOpacity(0.5);
                    }
                    curPlant =null;
                }
            });
            node.setOnMouseEntered(e->
            {
                node.setEffect(new Glow(0.5f));
            });
            node.setOnMouseExited(e->
            {
                node.setEffect(null);
            });

            i++;
            if(i>=9)
            {
                i=0;
                j++;
            }
        }

        for(Node node : plantIcons.getChildren())
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

        Timeline t1=new Timeline();
        t1.setCycleCount(1);
        t1.getKeyFrames().add(new KeyFrame(Duration.seconds(5), new KeyValue(sun1.translateYProperty(),750+250*Math.random())));
        t1.setDelay(Duration.seconds(Math.random()*5 + 5));
        t1.play();
        sun1.setOnMouseClicked(e->
        {
            ImageView sun123=(ImageView)e.getSource();
            t1.stop();
            t1.setDelay(Duration.seconds(Math.random()*5 + 5));
            sun123.setTranslateY(0);
            t1.play();
            sunMoney+=25;
            suns.setText(Integer.toString(sunMoney));
        });

        Timeline t2=new Timeline();
        t2.setCycleCount(1);
        t2.getKeyFrames().add(new KeyFrame(Duration.seconds(5), new KeyValue(sun2.translateYProperty(),750+250*Math.random())));
        t2.setDelay(Duration.seconds(Math.random()*5 + 5));
        t2.play();
        sun2.setOnMouseClicked(e->
        {
            ImageView sun123=(ImageView)e.getSource();
            t2.stop();
            t2.setDelay(Duration.seconds(Math.random()*5 + 5));
            sun123.setTranslateY(0);
            t2.play();
            sunMoney+=25;
            suns.setText(Integer.toString(sunMoney));
        });

        Timeline t3=new Timeline();
        t3.setCycleCount(1);
        t3.getKeyFrames().add(new KeyFrame(Duration.seconds(5), new KeyValue(sun3.translateYProperty(),750+250*Math.random())));
        t3.setDelay(Duration.seconds(Math.random()*5 + 5));
        t3.play();
        sun3.setOnMouseClicked(e->
        {
            ImageView sun123=(ImageView)e.getSource();
            t3.stop();
            t3.setDelay(Duration.seconds(Math.random()*5 + 5));
            sun123.setTranslateY(0);
            t3.play();
            sunMoney+=25;
            suns.setText(Integer.toString(sunMoney));
        });

/*
        TranslateTransition trans1=new TranslateTransition();
        trans1.setDuration(Duration.seconds(8));
        trans1.setNode(sun1);
        trans1.setToY(1000);
        trans1.setCycleCount(1);

        TranslateTransition trans2=new TranslateTransition();
        trans2.setDuration(Duration.seconds(7));
        trans2.setNode(sun2);
        trans2.setToY(1000);
        trans2.setCycleCount(1);

        TranslateTransition trans3=new TranslateTransition();
        trans3.setDuration(Duration.seconds(5));
        trans3.setNode(sun3);
        trans3.setToY(1000);
        trans3.setCycleCount(1);

        PauseTransition sec2=new PauseTransition(Duration.seconds(2));
        PauseTransition sec3=new PauseTransition(Duration.seconds(3));
        PauseTransition sec5=new PauseTransition(Duration.seconds(5));

        SequentialTransition sq1=new SequentialTransition(trans1,sec2);
        sq1.setCycleCount(SequentialTransition.INDEFINITE);
        sq1.play();

        SequentialTransition sq2=new SequentialTransition(trans2,sec3);
        sq2.setCycleCount(SequentialTransition.INDEFINITE);
        sq2.play();

        SequentialTransition sq3=new SequentialTransition(trans3,sec5);
        sq3.setCycleCount(SequentialTransition.INDEFINITE);
        sq3.play();

        sun1.setOnMouseClicked(e->
        {
            ImageView sun123=(ImageView)e.getSource();
            sunMoney+=25;
            suns.setText(Integer.toString(sunMoney));

            sq1.pause();
            sun123.setLayoutY(0);
            sq1.playFrom(Duration.ZERO);

        });
        sun2.setOnMouseClicked(e->
        {
            ImageView sun123=(ImageView)e.getSource();
            sunMoney+=25;
            suns.setText(Integer.toString(sunMoney));
            sq2.playFrom(Duration.ZERO);
        });
        sun3.setOnMouseClicked(e->
        {
            ImageView sun123=(ImageView)e.getSource();
            sunMoney+=25;
            suns.setText(Integer.toString(sunMoney));
            sq3.playFrom(Duration.ZERO);
        });*/
    }

    public void printImgViews()
    {
        for(int i=0; i<9; i++)
        {
            for (int j = 0; j < 5; j++)
                System.out.print(plantGrid[i][j] + " ");

            System.out.print("\n");
        }
    }



    public void exit()
    {
        System.out.println("Terminating...");
        System.exit(0);
    }
    public void backToMenu()
    {
        Main.mainStage.setScene(Main.Menu);
        Main.mainStage.setFullScreen(true);
        Main.mainStage.show();
    }

    public void pause()
    {
        inGameMenu.setVisible(true);
        lawn.setOpacity(0.5);
    }

    public void unPause()
    {
        inGameMenu.setVisible(false);
        lawn.setOpacity(1);
    }

    public void selectPeaS()
    {
        curPlant =peaShooter;
        plantCost=100;
    }
    public void selectMine()
    {
        curPlant = potatoMine;
        plantCost=25;
    }
    public void selectSunF()
    {
        curPlant =sunFlower;
        plantCost=50;
    }
    public void selectWalnut()
    {
        curPlant =walnut;
        plantCost=50;
    }
    public void restart() throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("game5.fxml"));
        Scene game=new Scene(root,1920,1080);
        Main.mainStage.setScene(game);
        Main.mainStage.show();
        Main.mainStage.setFullScreen(true);
    }

    public void conti() throws Exception
    {
        Main.mainStage.setScene(Main.Menu);
        Main.mainStage.setFullScreen(true);
        Main.mainStage.show();
    }
}

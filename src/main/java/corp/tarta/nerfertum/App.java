package corp.tarta.nerfertum;

import corp.tarta.nerfertum.View.GridView;
import corp.tarta.nerfertum.View.ViewPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 *  Main Class
 *  Nefertum App
 *
 *  Uso del patron Singleton
 */
public class App extends Application {

    public static String APP_NAME = "NERFERTUM";

    private static App instance = null;

    private Stage mainStage = null;

    public App(){
        instance = this;
    }

    public App getInstance(){
        return  instance;
    }

    public static void main( String[] args )
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.mainStage = primaryStage;
        configStage();
        goToMain();
    }

    public void configStage(){
        MainPane mainPane = MainPane.getInstance();
        Scene mainScene = new Scene(mainPane);
        this.mainStage.setScene(mainScene);
        this.mainStage.setTitle(this.APP_NAME);
        this.mainStage.initStyle(StageStyle.DECORATED);
        this.mainStage.setMaximized(true);
        this.mainStage.setResizable(true);
    }

    public void goToMain(){
        this.mainStage.show();
    }
}

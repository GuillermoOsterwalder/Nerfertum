package corp.tarta.nerfertum.Controls;

import corp.tarta.nerfertum.View.GridView;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

/**
 * Created by Tarta on 30/06/2017.
 */
public class WelcomePane extends GridView {

    private Label title;

    public WelcomePane(){
        super(12,17);
        this.getStylesheets().remove(ComponentStyleElements.DEFAULT_STYLESHEET.getPath());
        this.getStylesheets().add(ComponentStyleElements.WELCOME_STYLESHEET.getPath());
        this.getStyleClass().add(ComponentStyleElements.WELCOME_CLASS.getPath());
        inicThings();

    }

    private void inicThings() {
        title = new Label("Bienvenido al sistema de gestión de la perfumería");
        title.getStyleClass().add("title");
        title.setFont(Font.font ("Verdana", 22));
        addChild(title,0,3,10,1);
    }


}
package corp.tarta.nerfertum.Controls;

import corp.tarta.nerfertum.View.GridView;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

/**
 * Created by Tarta on 26/06/2017.
 */
public class HeaderPane extends GridView{

    private Label title;
    private Label description;

    public HeaderPane(){
        super(12,3);
        this.getStylesheets().remove(ComponentStyleElements.DEFAULT_STYLESHEET.getPath());
        this.getStylesheets().add(ComponentStyleElements.HEADER_STYLESHEET.getPath());
        this.getStyleClass().add(ComponentStyleElements.HEADER_CLASS.getPath());
        inicThings();

    }

    private void inicThings(){
        inicTitle();
    }

    private void inicTitle(){
        title = new Label("Perfumería NOELIA");
        title.getStyleClass().add("title");
        title.setFont(Font.font ("Verdana", 20));
        addChild(title,2,1,8,1);

        description = new Label("Sistema de gestión");
        description.getStyleClass().add("text");
        addChild(description, 2,2,8,1);
    }

}

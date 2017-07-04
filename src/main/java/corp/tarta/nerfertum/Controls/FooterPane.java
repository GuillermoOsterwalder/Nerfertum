package corp.tarta.nerfertum.Controls;

import corp.tarta.nerfertum.View.GridView;
import javafx.scene.control.Label;

/**
 * Created by Tarta on 27/06/2017.
 */
public class FooterPane extends GridView {

    private Label footer;

    public FooterPane(){
        super(1,1);
        this.getStylesheets().remove(ComponentStyleElements.DEFAULT_STYLESHEET.getPath());
        this.getStylesheets().add(ComponentStyleElements.FOOTER_STYLESHEET.getPath());
        this.getStyleClass().add(ComponentStyleElements.FOOTER_CLASS.getPath());
        inicThings();

    }

    private void inicThings() {
        footer = new Label("Developed by TartaCorp");
        footer.getStyleClass().add("text");
        addChild(footer, 0,0,20,1);
    }
}

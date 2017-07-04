package corp.tarta.nerfertum.Controls;

import corp.tarta.nerfertum.View.GridView;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

/**
 * Created by Tarta on 30/06/2017.
 */
public class ProviderPane extends GridView {

    private Label title;

    public ProviderPane(){
        super(12,17);
        this.getStylesheets().remove(ComponentStyleElements.DEFAULT_STYLESHEET.getPath());
        this.getStylesheets().add(ComponentStyleElements.PROVIDER_STYLESHEET.getPath());
        this.getStyleClass().add(ComponentStyleElements.PROVIDER_CLASS.getPath());
        inicThings();

    }

    private void inicThings() {
        title = new Label("ACA VAN LOS PROVEEDORES");
        title.getStyleClass().add("title");
        title.setFont(Font.font ("Verdana", 20));
        addChild(title,2,1,8,1);
    }
}

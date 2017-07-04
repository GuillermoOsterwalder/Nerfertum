package corp.tarta.nerfertum.Controls;

import corp.tarta.nerfertum.View.GridView;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

/**
 * Created by Tarta on 30/06/2017.
 */
public class StockPane extends GridView {

    private Label title;

    public StockPane(){
        super(12,17);
        this.getStylesheets().remove(ComponentStyleElements.DEFAULT_STYLESHEET.getPath());
        this.getStylesheets().add(ComponentStyleElements.STOCK_STYLESHEET.getPath());
        this.getStyleClass().add(ComponentStyleElements.STOCK_CLASS.getPath());
        inicThings();

    }

    private void inicThings() {
        title = new Label("ACA VA EL STOCK");
        title.getStyleClass().add("title");
        title.setFont(Font.font ("Verdana", 20));
        addChild(title,2,1,8,1);
    }


}

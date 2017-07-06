package corp.tarta.nerfertum.Controls;

import corp.tarta.nerfertum.MainPane;
import corp.tarta.nerfertum.View.GridView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

/**
 * Created by Tarta on 27/06/2017.
 */
public class NavBarPane extends GridView {

    private Button sellButton;
    private Button stockButton;
    private Button clientButton;
    private Button providerButton;
    private Label navBarBackground;


    public NavBarPane(){
        super(1,18);
        this.getStylesheets().remove(ComponentStyleElements.DEFAULT_STYLESHEET.getPath());
        this.getStylesheets().add(ComponentStyleElements.NAVBAR_STYLESHEET.getPath());
        this.getStyleClass().add(ComponentStyleElements.NAVBAR_CLASS.getPath());
        inicThings();


    }

    private void inicThings() {
        inicBackground();
        inicButtons();
    }

    private void inicBackground() {
        navBarBackground = new Label();
        navBarBackground.getStyleClass().add("pane");
        addChild(navBarBackground,0,0,2,18);

    }

    private void inicButtons() {
        sellButton = new Button("Vender/Comprar");
        sellButton.getStyleClass().add("boton");
        sellButton.setFont(Font.font ("Verdana", 11));
        addChild(sellButton,0,1,1,1);
        sellButton.setOnAction(e -> MainPane.getInstance().toSellView());
        //sellButton.setOnAction(e -> App);


        stockButton = new Button("Stock");
        stockButton.getStyleClass().add("boton");
        stockButton.setFont(Font.font ("Verdana", 15));
        addChild(stockButton,0,3,1,1);
        stockButton.setOnAction(e -> MainPane.getInstance().toStockView());

        clientButton = new Button("Clientes");
        clientButton.getStyleClass().add("boton");
        clientButton.setFont(Font.font ("Verdana", 15));
        addChild(clientButton,0,5,1,1);
        clientButton.setOnAction(e -> MainPane.getInstance().toClientView());

        providerButton = new Button("Proveedores");
        providerButton.getStyleClass().add("boton");
        providerButton.setFont(Font.font ("Verdana", 13));
        addChild(providerButton,0,7,1,1);
        providerButton.setOnAction(e -> MainPane.getInstance().toProviderView());

    }
}

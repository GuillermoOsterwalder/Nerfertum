package corp.tarta.nerfertum.Controls;

import corp.tarta.nerfertum.MainPane;
import corp.tarta.nerfertum.View.GridView;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

/**
 * Created by Tarta on 05/07/2017.
 */
public class StockDialogPane extends GridView{

    private Label title;
    private Button cancel;
    private Button save;

    public StockDialogPane(){
        super(12,17);
        this.getStylesheets().remove(ComponentStyleElements.DEFAULT_STYLESHEET.getPath());
        this.getStylesheets().add(ComponentStyleElements.STOCKDIALOG_STYLESHEET.getPath());
        this.getStyleClass().add(ComponentStyleElements.STOCKDIALOG_CLASS.getPath());
        inicThings();
        inicStockView();

    }

    private void inicThings() {
        title = new Label("Carga de productos");
        title.getStyleClass().add("title");
        title.setFont(Font.font ("Verdana", 24));
        addChild(title,4,1,8,1);

        cancel = new Button("Cancelar");
        cancel.getStyleClass().add("boton");
        cancel.setFont(Font.font("Verdana", 16));
        addChild(cancel, 7, 8, 2, 1);
        cancel.setOnAction(e -> MainPane.getInstance().toStockView());

        save = new Button("Cargar");
        save.getStyleClass().add("boton");
        save.setFont(Font.font("Verdana", 16));
        addChild(save, 7, 6, 2, 1);
    }

    private void inicStockView(){

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        Label productIdLabel = new Label("Codigo del producto:");
        productIdLabel.setFont(Font.font("Verdana", 16));
        addChild(productIdLabel, 1, 5, 2, 1);


        final RestrictiveTextField productId = new IntField(9999999999999l,13);
        productId.setPromptText("Ingrese el código del producto");
        productId.setPrefColumnCount(10);
        productId.getText();
        GridPane.setConstraints(productId, 0, 0);
        grid.getChildren().add(productId);
        addChild(productId,1,6,2,1);

        Label productNameLabel = new Label("Nombre del producto:");
        productNameLabel.setFont(Font.font("Verdana", 16));
        addChild(productNameLabel, 1, 8, 2, 1);

        final RestrictiveTextField productName = new StringField(50);
        productName.setPromptText("Ingrese nombre del producto");
        productName.setPrefColumnCount(10);
        productName.getText();
        GridPane.setConstraints(productName, 0, 0);
        grid.getChildren().add(productName);
        addChild(productName,1,9,2,1);

        Label productDescriptionLabel = new Label("Descripción del producto:");
        productDescriptionLabel.setFont(Font.font("Verdana", 16));
        addChild(productDescriptionLabel, 1, 11, 2, 1);

        final RestrictiveTextField productDescription = new StringField(150);
        productDescription.setPromptText("Ingrese la descripcioón del producto");
        productDescription.setPrefColumnCount(10);
        productDescription.getText();
        GridPane.setConstraints(productDescription, 0, 0);
        grid.getChildren().add(productDescription);
        addChild(productDescription,1,12,2,1);

        Label productCantLabel = new Label("Cantidad del producto:");
        productCantLabel.setFont(Font.font("Verdana", 16));
        addChild(productCantLabel, 4, 5, 2, 1);

        final RestrictiveTextField productCant = new IntField(9999l,4);
        productCant.setPromptText("Ingrese la cantidad del producto");
        productCant.setPrefColumnCount(10);
        productCant.getText();
        GridPane.setConstraints(productCant, 0, 0);
        grid.getChildren().add(productCant);
        addChild(productCant,4,6,2,1);

        Label productCcostPriceLabel = new Label("Coste del producto:");
        productCcostPriceLabel.setFont(Font.font("Verdana", 16));
        addChild(productCcostPriceLabel, 4, 8, 2, 1);

        final RestrictiveTextField productCostPrice = new FloatField(999999.99f,9);
        productCostPrice.setPromptText("Ingrese el valor de costo del producto");
        productCostPrice.setPrefColumnCount(10);
        productCostPrice.getText();
        GridPane.setConstraints(productCostPrice, 0, 0);
        grid.getChildren().add(productCostPrice);
        addChild(productCostPrice,4,9,2,1);

        Label productPriceLabel = new Label("Precio al público:");
        productPriceLabel.setFont(Font.font("Verdana", 16));
        addChild(productPriceLabel, 4, 11, 2, 1);

        final RestrictiveTextField productPrice = new FloatField(999999.99f,9);
        productPrice.setPromptText("Ingrese el valor de costo  al cliente del producto");
        productPrice.setPrefColumnCount(10);
        productPrice.getText();
        GridPane.setConstraints(productPrice, 0, 0);
        grid.getChildren().add(productPrice);
        addChild(productPrice,4,12,2,1);


    }

}

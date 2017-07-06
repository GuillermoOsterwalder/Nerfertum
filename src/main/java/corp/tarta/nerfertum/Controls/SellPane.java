package corp.tarta.nerfertum.Controls;

import corp.tarta.nerfertum.View.GridView;

import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.scene.control.*;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

/**
 * Created by Tarta on 05/07/2017.
 */
public class SellPane extends GridView {

    private Label title;

    public SellPane(){
        super(12,16);
        this.getStylesheets().remove(ComponentStyleElements.DEFAULT_STYLESHEET.getPath());
        this.getStylesheets().add(ComponentStyleElements.SELL_STYLESHEET.getPath());
        this.getStyleClass().add(ComponentStyleElements.SELL_CLASS.getPath());
        InicThings();



    }

    private void InicThings() {
        title = new Label("Venta");
        title.getStyleClass().add("title");
        title.setFont(Font.font ("Verdana", 20));
        addChild(title,5,0,3,1);

        InicSellPanel();

        InicSellView();

        InicSellButton();


    }

    private void InicSellButton() {

        Button sellButton = new Button("Realizar Compra");
        sellButton.setFont(Font.font ("Verdana", 16));
        addChild(sellButton,5,14,2,1);

        Button cancelButton = new Button("Cancelar");
        cancelButton.setFont(Font.font ("Verdana", 16));
        addChild(cancelButton,8,14,2,1);

    }

    public void InicSellPanel(){
        //Creating a GridPane container
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);
        //Defining the Product text field
        final RestrictiveTextField product = new IntField(9999999999999l,13);
        product.setPromptText("Ingrese Código del Producto");
        product.setPrefColumnCount(10);
        product.getText();
        GridPane.setConstraints(product, 0, 0);
        grid.getChildren().add(product);
        addChild(product,1,2,2,1);

        final RestrictiveTextField cant = new IntField(10000l,5);
        cant.setPromptText("Ingrese Cantidad");
        cant.setPrefColumnCount(10);
        cant.getText();
        GridPane.setConstraints(cant, 0, 0);
        grid.getChildren().add(cant);
        addChild(cant,1,3,2,1);

        //Defining the Submit button
        Button addProdButton = new Button("Agregar Producto");
        addProdButton.setFont(Font.font ("Verdana", 16));
        GridPane.setConstraints(addProdButton, 1, 0);
        grid.getChildren().add(addProdButton);
        addChild(addProdButton,1,5,2,1);
        //Defining the Clear button
        Button clearButton = new Button("Limpiar Campos");
        clearButton.setFont(Font.font ("Verdana", 16));
        GridPane.setConstraints(clearButton, 1, 1);
        grid.getChildren().add(clearButton);
        addChild(clearButton,1,6,2,1);

    }

    public void InicSellView(){

        TableView<SellPane> tableView = new TableView();
        TableColumn<SellPane, StringProperty> colCod = new TableColumn<>("Código");
        TableColumn<SellPane, StringProperty> colProduct = new TableColumn<>("Producto");
        TableColumn<SellPane, StringProperty> colCant = new TableColumn<>("Cantidad");
        TableColumn<SellPane, StringProperty> colPrice = new TableColumn<>("Precio");
        TableColumn<SellPane, StringProperty> colTotal = new TableColumn<>("Total");
        tableView.getColumns().addAll(colCod, colProduct, colCant, colPrice, colTotal);

        colCod.setCellValueFactory(new PropertyValueFactory<>("cod"));
        colProduct.setCellValueFactory(new PropertyValueFactory<>("product"));
        colCant.setCellValueFactory(new PropertyValueFactory<>("cant"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));

        addChild(tableView,4,2,7,11);

        final RestrictiveTextField subtotal = new IntField(100l,3);
        subtotal.setPromptText("Descuento: % ");
        addChild(subtotal, 1, 11, 1, 1);

        Label subtotalViewLabel = new Label("Subtotal:");
        subtotalViewLabel.setFont(Font.font ("Verdana", 20));
        addChild(subtotalViewLabel, 1, 9, 1, 1);

        Label subtotalViewNum = new Label("000000");
        subtotalViewNum.setFont(Font.font ("Verdana", 20));
        addChild(subtotalViewNum, 2, 9, 1, 1);

        Label totalViewLabel = new Label("Total:");
        totalViewLabel.setFont(Font.font ("Verdana", 20));
        addChild(totalViewLabel, 1, 13, 1, 1);

        Label totalViewNum = new Label("000000");
        totalViewNum.setFont(Font.font ("Verdana", 20));
        addChild(totalViewNum, 2, 13, 1, 1);


    }


}

package corp.tarta.nerfertum.Controls;

import corp.tarta.nerfertum.MainPane;
import corp.tarta.nerfertum.View.GridView;
import javafx.beans.property.StringProperty;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Font;


/**
 * Created by Tarta on 30/06/2017.
 */
public class StockPane extends GridView {

    private Label title;
    private Button modifyStockButton;
    private Button deleteStockButton;
    private Button addStockButton;


    public StockPane(){
        super(12,17);
        this.getStylesheets().remove(ComponentStyleElements.DEFAULT_STYLESHEET.getPath());
        this.getStylesheets().add(ComponentStyleElements.STOCK_STYLESHEET.getPath());
        this.getStyleClass().add(ComponentStyleElements.STOCK_CLASS.getPath());
        inicThings();
        inicButtons();

    }

    private void inicThings() {
        title = new Label("Gestion del Stock");
        title.getStyleClass().add("title");
        title.setFont(Font.font ("Verdana", 20));
        addChild(title,5,0,3,1);

        TableView<StockPane> tableView = new TableView();
        TableColumn<StockPane, StringProperty> colCodigo = new TableColumn<>("Codigo");
        TableColumn<StockPane, StringProperty> colNombre = new TableColumn<>("Nombre");
        TableColumn<StockPane, StringProperty> colDescripcion = new TableColumn<>("Descripción");
        TableColumn<StockPane, StringProperty> colCosto = new TableColumn<>("Precio de Costo");
        TableColumn<StockPane, StringProperty> colPublico = new TableColumn<>("Precio al Publico");
        TableColumn<StockPane, StringProperty> colGanancia = new TableColumn<>("Ganancia");
        tableView.getColumns().addAll(colCodigo, colNombre, colDescripcion, colCosto, colPublico, colGanancia);

        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        colCosto.setCellValueFactory(new PropertyValueFactory<>("precio de costo"));
        colPublico.setCellValueFactory(new PropertyValueFactory<>("precio al publico"));
        colGanancia.setCellValueFactory(new PropertyValueFactory<>("ganancia"));

        addChild(tableView,1,2,10,11);

    }

    private void inicButtons() {

        modifyStockButton = new Button("Actualizar");
        modifyStockButton.getStyleClass().add("boton");
        modifyStockButton.setFont(Font.font("Verdana", 16));
        addChild(modifyStockButton, 8, 14, 2, 1);

        deleteStockButton = new Button("Borrar");
        deleteStockButton.getStyleClass().add("boton");
        deleteStockButton.setFont(Font.font("Verdana", 16));
        addChild(deleteStockButton, 5, 14, 2,1);

        addStockButton = new Button("Agregar");
        addStockButton.getStyleClass().add("boton");
        addStockButton.setFont(Font.font("Verdana", 16));
        addChild(addStockButton, 2, 14, 2,1);
        addStockButton.setOnAction(event -> MainPane.getInstance().toStockDialog());

    }



}

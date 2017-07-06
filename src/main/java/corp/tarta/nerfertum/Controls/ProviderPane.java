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
public class ProviderPane extends GridView {

    private Label title;
    private Button modifyProviderButton;
    private Button deleteProviderButton;
    private Button addProviderButton;

    public ProviderPane(){
        super(12,17);
        this.getStylesheets().remove(ComponentStyleElements.DEFAULT_STYLESHEET.getPath());
        this.getStylesheets().add(ComponentStyleElements.PROVIDER_STYLESHEET.getPath());
        this.getStyleClass().add(ComponentStyleElements.PROVIDER_CLASS.getPath());
        inicThings();
        inicButtons();

    }

    private void inicThings() {
        title = new Label("Proveedores");
        title.getStyleClass().add("title");
        title.setFont(Font.font ("Verdana", 20));
        addChild(title,5,0,8,1);

        TableView<ClientPane> tableView = new TableView();
        TableColumn<ClientPane, StringProperty> colId = new TableColumn<>("Id");
        TableColumn<ClientPane, StringProperty> colName = new TableColumn<>("Nombre");
        TableColumn<ClientPane, StringProperty> colLastName = new TableColumn<>("Apellido");
        TableColumn<ClientPane, StringProperty> colAdress = new TableColumn<>("Dirección");
        TableColumn<ClientPane, StringProperty> colPhone = new TableColumn<>("Telefono");
        TableColumn<ClientPane, StringProperty> colMail = new TableColumn<>("Mail");
        tableView.getColumns().addAll(colId, colName, colLastName, colAdress, colPhone, colMail);

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        colAdress.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colMail.setCellValueFactory(new PropertyValueFactory<>("mail"));




        addChild(tableView,1,2,10,11);

    }

    private void inicButtons() {
        modifyProviderButton = new Button("Actualizar");
        modifyProviderButton.getStyleClass().add("boton");
        modifyProviderButton.setFont(Font.font("Verdana", 16));
        addChild(modifyProviderButton, 8, 14, 2, 1);

        deleteProviderButton = new Button("Borrar");
        deleteProviderButton.getStyleClass().add("boton");
        deleteProviderButton.setFont(Font.font("Verdana", 16));
        addChild(deleteProviderButton, 5, 14, 2,1);

        addProviderButton = new Button("Agregar");
        addProviderButton.getStyleClass().add("boton");
        addProviderButton.setFont(Font.font("Verdana", 16));
        addChild(addProviderButton, 2, 14, 2,1);
        addProviderButton.setOnAction(event -> MainPane.getInstance().toProviderDialog());

    }
}

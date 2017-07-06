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
public class ClientPane extends GridView{

    private Label title;
    private Button modifyClientButton;
    private Button deleteClientButton;
    private Button addClientButton;


    public ClientPane(){
        super(12,16);
        this.getStylesheets().remove(ComponentStyleElements.DEFAULT_STYLESHEET.getPath());
        this.getStylesheets().add(ComponentStyleElements.CLIENT_STYLESHEET.getPath());
        this.getStyleClass().add(ComponentStyleElements.CLIENT_CLASS.getPath());
        inicButtons();
        inicThings();


    }

    private void inicThings() {
        title = new Label("Clientes");
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
        modifyClientButton = new Button("Actualizar");
        modifyClientButton.getStyleClass().add("boton");
        modifyClientButton.setFont(Font.font("Verdana", 16));
        addChild(modifyClientButton, 8, 14, 2, 1);

        deleteClientButton = new Button("Borrar");
        deleteClientButton.getStyleClass().add("boton");
        deleteClientButton.setFont(Font.font("Verdana", 16));
        addChild(deleteClientButton, 5, 14, 2,1);

        addClientButton = new Button("Agregar");
        addClientButton.getStyleClass().add("boton");
        addClientButton.setFont(Font.font("Verdana", 16));
        addChild(addClientButton, 2, 14, 2,1);
        addClientButton.setOnAction(event -> MainPane.getInstance().toClientDialog());

    }






}

package corp.tarta.nerfertum.Controls;

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
        title = new Label("  Clientes");
        title.getStyleClass().add("title");
        title.setFont(Font.font ("Verdana", 20));
        addChild(title,0,0,8,1);

        TableView<Persona> tableView = new TableView();
        TableColumn<Persona, StringProperty> colNombre = new TableColumn<>("Nombre");
        TableColumn<Persona, StringProperty> colApellido = new TableColumn<>("Apellido");
        TableColumn<Persona, StringProperty> colId = new TableColumn<>("Id");
        tableView.getColumns().addAll(colNombre, colApellido, colId);

        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));

        //Persona p1 = new Persona(new StringProperty"juan",new StringProperty("juan"),new StringProperty("juan"));
        //Persona p2 = new Persona("Maria", "Loza", "32412341341");
        //Persona p3 = new Persona("Adriana", "Mendez", "32412341991");

        //tableView.getItems().addAll(p1, p2, p3);

        addChild(tableView,1,2,10,11);

    }

    private void inicButtons() {
        modifyClientButton = new Button("Actualizar");
        modifyClientButton.getStyleClass().add("boton");
        modifyClientButton.setFont(Font.font("Verdana", 11));
        addChild(modifyClientButton, 7, 14, 1, 1);

        deleteClientButton = new Button("Borrar");
        deleteClientButton.getStyleClass().add("boton");
        deleteClientButton.setFont(Font.font("Verdana", 11));
        addChild(deleteClientButton, 5, 14, 1, 1);

        addClientButton = new Button("Agregar");
        addClientButton.getStyleClass().add("boton");
        addClientButton.setFont(Font.font("Verdana", 11));
        addChild(addClientButton, 3, 14, 1, 1);

    }






}

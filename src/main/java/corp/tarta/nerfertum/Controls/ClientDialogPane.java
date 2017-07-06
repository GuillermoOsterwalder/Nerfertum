package corp.tarta.nerfertum.Controls;

import corp.tarta.nerfertum.MainPane;
import corp.tarta.nerfertum.View.GridView;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

/**
 * Created by Tarta on 06/07/2017.
 */
public class ClientDialogPane extends GridView {
    private Label title;
    private Button cancel;
    private Button save;

    public ClientDialogPane(){
        super(12,17);
        this.getStylesheets().remove(ComponentStyleElements.DEFAULT_STYLESHEET.getPath());
        this.getStylesheets().add(ComponentStyleElements.CLIENTDIALOG_STYLESHEET.getPath());
        this.getStyleClass().add(ComponentStyleElements.CLIENTDIALOG_CLASS.getPath());
        inicThings();
        inicClientView();

    }

    private void inicThings() {
        title = new Label("Carga de Clientes");
        title.getStyleClass().add("title");
        title.setFont(Font.font ("Verdana", 24));
        addChild(title,4,1,8,1);

        cancel = new Button("Cancelar");
        cancel.getStyleClass().add("boton");
        cancel.setFont(Font.font("Verdana", 16));
        addChild(cancel, 7, 8, 2, 1);
        cancel.setOnAction(e -> MainPane.getInstance().toClientView());

        save = new Button("Cargar");
        save.getStyleClass().add("boton");
        save.setFont(Font.font("Verdana", 16));
        addChild(save, 7, 6, 2, 1);
    }

    private void inicClientView(){

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        Label idLabel = new Label("Codigo del cliente:");
        idLabel.setFont(Font.font("Verdana", 16));
        addChild(idLabel, 1, 5, 2, 1);


        final RestrictiveTextField id = new IntField(9999l,4);
        id.setPromptText("Ingrese el código del cliente");
        id.setPrefColumnCount(10);
        id.getText();
        GridPane.setConstraints(id, 0, 0);
        grid.getChildren().add(id);
        addChild(id,1,6,2,1);

        Label nameLabel = new Label("Nombre del cliente:");
        nameLabel.setFont(Font.font("Verdana", 16));
        addChild(nameLabel, 1, 8, 2, 1);

        final RestrictiveTextField name = new StringField(20);
        name.setPromptText("Ingrese nombre del cliente");
        name.setPrefColumnCount(10);
        name.getText();
        GridPane.setConstraints(name, 0, 0);
        grid.getChildren().add(name);
        addChild(name,1,9,2,1);

        Label lastnameLabel = new Label("Apellido del cliente");
        lastnameLabel.setFont(Font.font("Verdana", 16));
        addChild(lastnameLabel, 1, 11, 2, 1);

        final RestrictiveTextField lastname = new StringField(20);
        lastname.setPromptText("Ingrese el apellido del cliente");
        lastname.setPrefColumnCount(10);
        lastname.getText();
        GridPane.setConstraints(lastname, 0, 0);
        grid.getChildren().add(lastname);
        addChild(lastname,1,12,2,1);

        Label adressLabel = new Label("Dirección del cliente:");
        adressLabel.setFont(Font.font("Verdana", 16));
        addChild(adressLabel, 4, 5, 2, 1);

        final RestrictiveTextField adress = new StringField(50);
        adress.setPromptText("Ingrese la direccion del cliente");
        adress.setPrefColumnCount(10);
        adress.getText();
        GridPane.setConstraints(adress, 0, 0);
        grid.getChildren().add(adress);
        addChild(adress,4,6,2,1);

        Label phoneLabel = new Label("Telefono del cliente:");
        phoneLabel.setFont(Font.font("Verdana", 16));
        addChild(phoneLabel, 4, 8, 2, 1);

        final RestrictiveTextField phone = new StringField(20);
        phone.setPromptText("Ingrese el Telefono del cliente");
        phone.setPrefColumnCount(10);
        phone.getText();
        GridPane.setConstraints(phone, 0, 0);
        grid.getChildren().add(phone);
        addChild(phone,4,9,2,1);

        Label mailLabel = new Label("Mail del cliente:");
        mailLabel.setFont(Font.font("Verdana", 16));
        addChild(mailLabel, 4, 11, 2, 1);

        final RestrictiveTextField mail = new StringField(30);
        mail.setPromptText("Ingrese el mail del cliente");
        mail.setPrefColumnCount(10);
        mail.getText();
        GridPane.setConstraints(mail, 0, 0);
        grid.getChildren().add(mail);
        addChild(mail,4,12,2,1);


    }


}

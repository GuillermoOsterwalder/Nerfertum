package corp.tarta.nerfertum.Controls;

import javafx.beans.property.StringProperty;

/**
 * Created by Tarta on 02/07/2017.
 */
public class Persona {
    private StringProperty nombre;
    private StringProperty apellido;
    private StringProperty colId;

    public Persona(StringProperty nombre, StringProperty apellido, StringProperty id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.colId = id;
    }
}
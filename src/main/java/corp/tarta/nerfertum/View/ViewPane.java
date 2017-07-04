package corp.tarta.nerfertum.View;

/**
 * Created by Tarta on 26/06/2017.
 */
public class ViewPane extends GridView{

    public ViewPane(){
        super();
        setGridLinesVisible(true);
        this.getStyleClass().add("pane");
    }
}

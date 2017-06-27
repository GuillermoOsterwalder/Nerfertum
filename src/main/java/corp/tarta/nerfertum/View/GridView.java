package corp.tarta.nerfertum.View;

import javafx.scene.layout.*;

/**
 * Created by mariano on 26/06/17.
 */
public class GridView extends GridPane {

    public GridView(){
        inicGridSize();
    }

    public GridView(int col, int row){
        inicGridSize(col,row);
    }

    public void addChild(Region region, int col, int row, int colSpan, int rowSpan){
        this.add(region,col,row,colSpan,rowSpan);
        configureRegionSize(region);
    }

    private void inicGridSize(){
        final int numCols = 12 ;
        final int numRows = 20 ;
        inicCols(numCols);
        inicRows(numRows);
    }

    private void inicGridSize(int col, int row){
        final int numCols = col ;
        final int numRows = row ;
        inicCols(numCols);
        inicRows(numRows);
    }

    private void inicCols(int numCols){
        for (int i = 0; i < numCols; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0 / numCols);
            this.getColumnConstraints().add(colConst);
        }
    }

    private void inicRows(int numRows){
        for (int i = 0; i < numRows; i++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPercentHeight(100.0 / numRows);
            this.getRowConstraints().add(rowConst);
        }
    }

    private void configureRegionSize(Region region){
        region.setMaxWidth(Double.MAX_VALUE);
        region.setMaxHeight(Double.MAX_VALUE);
        setHgrow(region, Priority.ALWAYS);
        setVgrow(region, Priority.ALWAYS);
    }

    public void changeStyleSheet(String path){
        this.getStylesheets().remove(0);
        this.getStylesheets().add(path);
    }

    public void changeStyleClass(String p){
        this.getStyleClass().remove("pane");
        this.getStyleClass().add(p);
    }
}
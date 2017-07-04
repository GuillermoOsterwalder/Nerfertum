package corp.tarta.nerfertum;

import corp.tarta.nerfertum.Controls.*;
import corp.tarta.nerfertum.View.GridView;

/**
 * Created by Tarta on 27/06/2017.
 */
public class MainPane extends GridView{
    private static MainPane instance = null;

    public static MainPane getInstance(){
        if (instance == null){
            instance = new MainPane();
        }
        return instance;
    }

    private HeaderPane mainHeader;
    private NavBarPane navBar;
    private FooterPane footer;
    private WelcomePane welcome;
    private GridView actualPane;
    private ClientPane client;
    private StockPane stock;
    private ProviderPane provider;

    private MainPane(){
        super();
        this.setGridLinesVisible(true);
        inicMain();
    }

    private void inicMain() {
        mainHeader = new HeaderPane();
        this.addChild(mainHeader,0,0,12,2);

        navBar = new NavBarPane();
        this.addChild(navBar,0,2,1,18);

        footer = new FooterPane();
        this.addChild(footer, 0,19,12,1);

        welcome = new WelcomePane();
        this.addChild(welcome, 1,2,11,17);
        actualPane = welcome;
;

    }
    public void toClientView(){
        this.getChildren().remove(actualPane);
        client = new ClientPane();
        this.addChild(client, 1,2,11,17);
        actualPane = client;
    }

    public void toStockView(){
        this.getChildren().remove(actualPane);
        stock = new StockPane();
        this.addChild(stock, 1,2,11,17);
        actualPane = stock;
    }

    public void toProviderView(){
        this.getChildren().remove(actualPane);
        provider = new ProviderPane();
        this.addChild(provider, 1,2,11,17);
        actualPane = provider;
    }
}

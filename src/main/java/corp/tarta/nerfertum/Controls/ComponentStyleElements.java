package corp.tarta.nerfertum.Controls;

/**
 * Created by Tarta on 26/06/2017.
 */
public enum ComponentStyleElements {

    // STYLESHEETS
    DEFAULT_STYLESHEET("Stylesheet/style.css"),
    HEADER_STYLESHEET("Stylesheet/HeaderStyle.css"),
    NAVBAR_STYLESHEET("Stylesheet/NavBarStyle.css"),
    FOOTER_STYLESHEET("Stylesheet/FooterStyle.css"),
    STOCK_STYLESHEET("Stylesheet/StockStyle.css"),
    CLIENT_STYLESHEET("Stylesheet/ClientStyle.css"),
    PROVIDER_STYLESHEET("Stylesheet/ProviderStyle.css"),
    WELCOME_STYLESHEET("Stylesheet/WelcomeStyle.css"),
    SELL_STYLESHEET("Stylesheet/SellStyle.css"),
    STOCKDIALOG_STYLESHEET("Stylesheet/StockDialogStyle.css"),
    CLIENTDIALOG_STYLESHEET("Stylesheet/ClientDialogStyle.css"),
    PROVIDERDIALOG_STYLESHEET("Stylesheet/ClientDialogStyle.css"),


    // HEADER CLASSES
    HEADER_CLASS("pane"),

    // WELCOME CLASSES
    WELCOME_CLASS("pane"),

    // PROVIDER CLASSES
    PROVIDER_CLASS("pane"),

    // PROVIDER CLASSES
    PROVIDERDIALOG_CLASS("pane"),

    // FOOTER CLASSES
    FOOTER_CLASS("pane"),

    // CLIENT CLASSES
    CLIENT_CLASS("pane"),

    // CLIENT CLASSES
    CLIENTDIALOG_CLASS("pane"),

    // STOCK CLASSES
    STOCK_CLASS("pane"),

    // STOCKDIALOG CLASSES
    STOCKDIALOG_CLASS("pane"),

    // NAVBAR CLASSES
    NAVBAR_CLASS("pane"),

    // SELL CLASSES
    SELL_CLASS("pane");

    private String path;

    ComponentStyleElements(String path){
        this.path = path;
    }

    public String getPath(){
        return path;
    }

}

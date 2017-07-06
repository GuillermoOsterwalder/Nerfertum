package corp.tarta.nerfertum.Model.Services;

import corp.tarta.nerfertum.Exceptions.EpsonPrinterException;
import corp.tarta.nerfertum.Exceptions.NotFoundException;
import corp.tarta.nerfertum.Exceptions.NullValueException;
import corp.tarta.nerfertum.Model.Entities.*;
import corp.tarta.nerfertum.Model.IOControllers.EpsonPrintController;
import corp.tarta.nerfertum.Model.Repositories.OrderInvoiceRepository;
import corp.tarta.nerfertum.Model.Repositories.OrderProductRepository;

import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by mariano on 05/07/17.
 */
public class ShoppingCartServiceBean implements ShoppingCartService{

    private static ShoppingCartServiceBean instance = null;

    private ShoppingCart shoppingCart;

    private OrderInvoiceRepository orderInvoiceRepository;
    private OrderProductRepository orderProductRepository;

    private ShoppingCartServiceBean(){
        shoppingCart = new ShoppingCart();
        //orderInvoiceRepository = new OrderInvoiceRepositoryBean();
        //orderProductRepository = new OrderProductRepositoryBean();
    }

    public static ShoppingCartServiceBean getInstance(){
        if (instance == null){
            instance = new ShoppingCartServiceBean();
        }
        return instance;
    }


    @Override
    public void addToCart(Product product, int quantity) throws NullValueException {
        if (product.getId() == null || product.getSellPrice() == null || quantity < 0 ){
            throw new NullValueException();
        }
        if(shoppingCart.getProducts().containsKey(product.getId())){
            CartProduct cartProduct = shoppingCart.getProducts().get(product.getId());
            cartProduct.setQuantity(product.getQuantity()+quantity);
            cartProduct.setTotal(product.getSellPrice()*product.getQuantity());
            shoppingCart.getProducts().put(product.getId(),cartProduct);
        }else{
            CartProduct cartProduct = new CartProduct();
            cartProduct.setProductId(product.getId());
            cartProduct.setDescription(product.getDescription());
            cartProduct.setQuantity(quantity);
            cartProduct.setTotal(product.getSellPrice() * cartProduct.getQuantity());
        }
    }

    @Override
    public void removeFromCart(Long id) throws NotFoundException, NullValueException{
        if(id != null){
            if(shoppingCart.getProducts().containsKey(id)){
                shoppingCart.getProducts().remove(id);
            }else{
                throw new NotFoundException();
            }
        }else{
            throw new NullValueException();
        }

    }

    @Override
    public Float getSubTotal() {
        Float subTotal = 0f;
        for (Map.Entry<Long, CartProduct> cartProductEntry: shoppingCart.getProducts().entrySet()) {
            subTotal += cartProductEntry.getValue().getTotal();
        }
        return subTotal;
    }

    @Override
    public void setDisscount(Float disscount) throws NullValueException{
        if(disscount != null){
            shoppingCart.setDisscount(disscount);
        }else{
            throw new NullValueException();
        }
    }

    @Override
    public Float getDisscountPercent() {
        return shoppingCart.getDisscount();
    }

    @Override
    public Float getDisscountPrice() {
        Float disscount = 0f;
        disscount = getSubTotal() * getDisscountPercent() / 100;
        return disscount;
    }

    @Override
    public Float getTotal() {
        Float total = 0f;
        total = getSubTotal() - getDisscountPrice();
        return total;
    }

    @Override
    public void setClient(Client client) throws NullValueException {
        if(client != null){
            shoppingCart.setClient(client);
        }else{
            throw new NullValueException();
        }
    }

    @Override
    public Client getClient() {
        return shoppingCart.getClient();
    }

    @Override
    public void setPaymentMethod(PaymentMethod paymentMethod) throws NullValueException {
        if(paymentMethod != null){
            shoppingCart.setPaymentMethod(paymentMethod);
        }else{
            throw new NullValueException();
        }
    }

    @Override
    public PaymentMethod getPaymentMethod() {
        return shoppingCart.getPaymentMethod();
    }

    @Override
    public List<CartProduct> getAll() {
        List<CartProduct> returnList = new LinkedList<>();
        for (Map.Entry<Long, CartProduct> cartProductEntry: shoppingCart.getProducts().entrySet()) {
            returnList.add(cartProductEntry.getValue());
        }
        return returnList;
    }

    @Override
    public void clear() {
        shoppingCart.getProducts().clear();
    }

    @Override
    public void executeSell() throws NullValueException {
        /**
         * Generates and save order invoice
         */
        OrderInvoice orderInvoice = new OrderInvoice();
        orderInvoice.setId(orderInvoiceRepository.nextId());
        orderInvoice.setBuyerId(shoppingCart.getClient().getId());
        //add disscount
        orderInvoice.setTotal(getTotal());
        orderInvoice.setDate(LocalTime.now());
        orderInvoiceRepository.save(orderInvoice);

        /**
         * Generates and save order invoice's products
         */
        for (Map.Entry<Long, CartProduct> cartProductEntry: shoppingCart.getProducts().entrySet()) {
            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setInvoiceId(orderInvoice.getId());
            orderProduct.setProductId(cartProductEntry.getValue().getProductId());
            orderProduct.setQuantity(cartProductEntry.getValue().getQuantity());
            orderProduct.setTotal(cartProductEntry.getValue().getTotal());
            orderProductRepository.save(orderProduct);
        }

        /**
         * Adds movement to casher
         */
        AccountMovement sellMovement = new AccountMovement();
        sellMovement.setAccountId(CasherServiceBean.getInstance().getCasherId());
        sellMovement.setDate(LocalTime.now());
        sellMovement.setAmmount(orderInvoice.getTotal());
        sellMovement.setDescription("Venta nro: " + orderInvoice.getId());
        sellMovement.setBalance(CasherServiceBean.getInstance().getBalance() - sellMovement.getAmmount());
        CasherServiceBean.getInstance().addMovement(sellMovement);
    }

    @Override
    public void executeSellAndPrint() throws NullValueException, EpsonPrinterException {
        executeSell();
        EpsonPrintController.getInstance().printTicket(shoppingCart);
    }

}

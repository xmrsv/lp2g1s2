package upeu.edu.pe.lp2g1s2.app.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import upeu.edu.pe.lp2g1s2.app.domain.ItemCart;

public class CartService {

    private List<ItemCart> itemCarts;
    private HashMap<Integer, ItemCart> itemCartHashMap;

    public CartService() {
        this.itemCartHashMap = new HashMap<>();
        this.itemCarts = new ArrayList<>();
    }

    public void addItemCart(Integer idProduct, String nameProduct, Integer quantity,
            BigDecimal price) {
        ItemCart itemCart = new ItemCart(idProduct, nameProduct, quantity, price);
        itemCartHashMap.put(itemCart.getIdProduct(), itemCart);
        fillList();
    }

    public BigDecimal getTotalCart() {
        BigDecimal total = BigDecimal.ZERO;
        for (ItemCart itemCart : itemCarts) {
            total = total.add(itemCart.getTotalPriceItem());
        }
        return total;
    }

    public void removeItemCart(Integer idProduct) {
        itemCartHashMap.remove(idProduct);
        fillList();
    }

    public void removeAllItemsCart() {
        itemCartHashMap.clear();
        itemCarts.clear();
    }

    private void fillList() {
        itemCarts.clear();
        itemCartHashMap.forEach(
                (integer, ItemCart) -> itemCarts.add(ItemCart)
        );
    }

    public List<ItemCart> getItemCarts() {
        return itemCarts;
    }
}

package upeu.edu.pe.lp2g1s2.app.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import upeu.edu.pe.lp2g1s2.app.domain.ItemCart;

public class CartService {

    private List<ItemCart> itemCarts; // Lista de elementos en el carrito
    private HashMap<Integer, ItemCart> itemCartHashMap; // Mapa para realizar un seguimiento de los elementos en el carrito

    public CartService() {
        this.itemCartHashMap = new HashMap<>();
        this.itemCarts = new ArrayList<>();
    }

    public void addItemToCart(Integer quantity, Integer id, String nameProduct, BigDecimal price) {
        ItemCart itemCart = new ItemCart(id, nameProduct, quantity, price);
        itemCartHashMap.put(itemCart.getId(), itemCart);
        fillList();
    }

    public BigDecimal getTotalCart() {
        BigDecimal total = BigDecimal.ZERO;

        for (ItemCart itemCart : itemCarts) {
            total = total.add(itemCart.getTotalPricePerItem());
        }

        return total;
    }

    public void removeItemFromCart(Integer id) {
        itemCartHashMap.remove(id);
        fillList();
    }

    public void removeAllItemsFromCart() {
        itemCartHashMap.clear();
        itemCarts.clear();
    }

    private void fillList() {
        itemCarts.clear();
        itemCartHashMap.forEach((id, itemCart) -> itemCarts.add(itemCart));
    }

    public List<ItemCart> getItemCarts() {
        return itemCarts;
    }
}

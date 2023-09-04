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

    public void addItemCart(Integer quantity,
            Integer id,
            String nameProduct,
            BigDecimal price) {
        ItemCart itemCart = new ItemCart(id, nameProduct, quantity, price);
        itemCartHashMap.put(itemCart.getId(), itemCart);
        fillList();
    }

    public BigDecimal getTotalCart() {
        BigDecimal total = BigDecimal.ZERO;

        for (ItemCart itemCart : itemCarts) {
            total.add(itemCart.getTotalPricePerItem());
        }

        return total;
    }

    // Elimina un solo producto del carrito (HashMap)
    public void removeItemCart(Integer id) {
        itemCartHashMap.remove(id);
        fillList();
    }

    public void removeAllItemCart() {
        itemCartHashMap.clear();
        itemCarts.clear();
    }

    private void fillList() {
        itemCarts.clear();
        itemCartHashMap.forEach((integer, itemCart) -> itemCarts.add(itemCart));
    }

    // Ver el proceso de añadir un producto al carrito
    public List<ItemCart> getItemCarts() {
        return itemCarts;
    }
}

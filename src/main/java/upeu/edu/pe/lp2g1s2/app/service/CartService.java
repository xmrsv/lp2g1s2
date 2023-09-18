package upeu.edu.pe.lp2g1s2.app.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import upeu.edu.pe.lp2g1s2.app.domain.ItemCart;

/**
 * Servicio para gestionar el carrito de compras.
 */
public class CartService {

    private List<ItemCart> itemCarts; // Lista de elementos en el carrito
    private HashMap<Integer, ItemCart> itemCartHashMap; // Mapa para realizar un seguimiento de los elementos en el carrito

    /**
     * Constructor del servicio de carrito.
     */
    public CartService() {
        this.itemCartHashMap = new HashMap<>();
        this.itemCarts = new ArrayList<>();
    }

    /**
     * Agrega un producto al carrito.
     *
     * @param quantity Cantidad del producto.
     * @param id ID del producto.
     * @param nameProduct Nombre del producto.
     * @param price Precio del producto.
     */
    public void addItemToCart(Integer quantity, Integer id, String nameProduct, BigDecimal price) {
        ItemCart itemCart = new ItemCart(id, nameProduct, quantity, price);
        itemCartHashMap.put(itemCart.getId(), itemCart);
        fillList();
    }

    /**
     * Calcula el total del carrito.
     *
     * @return Total del carrito como BigDecimal.
     */
    public BigDecimal getTotalCart() {
        BigDecimal total = BigDecimal.ZERO;

        for (ItemCart itemCart : itemCarts) {
            total = total.add(itemCart.getTotalPricePerItem());
        }

        return total;
    }

    /**
     * Elimina un producto del carrito.
     *
     * @param id ID del producto a eliminar.
     */
    public void removeItemFromCart(Integer id) {
        itemCartHashMap.remove(id);
        fillList();
    }

    /**
     * Elimina todos los productos del carrito.
     */
    public void removeAllItemsFromCart() {
        itemCartHashMap.clear();
        itemCarts.clear();
    }

    private void fillList() {
        itemCarts.clear();
        itemCartHashMap.forEach((id, itemCart) -> itemCarts.add(itemCart));
    }

    /**
     * Obtiene la lista de productos en el carrito.
     *
     * @return Lista de productos en el carrito.
     */
    public List<ItemCart> getItemCarts() {
        return itemCarts;
    }
}

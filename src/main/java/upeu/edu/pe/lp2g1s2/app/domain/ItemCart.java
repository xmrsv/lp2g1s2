package upeu.edu.pe.lp2g1s2.app.domain;

import java.math.BigDecimal;
import java.util.HashMap;

public class ItemCart {

    private Integer id;
    private String nameProduct;
    private Integer quantity;
    private BigDecimal price;

    // Calcula el total del precio por item
    public BigDecimal getTotalPricePerItem() {
        return price.multiply(BigDecimal.valueOf(quantity));
    }

    public ItemCart(Integer id, String nameProduct, Integer quantity, BigDecimal price) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return "ItemCart{"
                + "id=" + id
                + ", nameProduct=" + nameProduct
                + ", quantity=" + quantity
                + ", price=" + price
                + '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    
}

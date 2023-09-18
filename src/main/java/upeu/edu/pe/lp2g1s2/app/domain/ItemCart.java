package upeu.edu.pe.lp2g1s2.app.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;

/**
 * Representa un artículo en un carrito de compras.
 */
@Entity
@Table(name = "item_cart")
public class ItemCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_name")
    private String productName;

    private Integer quantity;
    private BigDecimal price;

    /**
     * Constructor para crear un nuevo artículo en el carrito.
     *
     * @param id El identificador único del artículo.
     * @param nameProduct El nombre del producto.
     * @param quantity La cantidad de este artículo en el carrito.
     * @param price El precio unitario del artículo.
     */
    public ItemCart(Integer id, String nameProduct, Integer quantity, BigDecimal price) {
        this.id = id;
        this.productName = nameProduct;
        setQuantity(quantity); // Validamos la cantidad al asignarla.
        this.price = price;
    }

    /**
     * Calcula el precio total por artículo multiplicando la cantidad por el
     * precio unitario.
     *
     * @return El precio total por artículo.
     */
    public BigDecimal getTotalPricePerItem() {
        return price.multiply(BigDecimal.valueOf(quantity));
    }

    /**
     * Devuelve una representación de cadena de este artículo en el carrito.
     *
     * @return Una cadena que representa el artículo en el carrito.
     */
    @Override
    public String toString() {
        return "ItemCart{"
                + "id=" + id
                + ", nameProduct='" + productName + '\''
                + ", quantity=" + quantity
                + ", price=" + price
                + '}';
    }

    // Getters y setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Establece la cantidad de este artículo en el carrito, validando que no
     * sea negativa.
     *
     * @param quantity La cantidad a establecer.
     */
    public void setQuantity(Integer quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        }
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

package upeu.edu.pe.lp2g1s2.infrastructure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "stock")
public class StockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String description;
    private Integer entries;
    private Integer exits;
    private Integer balance;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;

    public StockEntity() {
    }

    public StockEntity(Integer id, String description, Integer entries, Integer exits, Integer balance, ProductEntity productEntity) {
        this.id = id;
        this.description = description;
        this.entries = entries;
        this.exits = exits;
        this.balance = balance;
        this.productEntity = productEntity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getEntries() {
        return entries;
    }

    public void setEntries(Integer entries) {
        this.entries = entries;
    }

    public Integer getExits() {
        return exits;
    }

    public void setExits(Integer exits) {
        this.exits = exits;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    @Override
    public String toString() {
        return "StockEntity{"
                + "id=" + id
                + ", description='" + description + '\''
                + ", entries=" + entries
                + ", exits=" + exits
                + ", balance=" + balance
                + ", productEntity=" + productEntity
                + '}';
    }
}

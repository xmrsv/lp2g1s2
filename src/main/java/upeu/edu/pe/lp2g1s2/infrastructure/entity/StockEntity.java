package upeu.edu.pe.lp2g1s2.infrastructure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "stocks")
public class StockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descripcion;
    private String entradas;
    private String salidas;
    private String balance;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;

    public StockEntity() {
    }

    public StockEntity(Integer id, String descripcion, String entradas, String salidas, String balance, ProductEntity productEntity) {
        this.id = id;
        this.descripcion = descripcion;
        this.entradas = entradas;
        this.salidas = salidas;
        this.balance = balance;
        this.productEntity = productEntity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEntradas() {
        return entradas;
    }

    public void setEntradas(String entradas) {
        this.entradas = entradas;
    }

    public String getSalidas() {
        return salidas;
    }

    public void setSalidas(String salidas) {
        this.salidas = salidas;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

}

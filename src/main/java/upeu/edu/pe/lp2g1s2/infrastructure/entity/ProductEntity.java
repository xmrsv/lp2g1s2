package upeu.edu.pe.lp2g1s2.infrastructure.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;
    private String name;
    private String description;
    private BigDecimal price;
    private String image;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;

    @ManyToOne
    @JoinColumn(name = "user_id") // Nombre de la columna
    private UserEntity userEntity;

    public ProductEntity() {
        this.setCode(UUID.randomUUID().toString());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(LocalDateTime dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    
    
    /*
    
    
    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", code=" + code + ", name=" + name
                + ", description=" + description + ", image=" + image
                + ", price=" + price + ", dateCreated=" + dateCreated
                + ", dateUpdated=" + dateUpdated + ", user=" + userEntity + '}';
    }

     */

    @Override
    public String toString() {
        return "ProductEntity{" + "id=" + id + ", code=" + code + ", name=" + name + ", description=" + description + ", price=" + price + ", image=" + image + ", dateCreated=" + dateCreated + ", dateUpdated=" + dateUpdated + ", userEntity=" + userEntity + '}';
    }
}

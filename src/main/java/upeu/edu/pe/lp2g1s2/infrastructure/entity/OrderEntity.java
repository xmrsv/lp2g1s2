package upeu.edu.pe.lp2g1s2.infrastructure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "order")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime dateOrder;
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id") // Nombre de la columna
    private UserEntity userEntity;

    public OrderEntity() {
    }

    public OrderEntity(Integer id, LocalDateTime dateOrder, String status, UserEntity userEntity) {
        this.id = id;
        this.dateOrder = dateOrder;
        this.status = status;
        this.userEntity = userEntity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(LocalDateTime dateOrder) {
        this.dateOrder = dateOrder;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @Override
    public String toString() {
        return "OrderEntity{" + "id=" + id + ", dateOrder=" + dateOrder + ", status=" + status + ", userEntity=" + userEntity + '}';
    }

}

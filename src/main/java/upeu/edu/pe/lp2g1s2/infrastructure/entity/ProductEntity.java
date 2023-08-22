package upeu.edu.pe.lp2g1s2.infrastructure.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.*;

@Data
@AllArgsConstructor
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
}

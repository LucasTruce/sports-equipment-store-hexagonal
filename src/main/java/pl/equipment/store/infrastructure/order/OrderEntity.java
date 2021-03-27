package pl.equipment.store.infrastructure.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.equipment.store.infrastructure.user.UserEntity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "user_order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private BigDecimal totalPrice;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

}

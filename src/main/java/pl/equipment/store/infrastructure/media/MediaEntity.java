package pl.equipment.store.infrastructure.media;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.equipment.store.infrastructure.product.ProductEntity;

import javax.persistence.*;

@Entity
@Table(name = "media")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MediaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;
    private String url;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;
}

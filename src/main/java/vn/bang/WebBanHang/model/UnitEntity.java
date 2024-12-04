package vn.bang.WebBanHang.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Unit")
public class UnitEntity extends AbstractEntity {

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "description",length = 255)
    private String description;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity products;

    @OneToMany(mappedBy = "Unit")
    private List<InventoryEntity> inventories;
}

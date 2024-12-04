package vn.bang.WebBanHang.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Inventory")
public class InventoryEntity extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private UnitEntity unit;

    @Column(name = "quantity")
    private int quantity;
    

}

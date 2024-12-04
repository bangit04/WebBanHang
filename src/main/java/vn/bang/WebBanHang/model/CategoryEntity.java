package vn.bang.WebBanHang.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "Category")
public class CategoryEntity extends AbstractEntity {

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "description", length = 255)
    private String description;

    @OneToMany(mappedBy = "Category")
    private List<ProductEntity> products;

    @OneToMany(mappedBy = "Category")
    private List<InventoryEntity> inventories;



}

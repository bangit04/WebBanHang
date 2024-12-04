package vn.bang.WebBanHang.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Product")
@Getter
@Setter
public class ProductEntity extends AbstractEntity {
    @Column(name = "name", length = 255)
    private String name;

    @OneToMany(mappedBy = "Product")
    private List<UnitEntity> unit;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    public ProductEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UnitEntity> getUnit() {
        return unit;
    }

    public void setUnit(List<UnitEntity> unit) {
        this.unit = unit;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
}

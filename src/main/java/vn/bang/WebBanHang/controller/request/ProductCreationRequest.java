package vn.bang.WebBanHang.controller.request;

import vn.bang.WebBanHang.model.CategoryEntity;
import vn.bang.WebBanHang.model.UnitEntity;

import java.io.Serializable;
import java.util.List;

public class ProductCreationRequest implements Serializable {

    private String name;
    private List<UnitEntity> unit;
    private List<CategoryEntity> category;

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

    public List<CategoryEntity> getCategory() {
        return category;
    }

    public void setCategory(List<CategoryEntity> category) {
        this.category = category;
    }
}

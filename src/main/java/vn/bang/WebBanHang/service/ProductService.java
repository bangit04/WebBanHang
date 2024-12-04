package vn.bang.WebBanHang.service;

import vn.bang.WebBanHang.controller.request.ProductCreationRequest;
import vn.bang.WebBanHang.model.ProductEntity;

import java.util.List;

public interface ProductService {

    List<ProductEntity> findAll();

    List<ProductEntity> findById(Long id);

    List<ProductEntity> findByName(String name);

    void add(ProductCreationRequest product);

    void update(ProductEntity product);

    void delete(Long id);
}

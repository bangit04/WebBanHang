package vn.bang.WebBanHang.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import vn.bang.WebBanHang.controller.request.ProductCreationRequest;
import vn.bang.WebBanHang.model.ProductEntity;
import vn.bang.WebBanHang.repository.CategoryRepository;
import vn.bang.WebBanHang.repository.InventoryRepository;
import vn.bang.WebBanHang.repository.ProductRepository;
import vn.bang.WebBanHang.repository.UnitRepository;
import vn.bang.WebBanHang.service.ProductService;

import java.util.List;

@Service
@Slf4j(topic = "PRODUCT-SERVICE")
public class ProductServiceImpl implements ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final UnitRepository unitRepository;
    private final InventoryRepository inventoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository, UnitRepository unitRepository, InventoryRepository inventoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.unitRepository = unitRepository;
        this.inventoryRepository = inventoryRepository;
    }


    @Override
    public List<ProductEntity> findAll() {
        log.info("find all product");




        return List.of();
    }

    @Override
    public List<ProductEntity> findById(Long id) {
        return List.of();
    }

    @Override
    public List<ProductEntity> findByName(String name) {
        return List.of();
    }

    @Override
    public void add(ProductCreationRequest req) {
        log.info("Add product: {}", req);

        ProductEntity product = new ProductEntity();
        product.setName(req.getName());
        product.setUnit(req.getUnit());
        product.setCategory(req.getCategory());
        productRepository.save(product);

    }

    @Override
    public void update(ProductEntity product) {

    }

    @Override
    public void delete(Long id) {

    }
}

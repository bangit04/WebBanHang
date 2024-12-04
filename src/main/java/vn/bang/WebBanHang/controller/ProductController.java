package vn.bang.WebBanHang.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.bang.WebBanHang.model.ProductEntity;
import vn.bang.WebBanHang.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
@Tag(name = "Product Controller")
@Slf4j(topic = "PRODUCT-CONTROLLER")
public class ProductController {
    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "Get product list")
    @GetMapping("/list")
    public List<ProductEntity> getAllProduct(){

        return List.of();
    }
}

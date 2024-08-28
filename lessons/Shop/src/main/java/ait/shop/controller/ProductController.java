package ait.shop.controller;

import ait.shop.exception_handling.Response;
import ait.shop.exception_handling.exceptions.FirstTestException;
import ait.shop.model.dto.ProductDTO;
import ait.shop.service.interfaces.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/products")
@Tag(name = "Product controller", description = "controller for operations with products")

public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "Create product", tags = {"Product"}, description = "Add new product.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductDTO.class)),
                            @Content(mediaType = "application/xml",
                                    schema = @Schema(implementation = ProductDTO.class))
                    }
                    ),
            @ApiResponse(responseCode = "400", description = "Invalid productname supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Product not found", content = @Content)})


    @PostMapping
    public ProductDTO saveProduct(@Valid @RequestBody ProductDTO productDTO) { //TODO ask to service

        return productService.saveProduct(productDTO);
    }

//    //GET /products?id=3
//    @GetMapping
//    public Product getById (@RequestParam long id) {//TODO ask to service from id
// return null;}


    //GET /products/{id} - peremennay wega
    @Operation(summary = "Get product by id", tags = {"ProductDTO"}, description = "Find product.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductDTO.class)),
                            @Content(mediaType = "application/xml",
                                    schema = @Schema(implementation = ProductDTO.class))
                    }
            ),
            @ApiResponse(responseCode = "400", description = "Invalid productname supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Product not found", content = @Content)})

    @GetMapping("/{id}")
    public ProductDTO getById(
            @Parameter(description = "The id that method to be fetched. ", required = true) @PathVariable long id) {    //TODO ask to service from id
//
//  TAK DELATb HELb3a   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//
// check; if id=10 trowble exept
//        if (id == 10) {
//            throw new FirstTestException("ID cannot be 10");
//        }
        //  TAK DELATb HELb3a   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        return productService.getById(id);
    }

    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        return productService.updateProduct(id, productDTO);
    }

    @PutMapping("/restore/{id}")
    public ProductDTO restoreByTitle(Long id) {
        return productService.restoreByTitle(id);
    }

    @DeleteMapping("/{id}")
    public ProductDTO remove(@PathVariable Long id) {
        return productService.remove(id);
    }

    @DeleteMapping("/{by-title}")
    public ProductDTO removeByTitle(String title) {
        return productService.removeByTitle(title);
    }

    @GetMapping
    public List<ProductDTO> getAll() {
        return productService.getAll();
    }

    @GetMapping("/count")
    public long getProductsCount() {
        return productService.getProductsCount();
    }

    @GetMapping("/total-price")
    public BigDecimal getTotalPrice() {
        return productService.getTotalPrice();
    }

    @GetMapping("average-price")
    public BigDecimal getAveragePrice() {
        return productService.getAveragePrice();
    }

    @ExceptionHandler(FirstTestException.class)
    public ResponseEntity<Response> handleException (FirstTestException e) {
        Response response = new Response(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


}

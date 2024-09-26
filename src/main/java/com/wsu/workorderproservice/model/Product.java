package com.wsu.workorderproservice.model;

import java.math.BigDecimal;

import com.wsu.workorderproservice.dto.ProductDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Product {
    @Id
    @Column(name = "sku_code")
    private String skuCode;
    @Column(name = "sku_description")
    private String skuDescription;
    @Column(name = "unit_cost")
    private BigDecimal unitCost;
    @Column(name = "product_type_code")
    private Character productTypeCode;    
    @Column(name = "universal_product_code")
    private String universalProductCode;
    @Column(name = "active")
    private Boolean active;

    public ProductDTO mapToDTO() {
        return ProductDTO.builder().skuCode(this.getSkuCode()).skuDescription(this.getSkuDescription())
        .unitCost(this.getUnitCost()).productTypeCode(this.getProductTypeCode())
        .universalProductCode(this.getUniversalProductCode()).active(this.getActive()).build();
    }
}

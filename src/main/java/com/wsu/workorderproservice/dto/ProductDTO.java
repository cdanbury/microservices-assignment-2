package com.wsu.workorderproservice.dto;

import java.math.BigDecimal;

import com.wsu.workorderproservice.model.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {
    private String skuCode;
    private String skuDescription;
    private BigDecimal unitCost;
    private Character productTypeCode;    
    private String universalProductCode;
    private Boolean active;

    public Product mapToEntity() {
        return Product.builder().skuCode(this.getSkuCode()).skuDescription(this.getSkuDescription())
        .unitCost(this.getUnitCost()).productTypeCode(this.getProductTypeCode())
        .universalProductCode(this.getUniversalProductCode()).active(this.getActive()).build();
    }
}

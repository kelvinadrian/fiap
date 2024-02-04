package com.fiap.fastfood.application.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private String id;

    private List<Item> items;

    private BigDecimal totalValue;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public BigDecimal getTotalValue() {
        return items.stream()
                .map(Item::getTotalItemValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}

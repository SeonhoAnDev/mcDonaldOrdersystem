package com.example.mcdonaldordersystem.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
@Builder
public class CreatOrder {
    private int customerId;
    private Map<Integer, Integer> quantityByProduct;
}

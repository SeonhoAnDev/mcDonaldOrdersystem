package com.example.mcdonaldordersystem.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreatCustomer {
    private final String name;
    private final String address;
    private final String phoneNumber;
}

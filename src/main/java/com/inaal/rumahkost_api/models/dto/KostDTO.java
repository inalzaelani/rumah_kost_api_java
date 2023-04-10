package com.inaal.rumahkost_api.models.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.List;

public class KostDTO {
    @NotBlank(message = "{invalid.name}")
    private String name;
    @NotBlank(message = "{invalid.address}")
    private String address;
    @NotNull(message = "{invalid.price}")
    @DecimalMin(value = "0.0", message = "{invalid.format.price}")
    private BigDecimal price;

    @NotNull(message = "{invalid.capacity}")
    @Min(value = 1, message = "{invalid.format.capacity}")
    private Integer capacity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}

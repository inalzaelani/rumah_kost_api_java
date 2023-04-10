package com.inaal.rumahkost_api.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;
import java.util.List;

public class KostDTO {
    @NotBlank(message = "{invalid.name}")
    private String name;
    @NotBlank(message = "{invalid.address}")
    private String address;
    @NotBlank(message = "{invalid.price}")
    @Pattern(regexp="(^$|[0-9]{10})", message = "{invalid.format.price}")
    private BigDecimal price;
    @NotBlank(message = "{invalid.capacity}")
    @Pattern(regexp="(^$|[0-9]{10})", message = "{invalid.format.capacity}")
    private Integer capasity;

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

    public Integer getCapasity() {
        return capasity;
    }

    public void setCapasity(Integer capasity) {
        this.capasity = capasity;
    }
}

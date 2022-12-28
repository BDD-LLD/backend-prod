package com.ldd.bdd.DTO.Request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@ToString
public class ProductInventoryDTORequest {

    private int location;

    private int category;

}

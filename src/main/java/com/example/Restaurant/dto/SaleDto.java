package com.example.Restaurant.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaleDto extends BaseDto {

    private Integer id;

    private CashierDto cashierDto;

    private TablesDto tablesDto;

    private String date;

    private String hour;

    private Double total;

    private String payment;

    private Double moneyRecievid;

    private Double change;

    private String status;

    private String tableStatus;

    private Double out;

    private String description;
}
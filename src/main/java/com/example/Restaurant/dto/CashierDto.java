package com.example.Restaurant.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CashierDto extends BaseDto{
    private Integer id;
    private String openDate;
    private String closureDate;
    private Double startDate;
    private Double endDate;
    private String obs;
    private String status;
}
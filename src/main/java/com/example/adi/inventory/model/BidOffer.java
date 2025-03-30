package com.example.adi.inventory.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class BidOffer {
    private Double amount;
    private Integer numberOfResources;
	private String status;
	private String itemCode;
}

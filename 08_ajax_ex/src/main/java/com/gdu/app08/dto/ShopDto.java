package com.gdu.app08.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ShopDto {
  private String query;
  private Integer display;
  private String sort;
}

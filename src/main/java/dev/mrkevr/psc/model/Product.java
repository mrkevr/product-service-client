package dev.mrkevr.psc.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
	Long id;
	String name;
	BigDecimal price;
	Integer quantity;
	LocalDateTime created;
	LocalDateTime updated;
}

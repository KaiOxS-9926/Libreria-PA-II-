package org.example.precios;

import lombok.Value;
import java.math.BigDecimal;

@Value
public class HighPrice {
    String titulo;
    BigDecimal precio;
    String isbn;
}

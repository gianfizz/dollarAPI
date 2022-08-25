package com.example.dollar;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class ModelDollar {

    private @Id @GeneratedValue Long Id;
    private @Column(unique = true) String dollarType;
    @JsonProperty("compra")
    private Double buyPrice;
    private Double venta;
    private Double valor;

    public Double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Double getVenta() {
        return venta;
    }

    public void setVenta(Double venta) {
        this.venta = venta;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}

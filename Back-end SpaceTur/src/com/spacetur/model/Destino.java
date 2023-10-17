package com.spacetur.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Destino {

    private int id;
    private double valor;
    private LocalDate data_ida;
    private LocalDate data_volta;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getData_ida() {
        return data_ida;
    }

    public void setData_ida(LocalDate data_ida) {
        this.data_ida = data_ida;
    }

    public LocalDate getData_volta() {
        return data_volta;
    }

    public void setData_volta(LocalDate data_volta) {
        this.data_volta = data_volta;
    }

	
}

package com.joaodddev.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private Cliente cliente;
    private LocalDate data;
    private List<ItemPedido> itens = new ArrayList<>();

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.data = LocalDate.now();
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    public double getTotal() {
        return itens.stream()
                .mapToDouble(ItemPedido::getSubtotal)
                .sum();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getData() {
        return data;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }
}

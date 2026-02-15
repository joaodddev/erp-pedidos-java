package com.joaodddev.service;

import com.joaodddev.model.ItemPedido;
import com.joaodddev.model.Pedido;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class RelatorioService {

    public void listarPedidos(List<Pedido> pedidos) {

    if (pedidos.isEmpty()) {
        System.out.println("Nenhum pedido cadastrado.");
        return;
    }

    for (Pedido p : pedidos) {
        System.out.println("\n============================");
        System.out.println("Cliente: " + p.getCliente().getNome());
        System.out.println("Data: " + p.getData());
        System.out.println("Itens:");

        for (ItemPedido item : p.getItens()) {
            System.out.println(
                "- " + item.getProduto().getNome() +
                " | Qtd: " + item.getQuantidade() +
                " | Subtotal: R$ " +
                String.format("%.2f", item.getSubtotal())
            );
        }

        System.out.println("TOTAL DO PEDIDO: R$ " +
                String.format("%.2f", p.getTotal()));
    }
}

    public void filtrarPorPeriodo(List<Pedido> pedidos, LocalDate inicio, LocalDate fim) {
        System.out.println("\n=== PEDIDOS FILTRADOS ===");

        pedidos.stream()
                .filter(p -> !p.getData().isBefore(inicio) && !p.getData().isAfter(fim))
                .forEach(p ->
                        System.out.println(
                                p.getData() + " | " +
                                p.getCliente().getNome() + " | R$ " +
                                String.format("%.2f", p.getTotal())
                        )
                );
    }

    public void exportarCSV(List<Pedido> pedidos) {
        try (FileWriter writer = new FileWriter("pedidos.csv")) {
            writer.write("Data,Cliente,Total\n");

            for (Pedido p : pedidos) {
                writer.write(
                        p.getData() + "," +
                        p.getCliente().getNome() + "," +
                        p.getTotal() + "\n"
                );
            }

            System.out.println("Arquivo pedidos.csv gerado com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro ao exportar CSV: " + e.getMessage());
        }
    }
}
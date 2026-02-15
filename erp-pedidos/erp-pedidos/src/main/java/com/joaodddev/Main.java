package com.joaodddev;

import com.joaodddev.model.*;
import com.joaodddev.service.RelatorioService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Pedido> pedidos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static RelatorioService relatorioService = new RelatorioService();

    public static void main(String[] args) {

        int opcao;

        do {
            System.out.println("\n=== SISTEMA DE PEDIDOS ===");
            System.out.println("1 - Criar pedido");
            System.out.println("2 - Listar pedidos");
            System.out.println("3 - Filtrar pedidos por período");
            System.out.println("4 - Exportar pedidos CSV");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> criarPedido();
                case 2 -> relatorioService.listarPedidos(pedidos);
                case 3 -> filtrarPorPeriodo();
                case 4 -> relatorioService.exportarCSV(pedidos);
                case 0 -> System.out.println("Encerrando sistema...");
                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }

    private static void criarPedido() {

        System.out.print("Nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        Cliente cliente = new Cliente(nomeCliente);

        Pedido pedido = new Pedido(cliente);

        String continuar;
        do {
            System.out.print("Nome do produto: ");
            String nomeProduto = scanner.nextLine();

            System.out.print("Preço do produto: ");
            double preco = scanner.nextDouble();

            System.out.print("Quantidade: ");
            int qtd = scanner.nextInt();
            scanner.nextLine();

            Produto produto = new Produto(nomeProduto, preco);
            ItemPedido item = new ItemPedido(produto, qtd);
            pedido.adicionarItem(item);

            System.out.print("Adicionar outro item? (s/n): ");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

        pedidos.add(pedido); // 🔴 ESSENCIAL (ANTES ESTAVA FALTANDO)

        System.out.println("Pedido cadastrado com sucesso!");
    }

    private static void filtrarPorPeriodo() {

        System.out.print("Data início (AAAA-MM-DD): ");
        LocalDate inicio = LocalDate.parse(scanner.nextLine());

        System.out.print("Data fim (AAAA-MM-DD): ");
        LocalDate fim = LocalDate.parse(scanner.nextLine());

        relatorioService.filtrarPorPeriodo(pedidos, inicio, fim);
    }
}

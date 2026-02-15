# 📦 Sistema de Pedidos em Java (Console)

Projeto desenvolvido em **Java** com foco em **Programação Orientada a Objetos (POO)**, organização em camadas e geração de relatórios.  
Ideal para demonstrar lógica de negócio, estrutura de projeto e boas práticas para aplicações backend iniciais.

---

## 🎯 Objetivo do Projeto

Simular um **sistema de pedidos** onde é possível:
- Criar pedidos com múltiplos produtos
- Calcular automaticamente o total
- Listar pedidos com extrato detalhado
- Filtrar pedidos por período
- Exportar relatórios em CSV

---

## 🧱 Estrutura do Projeto

src/
└── com.joaodddev
├── Main.java
├── model
│ ├── Cliente.java
│ ├── Produto.java
│ ├── Pedido.java
│ └── ItemPedido.java
└── service
└── RelatorioService.java
---

## 🛠️ Tecnologias Utilizadas

- Java 17+
- Programação Orientada a Objetos (POO)
- Collections (`List`, `ArrayList`)
- Stream API
- Geração de arquivos CSV
- IDE: VS Code

---

## 📋 Funcionalidades

✔ Criar pedidos via terminal  
✔ Adicionar múltiplos itens por pedido  
✔ Cálculo automático de totais  
✔ Listagem com extrato detalhado  
✔ Filtro por período (data inicial e final)  
✔ Exportação de relatório CSV  

---

## 🖥️ Exemplo de Saída

Cliente: João
Data: 2026-02-15
Itens:

Açúcar Cristal | Qtd: 10 | Subtotal: R$ 250.00

Etanol | Qtd: 5 | Subtotal: R$ 175.00
TOTAL DO PEDIDO: R$ 425.00
---

## 📊 Arquivo Gerado

O sistema gera automaticamente um arquivo:
pedidos.csv

Com o seguinte formato:
Data,Cliente,Total
2026-02-15,João,425.00

---

## 🚀 Como Executar

1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/sistema-pedidos-java
2. Abra no VS Code
3. Execute o arquivo:
Main.java

---

👨‍💻 Autor

João Victor
Estudante e entusiasta de Backend, Java e Análise de Dados Operacionais.

🔗 Conecte-se comigo no LinkedIn: https://www.linkedin.com/in/joao-victor-macedo-neves/

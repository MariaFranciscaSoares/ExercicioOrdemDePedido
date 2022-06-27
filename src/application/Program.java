package application;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

import entities.Cliente;
import entities.Ordem;
import entities.OrdemItem;
import entities.Produto;
import entities.enums.StatusOrdem;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);

		System.out.println("Insira os dados do cliente: ");
		System.out.println("Nome: ");
		String nome = sc.nextLine();
		System.out.println("Email: ");
		String email = sc.nextLine();
		System.out.println("Ano de Nascimento: ");
		int ano = sc.nextInt();
		System.out.println("Mês de Nascimento: ");
		int mes = sc.nextInt();
		System.out.println("Dia de Nascimento: ");
		int dia = sc.nextInt();
		
		LocalDate dateNascimento = LocalDate.of(ano, mes, dia);
		

		Cliente cliente = new Cliente(nome, email, dateNascimento);

		System.out.println();
		System.out.println("Insira os dados do pedido: ");
		System.out.println("Status: ");
		StatusOrdem status = StatusOrdem.valueOf(sc.next());

		System.out.println("Quantos itens para este pedido? ");
		int n = sc.nextInt();
		
		
		LocalDateTime date = LocalDateTime.now();
		Ordem ordem = new Ordem(date, status, cliente);

		for (int i = 1; i <= n; i++) {
			System.out.println("Insira os dados do item 0" + i + ":");
			System.out.println("Nome do Produto: ");
			sc.nextLine();
			String nomeProd = sc.nextLine();
			System.out.println("Preço do Produto: ");
			Double precoProd = sc.nextDouble();

			Produto produto = new Produto(nomeProd, precoProd);

			System.out.println("Quantidade do Produto: ");
			Integer quantidadeProd = sc.nextInt();

			OrdemItem ordemItem = new OrdemItem(quantidadeProd, produto);

			ordem.addItem(ordemItem);

		}

		System.out.println("RESUMO DO PEDIDO:");
		System.out.println(ordem);

		sc.close();

	}

}

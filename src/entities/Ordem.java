package entities;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import entities.enums.StatusOrdem;

public class Ordem {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	private LocalDateTime momento;
	private StatusOrdem status;
	private Cliente cliente;

	private List<OrdemItem> itens = new ArrayList<>();

	public Ordem(LocalDateTime momento, StatusOrdem status, Cliente cliente) {
		this.momento = momento;
		this.status = status;
		this.cliente = cliente;
	}

	public Ordem() {
	}

	public LocalDateTime getMomento() {
		return momento;
	}

	public void setMomento(LocalDateTime momento) {
		this.momento = momento;
	}

	public StatusOrdem getStatus() {
		return status;
	}

	public void setStatus(StatusOrdem status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<OrdemItem> getItens() {
		return itens;
	}

	public void addItem(OrdemItem item) {
		itens.add(item);
	}

	public void removeItem(OrdemItem item) {
		itens.remove(item);
	}

	public Double total() {
		Double soma = 0.0;
		for (OrdemItem item : itens) {
			soma += item.valorTotal();
		}
		return soma;
	}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("Momento Ordem: " + momento + "\n");
		string.append("Status Ordem: " + status + "\n");
		string.append(cliente.toString() + "\n");
		string.append("Ordem Itens" + "\n");
		for (OrdemItem item : itens) {
			string.append(item.toString());
		}
		string.append("Preço TOTAL: " + total());
		return string.toString();

	}

}

package entities;

public class OrdemItem {

	private Integer quantidade;
	Produto produto;

	public OrdemItem(Integer quantidade, Produto produto) {
		this.quantidade = quantidade;
		this.produto = produto;
	}

	public OrdemItem() {

	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double valorTotal() {
		return quantidade * produto.getPreco();
	}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append(produto.getNome() + ", ");
		string.append(produto.getPreco() + ", ");
		string.append("Quantidade: " + quantidade + ", ");
		string.append("Subtotal: " + valorTotal() + "\n");
		return string.toString();
	}

}

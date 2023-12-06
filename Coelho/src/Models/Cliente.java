package Models;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	
	String nome;
    String cpf;
    List<Imovel> imoveis;

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
		this.imoveis = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Imovel> getImoveis() {
		return imoveis;
	}

	public void setImoveis(List<Imovel> imoveis) {
		this.imoveis = imoveis;
	}
	
	@Override
	public String toString() {
		return this.cpf + "\t" + this.nome;
	}

}

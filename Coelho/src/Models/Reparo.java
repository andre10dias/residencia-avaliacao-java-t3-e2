package Models;

import java.util.Date;

public class Reparo {
	
	String descricao;
    String previsaoInicial;
    Date dataInicio;
    Date dataFim;
    boolean resolvido;
    Reparo proximoReparo;

	public Reparo() {
		// TODO Auto-generated constructor stub
	}
	
	public Reparo(String descricao, String previsaoInicial) {
        this.descricao = descricao;
        this.previsaoInicial = previsaoInicial;
        this.dataInicio = new Date();
        this.resolvido = false;
    }

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPrevisaoInicial() {
		return previsaoInicial;
	}

	public void setPrevisaoInicial(String previsaoInicial) {
		this.previsaoInicial = previsaoInicial;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public boolean isResolvido() {
		return resolvido;
	}

	public void setResolvido(boolean resolvido) {
		this.resolvido = resolvido;
	}

	public Reparo getProximoReparo() {
		return proximoReparo;
	}

	public void setProximoReparo(Reparo proximoReparo) {
		this.proximoReparo = proximoReparo;
	}

}

package com.rafael.petshop.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.rafael.petshop.domain.enuns.SituacaoPagamento;
@Entity
public class PagDinheiro extends Pagamento {

	private static final long serialVersionUID = 1L;
	
	private Date dataVencimento;
	private Double desconto;
	
	public PagDinheiro() {
		
	}

	public PagDinheiro(Integer id, Double valor, SituacaoPagamento situacao,Servico servico,Date dataVencimento, Double desconto) {
		super(id, valor, situacao, servico);
		// TODO Auto-generated constructor stub
		this.setDataVencimento(dataVencimento);
		this.setDesconto(desconto);
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}
	
	
}

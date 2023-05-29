package com.guimassoqueto.storeapi.storeapi.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.guimassoqueto.storeapi.storeapi.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComBoleto extends Pagamento {
  private static final long serialVersionUID = 1L;

  private Date dataPagamento;
  private Date dataVencimento;

  public PagamentoComBoleto() {}

  public PagamentoComBoleto(
    Integer id, 
    EstadoPagamento estado, 
    Pedido pedido,
    Date dataVencimento,
    Date dataPagamento
  ) {
    super(id, estado, pedido);
    this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
  }


  public Date getDataPagamento() {
    return this.dataPagamento;
  }

  public void setDataPagamento(Date dataPagamento) {
    this.dataPagamento = dataPagamento;
  }

  public Date getDataVencimento() {
    return this.dataVencimento;
  }

  public void setDataVencimento(Date dataVencimento) {
    this.dataVencimento = dataVencimento;
  }

}

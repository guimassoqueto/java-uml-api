package com.guimassoqueto.storeapi.storeapi.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Pedido implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @JsonFormat(pattern = "dd/MM/yyyy hh:mm")
  private Date instante;

  @OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
  private Pagamento pagamento;

  @ManyToOne
  @JoinColumn(name = "cliente_id")
  private Cliente cliente;

  @ManyToOne
  @JoinColumn(name = "endereco_de_entrega_id")
  private Endereco enderecoDeEntrega;

  @OneToMany(mappedBy = "id.pedido")
  private Set<ItemPedido> itens = new HashSet<>();

  public Pedido() {
  }

  public Pedido(Integer id, Date instante, Cliente cliente, Endereco enderecoDeEntrega) {
    this.id = id;
    this.instante = instante;
    this.cliente = cliente;
    this.enderecoDeEntrega = enderecoDeEntrega;
  }

  public Set<ItemPedido> getItens() {
    return this.itens;
  }

  public void setItens(Set<ItemPedido> itens) {
    this.itens = itens;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Date getInstante() {
    return this.instante;
  }

  public void setInstante(Date instante) {
    this.instante = instante;
  }

  public Pagamento getPagamento() {
    return this.pagamento;
  }

  public void setPagamento(Pagamento pagamento) {
    this.pagamento = pagamento;
  }

  public Cliente getCliente() {
    return this.cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public Endereco getEnderecoDeEntrega() {
    return this.enderecoDeEntrega;
  }

  public void setEnderecoDeEntrega(Endereco enderecoDeEntrega) {
    this.enderecoDeEntrega = enderecoDeEntrega;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Pedido)) {
      return false;
    }
    Pedido pedido = (Pedido) o;
    return Objects.equals(id, pedido.id);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

}

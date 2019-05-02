package br.edu.ifpe.pdsc_modelo.entidades;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pagamento", catalog = "CartorioProtesto")
public class Pagamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "data")
	private Date data;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
	private User usuario;
	
	@Column(name = "forma_pagamento")
	private String formaPagamento; 
}
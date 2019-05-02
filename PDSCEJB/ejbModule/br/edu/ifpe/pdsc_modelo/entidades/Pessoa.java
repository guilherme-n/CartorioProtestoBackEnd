package br.edu.ifpe.pdsc_modelo.entidades;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa", catalog = "CartorioProtesto")
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;

	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "telefone")
	private String telefone;
	
	@Column(name = "celular")
	private String celular;
	
	@Column(name = "data_nascimento")
	private Date dataNascimento;
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "endereco_id")
	private Endereco endereco;
	
}
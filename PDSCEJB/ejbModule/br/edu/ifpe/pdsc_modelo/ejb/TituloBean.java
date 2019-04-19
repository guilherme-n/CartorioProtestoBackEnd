package br.edu.ifpe.pdsc_modelo.ejb;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import br.edu.ifpe.pdsc_modelo.entidades.Titulo;
import br.edu.ifpe.pdsc_modelo.entidades.User;

@Stateful
@StatefulTimeout(unit = TimeUnit.MINUTES, value = 20)
public class TituloBean {
	
	@PersistenceContext(unitName = "pu", type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;
	
	@PostConstruct
    private void initializeBean(){
    }
	
	public Titulo cadastrarTitulo(String descricao, double valor) {
		Titulo vTitulo = new Titulo();
		vTitulo.setDescricao(descricao);
		vTitulo.setValor(valor);
		entityManager.persist(vTitulo);
		return vTitulo;
	}
	

	public List<Titulo> getAllTitulos() {
		String jpql = ("select t from Titulo t");
        Query query = entityManager.createQuery(jpql, Titulo.class);
        List<Titulo> titulos = query.getResultList();
        if (titulos!=null) {
        	return titulos;
        }
		return null;
	}
}
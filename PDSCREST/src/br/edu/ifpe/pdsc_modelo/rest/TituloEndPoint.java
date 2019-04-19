package br.edu.ifpe.pdsc_modelo.rest;

import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;
import static javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.FORBIDDEN;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;
import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;

import java.util.List;

import javax.naming.NamingException;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.xml.bind.DatatypeConverter;

import br.edu.ifpe.pdsc_modelo.ejb.Login;
import br.edu.ifpe.pdsc_modelo.ejb.TituloBean;
import br.edu.ifpe.pdsc_modelo.entidades.Titulo;
import br.edu.ifpe.pdsc_modelo.entidades.User;
import br.edu.ifpe.pdsc_modelo.util.ClientUtility;
import br.edu.ifpe.pdsc_modelo.util.PasswordUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Path("/titulos")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
@Transactional
public class TituloEndPoint {

	@POST
	@Consumes(APPLICATION_FORM_URLENCODED)
	public Response create(@FormParam("descricao") String descricao, @FormParam("valor") double valor) {
		try {
			
			TituloBean tituloBean = ClientUtility.getTituloBean();
			
			Titulo titulo = tituloBean.cadastrarTitulo(descricao, valor);
			if (titulo != null)
				return Response.ok(titulo).build();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return Response.status(NOT_FOUND).build();
	}

	/*@GET
	@Path("/{id}")
	public Response findById(@PathParam("id") int id) {
		try {
			Login loginbean = ClientUtility.getLoginBean();
			User user = loginbean.getUsuario(id);
			if (user != null)
				return Response.ok(user).build();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return Response.status(NOT_FOUND).build();
	}*/

	@GET
	public Response findAllTitulos() {
		try {
			TituloBean titulobean = ClientUtility.getTituloBean();
			List<Titulo> allTitulos = titulobean.getAllTitulos();
			if (allTitulos != null)
				return Response.ok(allTitulos).build();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return Response.status(NOT_FOUND).build();
	}
	
}
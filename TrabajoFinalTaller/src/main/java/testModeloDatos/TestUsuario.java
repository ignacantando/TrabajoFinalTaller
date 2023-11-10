package testModeloDatos;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modeloDatos.Usuario;

public class TestUsuario {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1() {
		String username="pepe21";
		String password="abc";
		String realname="";
		String telefono="5487541";
		
		Usuario usuario=new Usuario(username,password,realname,telefono);
		
		Assert.assertEquals("el usuario no es el mismo",username,usuario.getUsserName());
		Assert.assertEquals("la password no es la misma",password,usuario.getPassword());
		Assert.assertEquals("el realname no es el mismo",realname,usuario.getRealName());
		Assert.assertEquals("el telefono no es el mismo",telefono,usuario.getTelefono());
	}
	@Test
	public void test2() {
		String username="pepe21";
		String password="abc";
		String realname="pepe";
		String telefono="";
		
		Usuario usuario=new Usuario(username,password,realname,telefono);
		
		Assert.assertEquals("el usuario no es el mismo",username,usuario.getUsserName());
		Assert.assertEquals("la password no es la misma",password,usuario.getPassword());
		Assert.assertEquals("el realname no es el mismo",realname,usuario.getRealName());
		Assert.assertEquals("el telefono no es el mismo",telefono,usuario.getTelefono());
	}
	@Test
	public void test3() {
		String username="pepe21";
		String password="abc";
		String realname="pepe";
		String telefono="5487541";
		
		Usuario usuario=new Usuario(username,password,realname,telefono);
		
		Assert.assertEquals("el usuario no es el mismo",username,usuario.getUsserName());
		Assert.assertEquals("la password no es la misma",password,usuario.getPassword());
		Assert.assertEquals("el realname no es el mismo",realname,usuario.getRealName());
		Assert.assertEquals("el telefono no es el mismo",telefono,usuario.getTelefono());
	}

}

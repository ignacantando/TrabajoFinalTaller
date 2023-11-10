package testModeloDatos;


import org.junit.Assert;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modeloDatos.Cliente;
import modeloDatos.ClientePuntaje;
import modeloDatos.Empleador;
import modeloDatos.Usuario;
import util.Constantes;

public class TestClientePuntaje {

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
		String realname="pepe";
		String telefono="5487541";
		double puntaje=-25;
		
		Empleador cliente=new Empleador(username,password,realname,telefono,Constantes.SALUD,Constantes.JURIDICA);
		
		ClientePuntaje clientepuntaje=new ClientePuntaje(puntaje,cliente);
		
		Assert.assertEquals(cliente,clientepuntaje.getCliente());
		Assert.assertEquals("No coincide el puntaje",puntaje,clientepuntaje.getPuntaje(),0.001);
	}
	
	@Test
	public void test2() {
		String username="pepe21";
		String password="abc";
		String realname="pepe";
		String telefono="5487541";
		double puntaje=0;
		
		Empleador cliente=new Empleador(username,password,realname,telefono,Constantes.SALUD,Constantes.JURIDICA);
		
		ClientePuntaje clientepuntaje=new ClientePuntaje(puntaje,cliente);
		
		Assert.assertEquals(cliente,clientepuntaje.getCliente());
		Assert.assertEquals("No coincide el puntaje",puntaje,clientepuntaje.getPuntaje(),0.001);
	}
	
	@Test
	public void test3() {
		String username="pepe21";
		String password="abc";
		String realname="pepe";
		String telefono="5487541";
		double puntaje=25;
		
		Empleador cliente=new Empleador(username,password,realname,telefono,Constantes.SALUD,Constantes.JURIDICA);
		
		ClientePuntaje clientepuntaje=new ClientePuntaje(puntaje,cliente);
		
		Assert.assertEquals(cliente,clientepuntaje.getCliente());
		Assert.assertEquals("No coincide el puntaje",puntaje,clientepuntaje.getPuntaje(),0.001);
	}
	
	@Test
	public void test4() {
		String username="";
		String password="";
		String realname="";
		String telefono="";
		double puntaje=25;
		
		Empleador cliente=new Empleador(username,password,realname,telefono,Constantes.SALUD,Constantes.JURIDICA);
		
		ClientePuntaje clientepuntaje=new ClientePuntaje(puntaje,cliente);
		
		Assert.assertEquals(cliente,clientepuntaje.getCliente());
		Assert.assertEquals("No coincide el puntaje",puntaje,clientepuntaje.getPuntaje(),0.001);
		
	}

}

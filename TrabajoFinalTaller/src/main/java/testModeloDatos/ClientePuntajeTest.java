package testModeloDatos;


import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modeloDatos.ClientePuntaje;
import modeloDatos.Empleador;
import util.Constantes;

public class ClientePuntajeTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructor1() {
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
	public void testConstructor2() {
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
	public void testConstructor3() {
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
	public void testConstructor4() {
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

	@Test
	public void testSetCliente(){
		String username="pepe21";
		String password="abc";
		String realname="pepe";
		String telefono="5487541";
		double puntaje=25;

		Empleador cliente=new Empleador(username,password,realname,telefono,Constantes.SALUD,Constantes.JURIDICA);
		Empleador cliente2=new Empleador("JUAN",password,realname,telefono,Constantes.SALUD,Constantes.JURIDICA);
		ClientePuntaje clientepuntaje=new ClientePuntaje(puntaje,cliente);

		clientepuntaje.setCliente(cliente2);

		Assert.assertEquals(cliente2,clientepuntaje.getCliente());
		//SE SUPONE QUE AL SETEAR AL CLIENTE 2, QUEDA CON EL PUNTAJE DEL PRIMERO?
		/////////////////////////////////////////////////
	}

}

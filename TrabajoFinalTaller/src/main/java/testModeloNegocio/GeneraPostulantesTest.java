package testModeloNegocio;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import modeloNegocio.Agencia;
import util.Constantes;
import modeloDatos.ClientePuntaje;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import modeloDatos.Ticket;

public class GeneraPostulantesTest {
	
	Agencia agencia;

	@Before
	public void setUp() throws Exception {
		agencia=Agencia.getInstance();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void esc1() {
		HashMap<String,Empleador> empleadores=new HashMap<String,Empleador>();
		HashMap<String,EmpleadoPretenso> empleados=new HashMap<String,EmpleadoPretenso>();

		agencia.setEmpleadores(empleadores);
		agencia.setEmpleados(empleados);
		
		agencia.generaPostulantes();
	}

	@Test
	public void esc2() {
		HashMap<String,Empleador> empleadores=new HashMap<String,Empleador>();
		HashMap<String,EmpleadoPretenso> empleados=new HashMap<String,EmpleadoPretenso>();

		EmpleadoPretenso empleadoPretenso1= new EmpleadoPretenso("pepe21","123","pepe","5465","lopez",21);
		EmpleadoPretenso empleadoPretenso2 = new EmpleadoPretenso("lucas34","123","lucas","5465","gomez",24);
		
		
		empleados.put("1", empleadoPretenso1);
		empleados.put("2", empleadoPretenso2);
		
		
		agencia.setEmpleadores(empleadores);
		agencia.setEmpleados(empleados);
		
		agencia.generaPostulantes();
		
		Assert.assertNull("El esc2 no da null",empleadoPretenso1.getListaDePostulantes());
		Assert.assertNull("El esc2 no da null",empleadoPretenso2.getListaDePostulantes());
		
	}
	
	@Test
	public void esc3() {
		HashMap<String,Empleador> empleadores=new HashMap<String,Empleador>();
		HashMap<String,EmpleadoPretenso> empleados=new HashMap<String,EmpleadoPretenso>();

		EmpleadoPretenso empleadoPretenso1= new EmpleadoPretenso("pepe21","123","pepe","5465","lopez",21);
		EmpleadoPretenso empleadoPretenso2 = new EmpleadoPretenso("lucas34","123","lucas","5465","gomez",24);

		Empleador empleador1 = new Empleador("luis","123","luis","6546",Constantes.SALUD,Constantes.JURIDICA);
		Empleador empleador2 = new Empleador("pedro","123","pedro","6546",Constantes.SALUD,Constantes.JURIDICA);
		
		empleados.put("1", empleadoPretenso1);
		empleados.put("2", empleadoPretenso2);

		
		empleadores.put("1",empleador1);
		empleadores.put("2",empleador2);
		
		agencia.setEmpleadores(empleadores);
		agencia.setEmpleados(empleados);
		
		agencia.generaPostulantes();
		
		Assert.assertNull("El esc2 no da null",empleadoPretenso1.getListaDePostulantes());
		Assert.assertNull("El esc2 no da null",empleadoPretenso2.getListaDePostulantes());
		
		Assert.assertNull("El esc2 no da null",empleador1.getListaDePostulantes());
		Assert.assertNull("El esc2 no da null",empleador2.getListaDePostulantes());
		
		
	}
	
	@Test
	public void esc4() {
		HashMap<String,Empleador> empleadores=new HashMap<String,Empleador>();
		HashMap<String,EmpleadoPretenso> empleados=new HashMap<String,EmpleadoPretenso>();

		EmpleadoPretenso empleadoPretenso1= new EmpleadoPretenso("pepe21","123","pepe","5465","lopez",21);
		EmpleadoPretenso empleadoPretenso2 = new EmpleadoPretenso("lucas34","123","lucas","5465","gomez",24);

		
		
		Empleador empleador1 = new Empleador("luis","123","luis","6546",Constantes.SALUD,Constantes.JURIDICA);
		Empleador empleador2 = new Empleador("pedro","123","pedro","6546",Constantes.SALUD,Constantes.JURIDICA);
		
		
		
		empleados.put("1", empleadoPretenso1);
		empleados.put("2", empleadoPretenso2);

		
		empleadores.put("1",empleador1);
		empleadores.put("2",empleador2);

		
		agencia.setEmpleadores(empleadores);
		agencia.setEmpleados(empleados);
		
		Ticket ticket=new Ticket(Constantes.HOME_OFFICE,150000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.SECUNDARIOS);
		Ticket ticket2=new Ticket(Constantes.PRESENCIAL,100000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.SECUNDARIOS);
		

		Ticket ticket4=new Ticket(Constantes.HOME_OFFICE,150000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.SECUNDARIOS);
		Ticket ticket5=new Ticket(Constantes.PRESENCIAL,100000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.SECUNDARIOS);
		

		empleadoPretenso1.setTicket(ticket);
		empleadoPretenso2.setTicket(ticket2);
		
		
		empleador1.setTicket(ticket4);
		empleador2.setTicket(ticket5);
		
		agencia.generaPostulantes();
	
		ArrayList<ClientePuntaje> c1=new ArrayList<ClientePuntaje>();
		
		ClientePuntaje cl1=new ClientePuntaje(5.0,empleador1);
		ClientePuntaje cl2=new ClientePuntaje(3.0,empleador2);
	
		c1.add(cl1);
		c1.add(cl2);
		
		ArrayList<ClientePuntaje> c2=new ArrayList<ClientePuntaje>();
		
		ClientePuntaje cl3=new ClientePuntaje(5.0,empleador2);
		ClientePuntaje cl4=new ClientePuntaje(3.0,empleador1);
	
		c2.add(cl3);
		c2.add(cl4);
		
		ArrayList<ClientePuntaje> c3=new ArrayList<ClientePuntaje>();
		
		ClientePuntaje cl5=new ClientePuntaje(5.0,empleadoPretenso1);
		ClientePuntaje cl6=new ClientePuntaje(3.0,empleadoPretenso2);
	
		c3.add(cl5);
		c3.add(cl6);
		ArrayList<ClientePuntaje> c4=new ArrayList<ClientePuntaje>();
		
		ClientePuntaje cl7=new ClientePuntaje(5.0,empleadoPretenso2);
		ClientePuntaje cl8=new ClientePuntaje(3.0,empleadoPretenso1);
	
		c4.add(cl7);
		c4.add(cl8);
		
		Assert.assertEquals(c1.get(0).getPuntaje(),empleadoPretenso1.getListaDePostulantes().get(0).getPuntaje(),0.01);
		Assert.assertEquals(c1.get(1).getPuntaje(),empleadoPretenso1.getListaDePostulantes().get(1).getPuntaje(),0.01);
		Assert.assertEquals(c1.get(0).getCliente(),empleadoPretenso1.getListaDePostulantes().get(0).getCliente());
		Assert.assertEquals(c1.get(1).getCliente(),empleadoPretenso1.getListaDePostulantes().get(1).getCliente());
		
		
		Assert.assertEquals(c2.get(0).getPuntaje(),empleadoPretenso2.getListaDePostulantes().get(0).getPuntaje(),0.01);
		Assert.assertEquals(c2.get(1).getPuntaje(),empleadoPretenso2.getListaDePostulantes().get(1).getPuntaje(),0.01);
		Assert.assertEquals(c2.get(0).getCliente(),empleadoPretenso2.getListaDePostulantes().get(0).getCliente());
		Assert.assertEquals(c2.get(1).getCliente(),empleadoPretenso2.getListaDePostulantes().get(1).getCliente());
		
		
		Assert.assertEquals(c3.get(0).getPuntaje(),empleador1.getListaDePostulantes().get(0).getPuntaje(),0.01);
		Assert.assertEquals(c3.get(1).getPuntaje(),empleador1.getListaDePostulantes().get(1).getPuntaje(),0.01);
		Assert.assertEquals(c3.get(0).getCliente(),empleador1.getListaDePostulantes().get(0).getCliente());
		Assert.assertEquals(c3.get(1).getCliente(),empleador1.getListaDePostulantes().get(1).getCliente());
		
		
		Assert.assertEquals(c4.get(0).getPuntaje(),empleador2.getListaDePostulantes().get(0).getPuntaje(),0.01);
		Assert.assertEquals(c4.get(1).getPuntaje(),empleador2.getListaDePostulantes().get(1).getPuntaje(),0.01);
		Assert.assertEquals(c4.get(0).getCliente(),empleador2.getListaDePostulantes().get(0).getCliente());
		Assert.assertEquals(c4.get(1).getCliente(),empleador2.getListaDePostulantes().get(1).getCliente());

	}

}

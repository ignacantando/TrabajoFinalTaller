package testModeloNegocio;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modeloDatos.ClientePuntaje;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import modeloDatos.Ticket;
import modeloNegocio.Agencia;
import util.Constantes;
import util.Mensajes;

public class GatillarRondaTest {

	Agencia agencia;
	@Before
	public void setUp() throws Exception {
		agencia=Agencia.getInstance();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testesc1() {
		agencia.setEstadoContratacion(true);
		agencia.gatillarRonda();
		
		Assert.assertEquals(agencia.getEstado(),Mensajes.AGENCIA_EN_BUSQUEDA.getValor());
	}
	@Test
	public void testesc2() {
		agencia.setEstadoContratacion(false);
		agencia.gatillarRonda();
		
		Assert.assertEquals(agencia.getEstado(),Mensajes.AGENCIA_EN_CONTRATACION.getValor());
		
	}
	@Test
	public void testesc3() {
		EmpleadoPretenso empleadoPretenso1= new EmpleadoPretenso("pepe21","123","pepe","5465","lopez",21);
		EmpleadoPretenso empleadoPretenso2 = new EmpleadoPretenso("lucas34","123","lucas","5465","gomez",24);
		
		HashMap<String,EmpleadoPretenso> empleados=new HashMap<String,EmpleadoPretenso>();
		
		empleados.put("1", empleadoPretenso1);
		empleados.put("2", empleadoPretenso2);
	
		Ticket ticket = new Ticket(Constantes.HOME_OFFICE,150000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.SECUNDARIOS);
	    Ticket ticket2 = new Ticket(Constantes.PRESENCIAL,100000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_MEDIA,Constantes.SECUNDARIOS);
		
	    empleadoPretenso1.setTicket(ticket);
	    empleadoPretenso2.setTicket(ticket2);
	    
		agencia.setEmpleados(empleados);
		
		agencia.setEstadoContratacion(true);
		
		agencia.gatillarRonda();
	    
		Assert.assertEquals(0,empleadoPretenso1.getPuntaje());
		Assert.assertEquals(0,empleadoPretenso2.getPuntaje());
		Assert.assertEquals(agencia.getEstado(),Mensajes.AGENCIA_EN_BUSQUEDA.getValor());
		Assert.assertNull(empleadoPretenso1.getListaDePostulantes());
		Assert.assertNull(empleadoPretenso2.getListaDePostulantes());
	}
	@Test
	public void testesc4() {
		Empleador empleador1 = new Empleador("luis","123","luis","6546",Constantes.SALUD,Constantes.JURIDICA);
		Empleador empleador2 = new Empleador("pedro","123","pedro","6546",Constantes.SALUD,Constantes.JURIDICA);
		
		HashMap<String,Empleador> empleadores=new HashMap<String,Empleador>();
		
		empleadores.put("1", empleador1);
		empleadores.put("2", empleador2);
		
		Ticket ticket3 = new Ticket(Constantes.HOME_OFFICE,150000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.SECUNDARIOS);
	    Ticket ticket4 = new Ticket(Constantes.PRESENCIAL,100000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_MEDIA,Constantes.SECUNDARIOS);
		
	    empleador1.setTicket(ticket3);
	    empleador2.setTicket(ticket4);
	    
		agencia.setEmpleadores(empleadores);
		agencia.setEstadoContratacion(false);
		
		HashMap<String,EmpleadoPretenso> empleados=new HashMap<String,EmpleadoPretenso>();
		agencia.setEmpleados(empleados);
		
		agencia.gatillarRonda();
	    
		ArrayList<ClientePuntaje> c= new ArrayList<ClientePuntaje>();
		
		Assert.assertEquals(c,empleador1.getListaDePostulantes());  //no miro si los genera bien ya que eso lo testeamos en generapostulante
		Assert.assertEquals(c,empleador2.getListaDePostulantes());
		Assert.assertEquals(0,empleador1.getPuntaje());
		Assert.assertEquals(0,empleador2.getPuntaje());
		Assert.assertEquals(agencia.getEstado(),Mensajes.AGENCIA_EN_CONTRATACION.getValor());
	}

	@Test
	public void testesc5() {
		/*
		 * Empleados{pepe21{luis,leo},lucas34{leo,fran},tomas98{luis,pedro}}
		 *	Empleadores{luis{pepe21,tomas98},pedro{tomas98},leo{pepe21,lucas34},fran{lucas34}}
		 */
		
		EmpleadoPretenso empleadoPretenso1= new EmpleadoPretenso("pepe21","123","pepe","5465","lopez",21);
		EmpleadoPretenso empleadoPretenso2 = new EmpleadoPretenso("lucas34","123","lucas","5465","gomez",24);
		
		
		
		Empleador empleador1 = new Empleador("luis","123","luis","6546",Constantes.SALUD,Constantes.JURIDICA);
		Empleador empleador2 = new Empleador("pedro","123","pedro","6546",Constantes.SALUD,Constantes.JURIDICA);
		
		
		HashMap<String,Empleador> empleadores=new HashMap<String,Empleador>();
		HashMap<String,EmpleadoPretenso> empleados=new HashMap<String,EmpleadoPretenso>();
		
		empleados.put("1", empleadoPretenso1);
		empleados.put("2", empleadoPretenso2);
	
		
		empleadores.put("1", empleador1);
		empleadores.put("2", empleador2);

		Ticket ticket = new Ticket(Constantes.HOME_OFFICE,150000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.SECUNDARIOS);
	    Ticket ticket2 = new Ticket(Constantes.PRESENCIAL,100000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_MEDIA,Constantes.SECUNDARIOS);
		
		Ticket ticket3 = new Ticket(Constantes.HOME_OFFICE,150000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.SECUNDARIOS);
	    Ticket ticket4 = new Ticket(Constantes.PRESENCIAL,100000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_MEDIA,Constantes.SECUNDARIOS);
		
	    empleadoPretenso1.setTicket(ticket);
	    empleadoPretenso2.setTicket(ticket2);
	    
	    empleador1.setTicket(ticket3);
	    empleador2.setTicket(ticket4);
	    
	    
	    
		agencia.setEmpleadores(empleadores);
		agencia.setEmpleados(empleados);
		
		agencia.setEstadoContratacion(false);
		
		agencia.gatillarRonda();
		
		Assert.assertNotNull(empleador1.getListaDePostulantes());  //no miro si los genera bien ya que eso lo testeamos en generapostulante
		Assert.assertNotNull(empleador2.getListaDePostulantes());
		Assert.assertNotNull(empleadoPretenso1.getListaDePostulantes());
		Assert.assertNotNull(empleadoPretenso2.getListaDePostulantes());
		
		Assert.assertEquals(agencia.getEstado(),Mensajes.AGENCIA_EN_CONTRATACION.getValor());
	}

	@Test
	public void testesc6() {
		EmpleadoPretenso empleadoPretenso1= new EmpleadoPretenso("pepe21","123","pepe","5465","lopez",21);
		EmpleadoPretenso empleadoPretenso2 = new EmpleadoPretenso("lucas34","123","lucas","5465","gomez",24);
		
		
		
		Empleador empleador1 = new Empleador("luis","123","luis","6546",Constantes.SALUD,Constantes.JURIDICA);
		Empleador empleador2 = new Empleador("pedro","123","pedro","6546",Constantes.SALUD,Constantes.JURIDICA);
		
		
		HashMap<String,Empleador> empleadores=new HashMap<String,Empleador>();
		HashMap<String,EmpleadoPretenso> empleados=new HashMap<String,EmpleadoPretenso>();
		
		empleados.put("1", empleadoPretenso1);
		empleados.put("2", empleadoPretenso2);
	
		
		empleadores.put("1", empleador1);
		empleadores.put("2", empleador2);

		Ticket ticket = new Ticket(Constantes.HOME_OFFICE,150000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.SECUNDARIOS);
	    Ticket ticket2 = new Ticket(Constantes.PRESENCIAL,100000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_MEDIA,Constantes.SECUNDARIOS);
		
		Ticket ticket3 = new Ticket(Constantes.HOME_OFFICE,150000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.SECUNDARIOS);
	    Ticket ticket4 = new Ticket(Constantes.PRESENCIAL,100000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_MEDIA,Constantes.SECUNDARIOS);
		
	    empleadoPretenso1.setTicket(ticket);
	    empleadoPretenso2.setTicket(ticket2);
	    
	    empleador1.setTicket(ticket3);
	    empleador2.setTicket(ticket4);
	    
	    
	    
		agencia.setEmpleadores(empleadores);
		agencia.setEmpleados(empleados);
		
		agencia.setEstadoContratacion(false);
		
		agencia.gatillarRonda();
		
		
		empleadoPretenso1.setCandidato(empleador1);
		empleador1.setCandidato(empleadoPretenso1);
		
		
		
		empleadoPretenso1.setPuntaje(0);
		empleadoPretenso2.setPuntaje(0);
		
		empleador1.setPuntaje(0);
		empleador2.setPuntaje(0);
		//---------------------------------------------------------------------------------------------
		
		
		agencia.gatillarRonda();
		
		Assert.assertEquals(10,empleadoPretenso1.getPuntaje());
		Assert.assertEquals(50,empleador1.getPuntaje());

		Assert.assertEquals(0,empleadoPretenso2.getPuntaje());
		
		
		Assert.assertNull(empleador1.getListaDePostulantes()); 
		Assert.assertNull(empleador2.getListaDePostulantes());
		Assert.assertNull(empleadoPretenso1.getListaDePostulantes());
		Assert.assertNull(empleadoPretenso2.getListaDePostulantes());
		
		Assert.assertEquals(agencia.getEstado(),Mensajes.AGENCIA_EN_BUSQUEDA.getValor());
		
		Assert.assertEquals(-20,empleador2.getPuntaje());  //Esta mal 
	}
	
}

package testModeloNegocio;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import excepciones.ContraException;
import excepciones.ImposibleCrearEmpleadoException;
import excepciones.ImposibleCrearEmpleadorException;
import excepciones.ImposibleModificarTicketsException;
import excepciones.NewRegisterException;
import excepciones.NombreUsuarioException;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Ticket;
import modeloNegocio.Agencia;
import util.Constantes;

public class CrearTicketEmpleadoTest {
	
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
		EmpleadoPretenso empleadoPretenso1= new EmpleadoPretenso("pepe21","123","pepe","5465","lopez",21);
		
		Ticket ticket=new Ticket(Constantes.HOME_OFFICE,1000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		empleadoPretenso1.setTicket(ticket);
	
		try {
			agencia.registroEmpleado("luis","123","luis","lopez","6546",26);
		} catch (NewRegisterException e) {
			e.printStackTrace();
		} catch (ImposibleCrearEmpleadoException e) {
			e.printStackTrace();
		}
	
		try {
			agencia.login("luis","123");
		} catch (ContraException e) {
			e.printStackTrace();
		} catch (NombreUsuarioException e) {
			e.printStackTrace();
		}
		
		agencia.setEstadoContratacion(false);
		try {
			agencia.crearTicketEmpleado(Constantes.HOME_OFFICE, 1000, Constantes.JORNADA_MEDIA, Constantes.JUNIOR, Constantes.EXP_NADA, Constantes.PRIMARIOS, empleadoPretenso1);
		} catch (ImposibleModificarTicketsException e) {
			fail();
		}

		Assert.assertEquals("El esc1 da error",Constantes.HOME_OFFICE,empleadoPretenso1.getTicket().getLocacion());
		Assert.assertEquals("El esc1 da error",1000,empleadoPretenso1.getTicket().getRemuneracion());
		Assert.assertEquals("El esc1 da error",Constantes.JORNADA_MEDIA,empleadoPretenso1.getTicket().getJornada());
		Assert.assertEquals("El esc1 da error",Constantes.JUNIOR,empleadoPretenso1.getTicket().getPuesto());
		Assert.assertEquals("El esc1 da error",Constantes.EXP_NADA,empleadoPretenso1.getTicket().getExperiencia());
		Assert.assertEquals("El esc1 da error",Constantes.PRIMARIOS,empleadoPretenso1.getTicket().getEstudios());
	}

	@Test
	public void esc2() {
		EmpleadoPretenso empleadoPretenso1= new EmpleadoPretenso("pepe21","123","pepe","5465","lopez",21);
		
		agencia.setEstadoContratacion(false);
		try {
			agencia.crearTicketEmpleado(Constantes.HOME_OFFICE, 1000, Constantes.JORNADA_MEDIA, Constantes.JUNIOR, Constantes.EXP_NADA, Constantes.PRIMARIOS, empleadoPretenso1);
		} catch (ImposibleModificarTicketsException e) {
			fail();
		}
		
		Assert.assertEquals("El esc1 da error",Constantes.HOME_OFFICE,empleadoPretenso1.getTicket().getLocacion());
		Assert.assertEquals("El esc1 da error",1000,empleadoPretenso1.getTicket().getRemuneracion());
		Assert.assertEquals("El esc1 da error",Constantes.JORNADA_MEDIA,empleadoPretenso1.getTicket().getJornada());
		Assert.assertEquals("El esc1 da error",Constantes.JUNIOR,empleadoPretenso1.getTicket().getPuesto());
		Assert.assertEquals("El esc1 da error",Constantes.EXP_NADA,empleadoPretenso1.getTicket().getExperiencia());
		Assert.assertEquals("El esc1 da error",Constantes.PRIMARIOS,empleadoPretenso1.getTicket().getEstudios());
	}
	
	@Test
	public void esc3() {
		EmpleadoPretenso empleadoPretenso1= new EmpleadoPretenso("pepe21","123","pepe","5465","lopez",21);
		
		agencia.setEstadoContratacion(true);
		try {
			agencia.crearTicketEmpleado(Constantes.HOME_OFFICE, 1000, Constantes.JORNADA_MEDIA, Constantes.JUNIOR, Constantes.EXP_NADA, Constantes.PRIMARIOS, empleadoPretenso1);
		} catch (ImposibleModificarTicketsException e) {
			
		}
	}

}

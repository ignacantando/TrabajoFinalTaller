package testModeloNegocio;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import excepciones.ContraException;
import excepciones.ImposibleCrearEmpleadorException;
import excepciones.ImposibleModificarTicketsException;
import excepciones.NewRegisterException;
import excepciones.NombreUsuarioException;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import modeloDatos.Ticket;
import modeloNegocio.Agencia;
import util.Constantes;
import util.Mensajes;

public class CrearTicketEmpleadorTest {

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
		Empleador empleador1 = new Empleador("luis","123","luis","6546",Constantes.SALUD,Constantes.JURIDICA);
		
		
		Ticket ticket=new Ticket(Constantes.HOME_OFFICE,20000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);

		empleador1.setTicket(ticket);
		
		try {
			agencia.registroEmpleador("luis","123","luis","6546",Constantes.JURIDICA,Constantes.SALUD);
		} catch (NewRegisterException e) {
			e.printStackTrace();
		} catch (ImposibleCrearEmpleadorException e) {
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
			agencia.crearTicketEmpleado(Constantes.HOME_OFFICE, 1000, Constantes.JORNADA_MEDIA, Constantes.JUNIOR, Constantes.EXP_NADA, Constantes.PRIMARIOS,empleador1);
		} catch (ImposibleModificarTicketsException e) {
			fail();
		}

		Assert.assertEquals("El esc1 da error",Constantes.HOME_OFFICE,empleador1.getTicket().getLocacion());
		Assert.assertEquals("El esc1 da error",1000,empleador1.getTicket().getRemuneracion());
		Assert.assertEquals("El esc1 da error",Constantes.JORNADA_MEDIA,empleador1.getTicket().getJornada());
		Assert.assertEquals("El esc1 da error",Constantes.JUNIOR,empleador1.getTicket().getPuesto());
		Assert.assertEquals("El esc1 da error",Constantes.EXP_NADA,empleador1.getTicket().getExperiencia());
		Assert.assertEquals("El esc1 da error",Constantes.PRIMARIOS,empleador1.getTicket().getEstudios());
	}
	
	@Test
	public void esc2() {
		Empleador empleador1 = new Empleador("luis","123","luis","6546",Constantes.SALUD,Constantes.JURIDICA);
		
		agencia.setEstadoContratacion(false);
		try {
			agencia.crearTicketEmpleado(Constantes.HOME_OFFICE, 1000, Constantes.JORNADA_MEDIA, Constantes.JUNIOR, Constantes.EXP_NADA, Constantes.PRIMARIOS, empleador1);
		} catch (ImposibleModificarTicketsException e) {
			fail();
		}
		
		Assert.assertEquals("El esc1 da error",Constantes.HOME_OFFICE,empleador1.getTicket().getLocacion());
		Assert.assertEquals("El esc1 da error",1000,empleador1.getTicket().getRemuneracion());
		Assert.assertEquals("El esc1 da error",Constantes.JORNADA_MEDIA,empleador1.getTicket().getJornada());
		Assert.assertEquals("El esc1 da error",Constantes.JUNIOR,empleador1.getTicket().getPuesto());
		Assert.assertEquals("El esc1 da error",Constantes.EXP_NADA,empleador1.getTicket().getExperiencia());
		Assert.assertEquals("El esc1 da error",Constantes.PRIMARIOS,empleador1.getTicket().getEstudios());
	}
	
	@Test
	public void esc3() {
		EmpleadoPretenso empleadoPretenso1= new EmpleadoPretenso("pepe21","123","pepe","5465","lopez",21);
		
		agencia.setEstadoContratacion(true);
		try {
			agencia.crearTicketEmpleado(Constantes.HOME_OFFICE, 1000, Constantes.JORNADA_MEDIA, Constantes.JUNIOR, Constantes.EXP_NADA, Constantes.PRIMARIOS, empleadoPretenso1);
			Assert.fail("Deberia lanzar excepcion");
		} catch (ImposibleModificarTicketsException e) {
			Assert.assertEquals(Mensajes.ERROR_AGENCIA_EN_CONTRATACION.getValor(),e.getMessage());
		}
	}

}

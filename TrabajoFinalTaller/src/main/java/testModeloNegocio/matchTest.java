package testModeloNegocio;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modeloDatos.ClientePuntaje;
import modeloDatos.Contratacion;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import modeloDatos.Ticket;
import modeloNegocio.Agencia;
import util.Constantes;

public class matchTest {
	
	Agencia agencia;

	@Before
	public void setUp() throws Exception {
		agencia=Agencia.getInstance();

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Ticket ticket=new Ticket(Constantes.HOME_OFFICE,1000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		
		EmpleadoPretenso empleadoPretenso1= new EmpleadoPretenso("pepe21","123","pepe","5465","lopez",21);
		empleadoPretenso1.setPuntaje(0);
		empleadoPretenso1.setTicket(ticket);
		
		Empleador empleador1 = new Empleador("luis","123","luis","6546",Constantes.SALUD,Constantes.JURIDICA);
		empleador1.setPuntaje(0);
		empleador1.setTicket(ticket);
		
		agencia.match(empleador1, empleadoPretenso1);
		
		Assert.assertEquals("esc1 hay error",50,empleador1.getPuntaje()); 
		Assert.assertEquals("esc1 hay error",10,empleadoPretenso1.getPuntaje());
		
		
		ArrayList<Contratacion> c1=new ArrayList<Contratacion>();
	
		Assert.assertNotEquals("esc1 hay error",c1, agencia.getContrataciones());
		
		
		Assert.assertNull(empleadoPretenso1.getTicket());
		Assert.assertNull(empleador1.getTicket());
	}

}

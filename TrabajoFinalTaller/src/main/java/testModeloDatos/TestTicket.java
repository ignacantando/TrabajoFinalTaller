package testModeloDatos;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import excepciones.ImposibleModificarTicketsException;
import excepciones.LimiteInferiorRemuneracionInvalidaException;
import excepciones.LimiteSuperiorRemuneracionInvalidaException;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Ticket;
import modeloNegocio.Agencia;
import util.Constantes;

public class TestTicket {

	Ticket ticket;
	Ticket ticket2;
	Ticket ticket3;
	@Before
	public void setUp() throws Exception {
		//exc 1 (hacer todos los escenarios)
		ticket=new Ticket(Constantes.HOME_OFFICE,1000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		
		//exc2
		ticket2=new Ticket(Constantes.PRESENCIAL,1000,Constantes.JORNADA_COMPLETA,Constantes.SENIOR,Constantes.EXP_MEDIA,Constantes.SECUNDARIOS);
		
		//exc3
		ticket3=new Ticket(Constantes.INDISTINTO,1000,Constantes.JORNADA_EXTENDIDA,Constantes.MANAGMENT,Constantes.EXP_MUCHA,Constantes.TERCIARIOS);
	}

	@After
	public void tearDown() throws Exception {
	}

	
	
	@Test
	public void testComparacionLocation() {
		Ticket otro1=new Ticket(Constantes.HOME_OFFICE,1000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		Ticket otro2=new Ticket(Constantes.PRESENCIAL,1000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		Ticket otro3=new Ticket(Constantes.INDISTINTO,1000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		
		Assert.assertEquals("No coincide el getLocacion",1,ticket.getComparacionLocacion(otro1),0.0001);
		Assert.assertEquals("No coincide el getLocacion",-1,ticket.getComparacionLocacion(otro2),0.0001);
		Assert.assertEquals("No coincide el getLocacion",1,ticket.getComparacionLocacion(otro3),0.0001);
	}

	@Test
	public void testComparacionJornada() {
		Ticket otro1=new Ticket(Constantes.HOME_OFFICE,1000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		Ticket otro2=new Ticket(Constantes.PRESENCIAL,1000,Constantes.JORNADA_COMPLETA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		Ticket otro3=new Ticket(Constantes.INDISTINTO,1000,Constantes.JORNADA_EXTENDIDA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		
		Assert.assertEquals("No coincide el getJornada",1,ticket.getComparacionJornada(otro1),0.0001);
		Assert.assertEquals("No coincide el getJornada",-0.5,ticket.getComparacionJornada(otro2),0.0001);
		Assert.assertEquals("No coincide el getJornada",-1,ticket.getComparacionJornada(otro3),0.0001);
	}
	@Test
	public void testComparacionPuesto() {
		Ticket otro1=new Ticket(Constantes.HOME_OFFICE,1000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		Ticket otro2=new Ticket(Constantes.PRESENCIAL,1000,Constantes.JORNADA_MEDIA,Constantes.SENIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		Ticket otro3=new Ticket(Constantes.INDISTINTO,1000,Constantes.JORNADA_MEDIA,Constantes.MANAGMENT,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		
		Assert.assertEquals("No coincide el getPuesto",1,ticket.getComparacionPuesto(otro1),0.0001);
		Assert.assertEquals("No coincide el getPuesto",-0.5,ticket.getComparacionPuesto(otro2),0.0001);
		Assert.assertEquals("No coincide el getPuesto",-1,ticket.getComparacionPuesto(otro3),0.0001);
	}
	@Test
	public void testComparacionEstudios() {
		Ticket otro1=new Ticket(Constantes.HOME_OFFICE,1000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		Ticket otro2=new Ticket(Constantes.PRESENCIAL,1000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.SECUNDARIOS);
		Ticket otro3=new Ticket(Constantes.INDISTINTO,1000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.TERCIARIOS);
		
		Assert.assertEquals("No coincide el getEstudios",1,ticket.getComparacionEstudios(otro1),0.0001);
		Assert.assertEquals("No coincide el getEstudios",1.5,ticket.getComparacionEstudios(otro2),0.0001);
		Assert.assertEquals("No coincide el getEstudios",2,ticket.getComparacionEstudios(otro3),0.0001);
	}
	@Test
	public void testComparacionExperiencia() {
		Ticket otro1=new Ticket(Constantes.HOME_OFFICE,1000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		Ticket otro2=new Ticket(Constantes.PRESENCIAL,1000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_MEDIA,Constantes.PRIMARIOS);
		Ticket otro3=new Ticket(Constantes.INDISTINTO,1000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_MUCHA,Constantes.PRIMARIOS);
		
		Assert.assertEquals("No coincide el getExperiencia",1,ticket.getComparacionExperiencia(otro1),0.0001);
		Assert.assertEquals("No coincide el getExperiencia",1.5,ticket.getComparacionExperiencia(otro2),0.0001);
		Assert.assertEquals("No coincide el getExperiencia",2,ticket.getComparacionExperiencia(otro3),0.0001);
	}
	@Test
	public void testSetRenumeracion() {
		ticket.setRemuneracion(1000);
		Assert.assertEquals("No coincide la renumeracion",1000,ticket.getRemuneracion(),0.0001);
	}
	
	@Test
	public void testComparacionRenumeracion() {
		Agencia agencia= Agencia.getInstance();
		try {
			agencia.setLimitesRemuneracion(5000,15000);
		} catch (LimiteSuperiorRemuneracionInvalidaException | LimiteInferiorRemuneracionInvalidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EmpleadoPretenso empleado=new EmpleadoPretenso();
		try {
			agencia.crearTicketEmpleado("", 2500, "", "", "", "",empleado);
		} catch (ImposibleModificarTicketsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Ticket otro1=new Ticket(Constantes.HOME_OFFICE,2600,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		Ticket otro2=new Ticket(Constantes.PRESENCIAL,5500,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_MEDIA,Constantes.PRIMARIOS);
		Ticket otro3=new Ticket(Constantes.INDISTINTO,20000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_MUCHA,Constantes.PRIMARIOS);
		
		Assert.assertEquals("No coincide el getRenumeracion",1,ticket.getComparacionRemuneracion(otro1),0.0001);
		Assert.assertEquals("No coincide el getRenumeracion",-1,ticket.getComparacionRemuneracion(otro3),0.0001);
		Assert.assertEquals("No coincide el getRenumeracion",-0.5,ticket.getComparacionRemuneracion(otro2),0.0001);//este esta mal
	}
		
	
	@Test
	public void testComparacionTotal() {
		Ticket otro1=new Ticket(Constantes.HOME_OFFICE,2600,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		Ticket otro2=new Ticket(Constantes.PRESENCIAL,5500,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_MEDIA,Constantes.PRIMARIOS);
		Ticket otro3=new Ticket(Constantes.INDISTINTO,20000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_MUCHA,Constantes.PRIMARIOS);
		//Assert.assertEquals("No coincide el getRenumeracion",6,ticket.getComparacionTotal(otro1),0.0001);//se supone que los totales dan mal ya que los otros gets dieron mal
		Assert.assertEquals("No coincide el getRenumeracion",0.5,ticket.getComparacionTotal(otro2),0.0001);
		Assert.assertEquals("No coincide el getRenumeracion",3,ticket.getComparacionTotal(otro3),0.0001);
	}
	
	//Exc 2
	
	@Test
	public void testComparacionLocation2() {
		Ticket otro1=new Ticket(Constantes.HOME_OFFICE,1000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		Ticket otro2=new Ticket(Constantes.PRESENCIAL,1000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		Ticket otro3=new Ticket(Constantes.INDISTINTO,1000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		
		Assert.assertEquals("No coincide el getLocacion",-1,ticket2.getComparacionLocacion(otro1),0.0001);
		Assert.assertEquals("No coincide el getLocacion",1,ticket2.getComparacionLocacion(otro2),0.0001);
		Assert.assertEquals("No coincide el getLocacion",-1,ticket2.getComparacionLocacion(otro3),0.0001);
	}

	@Test
	public void testComparacionJornada2() {
		Ticket otro1=new Ticket(Constantes.HOME_OFFICE,1000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		Ticket otro2=new Ticket(Constantes.PRESENCIAL,1000,Constantes.JORNADA_COMPLETA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		Ticket otro3=new Ticket(Constantes.INDISTINTO,1000,Constantes.JORNADA_EXTENDIDA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		
		Assert.assertEquals("No coincide el getJornada",-0.5,ticket2.getComparacionJornada(otro1),0.0001);
		Assert.assertEquals("No coincide el getJornada",1,ticket2.getComparacionJornada(otro2),0.0001);
		Assert.assertEquals("No coincide el getJornada",-0.5,ticket2.getComparacionJornada(otro3),0.0001);
	}
	@Test
	public void testComparacionPuesto2() {
		Ticket otro1=new Ticket(Constantes.HOME_OFFICE,1000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		Ticket otro2=new Ticket(Constantes.PRESENCIAL,1000,Constantes.JORNADA_MEDIA,Constantes.SENIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		Ticket otro3=new Ticket(Constantes.INDISTINTO,1000,Constantes.JORNADA_MEDIA,Constantes.MANAGMENT,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		
		Assert.assertEquals("No coincide el getPuesto",-0.5,ticket2.getComparacionPuesto(otro1),0.0001);
		Assert.assertEquals("No coincide el getPuesto",1,ticket2.getComparacionPuesto(otro2),0.0001);
		Assert.assertEquals("No coincide el getPuesto",-0.5,ticket2.getComparacionPuesto(otro3),0.0001);
	}
	@Test
	public void testComparacionEstudios2() {
		Ticket otro1=new Ticket(Constantes.HOME_OFFICE,1000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		Ticket otro2=new Ticket(Constantes.PRESENCIAL,1000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.SECUNDARIOS);
		Ticket otro3=new Ticket(Constantes.INDISTINTO,1000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.TERCIARIOS);
		
		Assert.assertEquals("No coincide el getEstudios",-0.5,ticket2.getComparacionEstudios(otro1),0.0001);
		Assert.assertEquals("No coincide el getEstudios",1,ticket2.getComparacionEstudios(otro2),0.0001);
		Assert.assertEquals("No coincide el getEstudios",1.5,ticket2.getComparacionEstudios(otro3),0.0001);
	}
	@Test
	public void testComparacionExperiencia2() {
		Ticket otro1=new Ticket(Constantes.HOME_OFFICE,1000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		Ticket otro2=new Ticket(Constantes.PRESENCIAL,1000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_MEDIA,Constantes.PRIMARIOS);
		Ticket otro3=new Ticket(Constantes.INDISTINTO,1000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_MUCHA,Constantes.PRIMARIOS);
		
		Assert.assertEquals("No coincide el getExperiencia",-0.5,ticket2.getComparacionExperiencia(otro1),0.0001);
		Assert.assertEquals("No coincide el getExperiencia",1,ticket2.getComparacionExperiencia(otro2),0.0001);
		Assert.assertEquals("No coincide el getExperiencia",1.5,ticket2.getComparacionExperiencia(otro3),0.0001);
	}
	@Test
	public void testComparacionRenumeracion2() {
		Agencia agencia= Agencia.getInstance();
		try {
			agencia.setLimitesRemuneracion(5000,15000);
		} catch (LimiteSuperiorRemuneracionInvalidaException | LimiteInferiorRemuneracionInvalidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EmpleadoPretenso empleado=new EmpleadoPretenso();
		try {
			agencia.crearTicketEmpleado("", 5500, "", "", "", "",empleado);
		} catch (ImposibleModificarTicketsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Ticket otro1=new Ticket(Constantes.HOME_OFFICE,2600,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		Ticket otro2=new Ticket(Constantes.PRESENCIAL,5500,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_MEDIA,Constantes.PRIMARIOS);
		Ticket otro3=new Ticket(Constantes.INDISTINTO,20000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_MUCHA,Constantes.PRIMARIOS);
		
		Assert.assertEquals("No coincide el getRenumeracion",1,ticket.getComparacionRemuneracion(otro1),0.0001);
		Assert.assertEquals("No coincide el getRenumeracion",1,ticket.getComparacionRemuneracion(otro2),0.0001);
		Assert.assertEquals("No coincide el getRenumeracion",-0.5,ticket.getComparacionRemuneracion(otro3),0.0001); //este esta mal
	}
	@Test
	public void testComparacionTotal2() {
		Ticket otro1=new Ticket(Constantes.HOME_OFFICE,2600,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		Ticket otro2=new Ticket(Constantes.PRESENCIAL,5500,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_MEDIA,Constantes.PRIMARIOS);
		Ticket otro3=new Ticket(Constantes.INDISTINTO,20000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_MUCHA,Constantes.PRIMARIOS);
		
		Assert.assertEquals("No coincide el getRenumeracion",-2,ticket.getComparacionTotal(otro1),0.0001);
		Assert.assertEquals("No coincide el getRenumeracion",6,ticket.getComparacionTotal(otro2),0.0001);
		Assert.assertEquals("No coincide el getRenumeracion",0.5,ticket.getComparacionTotal(otro3),0.0001);//este esta mal
	}
	
	//Exc 3
	
	@Test
	public void testComparacionLocation3() {
		Ticket otro1=new Ticket(Constantes.HOME_OFFICE,1000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		Ticket otro2=new Ticket(Constantes.PRESENCIAL,1000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		Ticket otro3=new Ticket(Constantes.INDISTINTO,1000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		
		Assert.assertEquals("No coincide el getLocacion",1,ticket3.getComparacionLocacion(otro1),0.0001);
		Assert.assertEquals("No coincide el getLocacion",-1,ticket3.getComparacionLocacion(otro2),0.0001);
		Assert.assertEquals("No coincide el getLocacion",1,ticket3.getComparacionLocacion(otro3),0.0001);
	}

	@Test
	public void testComparacionJornada3() {
		Ticket otro1=new Ticket(Constantes.HOME_OFFICE,1000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		Ticket otro2=new Ticket(Constantes.PRESENCIAL,1000,Constantes.JORNADA_COMPLETA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		Ticket otro3=new Ticket(Constantes.INDISTINTO,1000,Constantes.JORNADA_EXTENDIDA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		
		Assert.assertEquals("No coincide el getJornada",-1,ticket3.getComparacionJornada(otro1),0.0001);
		Assert.assertEquals("No coincide el getJornada",1,ticket3.getComparacionJornada(otro2),0.0001);
		Assert.assertEquals("No coincide el getJornada",1,ticket3.getComparacionJornada(otro3),0.0001); ///da mal
	}
	@Test
	public void testComparacionPuesto3() {
		Ticket otro1=new Ticket(Constantes.HOME_OFFICE,1000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		Ticket otro2=new Ticket(Constantes.PRESENCIAL,1000,Constantes.JORNADA_MEDIA,Constantes.SENIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		Ticket otro3=new Ticket(Constantes.INDISTINTO,1000,Constantes.JORNADA_MEDIA,Constantes.MANAGMENT,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		
		Assert.assertEquals("No coincide el getPuesto",-1,ticket3.getComparacionPuesto(otro1),0.0001);
		Assert.assertEquals("No coincide el getPuesto",1,ticket3.getComparacionPuesto(otro2),0.0001);
		Assert.assertEquals("No coincide el getPuesto",1,ticket3.getComparacionPuesto(otro3),0.0001); //da mal
	}
	@Test
	public void testComparacionEstudios3() {
		Ticket otro1=new Ticket(Constantes.HOME_OFFICE,1000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		Ticket otro2=new Ticket(Constantes.PRESENCIAL,1000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.SECUNDARIOS);
		Ticket otro3=new Ticket(Constantes.INDISTINTO,1000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.TERCIARIOS);
		
		Assert.assertEquals("No coincide el getEstudios",-2,ticket3.getComparacionEstudios(otro1),0.0001);
		Assert.assertEquals("No coincide el getEstudios",-1.5,ticket3.getComparacionEstudios(otro2),0.0001);
		Assert.assertEquals("No coincide el getEstudios",1,ticket3.getComparacionEstudios(otro3),0.0001);
	}
	@Test
	public void testComparacionExperiencia3() {
		Ticket otro1=new Ticket(Constantes.HOME_OFFICE,1000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		Ticket otro2=new Ticket(Constantes.PRESENCIAL,1000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_MEDIA,Constantes.PRIMARIOS);
		Ticket otro3=new Ticket(Constantes.INDISTINTO,1000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_MUCHA,Constantes.PRIMARIOS);
		
		Assert.assertEquals("No coincide el getExperiencia",-2,ticket3.getComparacionExperiencia(otro1),0.0001);
		Assert.assertEquals("No coincide el getExperiencia",-1.5,ticket3.getComparacionExperiencia(otro2),0.0001);
		Assert.assertEquals("No coincide el getExperiencia",1,ticket3.getComparacionExperiencia(otro3),0.0001);
	}
	@Test
	public void testComparacionRenumeracion3() {
		Agencia agencia= Agencia.getInstance();
		try {
			agencia.setLimitesRemuneracion(5000,15000);
		} catch (LimiteSuperiorRemuneracionInvalidaException | LimiteInferiorRemuneracionInvalidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EmpleadoPretenso empleado=new EmpleadoPretenso();
		try {
			agencia.crearTicketEmpleado("", 2500, "", "", "", "",empleado);
		} catch (ImposibleModificarTicketsException e) {
			e.printStackTrace();
		}
		
		Ticket otro1=new Ticket(Constantes.HOME_OFFICE,2600,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		Ticket otro2=new Ticket(Constantes.PRESENCIAL,5500,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_MEDIA,Constantes.PRIMARIOS);
		Ticket otro3=new Ticket(Constantes.INDISTINTO,20000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_MUCHA,Constantes.PRIMARIOS);
		
		Assert.assertEquals("No coincide el getRenumeracion",1,ticket.getComparacionRemuneracion(otro1),0.0001);
		Assert.assertEquals("No coincide el getRenumeracion",1,ticket.getComparacionRemuneracion(otro2),0.0001);
		Assert.assertEquals("No coincide el getRenumeracion",1,ticket.getComparacionRemuneracion(otro3),0.0001);//este esta mal
	}
	@Test
	public void testComparacionTotal3() {
		Ticket otro1=new Ticket(Constantes.HOME_OFFICE,2600,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		Ticket otro2=new Ticket(Constantes.PRESENCIAL,5500,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_MEDIA,Constantes.PRIMARIOS);
		Ticket otro3=new Ticket(Constantes.INDISTINTO,20000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_MUCHA,Constantes.PRIMARIOS);
		
		Assert.assertEquals("No coincide el getRenumeracion",-4,ticket.getComparacionTotal(otro1),0.0001);
		Assert.assertEquals("No coincide el getRenumeracion",-1,ticket.getComparacionTotal(otro2),0.0001);
		Assert.assertEquals("No coincide el getRenumeracion",6,ticket.getComparacionTotal(otro3),0.0001);//este esta mal
	}
	
}

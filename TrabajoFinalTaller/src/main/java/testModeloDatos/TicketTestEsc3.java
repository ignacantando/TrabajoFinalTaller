package testModeloDatos;

import modeloDatos.ClientePuntaje;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import modeloDatos.Ticket;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.Constantes;

import java.util.ArrayList;
public class TicketTestEsc3 {

    Ticket ticket = new Ticket(Constantes.HOME_OFFICE,1000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
    Ticket ticket2 = new Ticket(Constantes.PRESENCIAL,10000,Constantes.JORNADA_COMPLETA,Constantes.SENIOR,Constantes.EXP_MEDIA,Constantes.SECUNDARIOS);
    Ticket ticket3 = new Ticket(Constantes.INDISTINTO,100000,Constantes.JORNADA_EXTENDIDA,Constantes.MANAGMENT,Constantes.EXP_MUCHA,Constantes.TERCIARIOS);

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetComparacionLocacion1(){
        Assert.assertEquals("No coincide el getLocacion",1,ticket3.getComparacionLocacion(ticket),0.0001);
    }

    @Test
    public void testGetComparacionLocacion2(){
        Assert.assertEquals("No coincide el getLocacion",-1,ticket3.getComparacionLocacion(ticket2),0.0001);
    }

    @Test
    public void testGetComparacionLocacion3(){
        Assert.assertEquals("No coincide el getLocacion",1,ticket3.getComparacionLocacion(ticket3),0.0001);
    }

    @Test
    public void testGetComparacionRenumeracion1(){
        Assert.assertEquals(("No coincide  renum"),1,ticket3.getComparacionRemuneracion(ticket),0.0001);
    }

    @Test
    public void testGetComparacionRenumeracion2(){
        Assert.assertEquals(("No coincide  renum"),1,ticket3.getComparacionRemuneracion(ticket2),0.0001);
    }

    @Test
    public void testGetComparacionRenumeracion3(){
        Assert.assertEquals(("No coincide  renum"),1,ticket3.getComparacionRemuneracion(ticket3),0.0001);
    }

    @Test
    public void testGetComparacionCargaHoraria1(){
        Assert.assertEquals(("No coincide  carga horaria"),-1,ticket3.getComparacionJornada(ticket),0.0001);
    }

    @Test
    public void testGetComparacionCargaHoraria2(){
        Assert.assertEquals(("No coincide  carga horaria"),1,ticket3.getComparacionJornada(ticket2),0.0001);
    }

    @Test
    public void testGetComparacionCargaHoraria3(){
        Assert.assertEquals(("No coincide  carga horaria"),1,ticket3.getComparacionJornada(ticket3),0.0001);
    }

    @Test
    public void testGetComparacionPuesto1(){
        Assert.assertEquals(("No coincide  puesto laboral"),-1,ticket3.getComparacionPuesto(ticket),0.0001);
    }

    @Test
    public void testGetComparacionPuesto2(){
        Assert.assertEquals(("No coincide  puesto laboral"),1,ticket3.getComparacionPuesto(ticket2),0.0001);
    }

    @Test
    public void testGetComparacionPuesto3(){
        Assert.assertEquals(("No coincide  puesto laboral"),1,ticket3.getComparacionPuesto(ticket3),0.0001);
    }

    @Test
    public void testGetComparacionExperiencia1(){
        Assert.assertEquals(("No coincide  experiencia"),-2,ticket3.getComparacionExperiencia(ticket),0.0001);
    }

    @Test
    public void testGetComparacionExperiencia2(){
        Assert.assertEquals(("No coincide  experiencia"),-1.5,ticket3.getComparacionExperiencia(ticket2),0.0001);
    }

    @Test
    public void testGetComparacionExperiencia3(){
        Assert.assertEquals(("No coincide  experiencia"),1,ticket3.getComparacionExperiencia(ticket3),0.0001);
    }

    @Test
    public void testGetComparacionEstudios1(){
        Assert.assertEquals(("No coincide estudios"),-2,ticket3.getComparacionEstudios(ticket),0.0001);
    }

    @Test
    public void testGetComparacionEstudios2(){
        Assert.assertEquals(("No coincide estudios"),-1.5,ticket3.getComparacionEstudios(ticket2),0.0001);
    }

    @Test
    public void testGetComparacionEstudios3(){
        Assert.assertEquals(("No coincide estudios"),1,ticket3.getComparacionEstudios(ticket3),0.0001);
    }

    @Test
    public void testSetRenumeracion(){
        ticket.setRemuneracion(3232);
        Assert.assertEquals("No coincide el set de renumeracion",3232,ticket.getRemuneracion());
    }

}

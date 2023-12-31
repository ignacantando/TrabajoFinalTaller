package testModeloDatos;

import modeloDatos.ClientePuntaje;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import modeloDatos.Ticket;
import modeloNegocio.Agencia;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.Constantes;

public class EmpleadoPretensoTest {



    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void testConstructor1(){
        String username="pepe21";
        String password="abc";
        String realname="";
        String telefono="5487541";
        String apellido= "Lopez";
        int edad=25;

        EmpleadoPretenso empleadoPretenso = new EmpleadoPretenso(username,password,realname,telefono,apellido,edad);

        Assert.assertEquals("El usuario no es el mismo",username,empleadoPretenso.getUsserName());
        Assert.assertEquals("La contraseña no es la misma",password,empleadoPretenso.getPassword());
        Assert.assertEquals("El realname no es el mismo",realname,empleadoPretenso.getRealName());
        Assert.assertEquals("El telefono no es el mismo",telefono,empleadoPretenso.getTelefono());
        Assert.assertEquals("El apellido no es el mismo",apellido,empleadoPretenso.getApellido());
        Assert.assertEquals("La edad no es la misma",edad,empleadoPretenso.getEdad());
    }

    @Test
    public void testConstructor2(){
        String username="pepe21";
        String password="abc";
        String realname="pepe";
        String telefono="";
        String apellido= "Lopez";
        int edad=25;

        EmpleadoPretenso empleadoPretenso = new EmpleadoPretenso(username,password,realname,telefono,apellido,edad);

        Assert.assertEquals("El usuario no es el mismo",username,empleadoPretenso.getUsserName());
        Assert.assertEquals("La contraseña no es la misma",password,empleadoPretenso.getPassword());
        Assert.assertEquals("El realname no es el mismo",realname,empleadoPretenso.getRealName());
        Assert.assertEquals("El telefono no es el mismo",telefono,empleadoPretenso.getTelefono());
        Assert.assertEquals("El apellido no es el mismo",apellido,empleadoPretenso.getApellido());
        Assert.assertEquals("La edad no es la misma",edad,empleadoPretenso.getEdad());
    }

    @Test
    public void testConstructor3(){
        String username="pepe21";
        String password="abc";
        String realname="pepe";
        String telefono="5487541";
        String apellido= "";
        int edad=25;

        EmpleadoPretenso empleadoPretenso = new EmpleadoPretenso(username,password,realname,telefono,apellido,edad);

        Assert.assertEquals("El usuario no es el mismo",username,empleadoPretenso.getUsserName());
        Assert.assertEquals("La contraseña no es la misma",password,empleadoPretenso.getPassword());
        Assert.assertEquals("El realname no es el mismo",realname,empleadoPretenso.getRealName());
        Assert.assertEquals("El telefono no es el mismo",telefono,empleadoPretenso.getTelefono());
        Assert.assertEquals("El apellido no es el mismo",apellido,empleadoPretenso.getApellido());
        Assert.assertEquals("La edad no es la misma",edad,empleadoPretenso.getEdad());
    }

    @Test
    public void testConstructor4(){
        String username="pepe21";
        String password="abc";
        String realname="pepe";
        String telefono="5487541";
        String apellido= "Lopez";
        int edad=1;

        EmpleadoPretenso empleadoPretenso = new EmpleadoPretenso(username,password,realname,telefono,apellido,edad);

        Assert.assertEquals("El usuario no es el mismo",username,empleadoPretenso.getUsserName());
        Assert.assertEquals("La contraseña no es la misma",password,empleadoPretenso.getPassword());
        Assert.assertEquals("El realname no es el mismo",realname,empleadoPretenso.getRealName());
        Assert.assertEquals("El telefono no es el mismo",telefono,empleadoPretenso.getTelefono());
        Assert.assertEquals("El apellido no es el mismo",apellido,empleadoPretenso.getApellido());
        Assert.assertEquals("La edad no es la misma",edad,empleadoPretenso.getEdad());
    }


    @Test
    public void testSetEdad1(){
        String username="pepe21";
        String password="abc";
        String realname="pepe";
        String telefono="5487541";
        String apellido= "Lopez";
        int edad=1;

        EmpleadoPretenso empleadoPretenso = new EmpleadoPretenso(username,password,realname,telefono,apellido,edad);
        edad=5;
        empleadoPretenso.setEdad(edad);
        Assert.assertEquals("Edad no coincide",edad,empleadoPretenso.getEdad());
    }

    @Test
    public void testSetEdad2(){
        String username="pepe21";
        String password="abc";
        String realname="pepe";
        String telefono="5487541";
        String apellido= "Lopez";
        int edad=12;

        EmpleadoPretenso empleadoPretenso = new EmpleadoPretenso(username,password,realname,telefono,apellido,edad);
        edad=1;
        empleadoPretenso.setEdad(edad);
        Assert.assertEquals("Edad no coincide",edad,empleadoPretenso.getEdad());
    }

    @Test
    public void testCalculaComision1(){
        String username="pepe21";
        String password="123";
        String realname="pepe";
        String telefono="5487541";
        String apellido= "Lopez";
        int edad=25;
        int puntaje=-10;

        EmpleadoPretenso empleadoPretenso = new EmpleadoPretenso(username,password,realname,telefono,apellido,edad);

        empleadoPretenso.setPuntaje(puntaje);
        Ticket ticket= new Ticket(Constantes.HOME_OFFICE,100000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_MEDIA,Constantes.SECUNDARIOS);

        Assert.assertEquals(100000*(0.8),empleadoPretenso.calculaComision(ticket),0.01);
    }

    @Test
    public void testCalculaComision2(){
        String username="pepe21";
        String password="123";
        String realname="pepe";
        String telefono="5487541";
        String apellido= "Lopez";
        int edad=25;
        int puntaje=5;

        EmpleadoPretenso empleadoPretenso = new EmpleadoPretenso(username,password,realname,telefono,apellido,edad);

        empleadoPretenso.setPuntaje(puntaje);
        Ticket ticket= new Ticket(Constantes.HOME_OFFICE,100000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_MEDIA,Constantes.SECUNDARIOS);

        Assert.assertEquals(100000*(0.8-((double)puntaje/100)),empleadoPretenso.calculaComision(ticket),0.01);
    }
    

    @Test
    public void testCalculaComision3(){
        String username="pepe21";
        String password="123";
        String realname="pepe";
        String telefono="5487541";
        String apellido= "Lopez";
        int edad=25;
        int puntaje=15;

        EmpleadoPretenso empleadoPretenso = new EmpleadoPretenso(username,password,realname,telefono,apellido,edad);
        
        empleadoPretenso.setPuntaje(puntaje);
        Ticket ticket= new Ticket(Constantes.HOME_OFFICE,100000,Constantes.JORNADA_MEDIA,Constantes.SENIOR,Constantes.EXP_MEDIA,Constantes.SECUNDARIOS);

        Assert.assertEquals(100000*(0.9-((double)puntaje/100)),empleadoPretenso.calculaComision(ticket),0.01);
    }

    @Test
    public void testCalculaComision4(){
        String username="pepe21";
        String password="123";
        String realname="pepe";
        String telefono="5487541";
        String apellido= "Lopez";
        int edad=25;
        int puntaje=17;

        EmpleadoPretenso empleadoPretenso = new EmpleadoPretenso(username,password,realname,telefono,apellido,edad);
        
        empleadoPretenso.setPuntaje(puntaje);
        Ticket ticket= new Ticket(Constantes.HOME_OFFICE,100000,Constantes.JORNADA_MEDIA,Constantes.MANAGMENT,Constantes.EXP_MEDIA,Constantes.SECUNDARIOS);

        Assert.assertEquals(100000*(1-((double)puntaje/100)),empleadoPretenso.calculaComision(ticket),0.01);
    }
    
    @Test
    public void testCalculaComision5(){
        String username="pepe21";
        String password="123";
        String realname="pepe";
        String telefono="5487541";
        String apellido= "Lopez";
        int edad=25;
        int puntaje=85;

        EmpleadoPretenso empleadoPretenso = new EmpleadoPretenso(username,password,realname,telefono,apellido,edad);

        empleadoPretenso.setPuntaje(puntaje);
        Ticket ticket= new Ticket(Constantes.HOME_OFFICE,100000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_MEDIA,Constantes.SECUNDARIOS);

        Assert.assertEquals(100000*(0.8-((double)50/100)),empleadoPretenso.calculaComision(ticket),0.01);
    }

}

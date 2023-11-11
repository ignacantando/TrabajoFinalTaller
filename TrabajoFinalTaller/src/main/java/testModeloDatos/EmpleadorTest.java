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

public class EmpleadorTest {
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
        String rubro= Constantes.SALUD;
        String tipoPersona= Constantes.JURIDICA;

        Empleador empleador = new Empleador(username,password,realname,telefono,rubro,tipoPersona);

        Assert.assertEquals("El usuario no es el mismo",username,empleador.getUsserName());
        Assert.assertEquals("La contraseña no es la misma",password,empleador.getPassword());
        Assert.assertEquals("El realname no es el mismo",realname,empleador.getRealName());
        Assert.assertEquals("El telefono no es el mismo",telefono,empleador.getTelefono());
        Assert.assertEquals("El rubro no es el mismo",rubro,empleador.getRubro());
        Assert.assertEquals("El tipoPersona no es el mismo",tipoPersona,empleador.getTipoPersona());

    }

    @Test
    public void testConstructor2(){
        String username="pepe21";
        String password="abc";
        String realname="pepe";
        String telefono="";
        String rubro= Constantes.SALUD;
        String tipoPersona= Constantes.JURIDICA;

        Empleador empleador = new Empleador(username,password,realname,telefono,rubro,tipoPersona);

        Assert.assertEquals("El usuario no es el mismo",username,empleador.getUsserName());
        Assert.assertEquals("La contraseña no es la misma",password,empleador.getPassword());
        Assert.assertEquals("El realname no es el mismo",realname,empleador.getRealName());
        Assert.assertEquals("El telefono no es el mismo",telefono,empleador.getTelefono());
        Assert.assertEquals("El rubro no es el mismo",rubro,empleador.getRubro());
        Assert.assertEquals("El tipoPersona no es el mismo",tipoPersona,empleador.getTipoPersona());
    }

    @Test
    public void testConstructor3(){
        String username="pepe21";
        String password="abc";
        String realname="pepe";
        String telefono="5487541";
        String rubro= Constantes.SALUD;
        String tipoPersona= Constantes.JURIDICA;

        Empleador empleador = new Empleador(username,password,realname,telefono,rubro,tipoPersona);

        Assert.assertEquals("El usuario no es el mismo",username,empleador.getUsserName());
        Assert.assertEquals("La contraseña no es la misma",password,empleador.getPassword());
        Assert.assertEquals("El realname no es el mismo",realname,empleador.getRealName());
        Assert.assertEquals("El telefono no es el mismo",telefono,empleador.getTelefono());
        Assert.assertEquals("El rubro no es el mismo",rubro,empleador.getRubro());
        Assert.assertEquals("El tipoPersona no es el mismo",tipoPersona,empleador.getTipoPersona());
    }


    @Test
    public void testCalculaComision1(){
        String username="pepe21";
        String password="abc";
        String realname="pepe";
        String telefono="5487541";
        String rubro= Constantes.SALUD;
        String tipoPersona= Constantes.JURIDICA;
        Empleador empleador = new Empleador(username,password,realname,telefono,rubro,tipoPersona);
        Ticket ticket= new Ticket(Constantes.HOME_OFFICE,100000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_MEDIA,Constantes.SECUNDARIOS);
        Assert.assertEquals("No coincide la salida",60000,empleador.calculaComision(ticket),0.1);
    }

    @Test
    public void testCalculaComision2(){
        String username="pepe21";
        String password="abc";
        String realname="pepe";
        String telefono="5487541";
        String rubro= Constantes.COMERCIO_LOCAL;
        String tipoPersona= Constantes.JURIDICA;
        Empleador empleador = new Empleador(username,password,realname,telefono,rubro,tipoPersona);
        Ticket ticket= new Ticket(Constantes.HOME_OFFICE,100000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_MEDIA,Constantes.SECUNDARIOS);
        Assert.assertEquals("No coincide la salida",70000,empleador.calculaComision(ticket),0.1);
    }

    @Test
    public void testCalculaComision3(){
        String username="pepe21";
        String password="abc";
        String realname="pepe";
        String telefono="5487541";
        String rubro= Constantes.COMERCIO_INTERNACIONAL;
        String tipoPersona= Constantes.JURIDICA;
        Empleador empleador = new Empleador(username,password,realname,telefono,rubro,tipoPersona);
        Ticket ticket= new Ticket(Constantes.HOME_OFFICE,100000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_MEDIA,Constantes.SECUNDARIOS);
        Assert.assertEquals("No coincide la salida",80000,empleador.calculaComision(ticket),0.1);
    }

    @Test
    public void testSetCandidato(){
        String username="pepe21";
        String password="abc";
        String realname="pepe";
        String telefono="5487541";
        String rubro= Constantes.COMERCIO_INTERNACIONAL;
        String tipoPersona= Constantes.JURIDICA;

        Empleador empleador = new Empleador(username,password,realname,telefono,rubro,tipoPersona);
        EmpleadoPretenso empleadoPretenso=new EmpleadoPretenso("leonel","123","guccione","123","fernandez",40);
        empleador.setCandidato(empleadoPretenso);

        Assert.assertEquals("Seteo mal el Candidato",empleadoPretenso,empleador.getCandidato());
    }




    @Test
    public void testSetListaPostulante(){
        String username="pepe21";
        String password="abc";
        String realname="pepe";
        String telefono="5487541";
        String rubro= Constantes.COMERCIO_INTERNACIONAL;
        String tipoPersona= Constantes.JURIDICA;

        Empleador empleador = new Empleador(username,password,realname,telefono,rubro,tipoPersona);
        EmpleadoPretenso empleadoPretenso=new EmpleadoPretenso("leonel","123","guccione","1234","fernandez",40);
        EmpleadoPretenso empleadoPretenso2=new EmpleadoPretenso("guille","123","alvarez","1234","alejandro",45);

        ClientePuntaje clientePuntaje1 = new ClientePuntaje(8.0,empleadoPretenso);
        ClientePuntaje clientePuntaje2 = new ClientePuntaje(3.0,empleadoPretenso2);
        ArrayList<ClientePuntaje> array = new ArrayList<>();
        array.add((clientePuntaje1));
        array.add((clientePuntaje2));

        empleador.setListaDePostulantes(array);
        Assert.assertEquals("No seteo la lista de postulantes al empleador",array,empleador.getListaDePostulantes());
    }

    @Test
    public void testSetListaPostulante2(){
        String username="pepe21";
        String password="abc";
        String realname="pepe";
        String telefono="5487541";
        String rubro= Constantes.COMERCIO_INTERNACIONAL;
        String tipoPersona= Constantes.JURIDICA;

        Empleador empleador = new Empleador(username,password,realname,telefono,rubro,tipoPersona);

        ArrayList<ClientePuntaje> array = new ArrayList<>();

        empleador.setListaDePostulantes(array);
        Assert.assertEquals("No seteo la lista de postulantes al empleador",array,empleador.getListaDePostulantes());
    }


}

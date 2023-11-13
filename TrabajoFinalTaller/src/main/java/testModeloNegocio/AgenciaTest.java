package testModeloNegocio;

import excepciones.*;
import modeloDatos.*;
import modeloNegocio.Agencia;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import persistencia.AgenciaDTO;
import persistencia.UtilPersistencia;
import util.Constantes;
import util.Mensajes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class AgenciaTest {
    Agencia agencia = Agencia.getInstance();
    HashMap<String, EmpleadoPretenso> empleados;
    HashMap<String, Empleador> empleadores;

    ArrayList<Contratacion> contrataciones;

    @Before
    public void setUp() throws Exception {
         empleados= new HashMap(); 
         empleadores = new HashMap(); 
         contrataciones = new ArrayList<>(); 
         agencia.setEmpleadores(empleadores); 
         agencia.setEmpleados(empleados); 
         agencia.setContrataciones(contrataciones); 

        
        File archivo = new File("pepito.xml");
        if (archivo.exists())
            archivo.delete();
    }

    @After
    public void tearDown() throws Exception {
        agencia.cerrarSesion(); 
        agencia.setEstadoContratacion(false);
    }

    
    @Test
    public void testCerrarSesion(){
        agencia.cerrarSesion();
        Assert.assertEquals("El valor de tipoUsuario al cerrar sesion no es -1",-1,agencia.getTipoUsuario());
    }

    @Test
    public void testRegistroEmpleado1(){
        String username="pepe21";
        String password="abc";
        String realname="";
        String telefono="5487541";
        String apellido= "Lopez";
        int edad=25;
        Cliente empleado = null;

        try {
            empleado = agencia.registroEmpleado(username,password,realname,apellido,telefono,edad);
        } catch (NewRegisterException e) {
            Assert.fail();
        } catch (ImposibleCrearEmpleadoException e) {
            Assert.fail();
        }

        
        Assert.assertEquals("No se agrega el empleado al hashmap",agencia.getEmpleados().get(username),empleado);

    }

    @Test
    public void testRegistroEmpleado2(){
        String username="pepe21";
        String password="abc";
        String realname="pepe";
        String telefono="";
        String apellido= "Lopez";
        int edad=25;
        Cliente empleado = null;
        try {
            empleado = agencia.registroEmpleado(username,password,realname,apellido,telefono,edad);
        } catch (NewRegisterException e) {
            Assert.fail("No deberia lanzar excepcion NewRegisterException");
        } catch (ImposibleCrearEmpleadoException e) {
            Assert.fail("No deberia lanzar excepcion ImposibleCrearEmpleadoException");
        }

       
        Assert.assertEquals("No se agrega el empleado al hashmap",agencia.getEmpleados().get(username),empleado);
    }

    @Test
    public void testRegistroEmpleado3(){
        String username="pepe21";
        String password="abc";
        String realname="pepe";
        String telefono="5487541";
        String apellido= "";
        int edad=25;
        Cliente empleado= null;
        try {
            empleado = agencia.registroEmpleado(username,password,realname,apellido,telefono,edad);
        } catch (NewRegisterException e) {
            Assert.fail("No deberia lanzar excepcion NewRegisterException");
        } catch (ImposibleCrearEmpleadoException e) {
            Assert.fail("No deberia lanzar excepcion ImposibleCrearEmpleadoException");
        }

       
        Assert.assertEquals("No se agrega el empleado al hashmap",agencia.getEmpleados().get(username),empleado);
    }

    @Test
    public void testRegistroEmpleado4(){
        String username="pepe21";
        String password="abc";
        String realname="pepe";
        String telefono="5487541";
        String apellido= "Lopez";
        int edad=1;
        Cliente empleado=null;
        try {
            empleado = agencia.registroEmpleado(username,password,realname,apellido,telefono,edad);
        } catch (NewRegisterException e) {
            Assert.fail("No deberia lanzar excepcion NewRegisterException");
        } catch (ImposibleCrearEmpleadoException e) {
            Assert.fail("No deberia lanzar excepcion ImposibleCrearEmpleadoException");
        }

        
        Assert.assertEquals("No se agrega el empleado al hashmap",agencia.getEmpleados().get(username),empleado);
    }

    @Test
    public void testRegistroEmpleado5(){
        String username=null;
        String password="abc";
        String realname="pepe";
        String telefono="5487541";
        String apellido= "Lopez";
        int edad=25;
        Cliente empleado =null;
        try {
            empleado = agencia.registroEmpleado(username,password,realname,apellido,telefono,edad);
            Assert.fail();
        } catch (NewRegisterException e) {
            Assert.fail("No tiene que lanzar excepcion NewRegisterException");
        } catch (ImposibleCrearEmpleadoException e) {
          
            Assert.assertEquals(Mensajes.PARAMETROS_NULOS.getValor(),e.getMessage());

        }
       
        Assert.assertFalse("No tiene que agregar  el empleado al hashmap",agencia.getEmpleados().containsKey(username));
    }

    @Test
    public void testRegistroEmpleado6(){
        String username="pepe21";
        String password="abc";
        String realname="";
        String telefono="5487541";
        String apellido= "Lopez";
        int edad=25;

        Cliente empleado = null;
        Cliente empleado2 = null;
        try {
            empleado2 = agencia.registroEmpleado("pepe21","","","","",23);
        } catch (NewRegisterException e) {
        } catch (ImposibleCrearEmpleadoException e) {
        }

        try {
            empleado = agencia.registroEmpleado(username,password,realname,apellido,telefono,edad);
            Assert.fail("Deberia lanzar excepcion");
        } catch (NewRegisterException e) {
            Assert.assertEquals("Mensaje incorrecto excepcion",Mensajes.USUARIO_REPETIDO.getValor(),e.getMessage());
        } catch (ImposibleCrearEmpleadoException e) {
            Assert.fail();
        }
            Assert.assertEquals("No se tendria que haber agregado al hashmap",1,agencia.getEmpleados().size());
    }


    @Test
    public void testRegistroEmpleador1(){
        String username="pepe21";
        String password="abc";
        String realname="";
        String telefono="5487541";
        String tipoPersona= Constantes.JURIDICA;
        String rubro = Constantes.SALUD;

        Cliente empleador = null;

        try {
            empleador = agencia.registroEmpleador(username,password,realname,telefono,tipoPersona,rubro);
        } catch (NewRegisterException e) {
            Assert.fail();
        } catch (ImposibleCrearEmpleadorException e) {
            Assert.fail();
        }
        Assert.assertEquals("No se agrega el empleador al hashmap",agencia.getEmpleadores().get(username),empleador);

    }

    @Test
    public void testRegistroEmpleador2(){
        String username="pepe21";
        String password="abc";
        String realname="pepe";
        String telefono="";
        String tipoPersona= Constantes.JURIDICA;
        String rubro = Constantes.SALUD;

        Cliente empleador = null;

        try {
            empleador = agencia.registroEmpleador(username,password,realname,telefono,tipoPersona,rubro);
        } catch (NewRegisterException e) {
            Assert.fail();
        } catch (ImposibleCrearEmpleadorException e) {
            Assert.fail();
        }
        Assert.assertEquals("No se agrega el empleador al hashmap",agencia.getEmpleadores().get(username),empleador);

    }

    @Test
    public void testRegistroEmpleador3(){
        String username="pepe21";
        String password="abc";
        String realname="pepe";
        String telefono="5487541";
        String tipoPersona= Constantes.JURIDICA;
        String rubro = Constantes.SALUD;

        Cliente empleador = null;

        try {
            empleador = agencia.registroEmpleador(username,password,realname,telefono,tipoPersona,rubro);
        } catch (NewRegisterException e) {
            Assert.fail();
        } catch (ImposibleCrearEmpleadorException e) {
            Assert.fail();
        }
        Assert.assertEquals("No se agrega el empleador al hashmap",agencia.getEmpleadores().get(username),empleador);

    }

    @Test
    public void testRegistroEmpleador4(){
        String username=null;
        String password="abc";
        String realname="";
        String telefono="5487541";
        String tipoPersona= Constantes.JURIDICA;
        String rubro = Constantes.SALUD;

        Cliente empleador = null;

        try {
            empleador = agencia.registroEmpleador(username,password,realname,telefono,tipoPersona,rubro);
            Assert.fail("Deberia lanzar excepcion");
        } catch (NewRegisterException e) {
            Assert.fail();
        } catch (ImposibleCrearEmpleadorException e) {
            Assert.assertEquals(Mensajes.PARAMETROS_NULOS.getValor(),e.getMessage());
        }

        Assert.assertFalse("Se agrega el empleador al hashmap por mas que no lo tenia que hacer",agencia.getEmpleadores().containsKey(username));

    }

    @Test
    public void testRegistroEmpleador5(){
        String username="pepe21";
        String password=null;
        String realname="pepe";
        String telefono="5487541";
        String tipoPersona= Constantes.JURIDICA;
        String rubro = Constantes.SALUD;

        Cliente empleador = null;

        try {
            empleador = agencia.registroEmpleador(username,password,realname,telefono,tipoPersona,rubro);
            Assert.fail("Deberia lanzar excepcion");
        } catch (NewRegisterException e) {
            Assert.fail();
        } catch (ImposibleCrearEmpleadorException e) {
            Assert.assertEquals(Mensajes.PARAMETROS_NULOS.getValor(),e.getMessage());
        }

        Assert.assertFalse("Se agrega el empleador al hashmap por mas que no lo tenia que hacer",agencia.getEmpleadores().containsKey(username));

    }

    @Test
    public void testRegistroEmpleador6(){
        String username="pepe21";
        String password="abc";
        String realname="pepe";
        String telefono="5487541";
        String tipoPersona= Constantes.JURIDICA;
        String rubro = "AAA";

        Cliente empleador = null;

        try {
            empleador = agencia.registroEmpleador(username,password,realname,telefono,tipoPersona,rubro);
            Assert.fail("Deberia lanzar excepcion");
        } catch (NewRegisterException e) {
            Assert.fail();
        } catch (ImposibleCrearEmpleadorException e) {
            Assert.assertEquals(Mensajes.RUBRO_DESCONOCIDO.getValor(),e.getMessage());
        }

        Assert.assertFalse("Se agrega el empleador al hashmap por mas que no lo tenia que hacer",agencia.getEmpleadores().containsKey(username));

    }

    @Test
    public void testRegistroEmpleador7(){
        String username="pepe21";
        String password="abc";
        String realname="pepe";
        String telefono="5487541";
        String tipoPersona= "VFS";
        String rubro = Constantes.SALUD;

        Cliente empleador = null;

        try {
            empleador = agencia.registroEmpleador(username,password,realname,telefono,tipoPersona,rubro);
            Assert.fail("Deberia lanzar excepcion");
        } catch (NewRegisterException e) {
            Assert.fail();
        } catch (ImposibleCrearEmpleadorException e) {
            Assert.assertEquals(Mensajes.TIPO_PERSONA_DESCONOCIDO.getValor(),e.getMessage());
        }

        Assert.assertFalse("Se agrega el empleador al hashmap por mas que no lo tenia que hacer",agencia.getEmpleadores().containsKey(username));
    }

    @Test
    public void testRegistroEmpleador8(){
        String username="pepe21";
        String password="abc";
        String realname="pepe";
        String telefono="5487541";
        String tipoPersona= Constantes.JURIDICA;
        String rubro = Constantes.SALUD;

        Cliente empleador = null;
        Cliente empleador2= null;


        try {
            empleador2 = agencia.registroEmpleador("pepe21",password,realname,telefono,tipoPersona,rubro);
        } catch (NewRegisterException e) {

        } catch (ImposibleCrearEmpleadorException e) {

        }

        try {
            empleador = agencia.registroEmpleador(username,password,realname,telefono,tipoPersona,rubro);
            Assert.fail("Deberia lanzar excepcion empleador con mismo nombre");
        } catch (NewRegisterException e) {

        } catch (ImposibleCrearEmpleadorException e) {
            Assert.fail();
        }

        Assert.assertEquals("Se agrega el empleador al hashmap",1,agencia.getEmpleadores().size());

    }


    @Test
    public void login1(){
        String username="pepe21";
        String password="abc";
        String realname="pepe";
        String telefono="5487541";
        String apellido= "Lopez";
        int edad=25;

        EmpleadoPretenso empleadoPretenso = new EmpleadoPretenso(username,password,realname,telefono,apellido,edad);
        empleados.put(username,empleadoPretenso);

        try {
            agencia.login(username,password);
        } catch (ContraException e) {
            Assert.fail("No deberia lanzar excepcion ContraseñaException");

        } catch (NombreUsuarioException e) {
            Assert.fail("No deberia lanzar excepcion NombreUsuarioException");
        }

        Assert.assertEquals("No coincide el tipo de usuario ",0,agencia.getTipoUsuario());

    }

    @Test
    public void login2(){
        String username="pepe21";
        String password="abc";
        String realname="pepe";
        String telefono="5487541";
        String rubro= Constantes.SALUD;
        String tipoPersona= Constantes.JURIDICA;

        Empleador empleador = new Empleador(username,password,realname,telefono,rubro,tipoPersona);

        empleadores.put(username,empleador);

        try {
            agencia.login(username,password);
        } catch (ContraException e) {
            Assert.fail("No deberia lanzar excepcion ContraseñaException");

        } catch (NombreUsuarioException e) {
            Assert.fail("No deberia lanzar excepcion NombreUsuarioException");
        }

        Assert.assertEquals("No coincide el tipo de usuario ",1,agencia.getTipoUsuario());

    }

    @Test
    public void login3() {

        String username = "pepe21";
        String password = "manuelita";
        String realname = "pepe";
        String telefono = "5487541";
        String apellido = "Lopez";
        int edad = 25;
        
        EmpleadoPretenso empleadoPretenso = new EmpleadoPretenso(username, password, realname, telefono, apellido, edad);
        empleados.put(username, empleadoPretenso);

        try {
            agencia.login(username, "hola");
            Assert.fail("Deberia lanzar excepcion contrasena invalida");
        } catch (ContraException e) {
            Assert.assertEquals(Mensajes.PASS_ERRONEO.getValor(),e.getMessage());

        } catch (NombreUsuarioException e) {
            Assert.fail("No deberia lanzar excepcion NombreUsuarioException");
        }

        Assert.assertEquals("Pudo loguearse igual ",-1,agencia.getTipoUsuario());

    }

    @Test
    public void login4() {

        String username = "pepe21";
        String password = "manuelita";
        String realname = "pepe";
        String telefono = "5487541";
        String apellido = "Lopez";
        int edad = 25;
        EmpleadoPretenso empleadoPretenso = new EmpleadoPretenso(username, password, realname, telefono, apellido, edad);
        empleados.put(username, empleadoPretenso);

        try {
            agencia.login("Messi", "manuelita");
            Assert.fail("Deberia lanzar excepcion NombreUsuarioException");
        } catch (ContraException e) {
            Assert.fail("No deberia lanzar ContraException");

        } catch (NombreUsuarioException e) {
            Assert.assertEquals(Mensajes.USUARIO_DESCONOCIDO.getValor(),e.getMessage());
        }

        Assert.assertEquals("Pudo loguearse igual ",-1,agencia.getTipoUsuario());
    }

    @Test
    public void testGetContratacionEmpleador1(){
        String username="pepe21";
        String password="abc";
        String realname="pepe";
        String telefono="5487541";
        String rubro= Constantes.SALUD;
        String tipoPersona= Constantes.JURIDICA;

        Empleador empleador = new Empleador(username,password,realname,telefono,rubro,tipoPersona);

        empleadores.put(username,empleador);
        Assert.assertNull(agencia.getContratacionEmpleador(empleador));

    }

    @Test
    public void testGetContratacionEmpleador2(){
        String username="pepe21";
        String password="abc";
        String realname="pepe";
        String telefono="5487541";
        String rubro= Constantes.SALUD;
        String tipoPersona= Constantes.JURIDICA;

        Empleador empleador = new Empleador(username,password,realname,telefono,rubro,tipoPersona);
        empleadores.put(username,empleador);

        EmpleadoPretenso empleado = new EmpleadoPretenso("pepito","123","juancito","1234567","Lopez",33);
        Empleador empleador2 = new Empleador("Macri","412421","Mauricio","2234242",Constantes.SALUD,Constantes.FISICA);
        Contratacion contratacion = new Contratacion(empleador2,empleado);
        ArrayList <Contratacion> contrataciones = new ArrayList<>();
        contrataciones.add(contratacion);
        agencia.setContrataciones(contrataciones);

        Assert.assertNull(agencia.getContratacionEmpleador(empleador));
    }

    @Test
    public void testGetContratacionEmpleador3(){

        String username="pepe21";
        String password="abc";
        String realname="pepe";
        String telefono="5487541";
        String rubro= Constantes.SALUD;
        String tipoPersona= Constantes.JURIDICA;
        Empleador empleador = new Empleador(username,password,realname,telefono,rubro,tipoPersona);
        empleadores.put(username,empleador);

        EmpleadoPretenso empleado = new EmpleadoPretenso("pepito","123","juancito","1234567","Lopez",33);
        Contratacion contratacion = new Contratacion(empleador,empleado);
        ArrayList <Contratacion> contrataciones = new ArrayList<>();
        contrataciones.add(contratacion);
        agencia.setContrataciones(contrataciones);

        Assert.assertEquals(empleado,agencia.getContratacionEmpleador(empleador));
    }

    @Test
    public void testGetContratacionEmpleado1(){
        String username="pepe21";
        String password="abc";
        String realname="pepe";
        String telefono="5487541";
        String apellido= "Lopez";
        int edad=1;

        EmpleadoPretenso empleadoPretenso = new EmpleadoPretenso(username,password,realname,telefono,apellido,edad);

        empleados.put(username,empleadoPretenso);
        Assert.assertNull(agencia.getContratacionEmpleadoPretenso(empleadoPretenso));

    }

    @Test
    public void testGetContratacionEmpleado2(){
        String username="pepe21";
        String password="abc";
        String realname="pepe";
        String telefono="5487541";
        String apellido= "Lopez";
        int edad=1;

        EmpleadoPretenso empleadoPretenso = new EmpleadoPretenso(username,password,realname,telefono,apellido,edad);

        empleados.put(username,empleadoPretenso);

        EmpleadoPretenso empleado2 = new EmpleadoPretenso("pepito","123","juancito","1234567","Lopez",33);
        Empleador empleador = new Empleador("Macri","412421","Mauricio","2234242",Constantes.SALUD,Constantes.FISICA);

        Contratacion contratacion = new Contratacion(empleador,empleado2);

        ArrayList <Contratacion> contrataciones = new ArrayList<>();
        contrataciones.add(contratacion);
        agencia.setContrataciones(contrataciones);

        Assert.assertNull(agencia.getContratacionEmpleadoPretenso(empleadoPretenso));
    }

    @Test
    public void testGetContratacionEmpleado3(){

        String username="pepe21";
        String password="abc";
        String realname="pepe";
        String telefono="5487541";
        String apellido= "Lopez";
        int edad=1;

        EmpleadoPretenso empleadoPretenso = new EmpleadoPretenso(username,password,realname,telefono,apellido,edad);

        empleados.put(username,empleadoPretenso);

        Empleador empleador = new Empleador("Macri","412421","Mauricio","2234242",Constantes.SALUD,Constantes.FISICA);

        Contratacion contratacion = new Contratacion(empleador,empleadoPretenso);

        ArrayList <Contratacion> contrataciones = new ArrayList<>();
        contrataciones.add(contratacion);

        agencia.setContrataciones(contrataciones);

        Assert.assertEquals(empleador,agencia.getContratacionEmpleadoPretenso(empleadoPretenso));
    }

    @Test
    public void testSetLimitesRenumeracion1(){
        try {
            agencia.setLimitesRemuneracion(-1000,2000);
            Assert.fail("Deberia lanzar excepcion");
        } catch (LimiteSuperiorRemuneracionInvalidaException e) {
            Assert.fail("No deberia lanzar excepcion limite superior");
        } catch (LimiteInferiorRemuneracionInvalidaException e) {
            Assert.assertEquals(Mensajes.LIMITE_REMUNERACION_NEGATIVO.getValor(),e.getMessage());
        }

    }

    @Test
    public void testSetLimitesRenumeracion2(){
        try {
            agencia.setLimitesRemuneracion(50000,20000);
            Assert.fail("Deberia lanzar excepcion limiteSuperiorRenumeracionInvalida");
        } catch (LimiteSuperiorRemuneracionInvalidaException e) {
            Assert.assertEquals(Mensajes.LIMITE_REMUNERACION_INVALIDO,e.getMessage());
        } catch (LimiteInferiorRemuneracionInvalidaException e) {
            Assert.fail("No deberia lanzar excepcion de limiteInferior");
        }

    }

    @Test
    public void testSetLimitesRenumeracion3(){
        try {
            agencia.setLimitesRemuneracion(70000,100000);
        } catch (LimiteSuperiorRemuneracionInvalidaException e) {
            Assert.fail("No deberia lanzar excepcion LimiteSuperior");
        } catch (LimiteInferiorRemuneracionInvalidaException e) {
            Assert.fail("No deberia lanzar excepcion de limiteInferior");
        }

    }

    @Test
    public void testEliminarTicket1(){

        agencia.setEstadoContratacion(false);
        String username="pepe21";
        String password="abc";
        String realname="pepe";
        String telefono="5487541";
        String rubro= Constantes.SALUD;
        String tipoPersona= Constantes.JURIDICA;

        Empleador empleador = new Empleador(username,password,realname,telefono,rubro,tipoPersona);
        Ticket ticket = new Ticket(Constantes.HOME_OFFICE,1000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
        empleador.setTicket(ticket);

        empleadores.put(username,empleador);
        try {
            agencia.login(username,password);
        } catch (ContraException e) {
        } catch (NombreUsuarioException e) {
        }

        empleador.setPuntaje(0);
        try {
            agencia.eliminarTicket();
        } catch (ImposibleModificarTicketsException e) {
            Assert.fail("No deberia lanzar excepcion ya que el estado de contratacion es valido");
        }

        Assert.assertNull(empleador.getTicket());
        Assert.assertEquals(-1,empleador.getPuntaje());
    }

    @Test
    public void testEliminarTicket2(){
        agencia.setEstadoContratacion(true);
        String username="pepe21";
        String password="abc";
        String realname="pepe";
        String telefono="5487541";
        String rubro= Constantes.SALUD;
        String tipoPersona= Constantes.JURIDICA;

        Empleador empleador = new Empleador(username,password,realname,telefono,rubro,tipoPersona);
        Ticket ticket = new Ticket(Constantes.HOME_OFFICE,1000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
        empleador.setTicket(ticket);

        empleadores.put(username,empleador);
        empleador.setPuntaje(0);
        try {
            agencia.login(username,password);
        } catch (ContraException e) {
        } catch (NombreUsuarioException e) {
        }

        try {
            agencia.eliminarTicket();
            Assert.fail("Deberia lanzar excepcion ya que el estado de contratacion no es valido");
        } catch (ImposibleModificarTicketsException e) {
            Assert.assertEquals(Mensajes.ERROR_AGENCIA_EN_CONTRATACION.getValor(),e.getMessage());
        }

        Assert.assertEquals(0,empleador.getPuntaje());
    }



    @Test
    public void testGuardarAgencia(){
        try {
            agencia.guardarAgencia("pepito.xml");

            File archivo = new File("pepito.xml");
            Assert.assertTrue("Debería existir el archivo pepito.xml", archivo.exists());
        } catch (IOException e) {
            Assert.fail("No deberia lanzar excepcion");
        }
    }

    @Test
    public void testCargarAgencia(){
        try {
            agencia.guardarAgencia("pepito2.xml");
            agencia.cargarAgencia("pepito3.xml");
            Assert.fail("Deberia lanzar excepcion porque no existe archivo");
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
            Assert.fail("No deberia entrar aca");
        }


    }

    @Test
    public void testAgenciaFromAgenciaDTO() {
        AgenciaDTO agenciaDTO = new AgenciaDTO();
        Empleador empleador = new Empleador("pepe21", "abc", "pepe", "54545", Constantes.SALUD, Constantes.FISICA);
        EmpleadoPretenso empleadoPretenso = new EmpleadoPretenso("Juancito", "abc", "Juan", "54545423", "Lopez", 94);

        HashMap<String, EmpleadoPretenso> empleados = new HashMap<>();
        HashMap<String, Empleador> empleadores = new HashMap<>();

        empleadores.put("pepe21", empleador);
        empleados.put("Juancito", empleadoPretenso);

        Contratacion contratacion = new Contratacion(empleador, empleadoPretenso);
        ArrayList<Contratacion> contrataciones = new ArrayList<>();
        contrataciones.add(contratacion);

       
        agenciaDTO.setEmpleadores(empleadores);
        agenciaDTO.setEmpleados(empleados);
        agenciaDTO.setLimiteInferior(3500);
        agenciaDTO.setLimiteSuperior(5000);
        agenciaDTO.setContrataciones(contrataciones);
        agenciaDTO.setEstadoContratacion(true);
        
        UtilPersistencia.agenciaFromAgenciaDTO(agenciaDTO); //esto crashea
     
        Assert.assertEquals(agenciaDTO.getEmpleadores(),agencia.getEmpleadores());
        Assert.assertEquals(agenciaDTO.getEmpleados(),agencia.getEmpleados());
        Assert.assertEquals(agenciaDTO.getContrataciones(),agencia.getContrataciones());
        Assert.assertEquals(agenciaDTO.getLimiteInferior(),agencia.getLimiteInferior());
        Assert.assertEquals(agenciaDTO.getLimiteSuperior(),agencia.getLimiteSuperior());
        Assert.assertEquals(agenciaDTO.isEstadoContratacion(),agencia.isEstadoContratacion());
        
    }

  
}

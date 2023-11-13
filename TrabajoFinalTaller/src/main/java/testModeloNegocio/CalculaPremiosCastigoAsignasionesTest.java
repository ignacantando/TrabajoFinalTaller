package testModeloNegocio;

import static org.junit.Assert.*;

import java.util.ArrayList;
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
import modeloDatos.ClientePuntaje;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import modeloDatos.Ticket;
import modeloNegocio.Agencia;
import util.Constantes;

public class CalculaPremiosCastigoAsignasionesTest {

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
		
		EmpleadoPretenso empleadoPretenso1= new EmpleadoPretenso("pepe21","123","pepe","5465","lopez",21);
		
		Empleador empleador1 = new Empleador("luis","123","luis","6546",Constantes.SALUD,Constantes.JURIDICA);
		
		agencia.calculaPremiosCastigosAsignaciones();
		
		Assert.assertEquals("hay error esc1 ",0,empleadoPretenso1.getPuntaje());
		Assert.assertEquals("hay error esc1 ",0,empleador1.getPuntaje());
	}
	
	@Test
	public void testesc2() {
		EmpleadoPretenso empleadoPretenso1= new EmpleadoPretenso("pepe21","123","pepe","5465","lopez",21);
		EmpleadoPretenso empleadoPretenso2 = new EmpleadoPretenso("lucas34","123","lucas","5465","gomez",24);
		EmpleadoPretenso empleadoPretenso3 = new EmpleadoPretenso("tomas98","123","tomas","5465","perez",23);
		
		
		Empleador empleador1 = new Empleador("luis","123","luis","6546",Constantes.SALUD,Constantes.JURIDICA);
		Empleador empleador2 = new Empleador("pedro","123","pedro","6546",Constantes.SALUD,Constantes.JURIDICA);
		Empleador empleador3 = new Empleador("leo","123","leo","6546",Constantes.SALUD,Constantes.JURIDICA);
		Empleador empleador4 = new Empleador("fran","123","fran","6546",Constantes.SALUD,Constantes.JURIDICA);
		
		empleadoPretenso1.setPuntaje(50);
		empleadoPretenso2.setPuntaje(20);
		empleadoPretenso3.setPuntaje(20);
		
		empleador1.setPuntaje(60);
		empleador2.setPuntaje(20);
		empleador3.setPuntaje(50);
		empleador4.setPuntaje(20);
		
		ArrayList<ClientePuntaje> array1=new ArrayList<ClientePuntaje>();
		ClientePuntaje cli1=new ClientePuntaje(60,empleador1);
		ClientePuntaje cli2=new ClientePuntaje(50,empleador3);
		array1.add(cli1);
		array1.add(cli2);
		
		ArrayList<ClientePuntaje> array2=new ArrayList<ClientePuntaje>();
		ClientePuntaje cli3=new ClientePuntaje(50,empleador3);
		ClientePuntaje cli4=new ClientePuntaje(20,empleador4);
		array2.add(cli3);
		array2.add(cli4);
		
		
		ArrayList<ClientePuntaje> array3=new ArrayList<ClientePuntaje>();
		ClientePuntaje cli5=new ClientePuntaje(60,empleador1);
		ClientePuntaje cli6=new ClientePuntaje(20,empleador2);
		array3.add(cli5);
		array3.add(cli6);
		
		
		ArrayList<ClientePuntaje> array4=new ArrayList<ClientePuntaje>();
		ClientePuntaje cli7=new ClientePuntaje(50,empleadoPretenso1);
		ClientePuntaje cli8=new ClientePuntaje(20,empleadoPretenso3);
		array4.add(cli7);
		array4.add(cli8);
		
		
		ArrayList<ClientePuntaje> array5=new ArrayList<ClientePuntaje>();
		ClientePuntaje cli9=new ClientePuntaje(20,empleadoPretenso3);
		array5.add(cli9);
		
		ArrayList<ClientePuntaje> array6=new ArrayList<ClientePuntaje>();
		ClientePuntaje cli10=new ClientePuntaje(50,empleadoPretenso1);
		ClientePuntaje cli11=new ClientePuntaje(20,empleadoPretenso2);
		array6.add(cli10);
		array6.add(cli11);
		ArrayList<ClientePuntaje> array7=new ArrayList<ClientePuntaje>();
		ClientePuntaje cli12=new ClientePuntaje(20,empleadoPretenso2);
		array7.add(cli12);

	
		empleadoPretenso1.setListaDePostulantes(array1);
		empleadoPretenso2.setListaDePostulantes(array2);
		empleadoPretenso3.setListaDePostulantes(array3);
		
		empleador1.setListaDePostulantes(array4);
		empleador2.setListaDePostulantes(array5);
		empleador3.setListaDePostulantes(array6);
		empleador4.setListaDePostulantes(array7);
		
		
		
		HashMap<String,Empleador> empleadores=new HashMap<String,Empleador>();
		HashMap<String,EmpleadoPretenso> empleados=new HashMap<String,EmpleadoPretenso>();
		
		empleados.put("1", empleadoPretenso1);
		empleados.put("2", empleadoPretenso2);
		empleados.put("3", empleadoPretenso3);
		
		empleadores.put("1", empleador1);
		empleadores.put("2", empleador2);
		empleadores.put("3", empleador3);
		empleadores.put("4", empleador4);
		
		System.out.println(empleadores);
		agencia.setEmpleadores(empleadores);
		agencia.setEmpleados(empleados);
		

		agencia.calculaPremiosCastigosAsignaciones();
	
		System.out.println(empleadoPretenso1.getPuntaje());
		System.out.println(empleadoPretenso2.getPuntaje());
		System.out.println(empleadoPretenso3.getPuntaje());
		
		System.out.println("----------------------------------");
		System.out.println(empleador1.getPuntaje());
		System.out.println(empleador2.getPuntaje());
		System.out.println(empleador3.getPuntaje());
		System.out.println(empleador4.getPuntaje()); 
		
	}

}

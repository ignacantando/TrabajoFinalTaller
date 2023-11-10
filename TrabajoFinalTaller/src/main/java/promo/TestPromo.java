package promo;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modeloDatos.ClientePuntaje;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import util.Constantes;

public class TestPromo {
	
	String testuserEmpleado="gonzalo";
	String testpassEmpleado="1234";
	String testrealnameEmpleado="pepe";
	String testtelEmpleado="123456";
	String testapellidoEmpleado="Lopez";
	int testedadEmpleado=5;
	
	String testuserEmpleador="pepe12";
	String testpassEmpleador="1234";
	String testrealnameEmpleador="pepe";
	String testtelEmpleador="123456";

	HashMap<String, EmpleadoPretenso> empleados;
	HashMap<String, Empleador> empleadores;
	UtilPromo promo=new UtilPromo();
	@Before
	public void setUp() throws Exception {
		empleados=new HashMap<String, EmpleadoPretenso>();
		empleadores=new HashMap<String, Empleador>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCamino1() {
		EmpleadoPretenso empleado1 = new EmpleadoPretenso(testuserEmpleado,testpassEmpleado,testrealnameEmpleado,testapellidoEmpleado,testtelEmpleado,testedadEmpleado);
		empleados.put("1", empleado1);
		ClientePuntaje cli3=new ClientePuntaje();
		ClientePuntaje cli4=new ClientePuntaje();
		ClientePuntaje cli5=new ClientePuntaje();
		ClientePuntaje cli6=new ClientePuntaje();
		ArrayList<ClientePuntaje> lista1= new ArrayList<ClientePuntaje>();
		lista1.add(cli3);
		lista1.add(cli4);
		empleado1.setListaDePostulantes(lista1);
		
		Empleador empleador=new Empleador(testuserEmpleador,testpassEmpleador,testrealnameEmpleador,testtelEmpleador,Constantes.SALUD,Constantes.JURIDICA);
		empleadores.put("1",empleador);
		empleador.setPuntaje(20);
		ClientePuntaje cli1=new ClientePuntaje(20,empleado1);
		ClientePuntaje cli2=new ClientePuntaje();
		ArrayList<ClientePuntaje> lista2= new ArrayList<ClientePuntaje>();
		lista2.add(cli1);
		lista2.add(cli2);
		lista2.add(cli5);
		lista2.add(cli6);

		empleador.setListaDePostulantes(lista2);
		//System.out.println(promo.aplicaPromo(true,empleados,empleadores));
	}
	
	@Test
	public void testCamino2() {
		EmpleadoPretenso empleado1 = new EmpleadoPretenso(testuserEmpleado,testpassEmpleado,testrealnameEmpleado,testapellidoEmpleado,testtelEmpleado,testedadEmpleado);
		empleados.put("1", empleado1);
		ClientePuntaje cli3=new ClientePuntaje();
		ClientePuntaje cli4=new ClientePuntaje();
		ClientePuntaje cli5=new ClientePuntaje();
		ClientePuntaje cli6=new ClientePuntaje();
		ArrayList<ClientePuntaje> lista1= new ArrayList<ClientePuntaje>();
		lista1.add(cli3);
		lista1.add(cli4);
		empleado1.setListaDePostulantes(lista1);
		
		Empleador empleador=new Empleador(testuserEmpleador,testpassEmpleador,testrealnameEmpleador,testtelEmpleador,Constantes.SALUD,Constantes.JURIDICA);
		empleadores.put("1",empleador);
		ClientePuntaje cli1=new ClientePuntaje();
		ClientePuntaje cli2=new ClientePuntaje();
		ArrayList<ClientePuntaje> lista2= new ArrayList<ClientePuntaje>();
		lista2.add(cli1);
		lista2.add(cli2);
		lista2.add(cli5);
		lista2.add(cli6);

		empleador.setListaDePostulantes(lista2);
		//System.out.println((promo.aplicaPromo(true,empleados,empleadores)));
	}
	
	@Test
	public void testCamino3() {
		EmpleadoPretenso empleado1 = new EmpleadoPretenso(testuserEmpleado,testpassEmpleado,testrealnameEmpleado,testapellidoEmpleado,testtelEmpleado,testedadEmpleado);
		empleados.put("1", empleado1);
		ClientePuntaje cli3=new ClientePuntaje();
		ClientePuntaje cli4=new ClientePuntaje();
		ClientePuntaje cli5=new ClientePuntaje();
		ClientePuntaje cli6=new ClientePuntaje();
		ArrayList<ClientePuntaje> lista1= new ArrayList<ClientePuntaje>();
		lista1.add(cli3);
		lista1.add(cli4);
		empleado1.setListaDePostulantes(lista1);

		
		Empleador empleador=new Empleador(testuserEmpleador,testpassEmpleador,testrealnameEmpleador,testtelEmpleador,Constantes.SALUD,Constantes.JURIDICA);
		empleadores.put("1",empleador);
		ClientePuntaje cli1=new ClientePuntaje();
		ClientePuntaje cli2=new ClientePuntaje();
		ArrayList<ClientePuntaje> lista2= new ArrayList<ClientePuntaje>();
		lista2.add(cli1);
		lista2.add(cli2);
		lista2.add(cli5);
		lista2.add(cli6);

		empleador.setListaDePostulantes(lista2);
		//System.out.println((promo.aplicaPromo(true,empleados,empleadores)));
	}
	
	@Test
	public void testCamino4() {
		EmpleadoPretenso empleado1 = new EmpleadoPretenso(testuserEmpleado,testpassEmpleado,testrealnameEmpleado,testapellidoEmpleado,testtelEmpleado,testedadEmpleado);
		empleados.put("1", empleado1);
		ClientePuntaje cli3=new ClientePuntaje();
		ClientePuntaje cli4=new ClientePuntaje();
		ClientePuntaje cli5=new ClientePuntaje();
		ArrayList<ClientePuntaje> lista1= new ArrayList<ClientePuntaje>();
		lista1.add(cli3);
		lista1.add(cli4);
		lista1.add(cli5);
		empleado1.setListaDePostulantes(lista1);
	
		
		Empleador empleador=new Empleador(testuserEmpleador,testpassEmpleador,testrealnameEmpleador,testtelEmpleador,Constantes.SALUD,Constantes.JURIDICA);
		empleadores.put("1",empleador);
		ClientePuntaje cli1=new ClientePuntaje();
		ClientePuntaje cli2=new ClientePuntaje();
		ArrayList<ClientePuntaje> lista2= new ArrayList<ClientePuntaje>();
		lista2.add(cli1);
		lista2.add(cli2);

		empleador.setListaDePostulantes(lista2);
		//System.out.println((promo.aplicaPromo(true,empleados,empleadores)));
	}
	
	@Test
	public void testCamino5() {
		EmpleadoPretenso empleado1 = new EmpleadoPretenso(testuserEmpleado,testpassEmpleado,testrealnameEmpleado,testapellidoEmpleado,testtelEmpleado,testedadEmpleado);
		empleados.put("1", empleado1);
		
		Empleador empleador=new Empleador(testuserEmpleador,testpassEmpleador,testrealnameEmpleador,testtelEmpleador,Constantes.SALUD,Constantes.JURIDICA);
		empleadores.put("1",empleador);
		ClientePuntaje cli1=new ClientePuntaje();
		ClientePuntaje cli2=new ClientePuntaje();
		ArrayList<ClientePuntaje> lista= new ArrayList<ClientePuntaje>();
		lista.add(cli1);
		lista.add(cli2);
		empleador.setListaDePostulantes(lista);
		//System.out.println((promo.aplicaPromo(true,empleados,empleadores)));
	}
	
	@Test
	public void testCamino6() {
		Empleador empleador=new Empleador(testuserEmpleador,testpassEmpleador,testrealnameEmpleador,testtelEmpleador,Constantes.SALUD,Constantes.JURIDICA);
		empleadores.put("1",empleador);
		ClientePuntaje cli1=new ClientePuntaje();
		ClientePuntaje cli2=new ClientePuntaje();
		ArrayList<ClientePuntaje> lista= new ArrayList<ClientePuntaje>();
		lista.add(cli1);
		lista.add(cli2);
		empleador.setListaDePostulantes(lista);
		//System.out.println((promo.aplicaPromo(true,empleados,empleadores)));
	}
	
	@Test
	public void testCamino7() {

		Empleador empleador=new Empleador(testuserEmpleador,testpassEmpleador,testrealnameEmpleador,testtelEmpleador,Constantes.SALUD,Constantes.JURIDICA);
		empleadores.put("1",empleador);
		//System.out.println((promo.aplicaPromo(true,empleados,empleadores)));//deberia fijarme si da null
	}
	
	@Test
	public void testCamino8() {
		//promo.aplicaPromo(true,empleados,empleadores); //deberia fijarme si da null
	}
	
	@Test
	public void testCamino9() {
		//promo.aplicaPromo(false,empleados,empleadores); //deberia fijarme si da null
	}
}

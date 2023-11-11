package testModeloDatos;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modeloDatos.Contratacion;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import util.Constantes;

public class ContratacionTest {

	String testuserEmpleador="pepe12";
	String testpassEmpleador="1234";
	String testrealnameEmpleador="pepe";
	String testtelEmpleador="123456";
	String testuserEmpleado="pepe12";
	String testpassEmpleado="1234";
	String testrealnameEmpleado="pepe";
	String testtelEmpleado="123456";
	String testapellidoEmpleado="Lopez";
	int testedadEmpleado=5;
	
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructor1() {
		Empleador empleador=new Empleador();
		EmpleadoPretenso empleado=new EmpleadoPretenso();
		
		Contratacion contrato=new Contratacion(empleador,empleado);
		
		Assert.assertEquals(empleado, contrato.getEmpleado());
		Assert.assertEquals(empleador, contrato.getEmpleador());
	}
	
	@Test
	public void testConstructor2() {
		Empleador empleador=new Empleador(testuserEmpleador,testpassEmpleador,testrealnameEmpleador,testtelEmpleador,Constantes.SALUD,Constantes.JURIDICA);

		EmpleadoPretenso empleado=new EmpleadoPretenso();
		
		Contratacion contrato=new Contratacion(empleador,empleado);
		
		Assert.assertEquals(empleado, contrato.getEmpleado());
		Assert.assertEquals(empleador, contrato.getEmpleador());
	}
	
	@Test
	public void testConstructor3() {
		Empleador empleador=new Empleador();
		EmpleadoPretenso empleado=new EmpleadoPretenso(testuserEmpleado,testpassEmpleado,testrealnameEmpleado,testapellidoEmpleado,testtelEmpleado,testedadEmpleado);
		
		Contratacion contrato=new Contratacion(empleador,empleado);
		
		Assert.assertEquals(empleado, contrato.getEmpleado());
		Assert.assertEquals(empleador, contrato.getEmpleador());
	}
	
	@Test
	public void testConstructor4() {
		Empleador empleador=new Empleador(testuserEmpleador,testpassEmpleador,testrealnameEmpleador,testtelEmpleador,Constantes.SALUD,Constantes.JURIDICA);
		EmpleadoPretenso empleado=new EmpleadoPretenso(testuserEmpleado,testpassEmpleado,testrealnameEmpleado,testapellidoEmpleado,testtelEmpleado,testedadEmpleado);
		
		Contratacion contrato=new Contratacion(empleador,empleado);
		
		Assert.assertEquals(empleado, contrato.getEmpleado());
		Assert.assertEquals(empleador, contrato.getEmpleador());
	}
	

}

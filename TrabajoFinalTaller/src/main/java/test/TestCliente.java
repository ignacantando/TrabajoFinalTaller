package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import util.Constantes;

public class TestCliente {
	
	Empleador empleador;
	EmpleadoPretenso empleado;
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
		empleador=new Empleador(testuserEmpleador,testpassEmpleador,testrealnameEmpleador,testtelEmpleador,Constantes.SALUD,Constantes.JURIDICA);
		empleado=new EmpleadoPretenso(testuserEmpleado,testpassEmpleado,testrealnameEmpleado,testapellidoEmpleado,testtelEmpleado,testedadEmpleado);
	}
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {	
	}
	@Test
	public void testTel() {
		String tel=empleador.getTelefono();
		Assert.assertEquals("El telefono es incorrecto",testtelEmpleador,tel);
	}
	
	@Test
	public void testUser() {
		String username=empleador.getUsserName();
		Assert.assertEquals("El username es incorrecto",testuserEmpleador,username);
	}
	@Test
	public void testRubro() {
		String rubro=empleador.getRubro();
		Assert.assertEquals("El rubro es incorrecto",Constantes.SALUD,rubro);
	}
	@Test
	public void testPass() {
		String password=empleador.getPassword();
		Assert.assertEquals("La password es incorrecto",testpassEmpleador,password);
	}
	@Test
	public void testTipo() {
		String tipo=empleador.getTipoPersona();
		Assert.assertEquals("El tipo es incorrecto",Constantes.JURIDICA,tipo);
	}
	@Test
	public void testNombreReal() {
		String nombrereal=empleador.getRealName();
		Assert.assertEquals("El nombrereal es incorrecto",testrealnameEmpleador,nombrereal);
	}
}

package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import util.Constantes;

public class TestModeloNegocio {
	
	Empleador empleador;
	EmpleadoPretenso empleado;
	String testuser="pepe12";
	String testpass="1234";
	String testrealname="pepe";
	String testtel="123456";
	
	@Before
	public void setUp() throws Exception {
		empleador=new Empleador(testuser,testpass,testrealname,testtel,Constantes.SALUD,Constantes.JURIDICA);
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
		Assert.assertEquals("El telefono es incorrecto",testtel,tel);
	}
	
	@Test
	public void testUser() {
		String username=empleador.getUsserName();
		Assert.assertEquals("El username es incorrecto",testuser,username);
	}
	@Test
	public void testRubro() {
		String rubro=empleador.getRubro();
		Assert.assertEquals("El rubro es incorrecto",Constantes.SALUD,rubro);
	}
	@Test
	public void testPass() {
		String password=empleador.getPassword();
		Assert.assertEquals("La password es incorrecto",testpass,password);
	}
	@Test
	public void testTipo() {
		String tipo=empleador.getTipoPersona();
		Assert.assertEquals("El tipo es incorrecto",Constantes.JURIDICA,tipo);
	}
	@Test
	public void testNombreReal() {
		String nombrereal=empleador.getRealName();
		Assert.assertEquals("El nombrereal es incorrecto",testrealname,nombrereal);
	}
}

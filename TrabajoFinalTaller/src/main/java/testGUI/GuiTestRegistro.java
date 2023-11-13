package testGUI;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Robot;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controlador.Controlador;
public class GuiTestRegistro {
	Robot robot;
    Controlador controlador;
    FalsoOptionPane op = new FalsoOptionPane();

    public GuiTestRegistro(){
        try{
            robot = new Robot();
        }
        catch (AWTException e){
        }
    }
    
    @Before
    public void setUp() throws Exception{
        controlador = new Controlador();
        controlador.setMyOptionPane(op);
        controlador.getVista().
    }

    @After
    public void tearDown() throws Exception{
        controlador.getVista().setVisible(false);
    }
    
    @Test
    public void botonRegistrarDeshabilitado() {
    	JButton registrar=(JButton) TestUtils.getComponentForName(controlador.getVista(),Constantes.REG_BUTTON_REGISTRAR);
    	Assert.assertFalse("El boton de Registrar deberia estar deshabilitado pues ningun textfield esta lleno",registrar.isEnabled());
    	robot.delay(TestUtils.getDelay());
    	
    	//Obtengo las referencias a los componentes necesarios
    	JTextField usuario= (JTextField) TestUtils.getComponentForName(controlador.getVista(),Constantes.REG_USSER_NAME);
    	JTextField contrasenia= (JTextField) TestUtils.getComponentForName(controlador.getVista(),Constantes.REG_PASSWORD);
    	JTextField repiteContrasenia= (JTextField) TestUtils.getComponentForName(controlador.getVista(),Constantes.REG_CONFIRM_PASSWORD);
    	JTextField nombre= (JTextField) TestUtils.getComponentForName(controlador.getVista(),Constantes.REG_REAL_NAME);
    	JTextField telefono= (JTextField) TestUtils.getComponentForName(controlador.getVista(),Constantes.REG_TELEFONO);
    	JTextField apellido= (JTextField) TestUtils.getComponentForName(controlador.getVista(),Constantes.REG_APELLIDO);
    	JTextField edad= (JTextField) TestUtils.getComponentForName(controlador.getVista(),Constantes.REG_EDAD);
    	JRadioButton empleado=(JRadioButton) TestUtils.getComponentForName(controlador.getVista(),Constantes.EMPLEADO);
    	
    	//Lleno los JTextField
    	TestUtils.clickComponent(usuario,robot);
    	TestUtils.tipeaTexto("textoUsuario",robot);
    	TestUtils.clickComponent(contrasenia,robot);
    	TestUtils.tipeaTexto("textoContraseña",robot);
    	TestUtils.clickComponent(repiteContrasenia,robot);
    	TestUtils.tipeaTexto("textoContraseña",robot);
    	TestUtils.clickComponent(nombre,robot);
    	TestUtils.tipeaTexto("textoRepiteContraseña",robot);
    	TestUtils.clickComponent(telefono,robot);
    	TestUtils.tipeaTexto("textoTelefono",robot);
    	TestUtils.clickComponent(empleado,robot);
    	TestUtils.tipeaTexto("textoRepiteContraseña",robot);
    	TestUtils.clickComponent(apellido,robot);
    	TestUtils.tipeaTexto("textoApellido",robot);
    	TestUtils.clickComponent(edad,robot);
    	TestUtils.tipeaTexto("-15",robot);
    	//Verifico los resultados
    	Assert.assertFalse("El boton de registrar deberia estar habilitado",registrar.isEnabled());
    }
    
    @Test
    public void empleadorBotonRegistrarHabilitado() {
    	robot.delay(TestUtils.getDelay());
    	//Obtengo las referencias a los componentes necesarios
    	JButton registrar=(JButton) TestUtils.getComponentForName(controlador.getVista(),Constantes.REG_BUTTON_REGISTRAR);
    	JTextField usuario= (JTextField) TestUtils.getComponentForName(controlador.getVista(),Constantes.REG_USSER_NAME);
    	JTextField contrasenia= (JTextField) TestUtils.getComponentForName(controlador.getVista(),Constantes.REG_PASSWORD);
    	JTextField repiteContrasenia= (JTextField) TestUtils.getComponentForName(controlador.getVista(),Constantes.REG_CONFIRM_PASSWORD);
    	JTextField nombre= (JTextField) TestUtils.getComponentForName(controlador.getVista(),Constantes.REG_REAL_NAME);
    	JTextField telefono= (JTextField) TestUtils.getComponentForName(controlador.getVista(),Constantes.REG_TELEFONO);
    	JRadioButton empleador=(JRadioButton) TestUtils.getComponentForName(controlador.getVista(),Constantes.EMPLEADOR);
    	//Lleno los JTextField
    	TestUtils.clickComponent(usuario,robot);
    	TestUtils.tipeaTexto("textoUsuario",robot);
    	TestUtils.clickComponent(contrasenia,robot);
    	TestUtils.tipeaTexto("textoContraseña",robot);
    	TestUtils.clickComponent(repiteContrasenia,robot);
    	TestUtils.tipeaTexto("textoContraseña",robot);
    	TestUtils.clickComponent(nombre,robot);
    	TestUtils.tipeaTexto("textoRepiteContraseña",robot);
    	TestUtils.clickComponent(telefono,robot);
    	TestUtils.tipeaTexto("textoTelefono",robot);
    	TestUtils.clickComponent(empleador,robot);
    	
    	//Verifico los resultados
    	Assert.assertTrue("El boton de registrar deberia estar habilitado",registrar.isEnabled());
    }
    
    @Test
    public void empleadoBotonRegistrarHabilitado(){
    	robot.delay(TestUtils.getDelay());
    	//Obtengo las referencias a los componentes necesarios
    	JButton registrar=(JButton) TestUtils.getComponentForName(controlador.getVista(),Constantes.REG_BUTTON_REGISTRAR);
    	JTextField usuario= (JTextField) TestUtils.getComponentForName(controlador.getVista(),Constantes.REG_USSER_NAME);
    	JTextField contrasenia= (JTextField) TestUtils.getComponentForName(controlador.getVista(),Constantes.REG_PASSWORD);
    	JTextField repiteContrasenia= (JTextField) TestUtils.getComponentForName(controlador.getVista(),Constantes.REG_CONFIRM_PASSWORD);
    	JTextField nombre= (JTextField) TestUtils.getComponentForName(controlador.getVista(),Constantes.REG_REAL_NAME);
    	JTextField telefono= (JTextField) TestUtils.getComponentForName(controlador.getVista(),Constantes.REG_TELEFONO);
    	JTextField apellido= (JTextField) TestUtils.getComponentForName(controlador.getVista(),Constantes.REG_APELLIDO);
    	JTextField edad= (JTextField) TestUtils.getComponentForName(controlador.getVista(),Constantes.REG_EDAD);
    	JRadioButton empleado=(JRadioButton) TestUtils.getComponentForName(controlador.getVista(),Constantes.EMPLEADO);
    	
    	//Lleno los JTextField
    	TestUtils.clickComponent(usuario,robot);
    	TestUtils.tipeaTexto("textoUsuario",robot);
    	TestUtils.clickComponent(contrasenia,robot);
    	TestUtils.tipeaTexto("textoContraseña",robot);
    	TestUtils.clickComponent(repiteContrasenia,robot);
    	TestUtils.tipeaTexto("textoContraseña",robot);
    	TestUtils.clickComponent(nombre,robot);
    	TestUtils.tipeaTexto("textoRepiteContraseña",robot);
    	TestUtils.clickComponent(telefono,robot);
    	TestUtils.tipeaTexto("textoTelefono",robot);
    	TestUtils.clickComponent(empleado,robot);
    	TestUtils.tipeaTexto("textoRepiteContraseña",robot);
    	TestUtils.clickComponent(apellido,robot);
    	TestUtils.tipeaTexto("textoApellido",robot);
    	TestUtils.clickComponent(edad,robot);
    	TestUtils.tipeaTexto("18",robot);
    	//Verifico los resultados
    	Assert.assertTrue("El boton de Registar deberia estar habilitado",registrar.isEnabled());
    }
    
    @Test
    public void botonCancelar() {
    	vista 
    }
    
}

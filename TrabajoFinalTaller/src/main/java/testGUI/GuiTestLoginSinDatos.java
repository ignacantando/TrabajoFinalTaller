package testGUI;

import static org.junit.Assert.*;

import javax.swing.*;

import java.awt.AWTException;
import java.awt.Component;
import java.awt.Robot;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import util.Constantes;
import util.Mensajes;
import vista.IVista;
import controlador.Controlador;

public class GuiTestLoginSinDatos {

	Robot robot;
    Controlador controlador;
    FalsoOptionPane op = new FalsoOptionPane();

    public GuiTestLoginSinDatos(){
        try{
            robot = new Robot();
        }
        catch (AWTException e){
        }
    }
    
    @Before
    public void setUp() throws Exception{
        controlador = new Controlador();
        controlador.setMyOptionPane(this.op);
    }

    @After
    public void tearDown() throws Exception{
        ((Component) controlador.getVista()).setVisible(false);
    }
    
    @Test
    public void botonLoginDeshabilitado() {
    	JButton login=(JButton) TestUtils.getComponentForName((Component) controlador.getVista(),Constantes.LOGIN);
    	Assert.assertFalse("El boton de Login deberia estar deshabilitado",login.isEnabled());
    }
    
    @Test
    public void botonLoginHabilitado() {
    	robot.delay(TestUtils.getDelay());
    	//Obtengo las referencias a los componentes necesarios
    	JTextField usuario= (JTextField) TestUtils.getComponentForName((Component) controlador.getVista(),Constantes.NOMBRE_USUARIO);
    	JTextField contrasenia= (JTextField) TestUtils.getComponentForName((Component) controlador.getVista(),Constantes.PASSWORD);
    	JButton login=(JButton) TestUtils.getComponentForName((Component) controlador.getVista(),Constantes.LOGIN);
    	//Lleno los JTextField
    	TestUtils.clickComponent(usuario,robot);
    	TestUtils.tipeaTexto("textoUsuario",robot);
    	TestUtils.clickComponent(contrasenia,robot);
    	TestUtils.tipeaTexto("textoContrasenia",robot);
    	//Verifico los resultados
    	Assert.assertTrue("El boton de Login deberia estar habilitado",login.isEnabled());
    }
    
    @Test
    public void loginPersonaInexistente() {
    	robot.delay(TestUtils.getDelay());
    	//Obtengo las referencias a los componentes necesarios
    	JTextField usuario= (JTextField) TestUtils.getComponentForName((Component) controlador.getVista(),Constantes.NOMBRE_USUARIO);
    	JTextField contrasenia= (JTextField) TestUtils.getComponentForName((Component) controlador.getVista(),Constantes.PASSWORD);
    	JButton login=(JButton) TestUtils.getComponentForName((Component) controlador.getVista(),Constantes.LOGIN);
    	//Lleno los JTextField
    	TestUtils.clickComponent(usuario,robot);
    	TestUtils.tipeaTexto("usuarioInexistente",robot);
    	TestUtils.clickComponent(contrasenia,robot);
    	TestUtils.tipeaTexto("contraInexistente",robot);
    	TestUtils.clickComponent(login,robot);
    	Assert.assertEquals("Mensaje incorrecto, deberia decir: "+ Mensajes.USUARIO_DESCONOCIDO.getValor(), Mensajes.USUARIO_DESCONOCIDO.getValor(),op.getMensaje());
    }
    
    @Test
    public void botonRegistroHabilitado() {
    	JButton registro=(JButton) TestUtils.getComponentForName((Component) controlador.getVista(),Constantes.REGISTRAR);
    	Assert.assertTrue("El boton de registro deberia estar deshabilitado",registro.isEnabled());
    }
    
    @Test
    public void seInvocaRegistroControlador() {
    	IVista vista=controlador.getVista();
    	JButton registro= (JButton) TestUtils.getComponentForName((Component) controlador.getVista(),Constantes.REGISTRAR);
    	TestUtils.clickComponent(registro,robot);
    	Assert.assertTrue("Se clickeo el boton de registro pero no cambio el panel",vista==controlador.getVista());
    }
}

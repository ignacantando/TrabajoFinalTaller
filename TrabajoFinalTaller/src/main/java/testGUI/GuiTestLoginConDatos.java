package testGUI;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Component;
import java.awt.Robot;

import javax.swing.JButton;
import javax.swing.JTextField;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controlador.Controlador;
import modeloNegocio.Agencia;
import util.Constantes;
import util.Mensajes;
import vista.IVista;

public class GuiTestLoginConDatos {

	Robot robot;
    Controlador controlador;
    FalsoOptionPane op = new FalsoOptionPane();

    public GuiTestLoginConDatos(){
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
        Agencia agencia= Agencia.getInstance();
        agencia.registroEmpleado("Pepe123", "contrasenia", "Pedro", "Arias", "2235947965", 23);
    }
    
    @After
    public void tearDown() throws Exception{
    	
        ((Component) controlador.getVista()).setVisible(false);
    }
    
    @Test
    public void contraseniaEquivocada() {
    	robot.delay(TestUtils.getDelay());
    	//Obtengo las referencias a los componentes necesarios
    	JTextField usuario= (JTextField) TestUtils.getComponentForName((Component) controlador.getVista(),Constantes.NOMBRE_USUARIO);
    	JTextField contrasenia= (JTextField) TestUtils.getComponentForName((Component) controlador.getVista(),Constantes.PASSWORD);
    	JButton login=(JButton) TestUtils.getComponentForName((Component) controlador.getVista(),Constantes.LOGIN);
    	//Lleno los JTextField
    	TestUtils.clickComponent(usuario,robot);
    	TestUtils.tipeaTexto("pepe123",robot);
    	TestUtils.clickComponent(contrasenia,robot);
    	TestUtils.tipeaTexto("contraErronea",robot);
    	TestUtils.clickComponent(login,robot);
    	Assert.assertEquals("Mensaje incorrecto, deberia decir: "+ Mensajes.PASS_ERRONEO.getValor(), Mensajes.PASS_ERRONEO.getValor(),op.getMensaje());
    }
    
    @Test
    public void botonLoginFunciona() {
    	IVista vista=controlador.getVista();
    	robot.delay(TestUtils.getDelay());
    	//Obtengo las referencias a los componentes necesarios
    	JTextField usuario= (JTextField) TestUtils.getComponentForName((Component) controlador.getVista(),Constantes.NOMBRE_USUARIO);
    	JTextField contrasenia= (JTextField) TestUtils.getComponentForName((Component) controlador.getVista(),Constantes.PASSWORD);
    	JButton login=(JButton) TestUtils.getComponentForName((Component) controlador.getVista(),Constantes.LOGIN);
    	//Lleno los JTextField
    	TestUtils.clickComponent(usuario,robot);
    	TestUtils.tipeaTexto("pepe123",robot);
    	TestUtils.clickComponent(contrasenia,robot);
    	TestUtils.tipeaTexto("contrasenia",robot);
    	TestUtils.clickComponent(login,robot);
    	
    	Assert.assertTrue("El boton login no funciona, no redirecciona al panel correspondiente",vista==controlador.getVista());
    }
}

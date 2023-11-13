package testGUI;

import static org.junit.Assert.*;

import org.junit.Test;

public class GuiTestLogin {

	Robot robot;
    Controlador controlador;
    FalsoOptionPane op = new FalsoOptionPane();

    public GuiTestLogin(){
        try{
            robot = new Robot();
        }
        catch (AWTException e){
        }
    }
    
    @Before
    public void setUp() throws Exception{
        controlador = new Controlador();
        controlador.setOptionpane(op);
    }

    @After
    public void tearDown() throws Exception{
        controlador.getVentana().setVisible(false);
    }
    
    @Test
    public void botonLoginDeshabilitado() {
    	JButton login=(JButton) TestUtils.getComponentForName(controlador.getVista(),Constantes.LOGIN);
    	Assert.assertFalse("El boton de Login deberia estar deshabilitado",login.isEnabled());
    }
    
    @Test
    public void botonLoginHabilitado() {
    	robot.delay(TestUtils.getDelay());
    	//Obtengo las referencias a los componentes necesarios
    	JTextField usuario= (JTextField) TestUtils.getComponentForName(controlador.getVista(),Constantes.NOMBRE_USUARIO);
    	JTextField contrasenia= (JTextField) TestUtils.getComponentForName(controlador.getVista(),Constantes.PASSWORD);
    	JButton login=(JButton) TestUtils.getComponentForName(controlador.getVista(),Constantes.LOGIN);
    	//Lleno los JTextField
    	TestUtils.clickComponent(usuario,robot);
    	TestUtils.tipeaTexto("textoUsuario",robot);
    	TestUtils.clickComponent(contrasenia,robot);
    	TestUtils.tipeaTexto("textoContraseña",robot);
    	//Verifico los resultados
    	Assert.assertTrue("El boton de Login deberia estar habilitado",login.isEnabled());
    }
    
    @Test
    public void seInvocaLoginControlador() {
    	robot.delay(TestUtils.getDelay());
    	//Obtengo las referencias a los componentes necesarios
    	JTextField usuario= (JTextField) TestUtils.getComponentForName(controlador.getVista(),Constantes.NOMBRE_USUARIO);
    	JTextField contrasenia= (JTextField) TestUtils.getComponentForName(controlador.getVista(),Constantes.PASSWORD);
    	JButton login=(JButton) TestUtils.getComponentForName(controlador.getVista(),Constantes.LOGIN);
    	//Lleno los JTextField
    	TestUtils.clickComponent(usuario,robot);
    	TestUtils.tipeaTexto("textoUsuario",robot);
    	TestUtils.clickComponent(contrasenia,robot);
    	TestUtils.tipeaTexto("textoContraseña",robot);
    	//Verifico los resultados
    }
    
    @Test
    public void botonRegistroHabilitado() {
    	JButton registro=(JButton) TestUtils.getComponentForName(controlador.getVista(),Constantes.REGISTRAR);
    	Assert.assertFalse("El boton de registro deberia estar deshabilitado",registro.isEnabled());
    }
    
    @Test
    public void seInvocaRegistroControlador() {
    	IVista vista=controlador.getVista();
    	JButton registro= (JButton) TestUtils.getComponentForName(controlador.getVista(),Constantes.REGISTRAR);
    	TestUtils.clickComponent(registro,robot);
    	Assert.assertTrue("Se clickeo el boton de registro pero no cambio el panel",vista==controlador.getVista())
    }
}

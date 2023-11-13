package testGUI;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GuiTestAdmin {
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
    public void botonModificaValoresDeshabilitado() {
    	
    }
    
    @Test
    public void botonModificaValoresHabilitado() {
    	
    }
    
    @Test
    public void botonGatillar() {
    	
    }
    
    @Test
    public void botonAplicarPromo() {
    	
    }
    
    @Test
    public void botonCerrarSesion() {
    	
    }
    
}

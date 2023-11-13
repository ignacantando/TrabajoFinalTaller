package testGUI;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GuiTestCliente {
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
        controlador.goToRegistro();
        TestUtil
        controlador.setVista(controlador.getVista().goToCliente());
    }

    @After
    public void tearDown() throws Exception{
        controlador.getVentana().setVisible(false);
    }
    
	@Test
	public void botonSeleccionarCandidato() {
		
	}
	
	@Test
	public void panelTicketBotonConfirmarNuevoTicketDeshabilitados() {
		
	}
    
	@Test
	public void botonNuevoTicketHabilitado() {
		
	}
    
	@Test
	public void botonEliminarTicketDeshabilitado() {
		
	}
	
	@Test
	public void botonEliminarTicketHabilitado() {
		
	}
	
	
}

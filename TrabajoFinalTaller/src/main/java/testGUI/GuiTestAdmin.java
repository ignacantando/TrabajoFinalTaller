package testGUI;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Component;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controlador.Controlador;

public class GuiTestAdmin {
	Robot robot;
    Controlador controlador;
    FalsoOptionPane op = new FalsoOptionPane();

    public GuiTestAdmin(){
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
    }

    @After
    public void tearDown() throws Exception{
        ((Component) controlador.getVista()).setVisible(false);
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

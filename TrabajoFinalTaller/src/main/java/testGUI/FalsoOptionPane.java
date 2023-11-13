package testGUI;

import vista.IOptionPane;

import java.awt.Component;

public class FalsoOptionPane implements IOptionPane{
    private String mensaje = null;

    public FalsoOptionPane() {
        super();
    }

    public void ShowMessage(Component parent, String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

	@Override
	public void ShowMessage(String arg0) {
		// TODO Auto-generated method stub
		
	}
}

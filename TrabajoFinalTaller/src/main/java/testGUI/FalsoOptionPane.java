package testGUI;

import gui.IOptionPanel;

import java.awt.Component;

public class FalsoOptionPane implements InterfazOptionPanel {
    private String mensaje = null;

    public FalsoOptionPane() {
        super();
    }

    @Override
    public void ShowMessage(Component parent, String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}

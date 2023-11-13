package testGUI;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@Suite.SuiteClasses({GuiTestLoginSinDatos.class, GuiTestLoginConDatos.class, GuiTestRegistro.class, GuiTestAdmin.class, GuiTestCliente.class})

public class AllTests {
}

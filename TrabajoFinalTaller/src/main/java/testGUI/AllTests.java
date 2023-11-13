package testGUI;
import org.junit
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@Suite.SuiteClasses({GuiTestLoginSinDatos.class, GuiTestRegistro.class, GuiTestAdmin.class, GuiTestCliente.class})

public class AllTests {
}

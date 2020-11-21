package example

import com.formdev.flatlaf.FlatLightLaf
import swing.KotlingApp
import java.util.*
import javax.swing.SwingUtilities
import javax.swing.UIManager

class MyApp : KotlingApp(DemoView())

fun main() {
    Locale.setDefault(Locale.GERMAN) // ensure a default local exists

    // UI Manager stuff - not sure to rely on the UIManager
    UIManager.setLookAndFeel(FlatLightLaf())
    UIManager.getDefaults().addResourceBundle("swing.demo");

    SwingUtilities.invokeLater(MyApp())
}






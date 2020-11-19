package swing

import com.formdev.flatlaf.FlatLightLaf
import java.util.*
import javax.swing.SwingUtilities
import javax.swing.UIManager

class MyApp : KotlingApp(DemoView())

fun main() {
    Locale.setDefault(Locale.GERMAN) // ensure a default local exists
    UIManager.setLookAndFeel(FlatLightLaf())
    SwingUtilities.invokeLater(MyApp())
}






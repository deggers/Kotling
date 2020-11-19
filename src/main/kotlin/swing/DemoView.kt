package swing

import swing.layouts.BorderPane
import swing.layouts.KLabel.Companion.kLabel
import java.awt.Color
import java.awt.Dimension
import javax.swing.JPanel

class DemoView : KotlingView("Demo") {
    override val root = BorderPane.borderPane {
        top = JPanel().also {
            it.background = Color.ORANGE
            it.preferredSize = Dimension(200, 200)
        }
        left = JPanel().also {
            it.background = Color.RED
            it.preferredSize = Dimension(200, 200)
        }
        bottom = JPanel().also {
            it.background = Color.GREEN
            it.preferredSize = Dimension(200, 200)
        }
        right = JPanel().also {
            it.background = Color.BLUE
            it.preferredSize = Dimension(200, 200)
        }
        center = kLabel { lookupKey = "hello" }
    }
}

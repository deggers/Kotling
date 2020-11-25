package example

import swing.KotlingView
import swing.components.KButton.Companion.kButton
import swing.layouts.BorderPane.Companion.borderPane
import java.awt.Color
import java.awt.Dimension
import javax.swing.JPanel

class BorderPaneDemoView : KotlingView("Demo") {
    override val root = borderPane {
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
        center = kButton {
            lookupKey = "hello"
            onClick = { fire(" clicked") }
        }
    }
}

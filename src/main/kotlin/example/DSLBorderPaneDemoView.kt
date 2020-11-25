package example

import swing.KotlingView
import swing.layouts.KBorderPane.Companion.borderPane
import java.awt.Color
import java.awt.Dimension
import javax.swing.JPanel

class DSLBorderPaneDemoView : KotlingView("Demo") {
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
        center = JPanel().also {
            it.background = Color.LIGHT_GRAY
        }
    }
}
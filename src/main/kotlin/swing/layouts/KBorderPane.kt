package swing.layouts

import java.awt.BorderLayout
import javax.swing.JComponent
import javax.swing.JPanel

data class KBorderPane(
    var top: JComponent = JPanel(),
    var right: JComponent = JPanel(),
    var bottom: JComponent = JPanel(),
    var left: JComponent = JPanel(),
    var center: JComponent = JPanel()
) : JPanel(BorderLayout()) {

    init {
        add(top, BorderLayout.NORTH)
        add(right, BorderLayout.EAST)
        add(bottom, BorderLayout.SOUTH)
        add(left, BorderLayout.WEST)
        add(center, BorderLayout.CENTER)
    }

    class Builder {
        var top: JComponent = JPanel()
        var right: JComponent = JPanel()
        var bottom: JComponent = JPanel()
        var left: JComponent = JPanel()
        var center: JComponent = JPanel()
        fun build() = KBorderPane(this)
    }

    constructor(builder: Builder) : this(
        builder.top,
        builder.right,
        builder.bottom,
        builder.left,
        builder.center
    )

    companion object {
        inline fun borderPane(block: Builder.() -> Unit) = Builder().apply(block).build()
    }
}

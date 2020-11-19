package swing.layouts

import java.awt.BorderLayout
import javax.swing.JComponent
import javax.swing.JPanel

class BorderPane(
    top: JComponent?,
    right: JComponent?,
    bottom: JComponent?,
    left: JComponent?,
    center: JComponent?
) : JPanel(BorderLayout()) {

    init {
        if (top != null) add(top, BorderLayout.NORTH)
        if (right != null) add(right, BorderLayout.EAST)
        if (bottom != null) add(bottom, BorderLayout.SOUTH)
        if (left != null) add(left, BorderLayout.WEST)
        if (center != null) add(center, BorderLayout.CENTER)
    }

    class Builder {
        var top: JComponent? = null
        var right: JComponent? = null
        var bottom: JComponent? = null
        var left: JComponent? = null
        var center: JComponent? = null
        fun build() = BorderPane(this)
    }

    private constructor(builder: Builder) : this(
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

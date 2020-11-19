package swing.layouts

import translation.I18n
import java.awt.Graphics
import javax.swing.JLabel

class KLabel(private val lookupKey: String) : JLabel() {
    private val i18n = I18n()

    class Builder {
        lateinit var lookupKey: String // Throws compile time Error if not provided
        fun build() = KLabel(this)
    }

    private constructor(builder: Builder) : this(
        builder.lookupKey
    )

    companion object {
        inline fun kLabel(block: Builder.() -> Unit) = Builder().apply(block).build()
    }

    override fun paint(g: Graphics?) {
        super.paint(g)
        text = i18n.translate(lookupKey)
        revalidate()
    }

}
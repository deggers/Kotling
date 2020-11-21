package swing.components

import translation.I18n
import java.awt.Graphics
import java.awt.event.ActionEvent
import javax.swing.JButton

class KButton(
    private val lookupKey: String,
    onClick: (e: ActionEvent) -> Unit
) : JButton() {
    private val i18n = I18n()

    init {
        addActionListener(onClick)
    }
    
    class Builder {
        lateinit var lookupKey: String
        lateinit var onClick: (event: ActionEvent) -> Unit
        fun build(): KButton = KButton(builder = this)
    }

    private constructor(builder: Builder) : this(
        builder.lookupKey,
        builder.onClick
    )

    companion object {
        inline fun kButton(block: Builder.() -> Unit) = Builder().apply(block).build()
    }

    override fun paint(g: Graphics?) {
        super.paint(g)
        text = i18n.translate(lookupKey)
        revalidate()
    }

}

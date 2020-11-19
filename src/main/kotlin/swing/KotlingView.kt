package swing

import translation.I18n

/*
A KotlingView will be set into the frame
which is instantiated from KotlingApp
 */

abstract class KotlingView(title: String) : KotlingUIComponent(title) {
    private val i18n = I18n()
    fun translate(text: String): String = i18n.translate(text)
}

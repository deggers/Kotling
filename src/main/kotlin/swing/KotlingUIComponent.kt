package swing

import javax.swing.JComponent

/* @TODO
   - Should listen to local change events and set it on JComponent?
   - Then KotlingUIComponent needs access to some EventBus ? Or can
     be make use of the propagated PropertyChangeEvents ?
   - Does every UiComponent has access to the LanguageContext?
 */
abstract class KotlingUIComponent(var title: String = "") {
    abstract val root: JComponent

    fun fire(value: String) {
        println(value)
    }

}
package swing

import java.util.*
import javax.swing.JFrame

/*
KotlingApp will add the KotlingUIComponent to the frame
A Swing.Frame can only hold one JComponent

@TODO A Frame has a locale - how to deal with it?
@TODO Add localitation to the Swing Components
*/

open class KotlingApp(private val primaryView: KotlingUIComponent) : Runnable {
    override fun run() {
        val myFrame = JFrame(primaryView.title)

        /* @TODO
        This will fire up an PropertyChange for "local"
        As well invalidating the form because resizing might needed
        - Use EventBus (google) to listen for local changes which catched from KotlingUIComponent?
         */
        myFrame.locale = Locale.GERMAN
        // @TODO JFrame listens to ClientLanguageChange event..
        myFrame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE

        myFrame.add(primaryView.root)
        myFrame.setSize(300, 200)
        myFrame.isVisible = true
    }
}

package swing

import java.awt.BorderLayout
import java.awt.Container
import java.util.*
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.UIManager

/*
KotlingApp will add the KotlingUIComponent to the frame
A Swing.Frame can only hold one JComponent

@TODO A Frame has a locale - how to deal with it?
@TODO Add localitation to the Swing Components
*/

open class KotlingApp(private val primaryView: KotlingUIComponent) : Runnable {
    override fun run() {
        val myFrame = JFrame(primaryView.title)
        myFrame.layout = BorderLayout()

        /* @TODO
        This will fire up an PropertyChange for "local"
        As well invalidating the form because resizing might needed
        - Use EventBus (google) to listen for local changes which catched from KotlingUIComponent?
         */
        myFrame.locale = Locale.GERMAN
        // @TODO JFrame listens to ClientLanguageChange event..
        myFrame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE

        myFrame.add(primaryView.root, BorderLayout.CENTER)

        val myButton = JButton("To english").also {
            it.addActionListener {
                myFrame.locale = Locale.ENGLISH
                primaryView.root.locale = Locale.ENGLISH
            }
        }


        myFrame.add(myButton, BorderLayout.NORTH)

        myFrame.setSize(300, 200)
        myFrame.isVisible = true
    }
}

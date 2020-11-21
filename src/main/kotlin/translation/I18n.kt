package translation

import javax.swing.UIManager

// @TODO :: Error Handling ..
// @TODO should be created from Guice and passed around
class I18n {
    // Use the UIManager has it has proven logic built on to receive the bundles for the current local
    fun translate(key: String): String = UIManager.getString(key)
}
package translation

import java.util.*
import java.util.Locale
import java.util.ResourceBundle.getBundle


/*
@TODO did not work with overriding existing UI Delegates..
After knowing the internals of the Swing architecture, we are ready to make the Swing components aware
of locale switches at runtime. To achieve such a behavior, we will introduce one more level of indirection.
Instead of just setting a text field of a component to the real string which should be displayed, we set the
field to contain a key string instead. Then we override the UI delegate in such a way that instead of just
painting the string obtained from its associated component, it will look up the real value of the string
to paint depending on the actual locale. Source: http://www.progdoc.de/papers/intSwing/intswing/intswing.html
UI delegate for JLable
 */

// @TODO :: Error Handling ..
// @TODO should be created from Guice and passed around
class I18n {
    /*
    Notice that for performance reasons, getResourceString() stores resource files in a static map
    after using them for the first time. Thus, any further access will use this cached version, without
    the need to reload the file once again.
     */
    private val resourceBundles: Hashtable<String, ResourceBundle> = Hashtable<String, ResourceBundle>()

    /*
    Takes the System Locale to determine the displayed language :)
    but only used in Labels .. why make this publicaly available..
     */
    fun translate(key: String): String {
        if (key == "") {
            print("Empty input") // @TODO log this and monitor..
            return ""
        }
        val baseName = "swing.demo"
        val locale: Locale = Locale.getDefault()
        var resource: ResourceBundle? = resourceBundles[baseName + "_" + locale.toString()]
        if (resource == null) {
            try {
                resource = getBundle(baseName, locale)
                if (resource != null) {
                    resourceBundles[baseName + "_" + locale.toString()] = resource
                }
            } catch (e: Exception) {
                println(e)
            }
        }
        if (resource != null) {
            try {
                val value = resource.getString(key)
                if (value != null) return value
            } catch (mre: MissingResourceException) {
            }
        } else {
            print("Key not found for $key") //@TODO log and monitor
        }
        return "**$key**"
    }
}
import csstype.NamedColor
import csstype.Properties
import csstype.px
import emotion.css.css
import kotlinx.browser.document
import org.w3c.dom.ElementCreationOptions
import org.w3c.dom.get
import react.create
import react.dom.client.createRoot

fun main() {
    val container = document.getElementById("root")
    createRoot(container!!).render(App.create())
}
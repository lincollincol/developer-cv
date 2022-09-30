package widgets

import csstype.*
import emotion.react.css
import react.ChildrenBuilder
import react.dom.html.ReactHTML.a
import react.dom.html.ReactHTML.p
import react.dom.html.ReactHTML.span
import theme.Colors

fun ChildrenBuilder.TitleText(
    text: String,
    fontSize: FontSize = 6.vmin,
    extraStyleProperties: (PropertiesBuilder.() -> Unit)? = null

) = p { Text(text = text, fontSize = fontSize, fontWeight = FontWeight.bold, extraStyleProperties = extraStyleProperties) }

fun ChildrenBuilder.Text(
    text: String,
    fontSize: FontSize = 3.vmin,
    fontWeight: FontWeight = FontWeight.normal,
    color: Color = Colors.primary,
    extraStyleProperties: (PropertiesBuilder.() -> Unit)? = null
) {
    span {
        css {
            this.fontSize = fontSize
            this.fontWeight = fontWeight
            this.color = color
            extraStyleProperties?.invoke(this)
        }
        +text
    }
}

fun ChildrenBuilder.LinkText(
    text: String,
    url: String,
    fontSize: FontSize = 3.vmin,
    fontWeight: FontWeight = FontWeight.normal,
    extraStyleProperties: (PropertiesBuilder.() -> Unit)? = null
) = a {
    css {
        if(url.isEmpty()) pointerEvents = None.none
    }
    href = url
    Text(text, fontSize, fontWeight, Colors.secondary, extraStyleProperties)
}
package widgets

import csstype.*
import emotion.react.css
import react.ChildrenBuilder
import react.dom.html.ReactHTML.a
import react.dom.html.ReactHTML.li
import react.dom.html.ReactHTML.p
import react.dom.html.ReactHTML.span
import theme.Colors

fun ChildrenBuilder.TitleText(
    text: String,
    fontSize: FontSize = 6.vmin,
    onClick: (() -> Unit)? = null,
    extraStyleProperties: (PropertiesBuilder.() -> Unit)? = null
) = p {
    Text(
        text = text,
        fontSize = fontSize,
        fontWeight = FontWeight.bold,
        onClick = onClick,
        extraStyleProperties = extraStyleProperties)
}

fun ChildrenBuilder.LinkText(
    text: String,
    url: String,
    fontSize: FontSize = 3.vmin,
    fontWeight: FontWeight = FontWeight.normal,
    onClick: (() -> Unit)? = null,
    extraStyleProperties: (PropertiesBuilder.() -> Unit)? = null
) = a {
    css {
        if(url.isEmpty()) pointerEvents = None.none
    }
    href = url
    Text(
        text = text,
        fontSize = fontSize,
        fontWeight = fontWeight,
        color = Colors.secondary,
        onClick = onClick,
        extraStyleProperties = extraStyleProperties
    )
}

fun ChildrenBuilder.ListText(
    text: String,
    fontSize: FontSize = 3.vmin,
    fontWeight: FontWeight = FontWeight.normal,
    color: Color = Colors.primary,
    onClick: (() -> Unit)? = null,
    extraStyleProperties: (PropertiesBuilder.() -> Unit)? = null
) {
    li {
        Text(
            text = text,
            fontSize = fontSize,
            fontWeight = fontWeight,
            color = color,
            onClick = onClick,
            extraStyleProperties = extraStyleProperties
        )
    }
}

fun ChildrenBuilder.Text(
    text: String,
    fontSize: FontSize = 3.vmin,
    fontWeight: FontWeight = FontWeight.normal,
    color: Color = Colors.primary,
    onClick: (() -> Unit)? = null,
    extraStyleProperties: (PropertiesBuilder.() -> Unit)? = null
) {
    span {
        css {
            this.fontSize = fontSize
            this.fontWeight = fontWeight
            this.color = color
            extraStyleProperties?.invoke(this)
        }
        this.onClick = { onClick?.invoke() }
        +text
    }
}

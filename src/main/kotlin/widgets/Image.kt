package widgets

import csstype.*
import emotion.react.css
import react.ChildrenBuilder
import react.dom.html.AnchorTarget
import react.dom.html.ReactHTML
import react.dom.html.ReactHTML.a
import react.dom.html.ReactHTML.img
import theme.Colors

fun ChildrenBuilder.Image(
    src: String,
    width: Width,
    height: Height,
    radius: BorderRadius = 30.pct,
    fit: ObjectFit = ObjectFit.contain,
    backgroundColor: BackgroundColor = Colors.primary,
    extraStyleProperties: (PropertiesBuilder.() -> Unit)? = null,
    onClick: (() -> Unit)? = null,
) {
    img {
        css {
            this.width = width
            this.height = height
            this.borderRadius = radius
            this.objectFit = fit
            this.backgroundColor = backgroundColor
            extraStyleProperties?.invoke(this)
        }
        this.src = src
        this.onClick = { onClick?.invoke() }
    }
}

fun ChildrenBuilder.LinkImage(
    src: String,
    url: String,
    width: Width,
    height: Height,
    radius: BorderRadius = 30.pct,
    fit: ObjectFit = ObjectFit.contain,
    backgroundColor: BackgroundColor = Colors.primary,
    target: AnchorTarget = AnchorTarget._blank,
    extraStyleProperties: (PropertiesBuilder.() -> Unit)? = null
) {
    a {
        this.href = url
        this.target = target
        Image(src, width, height, radius, fit, backgroundColor, extraStyleProperties)
    }
}
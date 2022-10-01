package widgets

import csstype.*
import emotion.react.css
import react.ChildrenBuilder
import react.dom.html.ReactHTML.div

fun <T> ChildrenBuilder.Column(
    items: List<T>,
    justifyContent: JustifyContent = JustifyContent.normal,
    extraStyleProperties: (PropertiesBuilder.() -> Unit)? = null,
    itemBuilder: ChildrenBuilder.(T) -> Unit
) = List(
    items = items,
    justifyContent = justifyContent,
    flexDirection = FlexDirection.column,
    extraStyleProperties = extraStyleProperties ?: {},
    itemBuilder = itemBuilder
)

fun <T> ChildrenBuilder.Row(
    items: List<T>,
    justifyContent: JustifyContent = JustifyContent.normal,
    extraStyleProperties: (PropertiesBuilder.() -> Unit)? = null,
    itemBuilder: ChildrenBuilder.(T) -> Unit
) = List(
    items = items,
    justifyContent = justifyContent,
    flexDirection = FlexDirection.row,
    extraStyleProperties = extraStyleProperties ?: {},
    itemBuilder = itemBuilder
)

private fun <T> ChildrenBuilder.List(
    items: List<T>,
    justifyContent: JustifyContent,
    flexDirection: FlexDirection,
    extraStyleProperties: PropertiesBuilder.() -> Unit,
    itemBuilder: ChildrenBuilder.(T) -> Unit
) {
    div {
        css {
            this.display = Display.flex
            this.flexDirection = flexDirection
            this.justifyContent = justifyContent
            extraStyleProperties.invoke(this)
        }
        items.forEach {
            itemBuilder.invoke(this, it)
        }
    }
}
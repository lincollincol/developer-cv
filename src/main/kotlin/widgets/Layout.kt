package widgets

import csstype.*
import csstype.LineStyle.Companion.solid
import emotion.react.css
import react.ChildrenBuilder
import react.dom.html.ReactHTML.div
import utils.margin


fun ChildrenBuilder.Box(
    width: Width,
    height: Height,
//    alignItems: AlignItems = AlignItems.center,
    backgroundColor: BackgroundColor? = null,
    border: Border? = null,
    borderRadius: BorderRadius? = null,
    extraStyleProperties: (PropertiesBuilder.() -> Unit)? = null,
    boxBuilder: ChildrenBuilder.() -> Unit
) {
    div {
        css {
            this.width = width
            this.height = height
//            this.alignItems = alignItems
            this.backgroundColor = backgroundColor
            this.border = border
            this.borderRadius = borderRadius
            extraStyleProperties?.invoke(this)
        }
        boxBuilder.invoke(this)
    }
}

fun ChildrenBuilder.Column(
    extraStyleProperties: (PropertiesBuilder.() -> Unit)? = null,
    columnBuilder: ChildrenBuilder.() -> Unit
) {
    div {
        css {
            display = Display.flex
            flexDirection = FlexDirection.column
            extraStyleProperties?.invoke(this)
        }
        columnBuilder.invoke(this)
    }
}

fun ChildrenBuilder.Row(
    extraStyleProperties: (PropertiesBuilder.() -> Unit)? = null,
    columnBuilder: ChildrenBuilder.() -> Unit
) {
    div {
        css {
            display = Display.flex
            flexDirection = FlexDirection.row
            extraStyleProperties?.invoke(this)
        }
        columnBuilder.invoke(this)
    }
}

fun <T> ChildrenBuilder.ColumnList(
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

fun <T> ChildrenBuilder.RowList(
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
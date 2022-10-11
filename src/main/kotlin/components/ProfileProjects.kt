package components

import csstype.*
import emotion.react.css
import model.Project
import react.ChildrenBuilder
import react.dom.html.ReactHTML.div
import theme.Colors
import theme.Icons
import utils.margin
import widgets.*

fun ChildrenBuilder.ProfileProjects(projects: List<Project>) {
    Column {
        TitleText(text = "Interesting projects")
        ColumnList(items = projects) { ProjectItem(it) }
    }
}

fun ChildrenBuilder.ProjectItem(project: Project) {
    Row(
        extraStyleProperties = {
            margin(vertical = 2.vmin)
            alignItems = AlignItems.center
        }
    ) {
        if(project.image.isEmpty()) {
            Box(
                width = 12.vmin,
                height = 12.vmin,
                borderRadius = 30.pct,
                backgroundColor = Colors.primary,
                extraStyleProperties = {
                    display = Display.flex
                    justifyContent = JustifyContent.center
                    alignItems = AlignItems.center
                }
            ) {
                Text(
                    text = project.name.filter { it.isUpperCase() },
                    fontSize = 6.vmin,
                    fontWeight = FontWeight.bold,
                    color = Colors.secondary
                )
            }
        } else {
            Image(
                src = project.image,
                width = 12.vmin,
                height = 12.vmin,
                radius = 30.pct
            )
        }
        Column(
            extraStyleProperties = { margin(horizontal = 2.vmin) }
        ) {
            Row(
                extraStyleProperties = {
                    alignItems = AlignItems.center
                }
            ) {
                LinkText(
                    project.name,
                    project.url,
                    fontWeight = FontWeight.bold,
                )
                if(project.isOpenSource) {
                    Image(
                        src = Icons.OpenSource,
                        width = 2.5.vmin,
                        height = 2.5.vmin,
                        backgroundColor = null,
                        extraStyleProperties = { margin(horizontal = 1.vmin) }
                    )
                }
            }
            Text(project.description, fontSize = 2.5.vmin)
        }
    }
}
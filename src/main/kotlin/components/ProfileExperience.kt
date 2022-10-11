package components

import csstype.*
import emotion.react.css
import model.WorkExperience
import react.ChildrenBuilder
import react.dom.html.ReactHTML.div
import theme.Colors
import utils.margin
import widgets.*

fun ChildrenBuilder.ProfileWorkExperience(workExperience: List<WorkExperience>) {
    Column {
        TitleText("Professional Experience")
        workExperience.forEach { experience ->
            WorkExperienceItem(experience)
        }
    }
}

fun ChildrenBuilder.WorkExperienceItem(workExperience: WorkExperience) {
    Row(
        extraStyleProperties = { margin(vertical = 2.vmin) }
    ) {
        if(workExperience.image.isEmpty()) {
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
                    text = workExperience.company.filter { it.isUpperCase() },
                    fontWeight = FontWeight.bold,
                    color = Colors.secondary
                )
            }
        } else {
            Image(
                src = workExperience.image,
                width = 12.vmin,
                height = 12.vmin,
                radius = 25.pct
            )
        }
        Column(extraStyleProperties = { margin(horizontal = 2.vmin) }) {
            LinkText(workExperience.company, "", fontWeight = FontWeight.bold)
            Text(workExperience.dates, fontSize = 2.5.vmin)
            Text(workExperience.role, fontSize = 2.5.vmin)
            ColumnList(
                items = workExperience.responsibilities,
                extraStyleProperties = { margin(vertical = 1.vmin) }
            ) {
                ListText(it.name, fontSize = 2.5.vmin)
            }
        }
    }
}
/*


*


 */
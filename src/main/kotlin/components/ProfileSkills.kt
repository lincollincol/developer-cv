package components

import csstype.*
import emotion.react.css
import model.Skill
import react.ChildrenBuilder
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.li
import react.dom.html.ReactHTML.p
import react.dom.html.ReactHTML.span

fun ChildrenBuilder.ProfileSkills(skills: List<Skill>) {
    div {
        css {
            width = 70.pct
            display = Display.flex
            flexDirection = FlexDirection.column
        }
        p {
            css {
                fontSize = 6.vmin
                fontWeight = FontWeight.bold
            }
            +"Skills"
        }
        skills.forEach { skill ->
            SkillItem(skill)
        }
    }
}

private fun ChildrenBuilder.SkillItem(skill: Skill) {
    div {
        css {
            fontSize = 3.vmin
            display = Display.flex
            flexDirection = FlexDirection.column
        }
        li { +skill.name }
//        span { +skill.name }
    }
}
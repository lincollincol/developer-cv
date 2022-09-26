import csstype.*
import react.FC
import react.Props
import emotion.react.css
import kotlinx.browser.document
import react.ChildrenBuilder
import react.dom.html.InputType
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.input
import react.useState

external interface WelcomeProps : Props {
    var name: String
}

val Welcome = FC<WelcomeProps> { props ->
    var name by useState(props.name)
    div {
        css {
            padding = 5.px
            backgroundColor = Color("#000000")
            color = rgb(56, 246, 137)
            width = (document.body!!.clientWidth / 4).px
            height = document.body!!.clientHeight.px
        }
    }
    /*div {
        css {
            padding = 5.px
            backgroundColor = rgb(8, 97, 22)
            color = rgb(56, 246, 137)
        }
        +"Hello, $name"
    }
    input {
        css {
            marginTop = 5.px
            marginBottom = 5.px
            fontSize = 14.px
        }
        type = InputType.text
        value = name
        onChange = { event ->
            name = event.target.value
        }
    }
    input {
        css {
            marginTop = 5.px
            marginBottom = 5.px
            fontSize = 14.px
        }
        type = InputType.button
        value = "Change name"
        onClick = {
            name = "Clicked"
        }
    }*/
}

private fun ChildrenBuilder.menuOptions() {
    div {
        css {
            padding = 5.px
            backgroundColor = rgb(8, 97, 22)
            color = rgb(56, 246, 137)
        }
        +"Hello"
    }
}
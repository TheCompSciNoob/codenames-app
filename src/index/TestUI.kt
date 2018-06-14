package index

import kotlinx.html.js.onInputFunction
import org.w3c.dom.HTMLInputElement
import react.*
import react.dom.*

interface TestState: RState {
    var updateText: String
}

class TestUI: RComponent<RProps, TestState>() {

    override fun RBuilder.render() {
        h1 { +"Hello World" }
        p { +state.updateText }
        input {
            attrs {
                onInputFunction = {
                    val target = it.target as HTMLInputElement
                    setState { updateText = target.value }
                }
            }
        }
    }

    override fun TestState.init() {
        updateText = ""
    }
}

fun RBuilder.testUI() = child(TestUI::class) {}

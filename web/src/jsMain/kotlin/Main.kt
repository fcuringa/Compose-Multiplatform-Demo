import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import org.example.kmpdemo.domain.Counter
import org.example.kmpdemo.framework.di.injectedServices
import org.example.kmpdemo.presentation.CounterViewModel
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable
import org.kodein.di.compose.withDI
import org.kodein.di.instance

fun main(){
    renderComposable(rootElementId = "root") {
        counterApp()
    }
}

@Composable
fun counterApp() = withDI(injectedServices) {
    val viewModel: CounterViewModel by injectedServices.instance()
    val counterState = viewModel.getCounterFlow().collectAsState(
        initial = Counter()
    )

    Div ( {style { padding(1.em) }} ) {
        H1 {
            Text("Counter app!")
        }
        Div {
            Span( ) {
                Text("Value: ${counterState.value.value}, last action: ${counterState.value.message}")
            }
        }
        Div({style { padding(1.em) }}) {
            Button(attrs = {
                onClick {
                    viewModel.incrementCounterLaunch()
                }
            }) {
                Text("Increment")
            }

            Button(attrs = {
                onClick {
                    viewModel.decrementCounterLaunch()
                }
            }) {
                Text("Decrement")
            }
        }
    }

}
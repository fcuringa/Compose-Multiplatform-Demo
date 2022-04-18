
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.example.kmpdemo.domain.Counter
import org.example.kmpdemo.framework.di.injectedServices
import org.example.kmpdemo.presentation.CounterViewModel
import org.kodein.di.compose.withDI
import org.kodein.di.instance

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "Counter Desktop app") {
        MaterialTheme {
            counterApp()
        }
    }
}

@Composable
fun counterApp() = withDI(injectedServices){
    val viewModel: CounterViewModel by injectedServices.instance()
    val counterState = viewModel.getCounterFlow().collectAsState(
        initial = Counter()
    )

    Scaffold {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Value: ${counterState.value.value}",
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = "Last action: ${counterState.value.message}",
                modifier = Modifier.padding(8.dp)
            )
            Row {
                Button(
                    onClick = {viewModel.incrementCounterLaunch()},
                    modifier = Modifier.padding(4.dp)
                ) {
                    Text("+")
                }
                Button(
                    onClick = {viewModel.decrementCounterLaunch()},
                    modifier = Modifier.padding(4.dp)
                ) {
                    Text("-")
                }
            }
        }
    }
}
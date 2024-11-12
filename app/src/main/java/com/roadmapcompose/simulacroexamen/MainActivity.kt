package com.roadmapcompose.simulacroexamen

import android.graphics.drawable.shapes.Shape
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import com.roadmapcompose.simulacroexamen.ui.theme.SimulacroExamenTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimulacroExamenTheme {

            }
        }
    }
}

@Composable
fun Cabecera() {
    var estadoBoton by remember { mutableStateOf(false) }

    Row(
        Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            "Mouredev",
            modifier = Modifier.padding(end = 8.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.verified), "",
            modifier = Modifier
                .height(14.dp)
                .padding(end = 8.dp),
        )
        Button(onClick = {
            estadoBoton = !estadoBoton
        }) {
            if (!estadoBoton) {
                Text("Suscríbete")
            } else {
                Text("¡Suscrito!")
            }
        }
    }
}


@Composable
fun Biografia() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(contentAlignment = Alignment.BottomEnd) {
            Image(
                painter = painterResource(id = R.drawable.profile_moure),
                "Foto de perfil",
                Modifier
                    .size(72.dp)
                    .clip(CircleShape)
            )
            Image(
                painter = painterResource(id = R.drawable.verified),
                "verificado",
                Modifier.size(18.dp),

                )
        }
        Spacer(Modifier.width(36.dp))
        Column {
            Text(
                "Brais Moure",
                style = MaterialTheme.typography.titleSmall
            )
            Spacer(Modifier.padding(8.dp))
            Text(
                "Educación",
                fontStyle = FontStyle.Italic
            )
            Text("\uD83D\uDCBB Software engineer")
            Text("\uD83D\uDC4B Freelance fullstack")
            Text("⭐ GitHub Star, Microsoft MVP, GDG")
            Text("\uD83D\uDCDA Enseño programación")
        }
    }
}

@Composable
fun ItemDestacado(imgID: Int, tituloHistoria: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(122.dp)
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = imgID),
            tituloHistoria,
            Modifier
                .size(46.dp)
                .clip(CircleShape)
        )
        Text(
            text = tituloHistoria,
            style = MaterialTheme.typography.titleSmall
        )
    }
}


@Composable
fun HistoriasDestacadas() {
    val tituloDestacados = listOf(
        "Humor",
        "Retos",
        "FAQs",
        "Random",
        "Teletrabajo",
        "Setup",
        "Programacion",
        "Abastos",
        "Multimedia",
        "Android",
        "Enrique",
        " Perez",
        "Asier",
        "PMM",
        "AD",
        "SGE",
        "PSP",
        "EIE",
        "DI"
    )
    val rutaImmg = R.drawable.history_logo
    LazyRow(
        Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(tituloDestacados) { tituloHistoria ->
            ItemDestacado(
                imgID = rutaImmg,
                tituloHistoria = tituloHistoria
            )
        }
    }
}


@Preview(showSystemUi = true, device = "spec:width=800dp,height=500dp,dpi=200")
@Composable
fun PreviewApp() {
    Column {
        Cabecera()
        Biografia()
        HistoriasDestacadas()
    }
}
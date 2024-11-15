package com.roadmapcompose.simulacroexamen


import android.os.Bundle
import android.provider.CalendarContract.Colors
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.roadmapcompose.simulacroexamen.ui.theme.SimulacroExamenTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimulacroExamenTheme {
                SimulacroExamenTheme {
                    Navegacion()
                }

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
                    .size(92.dp)
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
            .padding(vertical = 16.dp)
    ) {
        Image(
            painter = painterResource(id = imgID),
            tituloHistoria,
            Modifier
                .size(56.dp)
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
        "Perez",
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

/* Creamos una variable de donde esta cada foto */
val fotosFeed = listOf(
    R.drawable.profile_moure,
    R.drawable.ic_launcher_background,
    R.drawable.history_logo,
    R.drawable.ic_launcher_background,
    R.drawable.verified,
    R.drawable.ic_launcher_background,
    R.drawable.profile_moure,
    R.drawable.ic_launcher_background,
    R.drawable.history_logo,
    R.drawable.ic_launcher_background,
    R.drawable.verified,
    R.drawable.ic_launcher_background,
    R.drawable.profile_moure,
    R.drawable.ic_launcher_background,
    R.drawable.history_logo,
    R.drawable.ic_launcher_background,
    R.drawable.verified,
    R.drawable.ic_launcher_background,

    )

/* Creamos una variable de el recuadro como tal */
@Composable
fun FotoFeed(
    @DrawableRes foto: Int
) {
    Image(
        painterResource(id = foto), contentDescription = null,
        modifier = Modifier.size(180.dp)
    )
}

@Composable
fun Feed() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        items(fotosFeed) {
            FotoFeed(foto = it)
        }
    }
}

@Composable
fun StaticFeed() {
    val itemsPerRow = 3
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        fotosFeed.chunked(itemsPerRow).forEach { rowItems ->
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                rowItems.forEach { foto ->
                    FotoFeed(foto = foto)
                }
            }
            Spacer(Modifier.height(16.dp)) // Espaciado vertical entre filas
        }
    }
}

val listaSeguidores = listOf(
    "Enrique", "Alessandra", "Ricky", "Jaime", "Jorge", "Davids", "Pablo", "Maria jose"
)

@Composable
fun TarjetaSeguidor(imgID: Int, nombreSeguidor: String) {
    Surface(
        modifier = Modifier
            .padding(16.dp)
            .border(4.dp, color = Color.Gray, shape = RoundedCornerShape(8), )
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ){
            Image(
                painter = painterResource(id = imgID), contentDescription = nombreSeguidor,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(90.dp),
                contentScale = ContentScale.FillWidth,

                )
            Text(text = nombreSeguidor,
                modifier = Modifier
                    .padding(16.dp))
        }
    }
}

@Composable
fun Seguidores(navegacion: NavController) {
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.onBackground)
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Seguidores",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.background
                )
                Button(
                    onClick = { navegacion.popBackStack() },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = Color.White
                    )
                ) {
                    Text("Perfil usuarios")
                }
            }

        }
    ) { innerPadding ->
        LazyColumn (modifier = Modifier.padding(innerPadding)) {
            items(listaSeguidores) {
                TarjetaSeguidor(imgID = R.drawable.profile_moure, nombreSeguidor = it)
            }
        }
    }
}

@Composable
fun PerfilUsuario(navegacion: NavController) {
    Scaffold(
        topBar = {
            Row(

                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.onBackground)
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Perfil de usuario",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.background
                )
                Button(
                    onClick = { navegacion.navigate("Seguidores") },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = Color.White

                    )
                ) {
                    Text("Seguidores")
                }
            }

        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            Cabecera()
            Biografia()
            HistoriasDestacadas()
            StaticFeed()
        }
    }
}

@Composable
fun Navegacion() {
    val rutas = rememberNavController()
    NavHost(navController = rutas, startDestination = "Usuarios") {
        composable("Usuarios") { PerfilUsuario(rutas) }
        composable("Seguidores") { Seguidores(rutas) }
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true,
    device = "spec:width=800dp,height=600dp,dpi=400"
)
@Composable
fun PreviewApp() {
    SimulacroExamenTheme {
        Navegacion()
    }
}
/*

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = "spec:width=800dp,height=600dp,dpi=400"
)
@Composable
fun One(){
    Feed()
}
*/

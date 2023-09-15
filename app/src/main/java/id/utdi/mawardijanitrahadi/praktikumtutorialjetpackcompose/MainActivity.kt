// Nama package class
package id.utdi.mawardijanitrahadi.praktikumtutorialjetpackcompose

// List import pada android studio
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import id.utdi.mawardijanitrahadi.praktikumtutorialjetpackcompose.ui.theme.PraktikumTutorialJetpackComposeTheme
// Fungsi Column memungkinkan Anda mengatur elemen secara vertikal.
import androidx.compose.foundation.layout.Column
// import untuk menambahkan elemen gambar
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.res.painterResource
// import untuk mengonfigurasi tata letak
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.border
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import android.content.res.Configuration


// Bagian utama projek
// Tutorial 2: Tata letak
// Mengonfigurasi tata letak

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MessageCard(Message("Android", "Jetpack Compose"))
                }
            }
        }
    }
}

data class Message(val author: String, val body: String)

// mengubah parameter composable terlebih dahulu untuk menerima objek Message sebagai ganti String, dan menambahkan composable Text lain di dalam composable MessageCard.
@Composable
// Kode ini membuat dua elemen teks di dalam tampilan konten.
// Tambahkan Column ke fungsi MessageCard.
// dapat menggunakan Row untuk mengatur item secara horizontal dan Box untuk menumpuk elemen.
// menambahkan composable Row agar memiliki desain yang terstruktur dengan baik dan composable Image di dalamnya.
// Modifier memungkinkan mengubah ukuran, tata letak, tampilan, atau interaksi tingkat tinggi composable, seperti membuat elemen menjadi dapat diklik.
fun MessageCard(msg: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(R.drawable.profile_picture),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(
                text = msg.author,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = msg.body,
                style = MaterialTheme.typography.body2
            )
        }
    }
}

// menampilkan hasil dengan fungsi preview
@Preview
@Composable
fun PreviewMessageCard() {
    ComposeTutorialTheme {
        Surface {
            MessageCard(
                msg = Message("Colleague", "Take a look at Jetpack Compose, it's great!")
            )
        }
    }
}

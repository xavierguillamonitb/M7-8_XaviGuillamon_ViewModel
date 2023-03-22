package com.example.affirmations

import android.content.ActivityNotFoundException
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.affirmations.ui.theme.CharactersViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.affirmations.model.Character
import com.example.affirmations.ui.theme.AffirmationsTheme
import com.example.affirmations.ui.theme.DetailViewModel

class DetailActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val characterId = intent.getIntExtra("id", 0)
        setContent {
            CharacterApp(characterId = characterId)
        }
    }

}
@Composable
fun CharacterApp(characterId: Int){
    AffirmationsTheme{
        DetailScreen(detailViewModel = DetailViewModel(characterId))
    }
}
@Composable
fun DetailScreen(detailViewModel: DetailViewModel) {
    val uiState by detailViewModel.uiState.collectAsState()
    val context = LocalContext.current
    Box {
        Image(
            painterResource(id = R.drawable.background), contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.5f),
            contentScale = ContentScale.FillHeight

        )
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        Column() {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = stringResource(id = uiState.stringResourceId),
                    modifier = Modifier.padding(16.dp),
                    style = TextStyle(
                        fontSize = 24.sp
                    ),
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                )
                Image(
                    painter = painterResource(id = uiState.imageResourceId),
                    contentDescription = stringResource(
                        id = uiState.stringResourceId
                    ),
                    modifier = Modifier
                        .size(100.dp)
                        .padding(8.dp)
                        .clip(CutCornerShape(20))
                )
            }
            Text(
                text = stringResource(id = uiState.descriptionId),
                modifier = Modifier.padding(16.dp)
            )
            Image(
                painter = painterResource(uiState.imageDetailResourceId),
                contentDescription = "Background",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth,
            )
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                ) {
                    Text(
                        text = "Card",
                        modifier = Modifier.padding(16.dp),
                    )
                    Image(
                        painter = painterResource(id = uiState.imageCardId),
                        contentDescription = stringResource(
                            id = uiState.stringResourceId
                        ),
                        modifier = Modifier
                            .padding(8.dp)
                            .size(500.dp),
                        contentScale = ContentScale.FillHeight,
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Card",
                        modifier = Modifier.padding(16.dp),
                    )
                    Image(
                        painter = painterResource(id = uiState.imageModelId),
                        contentDescription = stringResource(
                            id = uiState.stringResourceId
                        ),
                        modifier = Modifier
                            .padding(8.dp)
                            .size(500.dp),
                        contentScale = ContentScale.FillHeight,
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 15.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    IconButton(onClick = { context.sendMail(uiState.emailTo, uiState.email) }) {
                        Icon(
                            imageVector = Icons.Filled.Mail,
                            contentDescription = "Button Mail",
                            modifier = Modifier.padding(end = 30.dp)
                        )
                    }
                    IconButton(onClick = { context.dial(uiState.phone) }) {
                        Icon(
                            imageVector = Icons.Filled.Phone,
                            contentDescription = "ButtonPhone",
                            modifier = Modifier.padding(end = 30.dp)
                        )
                    }
                }
            }
        }
    }
}
fun Context.sendMail(to: String, subject: String) {
    try {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "message/rfc822"
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(to))
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        startActivity(Intent.createChooser(intent, ""))
    } catch (e: ActivityNotFoundException) {

    } catch (t: Throwable) {

    }
}

fun Context.dial(phone: String) {
    try {
        val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))
        startActivity(intent)
    } catch (t: Throwable) {

    }
}
package com.example.lemonade

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                    LemonadeContent()
            }
        }
    }
}


@Composable
fun LemonadeContent(modifier: Modifier = Modifier){
    var paso by remember {
        mutableStateOf(1)
    }
    var contador by remember {
        mutableStateOf(0)
    }

    when(paso){
        1 -> imageButtonLemon(
            imageRecourseId = R.drawable.lemon_tree,
            textLabelRecourseId = R.string.text1,
            contentDescriptionId = R.string.lemon_tree,
            onImageClick = {
                paso = 2
                contador = (2..4).random()
            }
        )
        2 -> imageButtonLemon(
            imageRecourseId = R.drawable.lemon_squeeze,
            textLabelRecourseId = R.string.text2,
            contentDescriptionId = R.string.lemon,
            onImageClick = {
                contador--
                if (contador == 0){
                    paso = 3
                }
            }
        )
        3 -> imageButtonLemon(
            imageRecourseId = R.drawable.lemon_drink,
            textLabelRecourseId = R.string.text3,
            contentDescriptionId = R.string.glass,
            onImageClick = {
                paso = 4
            }
        )
        4 -> imageButtonLemon(
            imageRecourseId = R.drawable.lemon_restart,
            textLabelRecourseId = R.string.text4,
            contentDescriptionId = R.string.empty,
            onImageClick = {
                paso = 1
            }
        )
    }


}
@Composable
fun imageButtonLemon(
    imageRecourseId: Int,
    textLabelRecourseId: Int,
    contentDescriptionId: Int,
    onImageClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Button(onClick = onImageClick ) {
            Image(
                painter = painterResource(id = imageRecourseId),
                contentDescription = stringResource(id = contentDescriptionId)
            )
        }
        Text(text = stringResource(id = textLabelRecourseId))
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadePreview() {
        LemonadeContent( modifier = Modifier
            .fillMaxSize()
            .wrapContentSize()
        )
}
package com.example.workingwithjetpackcompose

import android.inputmethodservice.Keyboard
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.DraggableState
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val painter= painterResource(id = R.drawable.ok)
            val decrip="this is akshit"
            val title="This is dEATHBoX"
//            ImageCard(painter = painter, contentDescription =decrip , title =title )
//            RowAndColumn()
//            TextShow()
//              MutableState()
//                TextFields()
            WorkingWithList()
        }

    }
@Composable
     fun WorkingWithList() {
        LazyColumn(){

            items(200){
                Text(text = "hello $it",textAlign = TextAlign.Center)
            }
        }
    }

    @Composable
     fun TextFields() {
    val scaffold= rememberScaffoldState()
    val scope= rememberCoroutineScope()
    var fieldValue by remember{
        mutableStateOf("")
    }
    Scaffold(modifier = Modifier.fillMaxSize(),
    scaffoldState = scaffold) {


        Column() {
            TextField(value = fieldValue, onValueChange = {
                fieldValue = it

            }, label = {
                Text(text = "enter")
            })

            Spacer(modifier = Modifier.height(12.dp))

            Button(onClick = {

                scope.launch {
                    scaffold.snackbarHostState.showSnackbar("helo brdr")

                }
            }) {
                Text("Click Me")

            }
        }
    }
    }

    @Composable fun MutableState() {
        val num: MutableState<Int> =remember{ mutableStateOf(1)}
        Column(modifier = Modifier.fillMaxSize(),
        Arrangement.Center,Alignment.CenterHorizontally) {
            Text(text = num.value.toString(),Modifier.clickable {
                num.value=num.value+1


            },textAlign = TextAlign.Center ,
            fontSize = 30.sp)

        }
    }

    @Composable
     fun TextShow() {
        Box(modifier = Modifier
            .background(Color.Black)
            .fillMaxHeight(0.4f)
            .fillMaxWidth(0.4f),
            contentAlignment = Alignment.Center
            
        ){
            Text(text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
//                        color = Color.Blue

                    )
                ){
                    append("n")

                    }
                append("aman")

            },
            color = Color.Green,
                textAlign = TextAlign.Center,
                textDecoration = TextDecoration.Underline,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
                )
        }
    }
}

@Composable
fun RowAndColumn() {
    Row(modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .width(width = 200.dp)
                .height(200.dp)
                .padding(20.dp)
                .border(5.dp, Color.Green)
                .fillMaxSize()
                .background(Color.Gray),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center


        ) {
            Text(text = "naman",modifier = Modifier.clickable {  })
            Text(text = "is")
            Text(text = "good")

        }
        Column(
            modifier = Modifier
                .width(width = 200.dp)
                .fillMaxSize()
                .background(Color.Gray),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center


        ) {
            Text(text = "naman")
            Text(text = "is")
            Text(text = "good")

        }
    }

}

@Composable
fun ImageCard(painter:Painter,contentDescription:String,title:String,modifier:Modifier=Modifier) {

    Card(modifier = Modifier
        .fillMaxWidth(0.5f)
        .padding(12.dp)
       ,
        shape = RoundedCornerShape(5.dp),
        elevation = 5.dp,
    ) {
        Box(modifier = Modifier.height(200.dp)) {

            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.Black),
                            startY = 300f
                        )
                    )

            )




            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(title, color = Color.White, fontStyle = FontStyle.Italic)
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
//    RowAndColumn()

}
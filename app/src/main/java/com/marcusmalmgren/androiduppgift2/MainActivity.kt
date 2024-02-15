package com.marcusmalmgren.androiduppgift2

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.marcusmalmgren.androiduppgift2.ui.theme.AndroidUppgift2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidUppgift2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TheButtonList()
                }
            }
        }
    }
}

@Composable
fun TheButtonList() {

    var addX by remember {
        mutableStateOf("X")
    }

    var addY by remember {
        mutableStateOf("Y")
    }


    var xyItems = remember {
        mutableStateListOf<XYThings>()
    }



    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier
            .height(100.dp)
            .background(Color.Blue)
        ) {
            Button(onClick = {
                var xThing = XYThings(addX)
                xyItems.add(xThing)
            }, modifier = Modifier
                .weight(1F)
                .padding(start = 20.dp, end = 20.dp, top = 20.dp)
            ) {
                Text(text = "X")
            }
            Button(onClick = {
                var xThing = XYThings(addY)
                xyItems.add(xThing)
            }, modifier = Modifier
                .weight(1F)
                .padding(start = 20.dp, end = 20.dp, top = 20.dp)
            ) {
                Text(text = "Y")
            }
        }

        LazyColumn(modifier = Modifier.height(650.dp)) {
            items(xyItems) { xyItem ->
                ListRow(xyItem)
            }
        }

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            Button(onClick = {
                xyItems.clear()
            }) {
                Text(text = "Reset")
            }
        }

    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidUppgift2Theme {
        TheButtonList()
    }
}
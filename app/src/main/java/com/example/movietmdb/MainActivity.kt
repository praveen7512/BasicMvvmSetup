package com.example.movietmdb

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.movietmdb.data.model.Post
import com.example.movietmdb.ui.theme.MovieTMDBTheme
import com.example.movietmdb.viewmodel.DatabaseViewModel
import com.example.movietmdb.viewmodel.PostViewModel
import com.example.movietmdb.viewmodel.StringViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.observeOn
import kotlinx.serialization.Serializable
import java.time.format.TextStyle

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            MovieTMDBTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {

                    Text(text = "hi from the swiggy")
                }
            }
        }
    }
}





@Composable
fun MovieSearchScreen(movie: List<Post>, onSearch: () -> Unit) {

    var query by remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier.padding(16.dp)) {
        BasicTextField(value = query, onValueChange = {
            query = it
        }) {
        }
    }
}



@Composable
fun DataDriverUI(onSearch : (String)->Unit) {
    
    var fieldData by remember {
        mutableStateOf("")
    }
    
    Button(onClick = {onSearch(fieldData)}) {
        
    }
}

@Composable
fun ShowDataInUI(query : (String)-> Unit){
    
    var data by remember {
        mutableStateOf("")
    }
    
    Button(onClick = { query(data) }) {
        
    }
}

@Composable
fun CardComponent(name : String){

    Card( modifier = Modifier.fillMaxWidth()){
        Text(text = name)
        Spacer(modifier = Modifier.height(10.dp))
    }
}


@Composable
fun DataCollect(onSend : (String , String , String , String)-> Unit) {
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var className by remember { mutableStateOf("") }
    var schoolName by remember { mutableStateOf("") }


    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(text = "Enter the value ofo name") })
        Spacer(modifier = Modifier.height(10.dp))
        TextField(value = age, onValueChange = { age = it })
        Spacer(modifier = Modifier.height(10.dp))
        TextField(value = className, onValueChange = { className = it })
        Spacer(modifier = Modifier.height(10.dp))
        TextField(value = schoolName, onValueChange = { schoolName = it })


    }

    Button(onClick = { onSend(name , age , className , schoolName)  }) {
                Text(text = "Send the Data")
    }

}

    @Composable
    fun TextFieldMine() {

        var nameEdit by remember { mutableStateOf("tex4") }
        var nameEdit2 by remember { mutableStateOf("text2") }

        Column(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Hello, Jetpack Compose!",
                modifier = Modifier.padding(16.dp),
                color = Color.Black,
                fontSize = 20.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif,
                letterSpacing = 1.5.sp,
            )
            Text(text = nameEdit2)
            Text(text = nameEdit)

            Spacer(modifier = Modifier.height(20.dp))

            TextField(
                value = nameEdit,
                onValueChange = {
                    nameEdit = it
                },
                label = { Text(text = "Enter your value") }
            )
            BasicTextField(

                value = nameEdit,
                onValueChange = {},


                ) {


            }

            Spacer(modifier = Modifier.height(4.dp))

            TextField(value = nameEdit2, onValueChange = {
                nameEdit2 = it
            },
                label = { Text(text = "Enter Message value 2") }
            )
        }
    }


    @Composable
    fun ShowDataFromAPI(databaseViewModel: DatabaseViewModel = hiltViewModel()) {
        val posts by databaseViewModel.dpRepo.collectAsState()

        Log.d("praveenData", "ShowDataFromAPI:${posts} ")
    }

    @Composable
    fun TextCounter(stringViewModel: StringViewModel = hiltViewModel()) {
        val counter = remember {
            mutableStateOf(0)
        }
        Log.d("praveenDataa", stringViewModel.nameString.collectAsState().value)
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "${counter.value}")
            Button(onClick = { counter.value++ }) {
                Text(text = "Increment")
            }
            Button(onClick = { counter.value-- }) {
                Text(text = "Decrement")
            }
        }
    }

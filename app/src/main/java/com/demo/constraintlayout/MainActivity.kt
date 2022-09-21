package com.demo.constraintlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.demo.constraintlayout.ui.theme.ConstraintLayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConstraintLayoutTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //ConstraintLayoutDemo()
                    ArrangeHorizontally()
                }
            }
        }
    }
}


@Composable
fun ArrangeHorizontally(){

    ConstraintLayout(modifier = Modifier.fillMaxSize())
    {
        val (text1, text2, text3) = createRefs()

        //provide constraint from 3 sides like xml

        Text(text = "Text one",
        modifier = Modifier.constrainAs(text1){
            start.linkTo(parent.start)
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
        })

        Text(text = "Text two",
        modifier = Modifier.constrainAs(text2){
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
        })

        Text(text = "Text three",
        modifier = Modifier.constrainAs(text3){
            end.linkTo(parent.end)
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
        })

    }
}



@Composable
fun ConstraintLayoutDemo(){
    
    ConstraintLayout(
        modifier = Modifier.fillMaxWidth()
    ) {

        val  (box1, box2, box3)=createRefs()    //create id for variables

        Box(
            modifier = Modifier
                .size(150.dp)
                .background(Color.Red)
                .constrainAs(box1) {

                }
        )

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Yellow)
                .constrainAs(box2) {

                }
        )

        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.Black)
                .constrainAs(box3) {

                }
        )


    }
}


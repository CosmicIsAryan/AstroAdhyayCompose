package com.example.treads.screens


import android.app.Activity
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.activity.OnBackPressedCallback
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowCircleRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.astroadhyaycompose.R
import com.example.treads.navigation.Routes
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.system.exitProcess


@Composable
fun Home (navHostController: NavHostController){

    val context = LocalContext.current
    val activity = context as? Activity
    val backPressedDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher

    // Handle back press to exit the app
    val backPressedCallback = rememberUpdatedState {
        activity?.finish()
        exitProcess(0) // Exit the app
    }

    LaunchedEffect(Unit) {
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (navHostController.currentBackStackEntry?.destination?.route == Routes.Home.routes) {
                    backPressedCallback.value.invoke()
                } else {
                    navHostController.popBackStack()
                }
            }
        }
        backPressedDispatcher?.addCallback(callback)
    }

    Column(

        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
            .padding(top = 20.dp)
    ) {

        HomeTopBar()
        Greeting()
        TodayDATE()
        CardContainer(navHostController)








    }

}


@Composable
fun TodayDATE(){
    Text(text = getFormattedDate() ,
        fontSize = 20.sp,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.onBackground,
        modifier = Modifier
            .padding(20.dp),
    )


}

@Composable
fun HomeTopBar(

){
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 30.dp)

    ) {
        Image(painter = painterResource(id = R.drawable.logo_bag), contentDescription = null ,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape))


        Text(text = "AstroAdhyaay" ,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 20.dp),

            color = MaterialTheme.colorScheme.onBackground)



    }



}

@Composable
fun Greeting(){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 40.dp, top = 20.dp)
    ){
        Text(text = "Hello" ,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground)
        Spacer(modifier = Modifier.width(5.dp))
        Text(text = "User" ,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            color = MaterialTheme.colorScheme.onBackground)

    }
}


@Composable
fun CardContainer(navHostController: NavHostController){

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 80.dp)
    ) {
        Card(title = "Kundli" ,
            Content = "fdmkdmsldw denjdnoj neddhf" ,
            Color = colorResource(id = R.color.lightPurple)  ,
            arrowColor = colorResource(id = R.color.darkPurple) ,
            navHostController = navHostController,
            Route = Routes.Kundli.routes


        )
        Card(title = "Rashifal" , Content = "Content" ,Color = colorResource(id = R.color.light2Purple) ,
            arrowColor = colorResource(id = R.color.darkPurple) ,
            navHostController = navHostController,
            Route = Routes.Kundli.routes)
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
    ) {
        Card(title = "Today's Panchang" , Content = "Content"  , Color = colorResource(id = R.color.midPurple) ,
            arrowColor = colorResource(id = R.color.light2Purple),
            navHostController = navHostController,
            Route = Routes.Kundli.routes
        )
        Card(title = "Appointment" , Content = "Content"  , colorResource(id = R.color.darkPurple) , arrowColor = colorResource(id = R.color.lightPurple),
            navHostController = navHostController,
            Route = Routes.Kundli.routes)
    }

}



@Composable
fun Card(
    title : String ,
    Content : String,
    Color : Color,
    arrowColor : Color,
    navHostController: NavHostController ,
    Route :String


){

    Box {

        Column (
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .background(Color)
                .width(180.dp)
                .height(180.dp)
                .clickable {
                    navHostController.navigate(Route) {

                    }


                }
        ){

            Text(
                text = title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(20.dp),
                color = colorResource(id = R.color.white)

                )


            Text(
                text = Content,
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding( start = 20.dp , end = 20.dp),
                color = colorResource(id = R.color.white)
            )


            Spacer(modifier = Modifier.weight(1f))

            Icon(
                imageVector = Icons.Rounded.ArrowCircleRight,
                tint = arrowColor,
                contentDescription = "null",
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(20.dp),
            )




        }



    }

}


fun getFormattedDate(): String {
    val dateFormat = SimpleDateFormat("MMMM d", Locale.getDefault())
    val currentDate = Date()
    val dayFormat = SimpleDateFormat("d", Locale.getDefault())
    val day = dayFormat.format(currentDate).toInt()
    val suffix = getDaySuffix(day)
    val formattedDate = dateFormat.format(currentDate)
    val yearFormat = SimpleDateFormat("yyyy", Locale.getDefault())
    val year = yearFormat.format(currentDate)
    return "$formattedDate$suffix, $year"
}
fun getDaySuffix(day: Int): String {
    return when {
        day in 11..13 -> "th"
        day % 10 == 1 -> "st"
        day % 10 == 2 -> "nd"
        day % 10 == 3 -> "rd"
        else -> "th"
    }
}
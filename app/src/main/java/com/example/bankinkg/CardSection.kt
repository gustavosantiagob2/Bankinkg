package com.example.bankinkg

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankinkg.data.Card
import com.example.bankinkg.ui.theme.BlueEnd
import com.example.bankinkg.ui.theme.BlueStart
import com.example.bankinkg.ui.theme.GreenEnd
import com.example.bankinkg.ui.theme.GreenStart
import com.example.bankinkg.ui.theme.OrangeEnd
import com.example.bankinkg.ui.theme.OrangeStart
import com.example.bankinkg.ui.theme.PurpleEnd
import com.example.bankinkg.ui.theme.PurpleStart
import com.example.bankinkg.ui.theme.YellowEnd
import com.example.bankinkg.ui.theme.YellowStart

val cards = listOf(
    Card(
        cardTypes = "VISA",
        cardNumber = "366 8745 5489 6587",
        cardName = "Gustavo Santiago",
        balance = 46.473,
        color = getGradient(PurpleStart, PurpleEnd)
    ),
    Card(
        cardTypes = "MASTERCARD",
        cardNumber = "654 6587 6235 6987",
        cardName = "Gustavo Henrique",
        balance = 5.473,
        color = getGradient(BlueStart, BlueEnd)
    ),
    Card(
        cardTypes = "VISA",
        cardNumber = "366 8745 5489 6587",
        cardName = "School",
        balance = 3.473,
        color = getGradient(OrangeStart, OrangeEnd)
    ),
    Card(
        cardTypes = "MASTER CARD",
        cardNumber = "366 8745 5489 6587",
        cardName = "Trips",
        balance = 15.473,
        color = getGradient(GreenStart, GreenEnd)
    ),
    Card(
        cardTypes = "OUROCARD",
        cardNumber = "875 8745 8523 8964",
        cardName = "Gustavo HMS",
        balance = 20.473,
        color = getGradient(YellowStart, YellowEnd)
    ),
)

fun getGradient(
    startColor: Color,
    endColor: Color,
): Brush {
    return Brush.horizontalGradient(
        colors = listOf(startColor, endColor)
    )
}

@Composable
fun CardSection() {
    LazyRow {
        items(cards.size) { index ->
            CardItem(index)
        }
    }
}

@Composable
fun CardItem(
    index: Int,
) {
    val card = cards[index]
    var lastItemPaddingEnd = 0.dp
    if (index == cards.size - 1) {
        lastItemPaddingEnd = 16.dp
    }

    var image = painterResource(id = R.drawable.ic_visa)
    if (card.cardTypes == "MASTER CARD")
        image = painterResource(id = R.drawable.ic_mastercard)

    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = lastItemPaddingEnd)
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .width(250.dp)
                .height(160.dp)
                .clickable { }
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = image,
                contentDescription = card.cardName,
                modifier = Modifier .width(60.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = card.cardName,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "$ ${card.balance}",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = card.cardNumber,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
package com.example.composeintagramapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeintagramapp.ui.theme.ComposeIntagramAppTheme

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyTiwtterPreview() {
    ComposeIntagramAppTheme {
        MyContainerScreen()
    }
}


@Composable
fun MyContainerScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF2B2B38))
    ) {
        ItemContainer(
            Modifier
                .fillMaxWidth()
                .padding(24.dp)
        )

        Divider(color = Color.Gray)
    }
}

@Composable
fun ItemContainer(modifier: Modifier) {
    Row(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "",
            Modifier
                .size(80.dp)
                .clip(CircleShape)
        )
        InfoContainer(
            Modifier
                .fillMaxWidth()
                .padding(start = 8.dp)
        )
    }
}

@Composable
fun InfoContainer(modifier: Modifier) {
    Column(modifier = modifier) {
        HeaderContainer()
        BodyContainer()
        Spacer(modifier = Modifier.size(16.dp))
        ProfileContainer()
        Spacer(modifier = Modifier.size(8.dp))
        ContainerIcons()
    }
}

@Composable
fun ContainerIcons() {
    var chatCounter by rememberSaveable {
        mutableIntStateOf(1)
    }
    var isNotCheckedChatIcon by rememberSaveable {
        mutableStateOf(true)
    }
//-----------------
    var shareCounter by rememberSaveable {
        mutableIntStateOf(1)
    }
    var isNotCheckedShareIcon by rememberSaveable {
        mutableStateOf(true)
    }
//------------------------------
    var likeCounter by rememberSaveable {
        mutableIntStateOf(1)
    }
    var isNotCheckedLikeIcon by rememberSaveable {
        mutableStateOf(true)
    }
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Absolute.SpaceBetween
    ) {
        MyChatItem(counter = chatCounter, isNotCheckedChatIcon = isNotCheckedChatIcon) {
            if (isNotCheckedChatIcon && chatCounter == 1) {
                chatCounter++
            } else if (!isNotCheckedChatIcon && chatCounter == 2) {
                chatCounter--
            }
            isNotCheckedChatIcon = !isNotCheckedChatIcon
        }

        MyShareItem(counter = shareCounter, isNotCheckedShareIcon = isNotCheckedShareIcon) {
            if (isNotCheckedShareIcon && shareCounter == 1) {
                shareCounter++
            } else if (!isNotCheckedShareIcon && shareCounter == 2) {
                shareCounter--
            }
            isNotCheckedShareIcon = !isNotCheckedShareIcon
        }
        MyLikeItem(likeCounter, isNotCheckedLikeIcon) {
            if (isNotCheckedLikeIcon && likeCounter == 1) {
                likeCounter++
            } else if (!isNotCheckedLikeIcon && likeCounter == 2) {
                likeCounter--
            }
            isNotCheckedLikeIcon = !isNotCheckedLikeIcon
        }
        Spacer(modifier = Modifier.size(16.dp))
    }
}

@Composable
fun MyChatItem(counter: Int, isNotCheckedChatIcon: Boolean, action: () -> Unit) {
    Row(modifier = Modifier.clickable { action() }) {
        Icon(
            painterResource(id = if (isNotCheckedChatIcon) R.drawable.ic_chat else R.drawable.ic_chat_filled),
            contentDescription = "",
            tint = Color(
                0xCCC7C7C7
            )
        )
        Text(
            text = "$counter",
            color = Color(0xCCC7C7C7),
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(start = 2.dp)
                .align(Alignment.CenterVertically),
            fontSize = 10.sp
        )
    }
}

@Composable
fun MyLikeItem(counter: Int, isNotCheck: Boolean, action: () -> Unit) {
    Row(modifier = Modifier.clickable { action() }) {
        Icon(
            painterResource(id = if (isNotCheck) R.drawable.ic_like else R.drawable.ic_like_filled),
            contentDescription = "",
            tint = if (isNotCheck) {
                Color(
                    0xCCC7C7C7
                )
            } else {
                Color.Red
            }
        )
        Text(
            text = "$counter",
            color = Color(0xCCC7C7C7),
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(start = 2.dp)
                .align(Alignment.CenterVertically),
            fontSize = 10.sp
        )
    }
}

@Composable
fun MyShareItem(counter: Int, isNotCheckedShareIcon: Boolean, action: () -> Unit) {
    Row(modifier = Modifier.clickable { action() }) {
        Icon(
            painterResource(id = R.drawable.ic_rt),
            contentDescription = "",
            tint = if (isNotCheckedShareIcon) {
                Color(
                    0xCCC7C7C7
                )
            } else {
                Color.Green
            }
        )
        Text(
            text = "$counter",
            color = Color(0xCCC7C7C7),
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(start = 2.dp)
                .align(Alignment.CenterVertically),
            fontSize = 10.sp
        )
    }
}

@Composable
fun ProfileContainer() {
    Image(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "",
        modifier = Modifier.fillMaxWidth().height(200.dp).clip(RoundedCornerShape(20.dp)),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun BodyContainer() {
    Text(
        text = "The sun set behind the mountains. A gentle breeze rustled, adding to the serene atmos pherebreeze rustled, adding to the serene atmosphere",
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        fontFamily = FontFamily.Default,
        color = Color.White,
        lineHeight = 18.sp
    )
}

@Composable
fun HeaderContainer() {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Jorge",
            fontWeight = FontWeight.Bold,
            color = Color(0xFFC4C4C4),
            fontSize = 12.sp
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = "@JorgeDevs",
            fontWeight = FontWeight.Normal,
            color = Color(0xCCC4C4C4),
            fontSize = 12.sp
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = "4h",
            fontWeight = FontWeight.Normal,
            color = Color(0xCCC4C4C4),
            fontSize = 12.sp
        )
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            painterResource(id = R.drawable.ic_dots),
            contentDescription = "",
            tint = Color.White
        )
    }
}

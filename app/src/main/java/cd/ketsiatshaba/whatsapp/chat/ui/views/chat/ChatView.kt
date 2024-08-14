@file:OptIn(ExperimentalMaterial3Api::class)

package cd.ketsiatshaba.whatsapp.chat.ui.views.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.EmojiEmotions
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.outlined.AttachFile
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import cd.ketsiatshaba.whatsapp.chat.ui.views.chat.components.ChatTopBar
import cd.ketsiatshaba.whatsapp.common.views.Colors

@Composable
fun ChatView() {
    Scaffold(
        topBar = {
            ChatTopBar()
        }
    ) { innerP ->
        ConstraintLayout(
            modifier = Modifier
                .padding(innerP)
                .fillMaxSize()
        ) {

            val (messages, chatBox) = createRefs()

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(messages) {
                        top.linkTo(parent.top)
                        bottom.linkTo(chatBox.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        height = Dimension.fillToConstraints
                    }
            ) {
                item {
                    ChatItemBox()
                }
            }

            ChatBoxInput(modifier = Modifier
                .fillMaxWidth()
                .constrainAs(chatBox) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })
        }

    }
}

@Composable
fun ChatBoxInput(modifier: Modifier) {
    Box(
        modifier
    ) {
        var chatBoxValue by remember { mutableStateOf(TextFieldValue("")) }
        ConstraintLayout(
            modifier = Modifier.fillMaxWidth()
        ) {
            val (messages, sendBtn) = createRefs()
            TextField(
                value = chatBoxValue,
                onValueChange = {
                    chatBoxValue = it
                },
                modifier = Modifier
                    .padding(vertical = 10.dp)
                    .navigationBarsPadding()
                    .imePadding()
                    .constrainAs(messages){
                        width = Dimension.percent(0.85f)
                    },
                textStyle = TextStyle(
                    color = Colors.gray,
                    fontSize = 16.sp,
                ),
                placeholder = {
                    Text(
                        text = "Type a message...",
                        style = TextStyle(
                            color = Colors.gray,
                            fontSize = 16.sp,
                        )
                    )
                },
                leadingIcon = {
                    IconButton(
                        onClick = { },
                        colors = IconButtonDefaults.iconButtonColors(
                            contentColor = Colors.gray
                        )
                    ) {
                        Icon(
                            Icons.Filled.EmojiEmotions,
                            contentDescription = null
                        )
                    }
                },
                trailingIcon = {
                    Row {
                        IconButton(
                            onClick = { /*TODO*/ },
                            colors = IconButtonDefaults.iconButtonColors(
                                contentColor = Color(0xFFCCCCCC)
                            )
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.AttachFile,
                                contentDescription = null
                            )
                        }
                        IconButton(
                            onClick = { /*TODO*/ },
                            colors = IconButtonDefaults.iconButtonColors(
                                contentColor = Color(0xFFCCCCCC)
                            )
                        ) {
                            Icon(
                                imageVector = Icons.Filled.CameraAlt,
                                contentDescription = null
                            )
                        }
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                shape = RoundedCornerShape(50),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Colors.dark,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                )
            )

            Card(
                modifier = Modifier
                    .constrainAs(sendBtn) {
                        start.linkTo(messages.end)
                        end.linkTo(parent.end)
                        centerVerticallyTo(parent)
                    }
            ) {
                IconButton(onClick = {}) {
                    Icon(Icons.Filled.Send, contentDescription = "send button")
                }
            }
        }
    }
}

@Composable
fun ChatItemBox() {
    Box(
        modifier = Modifier
//            .align(if (true) Alignment.End else Alignment.Start)
            .clip(
                RoundedCornerShape(
                    topStart = 48f,
                    topEnd = 48f,
                    bottomStart = if (false) 48f else 0f,
                    bottomEnd = if (false) 0f else 48f
                )
            )
            .background(Colors.LightGreen)
            .padding(16.dp)
    ) {
        Text(text = "Hello boy")
    }
}

@Preview
@Composable
fun ChatPreview() {
    ChatView()
}
package com.example.footballplayassistant.presentation.ui.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.customviews.buttons.CommonButton
import com.example.footballplayassistant.presentation.customviews.checkboxes.CheckBoxFriend
import com.example.footballplayassistant.presentation.customviews.headers.HeaderWithBackButton
import com.example.footballplayassistant.presentation.ui.theme.Gray75

@Composable
@Preview
fun InviteFriendsScreen() {
    Scaffold(bottomBar = {
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            CommonButton(text = stringResource(id = R.string.invite),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier)
            TextButton(modifier = Modifier.fillMaxWidth(),
                onClick = { /*TODO*/ }) {
                Text(
                    text = stringResource(id = R.string.cancel),
                    style = MaterialTheme.typography.bodyMedium,
                    color = Gray75
                )
            }
        }
    }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 12.dp).padding(it),
        ) {

            HeaderWithBackButton(
                text = stringResource(id = R.string.inviteFriend),
                imageButton = R.drawable.ic_arrow_share_25,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            LazyColumn {
                item {
                    CheckBoxFriend(text = "text", name = "name name", foto = R.drawable.user_foto)
                    Divider(modifier = Modifier.padding(horizontal = 16.dp))
                }
                item {
                    CheckBoxFriend(text = "text", name = "name name", foto = R.drawable.user_foto)
                    Divider(modifier = Modifier.padding(horizontal = 16.dp))
                }
                item {
                    CheckBoxFriend(text = "text", name = "name name", foto = R.drawable.user_foto)
                    Divider(modifier = Modifier.padding(horizontal = 16.dp))
                }
                item {
                    CheckBoxFriend(text = "text", name = "name name", foto = R.drawable.user_foto)
                    Divider(modifier = Modifier.padding(horizontal = 16.dp))
                }
            }
        }
    }
}
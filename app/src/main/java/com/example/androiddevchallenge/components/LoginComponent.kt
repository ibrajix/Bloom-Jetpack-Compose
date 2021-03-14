/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R

@Composable
fun LoginView(navController: NavController) {

    Surface(color = MaterialTheme.colors.background) {

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {

            // login text
            Text(
                text = stringResource(id = R.string.login_with_email),
                modifier = Modifier
                    .paddingFromBaseline(top = 184.dp)
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.onBackground,
                style = MaterialTheme.typography.h1,
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.nunitosans_bold))
            )

            // email text field
            OutlinedTextField(
                value = stringResource(id = R.string.email_address),
                onValueChange = { },
                modifier = Modifier
                    .padding(top = 16.dp, end = 16.dp, start = 16.dp)
                    .requiredHeight(56.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                textStyle = MaterialTheme.typography.body1,

            )

            // password text field
            OutlinedTextField(
                value = stringResource(id = R.string.password_hint),
                onValueChange = { },
                modifier = Modifier
                    .padding(top = 16.dp, end = 16.dp, start = 16.dp)
                    .requiredHeight(56.dp)
                    .fillMaxWidth(),
                textStyle = MaterialTheme.typography.body1,
            )

            // hint field helper
            val annotatedString =
                AnnotatedString.Builder(stringResource(id = R.string.login_helper))
                    .apply {
                        addStyle(
                            style = SpanStyle(textDecoration = TextDecoration.Underline),
                            35,
                            48
                        )
                        addStyle(
                            style = SpanStyle(textDecoration = TextDecoration.Underline),
                            68,
                            82
                        )
                    }

            Text(
                text = annotatedString.toAnnotatedString(),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .paddingFromBaseline(top = 24.dp, bottom = 16.dp)
                    .padding(horizontal = 16.dp)
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth(),
                color = MaterialTheme.colors.onBackground,
                style = MaterialTheme.typography.body2,
                fontFamily = FontFamily(Font(R.font.nunitosans_light))
            )

            // Login Button
            Button(

                onClick = { navController.navigate("home") },
                modifier = Modifier
                    .fillMaxWidth()
                    .requiredHeight(48.dp)
                    .padding(top = 0.dp, start = 16.dp, end = 16.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
                shape = MaterialTheme.shapes.medium
            ) {

                Text(
                    text = stringResource(id = R.string.login),
                    style = MaterialTheme.typography.button,
                    color = MaterialTheme.colors.onSecondary,
                    fontFamily = FontFamily(Font(R.font.nunitosans_semibold))
                )
            }
        }
    }
}

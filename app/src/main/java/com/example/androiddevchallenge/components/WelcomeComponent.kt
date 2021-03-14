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

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R

@Composable
fun WelcomeView(navController: NavController) {

    Surface(color = MaterialTheme.colors.primary) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {

            /*background image*/

            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_welcome_bg),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {

            // content here

            // welcome bg image
            Image(
                modifier = Modifier
                    .padding(top = 72.dp)
                    .offset(x = 88.dp)
                /*.align(Alignment.CenterHorizontally)*/,
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_welcome_illos), contentDescription = null,
                contentScale = ContentScale.Crop
            )

            // logo here
            Image(
                modifier = Modifier
                    .padding(top = 48.dp)
                    .align(Alignment.CenterHorizontally),
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_logo), contentDescription = null,
                contentScale = ContentScale.Crop
            )

            /*Welcome Text*/
            Text(
                text = stringResource(id = R.string.welcome_text),
                modifier = Modifier
                    .paddingFromBaseline(top = 32.dp, bottom = 40.dp)
                    .align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.onPrimary,
                fontFamily = FontFamily(Font(R.font.nunitosans_bold))
            )

            /*Create Account Button*/
            Button(
                onClick = { },
                modifier = Modifier
                    .padding(top = 40.dp, start = 16.dp, end = 16.dp, bottom = 8.dp)
                    .fillMaxWidth()
                    .requiredHeight(48.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
                shape = MaterialTheme.shapes.medium
            ) {

                Text(
                    text = stringResource(id = R.string.create_account),
                    style = MaterialTheme.typography.button,
                    color = MaterialTheme.colors.onSecondary,
                    fontFamily = FontFamily(Font(R.font.nunitosans_semibold))
                )
            }

            /*Login Button*/
            Button(
                onClick = { navController.navigate("login") },
                modifier = Modifier
                    .padding(top = 8.dp, start = 16.dp, end = 16.dp)
                    .fillMaxWidth()
                    .requiredHeight(48.dp),
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 0.dp,
                    pressedElevation = 0.dp
                ),
                colors = ButtonDefaults.buttonColors(Color.Transparent),
                shape = MaterialTheme.shapes.medium

            ) {

                Text(
                    text = stringResource(id = R.string.login),
                    style = MaterialTheme.typography.button,
                    color = MaterialTheme.colors.primaryVariant,
                    fontFamily = FontFamily(Font(R.font.nunitosans_bold))
                )
            }
        }
    }
}

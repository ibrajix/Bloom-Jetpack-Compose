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
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.ImageData

@Composable
fun HomeView(navController: NavController) {

    val horizontalListItem = listOf(
        ImageData(R.drawable.desert_chic, imageTitle = stringResource(id = R.string.desert_chick)),
        ImageData(R.drawable.tiny_terrariums, imageTitle = stringResource(id = R.string.tiny_terrariums)),
        ImageData(R.drawable.jungle_vibes, imageTitle = stringResource(id = R.string.jungle_vibes)),
        ImageData(R.drawable.easy_care, imageTitle = stringResource(id = R.string.easy_care)),
        ImageData(R.drawable.statements, imageTitle = stringResource(id = R.string.statements)),
    )

    val verticalListItems = listOf(
        ImageData(R.drawable.monstera, imageTitle = stringResource(id = R.string.monstera)),
        ImageData(R.drawable.aglaonema, imageTitle = stringResource(id = R.string.aglaonema)),
        ImageData(R.drawable.fiddle_leaf_tree, imageTitle = stringResource(id = R.string.fiddle_leaf_tree)),
        ImageData(R.drawable.snake_plant, imageTitle = stringResource(id = R.string.snake_plant)),
        ImageData(R.drawable.pothos, imageTitle = stringResource(id = R.string.pothos)),
    )

    Surface(color = MaterialTheme.colors.background) {

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {

            // top space
            Spacer(
                modifier = Modifier
                    .requiredHeight(40.dp)
            )

            // search input field
            OutlinedTextField(
                value = stringResource(id = R.string.search),
                onValueChange = { },
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 0.dp)
                    .requiredHeight(56.dp)
                    .fillMaxWidth(),
                textStyle = MaterialTheme.typography.body1,

                leadingIcon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.magnify),
                        contentDescription = null,
                        modifier = Modifier
                            .requiredSize(18.dp)
                    )
                }
            )

            // text browse themes
            Text(
                text = stringResource(id = R.string.browse_themes),
                fontFamily = FontFamily(Font(R.font.nunitosans_bold)),
                modifier = Modifier
                    .paddingFromBaseline(top = 32.dp, 0.dp)
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Start,
                color = MaterialTheme.colors.onBackground,
                style = MaterialTheme.typography.h1,
                fontSize = 16.sp,
            )

            // spacer
            Spacer(
                modifier = Modifier
                    .requiredHeight(16.dp)
            )

            // card view
            LazyRow(
                content = {
                    // loop through the content here
                    for (data in horizontalListItem) {

                        item {

                            Surface(
                                modifier = Modifier.requiredSize(136.dp),
                                shape = MaterialTheme.shapes.small,
                                color = MaterialTheme.colors.background, elevation = 1.dp
                            ) {

                                Column {

                                    Image(
                                        painter = painterResource(id = data.imageResource),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .requiredHeight(96.dp)
                                            .requiredWidth(136.dp)
                                    )

                                    Box(
                                        modifier = Modifier
                                            .weight(1f, true)
                                            .padding(start = 16.dp)
                                    ) {

                                        Text(
                                            text = data.imageTitle,
                                            fontFamily = FontFamily(Font(R.font.nunitosans_bold)),
                                            style = MaterialTheme.typography.h2,
                                            color = MaterialTheme.colors.onBackground,
                                            fontSize = 16.sp,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .align(Alignment.CenterStart)
                                        )
                                    }
                                }
                            }
                        }
                    }
                },
                modifier = Modifier
                    .requiredHeight(136.dp)
                    .fillMaxWidth(),

                contentPadding = PaddingValues(start = 16.dp, bottom = 1.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)

            )

            Row(
                modifier = Modifier
                    .requiredHeight(56.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = stringResource(id = R.string.design_home_garden),
                    fontFamily = FontFamily(Font(R.font.nunitosans_bold)),
                    modifier = Modifier
                        .paddingFromBaseline(top = 40.dp, 0.dp)
                        .padding(start = 16.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    color = MaterialTheme.colors.onBackground,
                    style = MaterialTheme.typography.h1,
                    fontSize = 16.sp,
                )

                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.filter_variant),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 64.dp)
                        .requiredSize(24.dp)
                        .align(
                            Alignment.CenterVertically
                        )
                )
            }

            LazyColumn(

                content = {

                    verticalListItems.forEachIndexed { index, item ->
                        item {
                            Row(
                                Modifier
                                    .fillMaxWidth()
                                    .requiredHeight(56.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row() {
                                    Image(
                                        modifier = Modifier
                                            .requiredHeight(height = 56.dp)
                                            .requiredWidth(56.dp)
                                            .clip(MaterialTheme.shapes.small),
                                        painter = painterResource(id = item.imageResource),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop
                                    )

                                    Column(verticalArrangement = Arrangement.SpaceBetween) {
                                        Text(
                                            text = item.imageTitle,
                                            modifier = Modifier
                                                .paddingFromBaseline(top = 24.dp, bottom = 0.dp)
                                                .padding(start = 16.dp),
                                            textAlign = TextAlign.Start,
                                            color = MaterialTheme.colors.onBackground,
                                            style = MaterialTheme.typography.h2,
                                            fontSize = 14.sp
                                        )
                                        Text(
                                            text = "This is a description",
                                            modifier = Modifier
                                                .paddingFromBaseline(top = 0.dp, bottom = 24.dp)
                                                .padding(start = 16.dp),
                                            textAlign = TextAlign.Start,
                                            color = MaterialTheme.colors.onBackground,
                                            style = MaterialTheme.typography.body1,
                                            fontSize = 14.sp
                                        )
                                    }
                                }

                                Checkbox(
                                    modifier = Modifier.align(Alignment.CenterVertically),
                                    checked = index == 0,
                                    colors = CheckboxDefaults.colors(checkmarkColor = MaterialTheme.colors.onSecondary),
                                    onCheckedChange = { },
                                )
                            }
                            Divider(color = Color.Gray, thickness = 1.dp, startIndent = 72.dp)
                        }
                    }
                },
                contentPadding = PaddingValues(bottom = 56.dp, start = 16.dp, end = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)

            )

            // navigation bar

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {

                BottomNavigation(
                    modifier = Modifier
                        .align(Alignment.BottomCenter),
                    elevation = 16.dp,
                    backgroundColor = MaterialTheme.colors.primary
                ) {

                    // here lies the bottom nav items

                    BottomNavigationItem(
                        selected = true,
                        onClick = { },
                        icon = {
                            Icon(
                                modifier = Modifier.requiredSize(24.dp),
                                imageVector = ImageVector.vectorResource(id = R.drawable.home),
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(
                                text = stringResource(id = R.string.home),
                                style = MaterialTheme.typography.caption,
                                color = MaterialTheme.colors.onPrimary
                            )
                        }
                    )

                    BottomNavigationItem(
                        selected = false,
                        onClick = { },
                        icon = {
                            Icon(
                                modifier = Modifier.requiredSize(24.dp),
                                imageVector = ImageVector.vectorResource(id = R.drawable.heart_outline),
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(
                                text = stringResource(id = R.string.favorites),
                                style = MaterialTheme.typography.caption,
                                color = MaterialTheme.colors.onPrimary
                            )
                        }
                    )

                    BottomNavigationItem(
                        selected = false,
                        onClick = { },
                        icon = {
                            Icon(
                                modifier = Modifier.requiredSize(24.dp),
                                imageVector = ImageVector.vectorResource(id = R.drawable.account_circle),
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(
                                text = stringResource(id = R.string.profile),
                                style = MaterialTheme.typography.caption,
                                color = MaterialTheme.colors.onPrimary
                            )
                        }
                    )

                    BottomNavigationItem(
                        selected = false,
                        onClick = { },
                        icon = {
                            Icon(
                                modifier = Modifier.requiredSize(24.dp),
                                imageVector = ImageVector.vectorResource(id = R.drawable.cart),
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(
                                text = stringResource(id = R.string.cart),
                                style = MaterialTheme.typography.caption,
                                color = MaterialTheme.colors.onPrimary
                            )
                        }
                    )
                }
            }
        }
    }
}

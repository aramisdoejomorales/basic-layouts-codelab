package com.adoejosld.basiclayoutscodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adoejosld.basiclayoutscodelab.ui.theme.BasicLayoutsCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicLayoutsCodelabTheme {
                Column(modifier = Modifier) {
                    SearchBar(modifier = Modifier)
                    Spacer(modifier = Modifier.height(12.dp))
                    AlignYourBodyElement(
                        drawable = R.drawable.ab1_inversions,
                        text = R.string.ab1_inversions,
                        modifier = Modifier
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    FavoriteCollectionCard(
                        drawable = R.drawable.fc2_nature_meditations,
                        text = R.string.fc2_nature_meditations,
                        modifier = Modifier
                    )
                }
            }
        }
    }
}

@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
            focusedContainerColor = MaterialTheme.colorScheme.surface
        ),
        placeholder = {
            Text(stringResource(id = R.string.placeholder_search))
        },
        modifier = modifier
            .fillMaxWidth()
            .padding(all = 8.dp)
            .heightIn(56.dp)
    )
}

@Composable
fun AlignYourBodyElement(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(
                    CircleShape
                )
        )
        Text(
            text = stringResource(text),
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun FavoriteCollectionCard(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.width(255.dp)) {
            Image(
                painterResource(id = drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
            )
            Text(
                text = stringResource(id = text),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
fun SearchBarPreview() {
    BasicLayoutsCodelabTheme {
        Surface {
            SearchBar(modifier = Modifier.padding(10.dp))
        }
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
fun AlignYourBodyElementPreview() {
    BasicLayoutsCodelabTheme {
        Surface {
            AlignYourBodyElement(
                drawable = R.drawable.ab1_inversions,
                text = R.string.ab1_inversions,
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
fun FavoriteCollectionCardPreview() {
    BasicLayoutsCodelabTheme {
        Surface {
            FavoriteCollectionCard(
                drawable = R.drawable.fc2_nature_meditations,
                text = R.string.fc2_nature_meditations,
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}


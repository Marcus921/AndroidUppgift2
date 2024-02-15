package com.marcusmalmgren.androiduppgift2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ListRow(LRow : XYThings, modifier: Modifier = Modifier) {
    Row(modifier = Modifier
        .background(Color.White)
        .fillMaxWidth()
        .height(60.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = LRow.XThing)
    }
}

@Preview(showBackground = true)
@Composable
fun ShopRowPreview() {
    ListRow(XYThings("X"))
}
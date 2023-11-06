//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.offset
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.layout
//import androidx.compose.ui.unit.dp
//
//private val MaxTitleOffset = 200.dp
//private val MinTitleOffset = 100.dp
//private val MaxImageSize = 200.dp
//private val MinImageSize = 100.dp
//
//@Composable
//fun CollapsingBoxWithCircleShape(scroll: State<Int>) {
//    val maxOffset = with(LocalDensity.current) { MaxTitleOffset.toPx() }
//    val minOffset = with(LocalDensity.current) { MinTitleOffset.toPx() }
//
//    val collapseFraction by remember(scroll) {
//        derivedStateOf {
//            (scroll.value - minOffset) / (maxOffset - minOffset)
//        }
//    }
//
//    Column {
//        Spacer(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(MinTitleOffset)
//        )
//
//        CollapsingBox(collapseFraction) {
//            Box(
//                modifier = Modifier
//                    .size(
//                        lerp(MinImageSize, MaxImageSize, collapseFraction),
//                        lerp(MinImageSize, MaxImageSize, collapseFraction)
//                    )
//                    .clip(CircleShape)
//                    .background(Color.Blue),
//                contentAlignment = Alignment.Center
//            ) {
//                // Replace this Box with your image composable
//            }
//        }
//    }
//}
//
//@Composable
//fun CollapsingBox(
//    collapseFraction: Float,
//    content: @Composable () -> Unit
//) {
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .layout { measurable, constraints ->
//                val imageMaxSize = MaxImageSize.roundToPx()
//                val imageMinSize = MinImageSize.roundToPx()
//                val imageWidth = lerp(imageMaxSize, imageMinSize, collapseFraction)
//                val placeable = measurable.measure(Constraints.fixed(imageWidth, imageWidth))
//                val imageY = lerp(MinTitleOffset.toPx(), 0f, collapseFraction)
//                val imageX = lerp(
//                    (constraints.maxWidth - imageWidth) / 2,
//                    constraints.maxWidth - imageWidth,
//                    collapseFraction
//                )
//
//                layout(constraints.maxWidth, constraints.maxHeight) {
//                    placeable.placeRelative(imageX.roundToInt(), imageY.roundToInt())
//                }
//            }
//    ) {
//        content()
//    }
//}

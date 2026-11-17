package com.ubersoftink.datingapp.utils

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*

enum class Interest(
    val title: String,
    val icon: ImageVector
) {
    PHOTOGRAPHY("Photography", Icons.Outlined.PhotoCamera),
    SHOPPING("Shopping", Icons.Outlined.ShoppingBag),
    KARAOKE("Karaoke", Icons.Outlined.MicNone),
    YOGA("Yoga", Icons.Outlined.SelfImprovement),
    COOKING("Cooking", Icons.Outlined.RamenDining),
    TENNIS("Tennis", Icons.Outlined.SportsTennis),
    RUN("Run", Icons.Outlined.DirectionsRun),
    SWIMMING("Swimming", Icons.Outlined.Waves),
    ART("Art", Icons.Outlined.Palette),
    TRAVELING("Traveling", Icons.Outlined.Landscape),
    EXTREME("Extreme", Icons.Outlined.Paragliding),
    MUSIC("Music", Icons.Outlined.MusicNote),
    DRINK("Drink", Icons.Outlined.WineBar),
    VIDEO_GAMES("Video games", Icons.Outlined.SportsEsports)
}
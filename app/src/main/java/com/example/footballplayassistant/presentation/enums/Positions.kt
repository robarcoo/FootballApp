package com.example.footballplayassistant.presentation.enums

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.footballplayassistant.R

enum class Positions(@StringRes val position: Int) {
    Goalkeeper(R.string.goalkeeper),
    Fullback (R.string.fullback),
    Halfback(R.string.halfback),
    Forward(R.string.forward),
    NoPosition(R.string.noPosition)
}

@Composable
fun getPosition(pos: Positions): String {
    return stringResource(id = pos.position)
}
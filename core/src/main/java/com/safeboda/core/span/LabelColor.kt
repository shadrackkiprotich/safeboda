/*
 * Copyright 2020 Safeboda
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.safeboda.core.span

import android.content.Context
import android.graphics.PorterDuff.Mode.SRC_ATOP
import android.graphics.PorterDuff.Mode.SRC_OVER
import android.graphics.PorterDuffColorFilter
import android.graphics.drawable.Drawable
import android.graphics.drawable.LayerDrawable
import androidx.annotation.ColorInt
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.ColorUtils
import com.safeboda.core.R

enum class LabelColor {

    GRAY;

    companion object {

        fun backgroundDrawable(context: Context, labelColor: LabelColor): Drawable {
            return (
                ContextCompat.getDrawable(
                    context,
                    R.drawable.transparent_label_background
                )?.mutate() as LayerDrawable
                ).apply {
                getDrawable(0).mutate().colorFilter =
                    PorterDuffColorFilter(
                        backgroundColor(
                            context,
                            labelColor
                        ),
                        SRC_OVER
                    )
                getDrawable(1).mutate().colorFilter =
                    PorterDuffColorFilter(
                        strokeColor(
                            context,
                            labelColor
                        ),
                        SRC_ATOP
                    )
            }
        }

        @ColorInt
        fun backgroundColor(context: Context, labelColor: LabelColor) =
            ColorUtils.setAlphaComponent(
                baseBackgroundColor(
                    context,
                    labelColor
                ),
                backgroundAlpha()
            )

        @ColorInt
        fun strokeColor(context: Context, labelColor: LabelColor) =
            ColorUtils.setAlphaComponent(
                baseBackgroundColor(
                    context,
                    labelColor
                ),
                strokeAlpha()
            )

        private fun backgroundAlpha() = (0.08 * 255).toInt()

        private fun strokeAlpha() = (0.16 * 255).toInt()

        @ColorInt
        private fun baseBackgroundColor(context: Context, labelColor: LabelColor) =
            ResourcesCompat.getColor(
                context.resources,
                when (labelColor) {
                    GRAY -> R.color.gray_400
                },
                context.theme
            )
    }
}
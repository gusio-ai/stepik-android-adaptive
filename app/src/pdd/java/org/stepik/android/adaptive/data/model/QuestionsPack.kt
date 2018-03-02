package org.stepik.android.adaptive.data.model

import android.support.annotation.ColorInt
import android.support.annotation.DrawableRes
import android.support.annotation.StringRes
import org.stepik.android.adaptive.R

enum class QuestionsPack(
        val id: String,
        val courseId: Long,
        var size: Int = 0,
        @StringRes   val difficulty: Int,
        @DrawableRes val background: Int,
        @ColorInt    val textColor: Int = 0xFFFFFF,
        val isFree: Boolean = false) {
    Basic(
            id          = "questions_pack_basic",
            courseId    = 1838,
            difficulty  = R.string.questions_difficulty_mixed,
            background  = R.drawable.pack_bg_basic,
            textColor   = 0x495057,
            isFree      = true
    );

    companion object {
        fun getById(id: String) = values().find { it.id == id }
    }
}

package com.example.github_profile_repo_search.presentation

import androidx.fragment.app.Fragment

data class Marcin(
    var harry: Boolean = false,
    val megi: Megi? = null,
    val pies: String? = "Megi"
) {
    class Megi() {
        val isPies = true
    }
}

class Marta {
    init {
        var x: Boolean? = null
        if (x != null) {
            var marcin = Marcin(
                harry = x,
                megi = null
            )
        }
        var marcin = Marcin(
            harry = true,
            megi = Marcin.Megi(),
            pies = "Megi"
        )
//        val megi: Boolean = marcin.megi?.isPies ?: false
        val megi: Boolean = marcin.megi!!.isPies

        marcin.pies?.let { it.isLongerThanTwoLetters() }
    }
    private fun String.isLongerThanTwoLetters() = this.length > 2

}
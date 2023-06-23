package hu.bme.aut.android.composebasics.feature.register

import hu.bme.aut.android.composebasics.R

enum class Gender(val nameId: Int) {
    MALE(R.string.gender_male),
    FEMALE(R.string.gender_female),
    OTHER(R.string.other)
}
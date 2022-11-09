package com.menesdurak.roomrecyclercrud

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    var firstName: String = "",
    var lastName: String = ""
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
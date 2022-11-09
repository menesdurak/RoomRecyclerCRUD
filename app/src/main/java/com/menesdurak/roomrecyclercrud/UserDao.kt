package com.menesdurak.roomrecyclercrud

import androidx.room.*

@Dao
interface UserDao {

    @Insert
    suspend fun addUser(user: User)

    @Query("SELECT * FROM user ORDER BY id DESC")
    suspend fun getAllUser(): List<User>

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)
}
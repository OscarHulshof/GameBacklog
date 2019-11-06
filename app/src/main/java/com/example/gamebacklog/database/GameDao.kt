package com.example.gamebacklog.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.gamebacklog.model.Game

@Dao
interface GameDao {

    @Insert
    fun insertGame(game: Game)

    @Query("SELECT * from gameTable")
    fun getGameBacklog(): LiveData<List<Game>>

    @Delete
    suspend fun deleteGame(game: Game)

    @Query("DELETE from gameTable")
    suspend fun deleteGameBacklog()
}
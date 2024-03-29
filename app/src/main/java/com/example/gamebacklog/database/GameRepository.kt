package com.example.gamebacklog.database

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.gamebacklog.model.Game

class GameRepository(context: Context) {

    private val gameDao: GameDao

    init {
        val database = GameRoomDatabase.getDatabase(context)
        gameDao = database!!.gameDao()
    }

    fun getGameBacklog(): LiveData<List<Game>> {
        return gameDao.getGameBacklog()
    }

    fun insertGame(game: Game) {
        gameDao.insertGame(game)
    }

    suspend fun deleteGame(game: Game) {
        gameDao.deleteGame(game)
    }

    suspend fun deleteGameBacklog() {
        gameDao.deleteGameBacklog()
    }
}
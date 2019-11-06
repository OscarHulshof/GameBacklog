package com.example.gamebacklog.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.gamebacklog.database.GameRepository
import com.example.gamebacklog.model.Game
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val ioScope = CoroutineScope(Dispatchers.IO)
    private val gameRepo = GameRepository(application.applicationContext)

    val gameBacklog: LiveData<List<Game>> = gameRepo.getGameBacklog()

    fun insertGame(game: Game) {
        ioScope.launch {
            gameRepo.insertGame(game)
        }
    }

    fun deleteGame(game: Game) {
        ioScope.launch {
            gameRepo.deleteGame(game)
        }
    }

    fun deleteGameBacklog() {
        ioScope.launch {
            gameRepo.deleteGameBacklog()
        }
    }
}
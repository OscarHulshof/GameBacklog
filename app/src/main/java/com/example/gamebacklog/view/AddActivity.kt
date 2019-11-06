package com.example.gamebacklog.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.gamebacklog.R
import com.example.gamebacklog.model.Game

import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.content_add.*
import java.time.LocalDate
import java.time.Month
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.*

class AddActivity : AppCompatActivity() {

    private fun initViews() {
        fab_save.setOnClickListener {
            saveGame()
        }
    }

    private fun saveGame() {
        if (fieldsValid()) {
            val releaseMonthNumber = Integer.parseInt(etMonth.text.toString())
            val releaseMonthName =
                Month.of(releaseMonthNumber).getDisplayName(TextStyle.FULL_STANDALONE, Locale.UK)

            val game = Game(
                title = etTitle.text.toString(),
                platform = etPlatform.text.toString(),
                releaseDate = "${etDay.text} $releaseMonthName ${etYear.text}"
            )

            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_GAME, game)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }

    private fun fieldsValid(): Boolean = !(etTitle.text.toString().isBlank() ||
            etPlatform.text.toString().isBlank() ||
            etDay.text.toString().isBlank() ||
            etMonth.text.toString().isBlank() ||
            etYear.text.toString().isBlank())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        initViews()
    }

    companion object {
        const val EXTRA_GAME = "EXTRA_GAME"
    }
}

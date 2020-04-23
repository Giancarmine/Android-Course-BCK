package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlin.properties.Delegates

const val KEY_DICE_VALUE = "dice_value_key"

class MainActivity : AppCompatActivity() {

    lateinit var diceImage : ImageView
    var randomInt = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceImage = findViewById(R.id.dice_image)
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener {rollDice()}

        //Retrieve saved data if present
        if (savedInstanceState != null) {
            randomInt = savedInstanceState.getInt(KEY_DICE_VALUE, 1)

            printDice(randomInt)
        }
    }

    private fun rollDice() {
        randomInt = (1..6).random()

        Toast.makeText(this, R.string.buttonClicked,
            Toast.LENGTH_SHORT).show()

        printDice(randomInt)
    }

    private fun printDice(randomInt: Int) {
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt(KEY_DICE_VALUE, randomInt)
    }
}

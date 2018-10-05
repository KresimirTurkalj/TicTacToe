package com.example.android.tictactoe

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_tic_tac_toe.*
import java.util.*

class TicTacToe : AppCompatActivity(), OnClickListener {

    private val player1 = ArrayList<Int>()
    private val player2 = ArrayList<Int>()
    private var currentFirst = true
    private var allButtons: Array<Button> = emptyArray()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tic_tac_toe)

        val buttonOne1 = findViewById<Button>(R.id.button11)
        buttonOne1.setOnClickListener(this)
        val buttonOne2 = findViewById<Button>(R.id.button12)
        buttonOne2.setOnClickListener(this)
        val buttonOne3 = findViewById<Button>(R.id.button13)
        buttonOne3.setOnClickListener(this)
        val buttonTwo1 = findViewById<Button>(R.id.button21)
        buttonTwo1.setOnClickListener(this)
        val buttonTwo2 = findViewById<Button>(R.id.button22)
        buttonTwo2.setOnClickListener(this)
        val buttonTwo3 = findViewById<Button>(R.id.button23)
        buttonTwo3.setOnClickListener(this)
        val buttonThree1 = findViewById<Button>(R.id.button31)
        buttonThree1.setOnClickListener(this)
        val buttonThree2 = findViewById<Button>(R.id.button32)
        buttonThree2.setOnClickListener(this)
        val buttonThree3 = findViewById<Button>(R.id.button33)
        buttonThree3.setOnClickListener(this)

        allButtons = arrayOf(button11, button12, button13, button21, button22, button23, button31, button32, button33)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.button11 -> addField(button11, 1)
            R.id.button12 -> addField(button12, 2)
            R.id.button13 -> addField(button13, 3)
            R.id.button21 -> addField(button21, 4)
            R.id.button22 -> addField(button22, 5)
            R.id.button23 -> addField(button23, 6)
            R.id.button31 -> addField(button31, 7)
            R.id.button32 -> addField(button32, 8)
            R.id.button33 -> addField(button33, 9)
        }
        checkWinner()
    }

    private fun addField(button: Button, cellID: Int) {
        button.isEnabled = false
        if (currentFirst) {
            button.text = "X"
            button.setBackgroundColor(Color.LTGRAY)
            player1.add(cellID)
            currentFirst = false
        } else {
            button.text = "O"
            button.setBackgroundColor(Color.LTGRAY)
            player2.add(cellID)
            currentFirst = true
        }
    }

    private fun checkWinner() {
        var winner = -1
        //row horizontal 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3))
            winner = 1
        if (player2.contains(1) && player2.contains(2) && player2.contains(3))
            winner = 2
        //row horizontal 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6))
            winner = 1
        if (player2.contains(4) && player2.contains(5) && player2.contains(6))
            winner = 2
        //row horizontal 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9))
            winner = 1
        if (player2.contains(7) && player2.contains(8) && player2.contains(9))
            winner = 2

        //row vertical 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7))
            winner = 1
        if (player2.contains(1) && player2.contains(4) && player2.contains(7))
            winner = 2
        //row vertical 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8))
            winner = 1
        if (player2.contains(2) && player2.contains(5) && player2.contains(8))
            winner = 2
        //row vertical 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9))
            winner = 1
        if (player2.contains(3) && player2.contains(6) && player2.contains(9))
            winner = 2

        //row diagonal 1
        if (player1.contains(1) && player1.contains(5) && player1.contains(9))
            winner = 1
        if (player2.contains(1) && player2.contains(5) && player2.contains(9))
            winner = 2
        //row diagonal 2
        if (player1.contains(3) && player1.contains(5) && player1.contains(7))
            winner = 1
        if (player2.contains(3) && player2.contains(5) && player2.contains(7))
            winner = 2

        if (winner != -1) {
            Toast.makeText(this, "Player $winner is winner!", Toast.LENGTH_LONG).show()
            clearField()
            }
        else if(player1.size + player2.size == 9){
            Toast.makeText(this, "Draw!", Toast.LENGTH_LONG).show()
            clearField()
        }
    }

    private fun clearField() {
        for (button in allButtons) {
            button.setBackgroundColor(Color.WHITE)
            button.text = ""
            button.isEnabled = true
            player1.clear()
            player2.clear()
            currentFirst = true
        }
    }
}

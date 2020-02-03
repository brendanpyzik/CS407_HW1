package com.example.hw1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AbsListView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


var gameOver = 1
var number = 0
var trials = 0
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun play(view: View){
        if(GuessBox.text.isEmpty()){
            Hint.text = "You have to make a guess!"
            return
        }
        if (gameOver==1){
            number = Random().nextInt(100)+1
            gameOver = 0
            trials = 1
        }
        var guess = GuessBox.text.toString().toInt()
        GuessBox.text.clear()
        Trials.text = "Number of trials: $trials"
        if (guess < number){
            Hint.text = "Hint: Higher!"
        }
        else if (guess > number){
            Hint.text = "Hint: Lower!"
        }
        else{
            Hint.text = "You got it! The number was $number. Hit play again to guess another number"
            gameOver = 1
        }
        trials++;

        //Toast.makeText(this,"$number", Toast.LENGTH_SHORT).show()


    }
}

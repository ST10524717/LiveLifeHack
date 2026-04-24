package za.ac.iie.livelifehack

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FlashCardQuest : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_flash_card_quest)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Declaring all variable names needed in this screen
        val tvRealStatement = findViewById<TextView>(R.id.tvRealStatement)
        val btnHack = findViewById<Button>(R.id.btnHack)
        val btnMyth = findViewById<Button>(R.id.btnMyth)
        val btnNextQuestion = findViewById<Button>(R.id.btnNextQuestion)
        val tvFeedBack = findViewById<TextView>(R.id.tvFeedBack)
        val btnCheckScore = findViewById<Button>(R.id.btnCheckScore)

        //Storing all data for the facts and myths questions to be asked on the app
        val factsORmyth = arrayOf(
            "\nDrinking water helps you focus better",
            "\nDoes sugar make kids hyperactive",
            "\nPutting your phone on airplane mode makes it charge faster",
            "\nDoes swallowing gum stay in your stomach for 7 years?",
            "\nDoes studying in short sessions improve learning?"
        )
        //Reference
        //JetBrains. (2025). Kotlin arrays. Available at: https://kotlinlang.org/docs/arrays.html Accessed: 24 April 2026).
        val correctAns = arrayOf(true,false,true,false,true)
        val feedback = arrayOf(
            "\nHack!!Even mild dehydration can affect concentration,so staying hydrated enhance focus and energy",
            "\nMyth!Research shows sugar doesn't directly cause hyperactivity-it's often the environment",
            "\nHack!!This is because it turns of features like Wi-Fi and Bluetooth,which reduces battery usage while charging",
            "\nMyth!No.Your body can't digest gum,but it passes through your digestive system like other food",
            "\nHack!!Yes.This is known as the Pomodoro technique, and it helps improve focus and memory retention"
        )
        //The while loop for the FinalScore screen
        var reviewState = ""
        var counter = 0 //External controller of the while
        while (counter < correctAns.count()) {
            reviewState += "${counter+1}:${correctAns[counter]}\n"
            reviewState += "${feedback[counter]}\n\n"
            counter++//controller inside the while
        }

        var currentElement = 0 //The element starts at 0
        var finalScore = 0 //the score is set at 0

        tvRealStatement.text = factsORmyth[currentElement]//Shows when you go to next screen

        btnMyth.setOnClickListener {
            if (!correctAns[currentElement]) {
                tvFeedBack.text = "Correct" // Displaying feedback for each answer
                finalScore++
            } else {
                tvFeedBack.text = "Incorrrect"
            }
        }

        btnHack.setOnClickListener {
                    if (correctAns[currentElement]) {
                        tvFeedBack.text = "Correct"
                        finalScore++
                    } else {
                        tvFeedBack.text = "Incorrect"
                    }
                }
        //Moves through every question when answered
        btnNextQuestion.setOnClickListener {

            if (currentElement < factsORmyth.size - 1) {
                currentElement++
                tvRealStatement.text = factsORmyth[currentElement]
                tvFeedBack.text = "" //clear previous feedback
            } else {
                tvFeedBack.text = "Quiz has been completed: $finalScore"
            }
            tvRealStatement.text = factsORmyth[currentElement]

        }
        btnCheckScore.setOnClickListener {
            val screen = Intent(this, FinalScoreS::class.java)
            screen.putExtra("review", reviewState)
            screen.putExtra("Final score", finalScore)

            startActivity(screen)
        }


    }
}
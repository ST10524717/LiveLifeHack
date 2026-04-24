package za.ac.iie.livelifehack

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnStartQuiz = findViewById<Button>( R.id.btnStartQuiz)

             //This button navigates to the flash card question screen
        btnStartQuiz.setOnClickListener {

            val questScreen = Intent(this, FlashCardQuest::class.java)

            startActivity(questScreen)
        }
        //REFERENCE:
        // Android Developers. (2025). Handle user input: Button clicks. Available at: https://developer.android.com/guide/topics/ui/controls/button
        //(Accessed: 24 April 2026).
    }
}
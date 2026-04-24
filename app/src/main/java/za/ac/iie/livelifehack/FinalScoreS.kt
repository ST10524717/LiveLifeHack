package za.ac.iie.livelifehack

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class FinalScoreS : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_final_score_s)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Declarations
        val tvTotalCorrectAns = findViewById<TextView>(R.id.tvTotalCorrectAns)
        val tvPFeedback = findViewById<TextView>(R.id.tvPFeedback)
        val btnReview = findViewById<Button>(R.id.btnReview)
        val btnRedo = findViewById<Button>(R.id.btnRedo)

        val bundle: Bundle? = intent.extras
        val review = bundle?.getString("review")
        val finalScore: Int? = bundle?.getInt("Final score")

        if (finalScore == 6 || finalScore == 5 || finalScore == 4) {
            tvPFeedback.text = "Great you are a master Hacker!!"

        } else if (finalScore != null) {
            if (finalScore >= 3)
                tvPFeedback.text = "Keep practicing for a better score"
        } else {
            tvPFeedback.text = "You didn't partcipate in any hack and myth question"

        }
        //Display final score
        tvTotalCorrectAns.text = "$finalScore"


        //Display the review
        btnReview.setOnClickListener {
            tvPFeedback.text = "$review"



            //REFERENCES
            //Android Developers. (2025). Activities overview. Available at: https://developer.android.com/guide/components/activities/intro-activities
            //(Accessed: 24 April 2026).


          //  Android Developers. (2025). Find and use views in Kotlin. Available at: https://developer.android.com/kotlin/ktx#view-binding
           // (Accessed: 24 April 2026).

           // JetBrains. (2025). Kotlin control flow: If and when expressions. Available at: https://kotlinlang.org/docs/control-flow.html
           // (Accessed: 24 April 2026).


            //Philipp, S. (2023). Android Programming with Kotlin for Beginners. 2nd edn. Birmingham: Packt Publishing.

           // The Independent Institute of Education (IIE). (2026). IPRG5111 Programming Module Guide. Unpublished course material.




        }
    }
}
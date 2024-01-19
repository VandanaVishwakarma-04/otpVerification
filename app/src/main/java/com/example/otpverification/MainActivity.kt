package com.example.otpverification
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.otpverification.R
import com.example.otpverification.enterotp2

class MainActivity : AppCompatActivity() {

    private lateinit var enterNumber: EditText
    private lateinit var btnGetOtp: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        enterNumber = findViewById(R.id.inputnumber)
        btnGetOtp = findViewById(R.id.btnotp)

        btnGetOtp.setOnClickListener {
            if (!enterNumber.text.toString().trim().isEmpty()) {
                if (enterNumber.text.toString().trim().length == 10) {
                    val intent = Intent(applicationContext, enterotp2::class.java)
                    intent.putExtra("mobile", enterNumber.text.toString())
                    startActivity(intent)
                } else {
                    Toast.makeText(this@MainActivity, "Please enter a correct number", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this@MainActivity, "Enter a mobile number", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

package com.example.exam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn()
    }
    val log1 = "tempuser@gmail.com"
    val log2 = "newmain@mail.ru"
    val log3 = "admin@admin.kg"
    val log4 = "gotoisbad@dd.bb"
    val pass1 = "123456Qwer"
    val pass2 = "qwerty"
    val pass3 = "123456"
    val pass4 = "todo123"

    fun startActivity() {
        val intent = Intent(applicationContext, SecondActivity::class.java)
        startActivity(intent)
    }

    fun btn() {
        btnAct.setOnClickListener{
            if (log1 == email.editableText.toString() && pass1 == password.editableText.toString()){startActivity()}
            if (log2 == email.editableText.toString() && pass2 == password.editableText.toString()){startActivity()}
            if (log3 == email.editableText.toString() && pass3 == password.editableText.toString()){startActivity()}
            if (log4 == email.editableText.toString() && pass4 == password.editableText.toString()){startActivity()}
        }

    }
}
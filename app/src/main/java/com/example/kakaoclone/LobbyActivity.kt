package com.example.kakaoclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class LobbyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lobby)

        //main에서 값 가져오기
        val userId = intent.getStringExtra("userId")


        //유저명세팅
        val user_id = findViewById<TextView>(R.id.nickName)
        user_id.text = userId

    }
}
package com.example.kakaoclone

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import com.skydoves.balloon.ArrowPositionRules
import com.skydoves.balloon.Balloon
import com.skydoves.balloon.BalloonAnimation
import com.skydoves.balloon.BalloonSizeSpec
import com.skydoves.balloon.createBalloon
import com.skydoves.balloon.showAlignBottom

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val IdEdit = findViewById<EditText>(R.id.edit_id)
        val btn_login = findViewById<Button>(R.id.btn_login)
        val pwEdit = findViewById<EditText>(R.id.edit_PW)
        val saved_id = findViewById<TextView>(R.id.save_id)
        val view_more_btn = findViewById<ImageButton>(R.id.view_more_btn)


        //비밀번호 4자리 이상
        btn_login.isEnabled = false

        pwEdit.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                val pw = pwEdit.text.toString()
                if( pw.length > 3) {
                    btn_login.isEnabled = true
                    btn_login.setBackgroundResource(R.drawable.test_background2)
                } else {
                    btn_login.isEnabled = false
                    btn_login.setBackgroundResource(R.drawable.test_background)
                }
            }
        })

        //로그인 버튼 클릭 이후 Lobby 이동, 이후 메인은 종료 (뒤로가기시 안돌아옴)
        btn_login.setOnClickListener {
            val userId: String = IdEdit.text.toString()
            val intent = Intent(this, LobbyActivity::class.java)
            intent.putExtra("userId", userId)
            startActivity(intent)
            finish()
        }

        //information 툴팁 상호작용
        val test_tool_tip = findViewById<ImageButton>(R.id.inf_tool_tip)

        val ballon = Balloon.Builder(context = this)
            .setWidthRatio(0.68f)
            .setHeight(BalloonSizeSpec.WRAP)
            .setText("설정 시 로그인 상태로 실행됩니다. 잠금모드로 사용을 원할 경우 잠금모드 사용을 설정해주세요")
            .setTextColorResource(R.color.white)
            .setTextSize(15f)
            .setArrowPositionRules(ArrowPositionRules.ALIGN_ANCHOR)
            .setArrowSize(10)
            .setArrowPosition(0.5f)
            .setPadding(12)
            .setCornerRadius(8f)
            .setBackgroundColor(Color.parseColor("#433630"))
            .setBalloonAnimation(BalloonAnimation.FADE)
            .build()


        test_tool_tip.setOnClickListener{
            test_tool_tip.showAlignBottom(ballon)
        }

        //계정 더보기 화살표
        view_more_btn.setOnClickListener {
            saved_id.visibility = if(saved_id.visibility == View.VISIBLE) {
                View.GONE
            } else {
                View.VISIBLE
            }
        }
    }
}
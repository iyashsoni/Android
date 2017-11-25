package com.example.yashsoni.myfirstkotlinapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_click_me.setOnClickListener({
            if (et_user_name.text.toString().isBlank() || et_user_age.text.toString().isBlank()) {
                Toast.makeText(this, "Please fill both fields", Toast.LENGTH_SHORT).show()
            } else {
                val userObj = MyData(et_user_name.text.toString(),
                        Integer.valueOf(et_user_age.text.toString()))
                val i = Intent(this, SecondActivity().javaClass)
//                i.putExtra("name", userObj.name)
//                i.putExtra("age", userObj.age)
                i.putExtra("user", userObj)
                startActivity(i)
            }
        })
    }
}

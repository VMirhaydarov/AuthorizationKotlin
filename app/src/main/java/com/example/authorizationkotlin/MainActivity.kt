package com.example.authorizationkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.authorizationkotlin.db.DbManager
import com.example.authorizationkotlin.db.ListItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val dbManager = DbManager(this)
    lateinit var dataList: ArrayList<ListItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickBtnEnter(view: View){
        val login = etLogin.text.toString()
        val password = etPassword.text.toString()
        var isEnter = false
        for (item in dataList){
            if((login.equals(item.login))&&(password.equals(item.password))) {
                Toast.makeText(this, "Вход выполнен", Toast.LENGTH_LONG).show()
                isEnter = true
            }
        }
        if (!isEnter) Toast.makeText(this,"Вход не выполнен",Toast.LENGTH_LONG).show()
    }

    fun onClickBtnRegister(view: View){
        val i: Intent = Intent(this, RegActivity::class.java)
        startActivity(i)
    }

    override fun onResume() {
        super.onResume()
        dbManager.openDb()

        dataList = dbManager.readDb()
        tvDbInfo.setText("")
        for(item in dataList){
            tvDbInfo.append(item.name + " " + item.city + "\n")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        dbManager.closeDb()
    }

}

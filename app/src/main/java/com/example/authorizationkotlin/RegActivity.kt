package com.example.authorizationkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.authorizationkotlin.db.DbManager
import kotlinx.android.synthetic.main.activity_reg.*

class RegActivity : AppCompatActivity() {

    var dbManager = DbManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg)
    }

    override fun onResume() {
        super.onResume()
        dbManager.openDb()
    }

    override fun onDestroy() {
        super.onDestroy()
        dbManager.closeDb()
    }

    fun onClickBtnRegister(view: View){
        val name: String = etName.text.toString()
        val surname: String = etSurname.text.toString()
        val login: String = etLogin.text.toString()
        val password: String = etPassword.text.toString()
        val country: String = etCountry.text.toString()
        val city: String = etCity.text.toString()
        val gender:String = spGender.selectedItem.toString()

        if ((name.isBlank())||(surname.isBlank())||login.isBlank()||
                password.isBlank()||country.isBlank()||
                city.isBlank()||gender.isBlank())
        {
            Toast.makeText(this,"Введите все данные!",Toast.LENGTH_LONG).show()
            return
        }

        dbManager.insertToDb(name,surname,login,password,country,city,gender)
        Toast.makeText(this,"БД обновлена",Toast.LENGTH_LONG).show()

        val i: Intent = Intent(this, MainActivity::class.java)
        startActivity(i)
    }
}

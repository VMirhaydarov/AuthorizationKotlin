package com.example.authorizationkotlin.db

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

class DbManager(context: Context) {

    val dbHelper = DbHelper(context)
    var db: SQLiteDatabase? = null

    fun openDb(){
        db = dbHelper.writableDatabase
    }

    fun insertToDb(name: String, surname: String, login: String, password: String,
                    country: String, city: String, gender: String){
        val values = ContentValues().apply {
            put(DbNameClass.COLUMN_NAME, name)
            put(DbNameClass.COLUMN_SURNAME, surname)
            put(DbNameClass.COLUMN_LOGIN, login)
            put(DbNameClass.COLUMN_PASSWORD, password)
            put(DbNameClass.COLUMN_COUNTRY, country)
            put(DbNameClass.COLUMN_CITY, city)
            put(DbNameClass.COLUMN_GENDER, gender)
        }
        db?.insert(DbNameClass.TABLE_NAME,null,values)
    }

    @SuppressLint("Range")
    fun readDb(): ArrayList<ListItem>{
        val dataList = ArrayList<ListItem>()

        var cursor = db?.query(DbNameClass.TABLE_NAME,null, null,
            null, null, null,null,null)

        with(cursor){
            while (this?.moveToNext()!!){
                val name = cursor?.getString(cursor.getColumnIndex(DbNameClass.COLUMN_NAME))
                val surname = cursor?.getString(cursor.getColumnIndex(DbNameClass.COLUMN_SURNAME))
                val login = cursor?.getString(cursor.getColumnIndex(DbNameClass.COLUMN_LOGIN))
                val password = cursor?.getString(cursor.getColumnIndex(DbNameClass.COLUMN_PASSWORD))
                val country = cursor?.getString(cursor.getColumnIndex(DbNameClass.COLUMN_COUNTRY))
                val city = cursor?.getString(cursor.getColumnIndex(DbNameClass.COLUMN_CITY))
                val gender = cursor?.getString(cursor.getColumnIndex(DbNameClass.COLUMN_GENDER))
                val item = ListItem()
                item.name = name.toString()
                item.surname = surname.toString()
                item.login = login.toString()
                item.password = password.toString()
                item.country = country.toString()
                item.city = city.toString()
                item.gender = gender.toString()
                dataList.add(item)
            }
        }
        cursor?.close()

        return dataList
    }

    fun closeDb(){
        dbHelper.close()
    }

}
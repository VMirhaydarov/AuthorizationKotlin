package com.example.authorizationkotlin.db

import android.provider.BaseColumns

object DbNameClass {
    const val TABLE_NAME = "users"
    const val COLUMN_NAME = "name"
    const val COLUMN_SURNAME = "surname"
    const val COLUMN_LOGIN = "login"
    const val COLUMN_PASSWORD = "password"
    const val COLUMN_COUNTRY = "country"
    const val COLUMN_CITY = "city"
    const val COLUMN_GENDER = "gender"

    const val DATABASE_VERSION = 1
    const val DATABASE_NAME = "users.db"

    const val CREATE_TABLE = "CREATE TABLE IF NOT EXISTS $TABLE_NAME (" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "$COLUMN_NAME TEXT NOT NULL, " +
            "$COLUMN_SURNAME TEXT NOT NULL, " +
            "$COLUMN_LOGIN TEXT NOT NULL, " +
            "$COLUMN_PASSWORD TEXT NOT NULL, " +
            "$COLUMN_COUNTRY TEXT NOT NULL, " +
            "$COLUMN_CITY TEXT NOT NULL, " +
            "$COLUMN_GENDER TEXT NOT NULL );"

    const val DROP_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"

}
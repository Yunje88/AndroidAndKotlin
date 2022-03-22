package com.example.simpletable

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper (context: Context, factory: SQLiteDatabase.CursorFactory?):
        SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION){

    companion object{
        private val DATABASE_NAME = "ANDROIDKTCLASS.db"
        private val DATABASE_VERSION = 1
        val TABLE_NAME = "SimpleTable"
        val ID_COL = "id"
        val DATA_COL = "data"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val query = ("CREATE TABLE " + TABLE_NAME + " (" +
                ID_COL + " INTEGER PRIMARY KEY, " +
                DATA_COL + " TEXT" + ")" )

        db.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXIST " + TABLE_NAME)
        onCreate(db)
    }

    fun addData(data: String){
        val values = ContentValues()
        values.put(DATA_COL, data)
        val db = this.writableDatabase
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

}
package com.example.myapplication

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.lang.Exception

class DatabaseHelper private constructor(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){

    companion object {
        const val DATABASE_NAME = "CustomerReward.db"
        const val DATABASE_VERSION = 1
        const val TABLE_NAME = "User_table"
        const val COL1_ID = "_id"
        const val COL2_FNAME = "firstname"
        const val COL3_LNAME = "lastname"
        const val COL4_REWARD = "reward"

        @Volatile
        private var instance: DatabaseHelper? = null

        fun getInstance(context: Context) =
            instance ?: synchronized(DatabaseHelper::class.java) {
                instance ?: DatabaseHelper(context).also {
                    instance = it
                }
            }
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createQuery = "CREATE TABLE $TABLE_NAME (" +
                "$COL1_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COL2_FNAME TEXT, " +
                "$COL3_LNAME TEXT, " +
                "$COL4_REWARD INTEGER" +
                ")"

        db?.execSQL(createQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if (oldVersion != newVersion) {
            db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
            onCreate(db)

        }
    }

    fun insertData(firstname: String, lastname: String, reward: String){
        val db : SQLiteDatabase = this.writableDatabase
        val contentValues= ContentValues().apply {
            put(COL2_FNAME, firstname)
            put(COL3_LNAME, lastname)
            put(COL4_REWARD, reward)
        }
        db.insert(TABLE_NAME, null, contentValues)
    }

    fun updateData(id: String, firstname: String, lastname: String, reward: String){
        val db : SQLiteDatabase = this.writableDatabase
        val contentValues= ContentValues().apply {
            put(COL1_ID, id)
            put(COL2_FNAME, firstname)
            put(COL3_LNAME, lastname)
            put(COL4_REWARD, reward)
        }
        db.update(TABLE_NAME, contentValues,"$COL1_ID = ?", arrayOf(id))
    }

    fun deleteData(id: String){
        val db : SQLiteDatabase = this.writableDatabase
        db.delete(TABLE_NAME, "$COL1_ID = ?", arrayOf(id))
    }

    fun getAllData(): String{
        var result = "No data in DB"

        val db : SQLiteDatabase = this.readableDatabase
        val cursor : Cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)

        try{
            if(cursor.count != 0){
                val stringBuffer = StringBuffer()
                while( cursor.moveToNext()){
                    stringBuffer.append("ID :" + cursor.getInt(0).toString() + "\n")
                    stringBuffer.append("FIRST NAME :" + cursor.getInt(1).toString() + "\n")
                    stringBuffer.append("LAST NAME :" + cursor.getInt(2).toString() + "\n")
                    stringBuffer.append("REWARD :" + cursor.getInt(3).toString() + "\n\n")
                }
                result = stringBuffer.toString()
            }
        } catch (e:Exception) {
            e.printStackTrace()
        } finally {
            if (cursor != null && !cursor.isClosed){
                cursor.close()
            }
        }
        return result
    }

}
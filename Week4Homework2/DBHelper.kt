package com.example.myapplication

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.lang.Exception


class DBHelper(context: Context, factory: SQLiteDatabase.CursorFactory?):
        SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION){


    companion object{

        private val DATABASE_NAME = "ANDROIDKTCLASS"
        private val DATABASE_VERSION = 1
        private val TABLE_NAME = "qt_table"
        private val ID_COL = "id"

        private val FIRSTNAME_COL = "first_name"
        private val LASTNAME_COL = "last_name"
        private val COMPANY_COL = "company_name"
        private val ADDRESS_COL = "address"
        private val CITY_COL = "city"
        private val COUNTRY_COL = "country"
        private val STATE_COL = "state"
        private val ZIP_COL = "zip"
        private val PHONE1_COL = "first_phone"
        private val PHONE2_COL = "second_phone"
        private val EMAIL_COL = "email"

    }

            override fun onCreate(db: SQLiteDatabase){
                val query = ("CREATE TABLE " + TABLE_NAME + " (" +
                        ID_COL + " INTEGER PRIMARY KEY, " +
                        FIRSTNAME_COL + " TEXT, " + LASTNAME_COL + " TEXT, " +
                        COMPANY_COL + " TEXT, " + ADDRESS_COL + " TEXT, " +
                        CITY_COL + " TEXT, " + COUNTRY_COL + " TEXT, " +
                        STATE_COL + " TEXT, " + ZIP_COL + " TEXT, " +
                        PHONE1_COL + " TEXT, " + PHONE2_COL + " TEXT, " +
                        EMAIL_COL + " TEXT")

                db.execSQL(query)
            }

        override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int){
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
            onCreate(db)
        }

        fun getName(): String {

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
                        stringBuffer.append("COMPANY NAME :" + cursor.getInt(3).toString() + "\n")
                        stringBuffer.append("ADDRESS :" + cursor.getInt(4).toString() + "\n")
                        stringBuffer.append("CITY :" + cursor.getInt(5).toString() + "\n")
                        stringBuffer.append("COUNTRY :" + cursor.getInt(6).toString() + "\n")
                        stringBuffer.append("STATE :" + cursor.getInt(7).toString() + "\n")
                        stringBuffer.append("ZIP :" + cursor.getInt(8).toString() + "\n")
                        stringBuffer.append("PHONE1  :" + cursor.getInt(9).toString() + "\n")
                        stringBuffer.append("PHONE2 :" + cursor.getInt(10).toString() + "\n")
                        stringBuffer.append("EMAIL :" + cursor.getInt(11).toString() + "\n")
                    }
                    result = stringBuffer.toString()
                }
            } catch (e:Exception){
                e.printStackTrace()
            } finally {
                if (cursor != null && !cursor.isClosed){
                    cursor.close()
                }
            }
            return result
        }

}
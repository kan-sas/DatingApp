package com.ubersoftink.datingapp.data.models

import java.util.Date

//@Entity
data class User(
   // @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val mobileNumber: Int,          //сделать маску
    val firstName: String,
    val lastName: String,
    val birthday: Date,
    val sex: String,
    val interests: List<String>,    //Наверное стоит заменить
    //Нужны ли друзья в приложении для знакомств?
    val friendsId: List<Int>,       //типо внешний ключ
    val notification: Boolean,
    val matchesId: List<Int>,         //типо внешний ключ
)

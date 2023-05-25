package com.example.mvp.dao

import com.example.mvp.model.PersonModel

class PersonDao {
    val data = mutableListOf<PersonModel>()

    init {
        loadData()
    }

    fun loadData(){
        val nameList = arrayOf("Vasya","Masha","Petya","Marina","Vova")

        for (i in 0 .. 4)
            data.add(PersonModel(nameList[i]))
    }
}
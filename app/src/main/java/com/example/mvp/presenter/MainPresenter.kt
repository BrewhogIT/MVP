package com.example.mvp.presenter

import com.example.mvp.MainAdapter
import com.example.mvp.dao.PersonDao
import com.example.mvp.model.PersonModel

class MainPresenter :Controller.Presenter{
    private val dao = PersonDao()
    lateinit var view: Controller.View

    override fun attach(view: Controller.View) {
        this.view = view
    }

    fun openCard(personModel: PersonModel) {
        view.showToast("Be careful!")
        view.openCard(personModel)
    }

    fun getData():MutableList<PersonModel>{
        return dao.data
    }

}
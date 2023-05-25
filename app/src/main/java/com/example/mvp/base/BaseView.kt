package com.example.mvp.base

import com.example.mvp.model.PersonModel

class BaseView {

    interface View{
        fun openCard(data: PersonModel)
    }

    interface Presenter<in T>{
        fun attach(view:T)
    }
}
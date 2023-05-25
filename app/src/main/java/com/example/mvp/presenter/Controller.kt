package com.example.mvp.presenter

import com.example.mvp.base.BaseView

class Controller {

    interface View:BaseView.View{
        fun showToast(text:String)
    }

    interface Presenter:BaseView.Presenter<View>
}
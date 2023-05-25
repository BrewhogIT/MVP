package com.example.mvp

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvp.dao.PersonDao
import com.example.mvp.databinding.ActivityMainBinding
import com.example.mvp.model.PersonModel
import com.example.mvp.presenter.Controller
import com.example.mvp.presenter.MainPresenter

class MainActivity : AppCompatActivity(),Controller.View {

    private lateinit var binding: ActivityMainBinding
    private val presenter = MainPresenter()
    private val adapter = MainAdapter(presenter::openCard)

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter.attach(this)

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter.list = presenter.getData()

    }

    override fun showToast(text: String) {
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show()
    }

    override fun openCard(personModel: PersonModel) {
        AlertDialog.Builder(this)
            .setTitle("Person dialog")
            .setMessage("This is ${personModel.name}")
            .setPositiveButton("ok",null)
            .show()
    }

}
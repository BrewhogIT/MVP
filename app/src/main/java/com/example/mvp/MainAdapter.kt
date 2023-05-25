package com.example.mvp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.mvp.databinding.CardLayoutBinding
import com.example.mvp.model.PersonModel

class MainAdapter(val onClick:(PersonModel)-> Unit):Adapter<MainAdapter.MainHolder>() {

    var list = mutableListOf<PersonModel>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class MainHolder(view: View):ViewHolder(view) {
        lateinit var binding: CardLayoutBinding

        constructor(bind: CardLayoutBinding) : this(bind.root) {
            binding = bind
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val binding = CardLayoutBinding.inflate(LayoutInflater.from(parent.context))
        return MainHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.binding.nameText.text = list[position].name

        holder.itemView.setOnClickListener {
            onClick(list[position])
        }
    }
}
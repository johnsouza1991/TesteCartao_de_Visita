package br.com.businesscard.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintSet

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.businesscard.data.BusinessCard

class BusinessCardAdapter: ListAdapter<BusinessCard, BusinessCardAdapter.ViewHolder>(DiffCallback()) {
    var listenerShare:(View) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBusinessCardBinding.inflate(inflater,parent,false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    inner class ViewHolder(
        private val binding: ItemBusinessCardBinding):RecyclerView.ViewHolder(binding.root){
            fun bind (BusinessCard){
                binding.tvnome.text = item.nome
                binding.tvtelefone.text = item.telefone
                binding.tvemail.text = item.email
                binding.tvempresa.text = item.empresa
                binding.mcvContent.setCardBackgroundColor(Color.parseColor(item.fundoPersonalizado))
                binding.mcvContent.setOnClickListener{
                    listenerShare(it)
                }
            }
        }

}

class DiffCallback:DiffUtil.ItemCallback<BusinessCard>(){
    override fun areItemsTheSame(oldItem: BusinessCard, newItem: BusinessCard) = oldItem == newItem
    override fun areContentsTheSame(oldItem: BusinessCard, newItem: BusinessCard)= oldItem.id == newItem.id

}
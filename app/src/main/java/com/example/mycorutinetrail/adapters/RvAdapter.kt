package com.example.mycorutines.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.mycorutinetrail.databinding.SingleItemBinding


class RvAdapter(applicationContext: Context, languageList: List<com.example.mycorutines.model.Result>, ) : RecyclerView.Adapter<RvAdapter.ViewHolder>() {

    var onclick:((langItem:com.example.mycorutines.model.Result)->Unit)?=null

    private  var applicationContext :Context
    private var languageList: List<com.example.mycorutines.model.Result>
        init {
            this.languageList=languageList
            this.applicationContext=applicationContext
        }

    inner class ViewHolder(val binding: SingleItemBinding) : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = SingleItemBinding.inflate(LayoutInflater.from(applicationContext), parent, false)

        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){

            with(languageList[position]){
                holder.binding.idd.text = languageList[position]._id.toString()
                holder.binding.auther.text = languageList[position].author
                holder.binding.content.text = languageList[position].content
                holder.binding.authorslug.text = languageList[position].authorSlug
            }
            holder.binding.root.setOnClickListener {
                onclick?.invoke(languageList[position])
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list: List<com.example.mycorutines.model.Result>){
        this.languageList=list
        notifyDataSetChanged()
    }

    // return the size of languageList
    override fun getItemCount(): Int {
        return languageList.size
    }
}

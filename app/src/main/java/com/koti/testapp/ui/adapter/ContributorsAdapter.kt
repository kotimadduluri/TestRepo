package com.koti.testapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.koti.testapp.R
import com.koti.testapp.databinding.IitemContributorBinding
import com.koti.testapp.network.response.Contributor

/**
 * @author koti
 * Adapter to show Contributors
 */
class ContributorsAdapter : RecyclerView.Adapter<ContributorsAdapter.ViewHolder>() {
    private val contributes = ArrayList<Contributor>()

    class ViewHolder(private val binder: IitemContributorBinding) :
        RecyclerView.ViewHolder(binder.root) {
        fun bindData(item: Contributor) {
            binder.user = item
            binder.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            IitemContributorBinding.bind(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.iitem_contributor, parent, false)
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }

    override fun getItemCount() = contributes.size

    private fun getItem(pos: Int) = contributes[pos]

    fun submitList(it: List<Contributor>) {
        contributes.addAll(it)
        notifyDataSetChanged()
    }
}
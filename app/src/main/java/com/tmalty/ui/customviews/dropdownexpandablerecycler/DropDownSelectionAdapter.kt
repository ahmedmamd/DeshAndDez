//package com.tmalty.ui.customviews.dropdownexpandablerecycler
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.tmalty.R
//import com.tmalty.base.SelectionModel
//import com.tmalty.base.adapters.CustomBaseAdapter
//import com.tmalty.databinding.ItemLayoutDropDownSelectionBinding
//
//class DropDownSelectionAdapter(
//    var selectedItemId: String? = null,
//    val onItemSelected: (Int, SelectionModel) -> Unit,
//    val onItemUnSelected: (Int, SelectionModel) -> Unit
//) : CustomBaseAdapter<SelectionModel, DropDownSelectionAdapter.ViewHolder>() {
//    private val TAG = "DropDownSelectionAdapte"
//    var currentSelectionPosition = -1
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        // Inflate the item layout and create ViewHolder instance
//        val view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.item_layout_selectionut_drop_down_selection, parent, false)
//        return ViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val item = getItem(position)
//        holder.bind(item)
//    }
//
//    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        private val binding = ItemLayoutDropDownSelectionBinding.bind(itemView)
//        fun bind(item: SelectionModel) {
//            binding.nameTextview.text = item.name
//            checkIfHasPreviousSelectedItem(item)
//            updateUi()
//            itemView.setOnClickListener {
//                if (currentSelectionPosition == position) {
//                    currentSelectionPosition = -1
//                    selectedItemId = null
//                    onItemUnSelected(position, item)
//                    updateUi()
//                } else {
//                    if (currentSelectionPosition != -1) {
//                        notifyPreviousItem()
//                    } else currentSelectionPosition = position
//                    selectedItemId = item.id
//                    onItemSelected(position, item)
//                    notifyItemChanged(currentSelectionPosition)
//                }
//            }
//        }
//
//        private fun notifyPreviousItem() {
//            val previousPosition = currentSelectionPosition
//            currentSelectionPosition = position
//            notifyItemChanged(previousPosition)
//        }
//
//        private fun updateUi() {
//            binding.ivCheck.visibility =
//                if (currentSelectionPosition == position) View.VISIBLE else
//                    View.GONE
//        }
//
//        // check if adapters already has a previous selected item
//        private fun checkIfHasPreviousSelectedItem(item: SelectionModel) {
//            if (selectedItemId == item.id) {
//                currentSelectionPosition = position
//            }
//        }
//    }
//}
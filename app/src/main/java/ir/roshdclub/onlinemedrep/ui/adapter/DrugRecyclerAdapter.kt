package ir.roshdclub.onlinemedrep.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ir.roshdclub.onlinemedrep.R
import ir.roshdclub.onlinemedrep.db.Medicine
import ir.roshdclub.onlinemedrep.ui.listener.DrugInteractionListener

class DrugRecyclerAdapter (private val context: Context?,
                           private val mListener: DrugInteractionListener?): RecyclerView.Adapter<DrugRecyclerAdapter.ViewHolder>() {

    private var medicines = emptyList<Medicine>() // Cached copy of words


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_drugs, parent, false))
    }

    override fun getItemCount(): Int = medicines.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.txtHome.text = titles[position]
//        holder.imgHome.setImageResource(images[position])

        val current = medicines[position]
        holder.txtHome.text = current.name


        Glide
            .with(context!!)
            .load(current.image)
            .centerCrop()
            .placeholder(R.mipmap.ic_launcher)
            .into(holder.imgHome)

    }


    inner class ViewHolder (val view: View) : RecyclerView.ViewHolder(view){

        val txtHome = view.findViewById<TextView>(R.id.txt_home)
        val imgHome = view.findViewById<ImageView>(R.id.img_home)

        init {
            view.setOnClickListener {
                val name: String = txtHome.text.toString()
                mListener?.drugToDetail(name)
            }
        }

    }

    internal fun setWords(medicines: List<Medicine>) {
        this.medicines = medicines
        notifyDataSetChanged()
    }

}

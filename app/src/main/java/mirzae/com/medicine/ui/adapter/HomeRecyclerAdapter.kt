package mirzae.com.medicine.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mirzae.com.medicine.R
import mirzae.com.medicine.ui.home.HomeFragment

class HomeRecyclerAdapter(private val context: Context?, private val subjects: ArrayList<String>,
                          private val images: ArrayList<Int>, private val mListener: HomeFragment.HomeInteractionListener?): RecyclerView.Adapter<HomeRecyclerAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener = View.OnClickListener {
        mListener?.homeClickListener()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_menu, parent, false))
    }

    override fun getItemCount(): Int = subjects.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
          holder.txtHome.text = subjects[position]
          holder.imgHome.setImageResource(images[position])

          with(holder.view){
              setOnClickListener(mOnClickListener)

          }

    }

   inner class ViewHolder (val view: View) : RecyclerView.ViewHolder(view){

        val txtHome = view.findViewById<TextView>(R.id.txt_home)
        val imgHome = view.findViewById<ImageView>(R.id.img_home)


    }

}


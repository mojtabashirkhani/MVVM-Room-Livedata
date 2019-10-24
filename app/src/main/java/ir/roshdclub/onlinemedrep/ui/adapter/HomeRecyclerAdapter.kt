package ir.roshdclub.onlinemedrep.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ir.roshdclub.onlinemedrep.R
import ir.roshdclub.onlinemedrep.ui.listener.HomeInteractionListener

class HomeRecyclerAdapter(private val context: Context?, private val subjects: ArrayList<String>,
                          private val images: ArrayList<Int>, private val mListener: HomeInteractionListener?): RecyclerView.Adapter<HomeRecyclerAdapter.ViewHolder>() {



   /* private val mOnClickListener: View.OnClickListener = View.OnClickListener {

        mListener?.homeToSubject(pos)
    }

    private val dOnClickListener: View.OnClickListener = View.OnClickListener {

        mListener?.homeToDrug()
    }*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_menu, parent, false))
    }

    override fun getItemCount(): Int = subjects.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
          holder.txtHome.text = subjects[position]
          holder.imgHome.setImageResource(images[position])

          /*with(holder.view){


              when (holder.adapterPosition){

                  1,3,4,5 -> setOnClickListener(mOnClickListener)

                  else -> setOnClickListener(dOnClickListener)
              }


          }*/

    }

   inner class ViewHolder (val view: View) : RecyclerView.ViewHolder(view){

        val txtHome = view.findViewById<TextView>(R.id.txt_home)
        val imgHome = view.findViewById<ImageView>(R.id.img_home)


       init {

           view.setOnClickListener {

               when(adapterPosition){

                   1,3,4,5 -> mListener?.homeToSubject(adapterPosition)

                   else -> mListener?.homeToDrug()

               }
           }

       }

    }

}


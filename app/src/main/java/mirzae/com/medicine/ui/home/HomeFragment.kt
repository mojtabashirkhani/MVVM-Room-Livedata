package mirzae.com.medicine.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mirzae.com.medicine.R
import mirzae.com.medicine.ui.adapter.HomeRecyclerAdapter
import mirzae.com.medicine.ui.listener.HomeInteractionListener

class HomeFragment : Fragment(){


    private lateinit var homeViewModel: HomeViewModel
    private var listener : HomeInteractionListener? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val recyclerView: RecyclerView = root.findViewById(R.id.recycler_home)

        recyclerView.layoutManager =  GridLayoutManager(context,3)


        homeViewModel.list.observe(this, Observer {

            val x = it
            homeViewModel.image.observe(this, Observer {
                recyclerView.adapter = HomeRecyclerAdapter(context, x, it,listener)

            })

        })


        return root
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if (context is HomeInteractionListener){
            listener = context

        } else {
            throw RuntimeException(context.toString() + " must implement HomeInteraction") as Throwable

        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }



}
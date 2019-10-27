package ir.roshdclub.onlinemedrep.ui.screen.drug

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.roshdclub.onlinemedrep.R
import ir.roshdclub.onlinemedrep.ui.adapter.DrugRecyclerAdapter
import ir.roshdclub.onlinemedrep.ui.listener.DrugIntractionListener
import ir.roshdclub.onlinemedrep.ui.listener.HomeInteractionListener
import kotlinx.android.synthetic.main.item_menu.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class DrugFragment: Fragment() {

    private lateinit var drugViewModel: DrugViewModel
    private lateinit var drugViewModelFactory: DrugViewModelFactory
    private var listener: DrugIntractionListener? = null



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

       val subject = arguments?.getString("subject")

        drugViewModelFactory = DrugViewModelFactory(this.activity?.application!!, subject)

        drugViewModel =
            ViewModelProviders.of(this, drugViewModelFactory).get(DrugViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_drug, container, false)
        val recyclerView: RecyclerView = root.findViewById(R.id.recycler_drug)

        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = DrugRecyclerAdapter(context, listener)
        recyclerView.adapter = adapter

        drugViewModel.listDrug.observe(this, Observer {medicine ->
            medicine?.let { adapter.setWords(it) }

        })

        return root
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if (context is DrugIntractionListener){
            listener = context

        } else {
            throw RuntimeException(context.toString() + " must implement DrugInteraction") as Throwable

        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}
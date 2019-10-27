package ir.roshdclub.onlinemedrep.ui.screen.subject

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.roshdclub.onlinemedrep.R
import ir.roshdclub.onlinemedrep.ui.adapter.SubjectRecyclerAdapter
import ir.roshdclub.onlinemedrep.ui.listener.SubjectInteractionListener

class SubjectFragment: Fragment() {

    private lateinit var subjectViewModel: SubjectViewModel
    private var listener : SubjectInteractionListener? = null


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val position = arguments?.getInt("position")

        subjectViewModel =
            ViewModelProviders.of(this).get(SubjectViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_subject, container, false)
        val recyclerView: RecyclerView = root.findViewById(R.id.recycler_subject)

        recyclerView.layoutManager = LinearLayoutManager(context)


        subjectViewModel.txtProfession.observe(this, Observer {

            val x = it
            subjectViewModel.imgProfession.observe(this, Observer {

                if (position == 1)
                    recyclerView.adapter = SubjectRecyclerAdapter(context, x, it, listener)
            })


        })

        subjectViewModel.txtSupplements.observe(this, Observer {

            val x = it

            subjectViewModel.imgSupplements.observe(this, Observer {

                if (position == 3)
                    recyclerView.adapter = SubjectRecyclerAdapter(context, x, it, listener)
            })

        })

        return root
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if (context is SubjectInteractionListener){
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
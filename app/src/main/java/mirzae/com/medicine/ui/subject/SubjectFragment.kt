package mirzae.com.medicine.ui.subject

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
import mirzae.com.medicine.R
import mirzae.com.medicine.ui.adapter.SubjectRecyclerAdapter
import mirzae.com.medicine.ui.listener.HomeInteractionListener
import mirzae.com.medicine.ui.listener.SubjectInteractionListener

class SubjectFragment: Fragment() {

    private lateinit var subjectViewModel: SubjectViewModel
    private var listener : SubjectInteractionListener? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        subjectViewModel =
            ViewModelProviders.of(this).get(SubjectViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_subject, container, false)
        val recyclerView: RecyclerView = root.findViewById(R.id.recycler_subject)

        recyclerView.layoutManager = LinearLayoutManager(context)

        subjectViewModel.list.observe(this, Observer {

            val x = it

            subjectViewModel.image.observe(this, Observer {

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
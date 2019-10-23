package mirzae.com.medicine.ui.subject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import mirzae.com.medicine.R

class SubjectFragment: Fragment() {

    private lateinit var subjectViewModel: SubjectViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        subjectViewModel =
            ViewModelProviders.of(this).get(SubjectViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_subject, container, false)
        val textView: TextView = root.findViewById(R.id.text_subject)
        subjectViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }

}
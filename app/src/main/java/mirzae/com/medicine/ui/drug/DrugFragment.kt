package mirzae.com.medicine.ui.drug

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import mirzae.com.medicine.R

class DrugFragment: Fragment() {
    private lateinit var drugViewModel: DrugViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        drugViewModel =
            ViewModelProviders.of(this).get(DrugViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_drug, container, false)
        val textView: TextView = root.findViewById(R.id.text_drug)
        drugViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}
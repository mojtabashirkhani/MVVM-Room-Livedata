package mirzae.com.medicine.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import mirzae.com.medicine.R

class DetailFragment: Fragment() {

    private lateinit var detailViewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        detailViewModel =
            ViewModelProviders.of(this).get(DetailViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_contactus, container, false)
        val textView: TextView = root.findViewById(R.id.text_contactus)
        detailViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }

}
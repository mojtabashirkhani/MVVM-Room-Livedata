package ir.roshdclub.onlinemedrep.ui.drug

import android.graphics.Canvas
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.github.barteksc.pdfviewer.PDFView
import com.github.barteksc.pdfviewer.listener.*
import ir.roshdclub.onlinemedrep.R

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
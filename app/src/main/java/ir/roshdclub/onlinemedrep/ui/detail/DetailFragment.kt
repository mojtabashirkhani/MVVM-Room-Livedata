package ir.roshdclub.onlinemedrep.ui.detail

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.github.barteksc.pdfviewer.PDFView
import ir.roshdclub.onlinemedrep.R

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

        val pdfView: PDFView = root.findViewById(R.id.pdf_viewer)

        pdfView.fromAsset("sup.pdf")
            .password(null)//enter password if PDF is password protected
            .defaultPage(0)//set the default page
            .enableSwipe(true)//enable the swipe to change page
            .swipeHorizontal(false)//set horizontal swipe to false
            .enableDoubletap(true)//double tap to zoom
            .onDraw { canvas, pageWidth, pageHeight, displayedPage -> }
            .onDrawAll { canvas, pageWidth, pageHeight, displayedPage -> }
            .onPageError { page, t -> Toast.makeText(context, "Error", Toast.LENGTH_LONG).show() }
            .onPageChange { page, pageCount -> }
            .onTap { true }
            .onRender { nbPages, pageWidth, pageHeight -> pdfView.fitToWidth() }
            .enableAnnotationRendering(true)
            .invalidPageColor(Color.WHITE)
            .load()

        detailViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }

}
package ir.roshdclub.onlinemedrep.ui.screen.detail

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
    private lateinit var detailViewModelFactory: DetailViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val name =  arguments?.getString("name")
        detailViewModelFactory = DetailViewModelFactory(this.activity?.application!!, name)
        detailViewModel =
            ViewModelProviders.of(this, detailViewModelFactory).get(DetailViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_detail, container, false)

        val pdfView: PDFView = root.findViewById(R.id.pdf_viewer)

        detailViewModel.content.observe(this, Observer {

            pdfView.fromAsset(it.content)
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


        })


        return root
    }

}
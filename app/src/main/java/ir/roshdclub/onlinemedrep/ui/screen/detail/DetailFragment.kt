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
import com.github.barteksc.pdfviewer.link.DefaultLinkHandler
import com.github.barteksc.pdfviewer.util.FitPolicy
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

                .enableSwipe(true) // allows to block changing pages using swipe
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .defaultPage(0)
                .enableAnnotationRendering(false) // render annotations (such as comments, colors or forms)
                .password(null)
                .scrollHandle(null)
                .enableAntialiasing(true) // improve rendering a little bit on low-res screens
                .spacing(0)
                .autoSpacing(false) // add dynamic spacing to fit each page on its own on the screen
                .pageFitPolicy(FitPolicy.WIDTH) // mode to fit pages in the view
                .fitEachPage(false) // fit each page to the view, else smaller pages are scaled relative to largest page.
                .pageSnap(false) // snap pages to screen boundaries
                .pageFling(false) // make a fling change only a single page like ViewPager
                .nightMode(false) // toggle night mode
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
                .enableAnnotationRendering(true)
                .load()


        })


        return root
    }

}
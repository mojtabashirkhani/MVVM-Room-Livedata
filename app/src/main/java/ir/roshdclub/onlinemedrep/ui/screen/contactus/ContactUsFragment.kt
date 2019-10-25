package ir.roshdclub.onlinemedrep.ui.screen.contactus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import ir.roshdclub.onlinemedrep.R

class ContactUsFragment : Fragment() {

    private lateinit var contactUsViewModel: ContactUsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        contactUsViewModel =
            ViewModelProviders.of(this).get(ContactUsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_contactus, container, false)

        val txtContactUs: TextView = root.findViewById(R.id.text_contactus)
        val txtPhone: TextView = root.findViewById(R.id.txt_phone)
        val txtWebsite: TextView = root.findViewById(R.id.txt_website)

        contactUsViewModel.txtContactUs.observe(this, Observer {
            txtContactUs.text = it
        })

        contactUsViewModel.txtPhone.observe(this, Observer {
            txtPhone.text = it
        })

        contactUsViewModel.txtWebsite.observe(this, Observer {
            txtWebsite.text = it
        })

        return root
    }
}
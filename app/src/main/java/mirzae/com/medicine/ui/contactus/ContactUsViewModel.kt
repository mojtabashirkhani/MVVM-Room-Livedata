package mirzae.com.medicine.ui.contactus

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContactUsViewModel: ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is contactus Fragment"
    }
    val text: LiveData<String> = _text
}
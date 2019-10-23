package mirzae.com.medicine.ui.subject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SubjectViewModel: ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is subject Fragment"
    }
    val text: LiveData<String> = _text

}
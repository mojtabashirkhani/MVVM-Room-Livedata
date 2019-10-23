package mirzae.com.medicine.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailViewModel: ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is detail Fragment"
    }
    val text: LiveData<String> = _text
}
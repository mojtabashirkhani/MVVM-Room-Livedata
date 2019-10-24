package mirzae.com.medicine.ui.account

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AccountViewModel: ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "به زودی ..."
    }
    val text: LiveData<String> = _text

}
package ir.roshdclub.onlinemedrep.ui.screen.detail

import android.app.Application
import androidx.lifecycle.*
import ir.roshdclub.onlinemedrep.db.Medicine
import ir.roshdclub.onlinemedrep.db.MedicineDatabase
import ir.roshdclub.onlinemedrep.db.MedicineRepository

class DetailViewModel(application: Application, name: String?): AndroidViewModel(application) {


    private val repository: MedicineRepository
    val content : LiveData<Medicine>

    init {
        val medicineDao = MedicineDatabase.getDatabase(application, viewModelScope).medicineDao()
        repository = MedicineRepository(medicineDao)
        content = repository.getContent(name)

    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is detail Fragment"
    }
    val text: LiveData<String> = _text
}
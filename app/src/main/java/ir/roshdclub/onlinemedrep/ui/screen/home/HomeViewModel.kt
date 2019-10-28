package ir.roshdclub.onlinemedrep.ui.screen.home

import android.app.Application
import androidx.lifecycle.*
import ir.roshdclub.onlinemedrep.R
import ir.roshdclub.onlinemedrep.db.Medicine
import ir.roshdclub.onlinemedrep.db.MedicineDatabase
import ir.roshdclub.onlinemedrep.db.MedicineRepository

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: MedicineRepository
    var tag: MutableLiveData<String> = MutableLiveData()



    init {
        val medicineDao = MedicineDatabase.getDatabase(application, viewModelScope).medicineDao()
        repository = MedicineRepository(medicineDao)

    }

    fun getSearchResult(search: String?): LiveData<List<Medicine>>{
        return repository.getSearchResult(search)
    }


    private val txtSubject = MutableLiveData<ArrayList<String>>().apply {
    value = arrayListOf("محبوب ترین ها", "تخصص ها", "دارو های گیاهی", "مکمل ها", "مقالات علمی", "همایش ها", "یافته های جدید پزشکی")
    }
    private val imgSubject = MutableLiveData<ArrayList<Int>>().apply {
        value = arrayListOf(R.drawable.ic_file, R.drawable.ic_doctor,R.drawable.ic_herbal , R.drawable.ic_vitamins,
            R.drawable.ic_copyright, R.drawable.ic_lecture, R.drawable.ic_research)

    }

    val list: LiveData<ArrayList<String>> = txtSubject
    val image: LiveData<ArrayList<Int>> = imgSubject

}
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

    private val mNoResult = MutableLiveData<String>().apply {
        value = "موردی یافت نشد !!!"
    }

    private val txtSubject = MutableLiveData<ArrayList<String>>().apply {
    value = arrayListOf("محبوب ترین ها", "تخصص ها", "دارو های گیاهی", "مکمل ها", "مقالات علمی", "همایش ها", "یافته های جدید پزشکی")
    }
    private val imgSubject = MutableLiveData<ArrayList<Int>>().apply {
        value = arrayListOf(R.drawable.favourite, R.drawable.profession,R.drawable.herbal , R.drawable.supplement,
            R.drawable.article, R.drawable.conference, R.drawable.find)

    }

    val list: LiveData<ArrayList<String>> = txtSubject
    val image: LiveData<ArrayList<Int>> = imgSubject
    val result: LiveData<String> = mNoResult

}
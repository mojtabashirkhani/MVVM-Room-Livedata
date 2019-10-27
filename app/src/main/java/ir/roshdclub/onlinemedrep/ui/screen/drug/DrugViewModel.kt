package ir.roshdclub.onlinemedrep.ui.screen.drug

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import ir.roshdclub.onlinemedrep.db.Medicine
import ir.roshdclub.onlinemedrep.db.MedicineDatabase
import ir.roshdclub.onlinemedrep.db.MedicineRepository


class DrugViewModel(application: Application, subject: String?): AndroidViewModel(application) {

     val repository: MedicineRepository
     var listDrug : LiveData<List<Medicine>>


    init {
        val medicineDao = MedicineDatabase.getDatabase(application, viewModelScope).medicineDao()
        repository = MedicineRepository(medicineDao)
        listDrug = repository.getDrugsList(subject)

    }



    /*fun insertMedicines(medicine: Medicine) = viewModelScope.launch {
        repository.insertMedicines(medicine)
    }*/

}
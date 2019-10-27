package ir.roshdclub.onlinemedrep.db

import androidx.lifecycle.LiveData

class MedicineRepository(private val medicineDao: MedicineDao) {


//    val listHomeSubject: LiveData<List<Medicine>> = medicineDao.getHomeSubjects()
     fun getDrugsList(subject: String?): LiveData<List<Medicine>> {
     return medicineDao.getMedicines(subject)
   }

    fun getContent(name: String?): LiveData<Medicine>{
        return medicineDao.getContent(name)
    }
    suspend fun insertMedicines(medicine: Medicine){
        medicineDao.insertMedicines(medicine)
    }

}
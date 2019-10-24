package ir.roshdclub.onlinemedrep.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MedicineDao {

    @Query ("SELECT name FROM medicine WHERE tag LIKE (:tag)")
    fun search(tag: String): LiveData<List<Medicine>>

    @Query("SELECT DISTINCT subject FROM medicine WHERE subject IN ('محبوب ترین ها','تخصص ها','دارو های گیاهی','مکمل ها','مقالات علمی','همایش ها','یافته های جدید پزشکی') ")
    fun getHomeSubjects(): LiveData<List<Medicine>>

    @Query("SELECT DISTINCT subject FROM medicine WHERE subject NOT IN ('محبوب ترین ها','تخصص ها','دارو های گیاهی','مکمل ها','مقالات علمی','همایش ها','یافته های جدید پزشکی') ")
    fun getSubHomeSubjects(): LiveData<List<Medicine>>

    @Query("SELECT DISTINCT image FROM medicine WHERE subject IN ('محبوب ترین ها','تخصص ها','دارو های گیاهی','مکمل ها','مقالات علمی','همایش ها','یافته های جدید پزشکی') ")
    fun getHomeImages(): LiveData<List<Medicine>>

    @Query("SELECT DISTINCT image FROM medicine WHERE subject NOT IN ('محبوب ترین ها','تخصص ها','دارو های گیاهی','مکمل ها','مقالات علمی','همایش ها','یافته های جدید پزشکی') ")
    fun getSubHomeImages(): LiveData<List<Medicine>>

    @Query("SELECT name FROM medicine WHERE subject=(:subject)")
    fun getMedicines(subject: String): LiveData<List<Medicine>>

    @Query("SELECT content FROM medicine WHERE name = (:name)")
    fun getContent(name: String): LiveData<Medicine>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMedicines(medicine: Medicine)


}
package mirzae.com.medicine.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "tag", foreignKeys =
      arrayOf(ForeignKey(entity = Medicine::class,
     parentColumns = arrayOf("id_tag"),
     childColumns = arrayOf("medicine_id"))
    )
)

data class Tag (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_tag")
    var id: Int = 0,

    @ColumnInfo(name = "medicine_id")
    var medicineId: Int = 0,

    @ColumnInfo(name = "name")
    var name: String = ""


)

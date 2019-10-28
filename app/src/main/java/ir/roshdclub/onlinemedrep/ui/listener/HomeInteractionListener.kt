package ir.roshdclub.onlinemedrep.ui.listener

interface HomeInteractionListener {
    fun homeToSubject(position: Int)
    fun homeToDrug(subject: String)
    fun homeToDetail(name: String)

}
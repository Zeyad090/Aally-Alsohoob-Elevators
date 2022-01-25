package zeyad.app.aallyalsohoobelevators

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import zeyad.app.aallyalsohoobelevators.welcome.WelcomeFragment
import java.lang.IllegalStateException

class DialogSitting : DialogFragment(){

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

return Fragment().let {
val arlertDoialog = AlertDialog.Builder(requireContext())
    arlertDoialog.setView(requireActivity(). layoutInflater.inflate(R.layout.dialog_sitting, null))
    arlertDoialog.setPositiveButton("submit", DialogInterface.OnClickListener({dialog, id ->

    }))

    arlertDoialog.create()

}?:throw IllegalStateException("Fragment is null !!")

    }
}
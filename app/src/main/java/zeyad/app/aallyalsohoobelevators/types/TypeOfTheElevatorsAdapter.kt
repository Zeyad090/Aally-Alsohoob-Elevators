package zeyad.app.aallyalsohoobelevators.types

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import zeyad.app.aallyalsohoobelevators.R
import zeyad.app.aallyalsohoobelevators.cabin.CabinOfTypeOfCabinOfElavatorsViewHolder
import zeyad.app.aallyalsohoobelevators.cabin.CabinOfTypeOfElevatorsModel

class TypeOfTheElevatorsAdapter (private  val context: Context, private val images:List <TypesOfTheElevatorsModel>)
    :RecyclerView.Adapter<TypeOfTheElevatorsViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int): TypeOfTheElevatorsViewHolder {
        return TypeOfTheElevatorsViewHolder(
            //=============== RecyclerView in list items==================//
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_type_items,parent,false)
        )

    }
//==================this function for how many items do you have in recyclerView ===================//
    override fun getItemCount(): Int{
        return images.size
    }
//=======================for put the item in it position============================//
    override fun onBindViewHolder(holder: TypeOfTheElevatorsViewHolder, position: Int) {
        val idOfPhoto = images[position]
        holder.nameOfType.text = idOfPhoto.name
       Glide.with(context)
           .load(idOfPhoto.image)
           .into(holder.typeImage)
    }


}
//=====================for find the place what we will put the item in================//
class TypeOfTheElevatorsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val typeImage :ImageView = itemView.findViewById(R.id.image_of_type)
    val nameOfType : TextView = itemView.findViewById(R.id.name_of_type)

}
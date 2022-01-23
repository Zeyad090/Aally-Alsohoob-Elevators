package zeyad.app.aallyalsohoobelevators.cabin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import zeyad.app.aallyalsohoobelevators.R

class TypeOfCabinOfElevatorsAdapter(
    private val context: Context,
    private val photo: List<CabinOfTypeOfElevatorsModel>,
    //====================for select item from RecyclerView ==========================//
    val onItemClicked: (CabinOfTypeOfElevatorsModel) -> Unit,
) : RecyclerView.Adapter<CabinOfTypeOfCabinOfElavatorsViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int,
    ): CabinOfTypeOfCabinOfElavatorsViewHolder {
        return CabinOfTypeOfCabinOfElavatorsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_items, parent, false)

        )

    }

    override fun onBindViewHolder(holder: CabinOfTypeOfCabinOfElavatorsViewHolder, position: Int) {
        //================this for handle image from network=====================//
        val image = photo[position]
        Glide.with(context)
            .load(image.photo)
            .into(holder.photos)

        //===================select item to any where in the app ==========================//
        holder.itemView.setOnClickListener {
            onItemClicked(photo[position])
        }
    }
//=====================this for how many images you will bring =========================//
    override fun getItemCount(): Int {
        return photo.size
    }


}
//=====================this class for hold photo and put the photo in it place====================///
class CabinOfTypeOfCabinOfElavatorsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val photos: ImageView = itemView.findViewById(R.id.type_of_elevator)
}

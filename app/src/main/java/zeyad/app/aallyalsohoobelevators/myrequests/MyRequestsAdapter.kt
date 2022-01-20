package zeyad.app.aallyalsohoobelevators.myrequests

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import zeyad.app.aallyalsohoobelevators.R

class MyRequestsAdapter(
    private val context: Context,
    private val list: MutableList<MyRequests>,
    //====================for select item from RecyclerView ==========================//

) : RecyclerView.Adapter<MyRequestsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRequestsViewHolder {
        return MyRequestsViewHolder(
            LayoutInflater.from(parent.context)
                //=============== RecyclerView in list items my requests==================//

                .inflate(R.layout.list_items_my_requests, parent, false)
        )
    }
//=======================for put the item in it position============================//

    override fun onBindViewHolder(holder: MyRequestsViewHolder, position: Int) {
        val dataRequests = list[position]
        holder.country.text = dataRequests.Country
        holder.floor.text =dataRequests.Floor
        holder.machine.text =dataRequests.Machine
        holder.type.text =dataRequests.Types

        Glide.with(context)
            .load(dataRequests.imageCabin)
            .into(holder.imageCabin)

    }
//==================this function for how many items do you have in recyclerView ===================//

    override fun getItemCount(): Int {
        return list.size
    }
}

//=====================for find the place what we will put the item in================//

class MyRequestsViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
    val country : TextView = itemView.findViewById(R.id.country)
    val floor : TextView = itemView.findViewById(R.id.floors)
    val machine : TextView =itemView.findViewById(R.id.machine)
    val type :TextView = itemView.findViewById(R.id.types)
    val imageCabin : ImageView = itemView.findViewById(R.id.image_my_requests)

}

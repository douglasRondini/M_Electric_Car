package adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.my_electric_car.R
import model.InfoCar

class AdapterCar(
    private val context: Context,
    private val car: List<InfoCar>
    ): RecyclerView.Adapter<AdapterCar.InfoCarViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoCarViewHolder {
        val itemLista = LayoutInflater.from(context).inflate(R.layout.car_item,parent,false)
        val holder = InfoCarViewHolder(itemLista)
        return holder
    }

    override fun onBindViewHolder(holder: InfoCarViewHolder, position: Int) {
        holder.foto.setImageResource(car[position].foto)
        holder.preço.text = car[position].preço
        holder.bateria.text = car[position].bateria
        holder.potencia.text = car[position].potencia
        holder.recarga.text = car[position].recarga
    }

    override fun getItemCount(): Int = car.size


        inner class InfoCarViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            val foto = itemView.findViewById<ImageView>(R.id.img_car)
            val preço = itemView.findViewById<TextView>(R.id.txt_valor_preço)
            val bateria = itemView.findViewById<TextView>(R.id.txt_valor_bateria)
            val potencia = itemView.findViewById<TextView>(R.id.txt_valor_potencia)
            val recarga = itemView.findViewById<TextView>(R.id.txt_valor_recarga)

        }

    }



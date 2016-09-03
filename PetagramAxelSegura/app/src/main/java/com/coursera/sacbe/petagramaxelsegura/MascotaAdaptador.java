package com.coursera.sacbe.petagramaxelsegura;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Sacbe on 03/09/2016.
 */
public class MascotaAdaptador extends  RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    private ArrayList<Mascota> mascotas;
    private Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas=mascotas;
        this.activity=activity;
    }

    //Inflar el layout y lo pasará al view holder para obtener los views
    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    //asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombre.setText(mascota.getNombre());
        mascotaViewHolder.tvRaza.setText(mascota.getRaza());

        String raiting = "";

        if(mascota.getRaiting()>0)
             raiting = String.valueOf(mascota.getRaiting());

        mascotaViewHolder.tvRaiting.setText(raiting);

        mascotaViewHolder.imgFoto.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Toast.makeText(activity, mascota.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, DetalleMascota.class);
                intent.putExtra(activity.getResources().getString(R.string.pFoto), mascota.getFoto());
                intent.putExtra(activity.getResources().getString(R.string.pNombre), mascota.getNombre());
                intent.putExtra(activity.getResources().getString(R.string.pRaza), mascota.getRaza());

                String raiting = "";

                if(mascota.getRaiting()>0)
                    raiting = String.valueOf(mascota.getRaiting());

                intent.putExtra(activity.getResources().getString(R.string.pRating), raiting);
                activity.startActivity(intent);
                //activity.finish();
            }
        });

        mascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                mascota.setRaiting(mascota.getRaiting()+1);
                mascotaViewHolder.tvRaiting.setText(String.valueOf(mascota.getRaiting()));
                Toast.makeText(activity, "Diste like a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {//Cantidad de elementos que contiene la lista
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombre;
        private TextView tvRaza;
        private TextView tvRaiting;
        private ImageButton btnLike;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFotoCV);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvRaza = (TextView) itemView.findViewById(R.id.tvRazaCV);
            tvRaiting = (TextView) itemView.findViewById(R.id.tvRatingCV);
            btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);
        }
    }
}

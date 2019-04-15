package tech.mbsoft.dynamicviewaddrecylerview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import tech.mbsoft.dynamicviewaddrecylerview.ItemClickListener;
import tech.mbsoft.dynamicviewaddrecylerview.R;
import tech.mbsoft.dynamicviewaddrecylerview.model.CarModel;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.CarViewHolder> {

    Context context;
    ArrayList<CarModel> carModels;
    ItemClickListener itemClickListener;

    public CarAdapter(Context context, ArrayList<CarModel> carModels, ItemClickListener itemClickListener) {
        this.context = context;
        this.carModels = carModels;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_view_model_item, viewGroup, false);
        return new CarViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull final CarViewHolder carViewHolder, final int i) {

        final CarModel carModel = carModels.get(i);
        carViewHolder.tvCarName.setText(carModel.getCarName());
        //carViewHolder.carImage.setImageDrawable(context.getDrawable(R.drawable.ic_car));
        carViewHolder.carImage.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_car));

        carViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.onItemClicked(carViewHolder, carModel, i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return carModels.size();
    }

    public class CarViewHolder extends RecyclerView.ViewHolder {

        ImageView carImage;
        TextView tvCarName;

        public CarViewHolder(@NonNull View itemView) {
            super(itemView);
            carImage = itemView.findViewById(R.id.iv_car);
            tvCarName = itemView.findViewById(R.id.tv_car_name);

        }
    }
}

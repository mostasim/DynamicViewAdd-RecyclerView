package tech.mbsoft.dynamicviewaddrecylerview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import tech.mbsoft.dynamicviewaddrecylerview.adapter.CarAdapter;
import tech.mbsoft.dynamicviewaddrecylerview.model.CarModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout container = findViewById(R.id.container);

        View[] childViews = new View[3]; //we can have multiple child views
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //Adding multiple views
        for (int v = 0; v < childViews.length; v++) {
            childViews[v] = inflater.inflate(R.layout.car_list_model_item, null);
            TextView title = childViews[v].findViewById(R.id.tv_title);
            title.setText("Year " + 201 + "" + v);
            RecyclerView recyclerView = childViews[v].findViewById(R.id.list_item);

            //Adding multiple Data Item for individual list view
            ArrayList<CarModel> l = new ArrayList<CarModel>();
            for (int i = 0; i <= v + 5; i++) {
                CarModel model = new CarModel("img", "ModelName" + v + " ->" + i);
                l.add(model);
            }
            CarAdapter carAdapter = new CarAdapter(MainActivity.this, l, new ItemClickListener() {
                @Override
                public void onItemClicked(RecyclerView.ViewHolder vh, Object item, int pos) {
                    CarModel model = (item != null) ? (CarModel) item : null;
                    Toast.makeText(MainActivity.this, "Item Clicked: " + model.getCarName() + " " + pos, Toast.LENGTH_SHORT).show();
                }
            });


            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(carAdapter);

            container.addView(childViews[v]);


        }
    }
}

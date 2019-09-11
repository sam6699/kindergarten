package kindergarten.uz.kindergarten.adapters;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import kindergarten.uz.kindergarten.R;
import kindergarten.uz.kindergarten.entity.Group;

public class TypeAdapter extends RecyclerView.Adapter<TypeAdapter.TypeHolder>  {
    List<Group> list;

    public TypeAdapter(ArrayList<Group> ls) {
            this.list = ls;

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public TypeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v  = LayoutInflater.from(parent.getContext()).inflate(R.layout.type_item,parent,false);
        TypeHolder lih = new TypeHolder(v);
        return  lih;
    }

    @Override
    public void onBindViewHolder(TypeHolder holder, int position) {
            holder.tv1.setText(list.get(position).getType().getName());
                   if (list.get(position).getCount()==list.get(position).getBusy()){
            holder.tv3.setTextColor(Color.RED);
        }

        if (list.get(position).getType().getName().compareTo("kichik")==0)
            holder.tv4.setText("2-3");
        if (list.get(position).getType().getName().compareTo("o'rtacha")==0)
            holder.tv4.setText("4-5");
        if (list.get(position).getType().getName().compareTo("katta")==0)
            holder.tv4.setText("5-6");
        if (list.get(position).getType().getName().compareTo("tayorlov")==0)
            holder.tv4.setText("6-7");


        holder.tv3.setText(list.get(position).getBusy()+"/"+list.get(position).getCount() );
        holder.tv2.setText(list.get(position).getPrice()+"");




    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TypeHolder extends RecyclerView.ViewHolder {
        TextView tv1,tv2,tv3,tv4;
        ConstraintLayout cv;
        public TypeHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.type_item_content);
            tv1 = cv.findViewById(R.id.type_name);
            tv2 = cv.findViewById(R.id.price);
            tv3 = cv.findViewById(R.id.counts);
            tv4 = cv.findViewById(R.id.ages);
        }
    }
}

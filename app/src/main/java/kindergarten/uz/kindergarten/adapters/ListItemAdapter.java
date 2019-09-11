package kindergarten.uz.kindergarten.adapters;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import kindergarten.uz.kindergarten.R;
import kindergarten.uz.kindergarten.entity.Company;


public class ListItemAdapter extends RecyclerView.Adapter<ListItemAdapter.ListItemHolder> {
    List<Company> ls;

    public ListItemAdapter(ArrayList<Company> list){
        ls = list;

    }

    public ListItemAdapter() {

    }

    public void setList(ArrayList<Company> ls){
        this.ls.clear();
        this.ls.addAll(ls);

    }

    public List<Company> getLs() {
        return ls;
    }

    @Override
    public ListItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v  = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        ListItemHolder lh = new ListItemHolder(v);
        return lh;
    }

    @Override
    public void onBindViewHolder(ListItemHolder holder, int position) {


        holder.tv.setText(ls.get(position).getName());
        System.out.println(ls.get(position).getName());

    }




    @Override
    public int getItemCount() {
        return ls.size();
    }

    public class ListItemHolder extends RecyclerView.ViewHolder {
        ConstraintLayout item;
        TextView tv;
        public ListItemHolder(View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.item_container);
            tv = item.findViewById(R.id.item_name);

        }
    }
}

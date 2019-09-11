package kindergarten.uz.kindergarten;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import kindergarten.uz.kindergarten.adapters.RecyclerItemClickListener;
import kindergarten.uz.kindergarten.adapters.TypeAdapter;

public class TypeModal extends AppCompatActivity {
    RecyclerView rv;
    TypeAdapter ta;
    RecyclerItemClickListener nest;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.type_modal);
        rv = findViewById(R.id.list);
        setTitle("Xonalar");
        init();


    }


    public  void init(){
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        ta = new TypeAdapter(ReserveFragment.groups);
        rv.setAdapter(ta);
        rv.getAdapter().notifyDataSetChanged();
        rv.removeOnItemTouchListener(nest);
        System.out.println("start");
        nest = new RecyclerItemClickListener(this, rv, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                System.out.println(position);
                Intent intent =new Intent();
                intent.putExtra("group",ReserveFragment.groups.get(position).getId());
                intent.putExtra("name",ReserveFragment.groups.get(position).getType().getName());
                setResult(RESULT_OK,intent);
                close();
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        });
        rv.addOnItemTouchListener(nest);
    }


    public void close(){
        this.finish();

    }


}

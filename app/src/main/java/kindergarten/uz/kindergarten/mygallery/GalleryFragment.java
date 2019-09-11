package kindergarten.uz.kindergarten.mygallery;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import kindergarten.uz.kindergarten.R;
import kindergarten.uz.kindergarten.adapters.RecyclerItemClickListener;
import kindergarten.uz.kindergarten.entity.Image;
import kindergarten.uz.kindergarten.rest.RestConnector;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GalleryFragment extends Fragment {
    RecyclerView lux;
    ArrayList<Image> g_list;

    RecyclerItemClickListener nest;
    public static String selected;
    public static String str="";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.common_gallery_view,null);
        lux = v.findViewById(R.id.g_list);
        g_list = new ArrayList<>();
        loader();


        return v;
    }
    void loader(){
        final ImageAdapter ia = new ImageAdapter(g_list,getActivity().getResources().getDisplayMetrics());
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        lux.setLayoutManager(llm);
        lux.setAdapter(ia);
        lux.getAdapter().notifyDataSetChanged();
        lux.removeOnItemTouchListener(nest);
        nest = new RecyclerItemClickListener(lux.getContext(),lux, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                System.out.println("dasdadasd");
                selected = g_list.get(position).getPath();
                Intent intent = new Intent(getActivity(),GalleryPreview.class);
//                intent.putExtra("path",luxList.get(position).getPath());
                str=g_list.get(position).getPath();
                startActivity(intent);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        });
        lux.addOnItemTouchListener(nest);
        RestConnector.getInstance().getRestBasicApi().getFotos().enqueue(new Callback<ArrayList<Image>>() {
            @Override
            public void onResponse(Call<ArrayList<Image>> call, Response<ArrayList<Image>> response) {
                ia.setDataList(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Image>> call, Throwable t) {

            }
        });






    }


     class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageHolder> {

        List<Image> list;
        DisplayMetrics des;
        public ImageAdapter(List<Image> list,DisplayMetrics dm) {
            this.des=dm;
            this.list = list;
        }

        @Override
        public ImageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_item,parent,false);
            return new ImageHolder(v);
        }

         @Override
         public void onBindViewHolder(ImageHolder holder, int position) {
            byte [] i = Base64.decode(list.get(position).getPath(),Base64.DEFAULT);
            Bitmap b = BitmapFactory.decodeByteArray(i,0,i.length);

            holder.iv.setImageBitmap(b);
             System.out.println(list.get(position).getName());
         }


        @Override
        public int getItemCount() {
            return list.size();
        }

         public void setDataList(ArrayList<Image> imageList) {
            list.clear();
            list.addAll(imageList);

            notifyDataSetChanged();
         }


         class ImageHolder extends RecyclerView.ViewHolder{
            ImageView iv;

            public ImageHolder(View itemView) {
                super(itemView);
                iv = itemView.findViewById(R.id.img);

            }
        }

    }




}

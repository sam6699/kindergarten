package kindergarten.uz.kindergarten.cabinet;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Base64;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import kindergarten.uz.kindergarten.R;
import kindergarten.uz.kindergarten.entity.Shedule;
import kindergarten.uz.kindergarten.rest.RestConnector;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BIO extends Fragment {
    TextView name,birth,address,group,current,time,time1;
    LinearLayout menuLayout,activities;
    ImageView img;
    String uuid="";
    String style[]={"#FFCC66","#FFAD33","#FF952A"};
    TextView pat1,pat2;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_bio,null);
        name = v.findViewById(R.id.bio_name);
        birth = v.findViewById(R.id.bio_birth);
        address = v.findViewById(R.id.bio_adress);
        group = v.findViewById(R.id.bio_group);
        current =v.findViewById(R.id.bio_current);
        time = v.findViewById(R.id.bio_comming);
        time1 = v.findViewById(R.id.bio_out);
        menuLayout = v.findViewById(R.id.bio_menu1);
        activities = v.findViewById(R.id.bio_activity);
        pat1 = v.findViewById(R.id.textView25);
        pat2= v.findViewById(R.id.textView20);


        img = v.findViewById(R.id.imageView2);
        getActivity().setTitle("Cabinet");
        init();
        return v;
    }
    public void init(){
        Intent intent = getActivity().getIntent();
        uuid = intent.getStringExtra("user");
        RestConnector.getInstance().getRestBasicApi().getChild(uuid).enqueue(new Callback<Shedule>() {
            @Override
            public void onResponse(Call<Shedule> call, Response<Shedule> response) {
                Shedule shedule = response.body();
                name.setText("F.I.O:   " +shedule.getChild().getName());
                birth.setText("tug'lgan sana: "+shedule.getChild().getBirth());
                address.setText("Yashash manzili: "+shedule.getChild().getAddress());
                group.setText("Guruh turi: "+ shedule.getChild().getGroup().getType().getName());
                SimpleDateFormat sdf = new SimpleDateFormat("dd . MM . yy");
                current.setText(sdf.format(new Date()));
                time.setText(shedule.getCurrent().getCome()+" da boqchaga kelgan");
                time1.setText(shedule.getCurrent().getOut()+" da boqchadan ketgan");
                if(shedule.getChild().getImage().getPath()!=null&&shedule.getChild().getImage().getPath()!=""){
                byte[] b= Base64.decode(shedule.getChild().getImage().getPath(),Base64.DEFAULT);
                Bitmap bitmap = BitmapFactory.decodeByteArray(b,0,b.length);
                img.setImageBitmap(bitmap);
                }

                for (int i=0;i<shedule.getMenuList().size();i++){
                    TextView tv = new TextView(birth.getContext());
                    tv.setText(shedule.getMenuList().get(i).getType()+":");
                    tv.setTextColor(Color.WHITE);
                    tv.setBackgroundColor(Color.parseColor(style[i]));
                    menuLayout.addView(tv);
                    int index=1;
                    for (String s : shedule.getMenuList().get(i).getList()){
                        TextView tv1 = new TextView(tv.getContext());
                        tv1.setText(index+"."+s);
                    tv1.setTextColor(Color.WHITE);
                    tv1.setBackgroundColor(Color.parseColor(style[i]));
                        menuLayout.addView(tv1);
                    index++;
                    }
                }
                int cnt=1;
                for (int i=0;i<shedule.getChild().getList().size();i++){
                    LinearLayout linearLayout = new LinearLayout(activities.getContext());

                    linearLayout.setOrientation(LinearLayoutManager.HORIZONTAL);
                    linearLayout.setMinimumWidth(250);
                    linearLayout.setMinimumHeight(ViewGroup.LayoutParams.WRAP_CONTENT);

//                    linearLayout.setBackgroundColor(Color.YELLOW);
                    TextView tv = new TextView(linearLayout.getContext());
                    tv.setText(shedule.getChild().getList().get(i).getName()+"");
                    tv.setWidth(pat1.getWidth());
                    tv.setTextColor(Color.WHITE);
                    tv.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));

                    System.out.println("tv "+tv.getText());

                    TextView tv1 = new TextView(linearLayout.getContext());
                    tv1.setWidth(pat2.getWidth());

                    if(0<shedule.getChild().getList().get(i).getBall()&&shedule.getChild().getList().get(i).getBall()<=56){
                    tv1.setText("Qoniqarsiz");
                    tv1.setTextColor(Color.RED);
                        System.out.println(shedule.getChild().getList().get(i).getBall()+"balllll 56");

                    }
                    if(shedule.getChild().getList().get(i).getBall()<=70&&shedule.getChild().getList().get(i).getBall()>=56){
                        tv1.setText("Qoniqarli");
                        tv1.setTextColor(Color.parseColor("#FFCC66"));

                    }
                    if(shedule.getChild().getList().get(i).getBall()<=85&&shedule.getChild().getList().get(i).getBall()>=71){
                        tv1.setText("Yaxshi");
                        tv1.setTextColor(Color.parseColor("#1821DE"));

                    }
                    if(shedule.getChild().getList().get(i).getBall()<=100&&shedule.getChild().getList().get(i).getBall()>=86){
                        tv1.setText("A'lo");
                        tv1.setTextColor(Color.GREEN);

                    }
                    tv1.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                    tv1.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
                    linearLayout.addView(tv);
                    linearLayout.addView(tv1);

                    activities.addView(linearLayout);


                }




            }

            @Override
            public void onFailure(Call<Shedule> call, Throwable t) {

            }
        });




    }

}

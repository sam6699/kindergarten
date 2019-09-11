package kindergarten.uz.kindergarten;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import kindergarten.uz.kindergarten.entity.Main;
import kindergarten.uz.kindergarten.rest.RestConnector;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainFragment extends Fragment {


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.content_main_fragment,null);
        final TextView tv = v.findViewById(R.id.content_text);

        RestConnector.getInstance().getRestBasicApi().getMainId(MainActivity.instance.company).enqueue(new Callback<Main>() {
            @Override
            public void onResponse(Call<Main> call, Response<Main> response) {
                Main main =response.body();

                tv.setText(main.getText());
                MainActivity.instance.getSupportActionBar().setTitle(main.getTitle_text());

            }

            @Override
            public void onFailure(Call<Main> call, Throwable t) {
                                    t.printStackTrace();
            }
        });




        return v;
    }



}



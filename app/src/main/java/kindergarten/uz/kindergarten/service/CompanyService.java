package kindergarten.uz.kindergarten.service;

import android.widget.Toast;

import java.util.ArrayList;

import kindergarten.uz.kindergarten.adapters.ListItemAdapter;
import kindergarten.uz.kindergarten.entity.Company;
import kindergarten.uz.kindergarten.rest.RestConnector;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CompanyService {



    public void getAllCompanies(ListItemAdapter la){
    final ArrayList<Company> list = new ArrayList<>();

        final ListItemAdapter finalLa = la;
        RestConnector.getInstance().getRestBasicApi().getAllCompanies().enqueue(new Callback<ArrayList<Company>>() {
        @Override
        public void onResponse(Call<ArrayList<Company>> call, Response<ArrayList<Company>> response) {
            list.addAll(response.body());
            System.out.println(list.size()+"---------------?????????????");
            finalLa.setList(list);
            finalLa.notifyDataSetChanged();
        }

        @Override
        public void onFailure(Call<ArrayList<Company>> call, Throwable t) {
            t.printStackTrace();
        }
    });


}

    public boolean autority(final String text){
        final boolean[] isValid = {false};
        RestConnector.getInstance().getRestBasicApi().check(text).enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                isValid[0] = response.body();

            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                    t.printStackTrace();
            }
        });
            return isValid[0];
    }



}

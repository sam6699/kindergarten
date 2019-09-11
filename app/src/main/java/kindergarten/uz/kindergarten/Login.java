package kindergarten.uz.kindergarten;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import kindergarten.uz.kindergarten.cabinet.Cabinet;
import kindergarten.uz.kindergarten.rest.RestConnector;
import kindergarten.uz.kindergarten.service.CompanyService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    EditText et;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et = findViewById(R.id.uuid);
        btn = findViewById(R.id.login);
        event();
    }

    public void event(){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RestConnector.getInstance().getRestBasicApi().check(et.getText().toString()).enqueue(new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                        if (response.body()){
                            Intent intent = new Intent(btn.getContext(),Cabinet.class);
                            intent.putExtra("user",et.getText().toString());
                            startActivity(intent);
                        }else {
                            System.out.println("False input");
                            et.setError("UUID hato kiritilgan yoki mavjud emas");
                        }
                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {

                    }
                });



            }
        });



    }



}

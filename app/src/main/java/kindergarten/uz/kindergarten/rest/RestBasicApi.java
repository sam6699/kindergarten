package kindergarten.uz.kindergarten.rest;

import java.util.ArrayList;

import kindergarten.uz.kindergarten.entity.Child;
import kindergarten.uz.kindergarten.entity.Company;
import kindergarten.uz.kindergarten.entity.Contacts;
import kindergarten.uz.kindergarten.entity.Image;
import kindergarten.uz.kindergarten.entity.Main;
import kindergarten.uz.kindergarten.entity.Reserve;
import kindergarten.uz.kindergarten.entity.Group;
import kindergarten.uz.kindergarten.entity.Shedule;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RestBasicApi {

    @GET("company")
    Call<ArrayList<Company>> getAllCompanies();

    @GET("company/main")
    Call<Main> getMainId(@Query("id") Integer id);


    @GET("company/contacts")
    Call<Contacts> getConstacts(@Query("company_id") int id);

    @GET("company/groups")
    Call<ArrayList<Group>> getRooms(@Query("company_id") int id);

    @POST("reserve")
    Call<Reserve> addReserve(@Body Reserve data);

    @GET("company/auth")
    Call<Boolean> check(@Query("uuid")String id);

    @GET("company/child")
    Call<Shedule> getChild(@Query("id")String id);

    @GET("company/fotos")
    Call<ArrayList<Image>> getFotos();
}

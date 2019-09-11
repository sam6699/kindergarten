package kindergarten.uz.kindergarten;

import android.app.DatePickerDialog;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import kindergarten.uz.kindergarten.entity.Child;
import kindergarten.uz.kindergarten.entity.Parent;
import kindergarten.uz.kindergarten.entity.Reserve;
import kindergarten.uz.kindergarten.entity.Group;
import kindergarten.uz.kindergarten.rest.RestConnector;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_OK;

public class ReserveFragment extends Fragment {
    EditText name;
    Button birth;
    EditText address;
    EditText parent,phone;
    String strDate="";
    Button photo;
    ImageView img;
    
    Button type;
    
    Button reg;
    
    int company;
    Child child;
    int price=0;
    boolean isSale=false;
    static ArrayList<Group> groups;
    private static final int CAMERA_REQUEST = 0;


    Calendar dateSelected = Calendar.getInstance();
    private DatePickerDialog datePickerDialog;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            View v =  inflater.inflate(R.layout.content_reserve_fragment, null);
                    child = new Child();
            name = v.findViewById(R.id.name);
            birth = v.findViewById(R.id.age);
            address = v.findViewById(R.id.adress);
            parent = v.findViewById(R.id.parent);
            phone = v.findViewById(R.id.phone);
            photo = v.findViewById(R.id.btn_photo);
            img = v.findViewById(R.id.photo);
            
            type = v.findViewById(R.id.type);
            reg = v.findViewById(R.id.reg);
            initEvents();
            groups = new ArrayList<>();
            company = MainActivity.instance.company;
            RestConnector.getInstance().getRestBasicApi().getRooms(company).enqueue(new Callback<ArrayList<Group>>() {
                @Override
                public void onResponse(Call<ArrayList<Group>> call, Response<ArrayList<Group>> response) {
                    groups.addAll(response.body());
                }

                @Override
                public void onFailure(Call<ArrayList<Group>> call, Throwable t) {

                }
            });


            birth.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setDateTimeField();
                }
            });

        return v;
    }


    private void setDateTimeField() {
        Calendar newCalendar = dateSelected;
        final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        datePickerDialog = new DatePickerDialog(getActivity(),R.style.DialogTheme, new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                dateSelected.set(year, monthOfYear, dayOfMonth, 0, 0);
                birth.setText(sdf.format(dateSelected.getTime()));
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        strDate = birth.getText().toString();
        datePickerDialog.show();


    }

    public void validation(){
        int isValid=0;
        Parent parentId = new Parent();
        Reserve reserve = new Reserve();
        if (!name.getText().toString().equals("")){
            child.setName(name.getText().toString());
            isValid++;
        }else {
            name.setError("F.I.SHni kiriting ");

        }
        if (!birth.getText().toString().equals("")){
            isValid++;
            child.setBirth(birth.getText().toString());
        }else
            Toast.makeText(MainActivity.instance,"to'gilgan sanani kiriting",Toast.LENGTH_LONG).show();
        if (!phone.getText().toString().equals("")&&phone.getText().length()==12){

            parentId.setPhone(phone.getText().toString());
            isValid++;
        }else
            phone.setError("Telefon ramingiz to'liq emas ");
        if (!parent.getText().toString().equals("")){
            parentId.setName(parent.getText().toString());
            isValid++;
        }else
            parent.setError("Ota-onasini F.I.Sh ni kiriting ");
        if (!address.getText().toString().isEmpty()){
            isValid++;
            child.setAddress(address.getText().toString());

        }else
            address.setError("Yashash manzilni kiriting ");
        System.out.println("isValid "+isValid);
        if (isValid==5){

            child.setParent(parentId);
            reserve.setChild(child);
            RestConnector.getInstance().getRestBasicApi().addReserve(reserve).enqueue(new Callback<Reserve>() {
                @Override
                public void onResponse(Call<Reserve> call, Response<Reserve> response) {
                    System.out.println("TESDSAFTES");
                    Toast.makeText(MainActivity.instance,"Arizangiz yuborildi tez qunda siz bilan habaralashadilar",Toast.LENGTH_LONG).show();
                    clearFields();

                }

                @Override
                public void onFailure(Call<Reserve> call, Throwable t) {
                    Toast.makeText(MainActivity.instance,"Hato ro'y berdi",Toast.LENGTH_LONG).show();
                    t.printStackTrace();
                }
            });


        }

    }

    void clearFields(){
         name.setText("");
        birth.setText("TUGILGAN SANA");
        address.setText("");
        parent.setText("");
        phone.setText("");
        img.setImageDrawable(null);
        type.setText("GURUHNI TANLANG");
        child = new Child();

    }

    public void initEvents(){
        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);


            }
        });

        type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent typeIntent = new Intent(type.getContext(),TypeModal.class);
                startActivityForResult(typeIntent,10);

            }
        });



        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("from reg");
                validation();

            }
        });



    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            ByteArrayOutputStream byteArrayOS = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOS);
            String s = null;
            byte[] temp = byteArrayOS.toByteArray();
            s=Base64.encodeToString(temp,Base64.DEFAULT);
            img.setImageBitmap(bitmap);
            child.setDirection(s);
        }
        else if(requestCode ==10 &&resultCode==RESULT_OK){
            String s = data.getStringExtra("name");
            int id = data.getIntExtra("group",0);
            child.setGroup_id(id);
            type.setText(s+" guruh");
            System.out.println("IDDDD "+id);

        }
    }
}

package kindergarten.uz.kindergarten.cabinet;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kindergarten.uz.kindergarten.R;

public class News extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.fragment_news,null);
    return v;

    }
}

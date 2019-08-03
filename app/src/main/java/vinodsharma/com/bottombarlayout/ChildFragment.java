package vinodsharma.com.bottombarlayout;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.zip.Inflater;

public class ChildFragment extends Fragment {

    TextView TvParent,TvChild;
    public ChildFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View rootview=  inflater.inflate(R.layout.fragment_child, container, false);
        TvParent=rootview.findViewById(R.id.tvparent);
                TvChild=rootview.findViewById(R.id.tvchid);
                Bundle bundle=getArguments();
                TvParent.setText("Parent"+bundle.getString("parent"));
        TvChild.setText("Child"+bundle.getString("child"));

        return rootview;
    }
}

package kr.co.neostack.www.android_fragment_example;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment {

    // fragment_main.xml 파일과 인플레이션으로 연결해주는것을 메모리 객체화를 시켜주어야 한다.
    MainActivity activity;

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        activity = (MainActivity)getActivity();
    }

    @Override
    public void onDetach(){
        super.onDetach();
        activity = null;
    }

    // @Nullable 무조건 null인지 확인해야함
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // 인플레이션이 가능하다, container 이쪽으로 붙여달라, fragment_main을
        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.fragment_main,container,false);
        // rootview가 플래그먼트 화면으로 보이게 된다. 부분화면을 보여주고자하는 틀로 생각하면 된다.
        // fragment_main 파일과 MainFragment와 연결 해준다.
        // 인플레이션 과정을 통해서 받을 수 있다.


        // 버튼2 -> 버튼 으로 만든다음에 인플레이션이 되고나서 메모리가 되니까 find에서 찾을 수 있다.

        Button button = (Button) rootview.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            // 요청을 보내야 하는데 메인 액티비티에 다가 메소드를 하나 만들어야 한다.
            @Override
            public void onClick(View v) {
                activity.onFragmentChange(1);
            }
        });
        //getActivity();      // 액티비티위에 올라가게 한다.

        return rootview;
        // 플레그먼트 화면으로 보여주게 된다.
    }
}

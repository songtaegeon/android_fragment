package kr.co.neostack.www.android_fragment_example;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    MainFragment fragmentMain;
    MenuFragment fragmentMunu;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentMain = new MainFragment();
        fragmentMunu = new MenuFragment();

        Button button = (Button)findViewById(R.id.button);
        Button button2 = (Button)findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentMain).commit(); // 여러개의 명을 만들어서 쓴다
                // 꼭 commit 를 해주어야 실행이 된다. 플래그먼트 매니저가 플래그먼트를 담당 한다.
                // add라고해서 추가를 해주지 않고 replace를 써주는데, 기존에 있던것들을 대체 해 주게 된다.
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentMunu).commit(); // 여러개의 명을 만들어서 쓴다
                // 꼭 commit 를 해주어야 실행이 된다. 플래그먼트 매니저가 플래그먼트를 담당 한다.
                // transaction 기반으로 한다는것을 잊지 말것.
                // add라고해서 추가를 해주지 않고 replace를 써주는데, 기존에 있던것들을 대체 해 주게 된다.
            }
        });
    }

    public void onFragmentChange(int index){
        if(index ==0){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentMain).commit();

        }else if(index ==1){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentMunu).commit();
        }
    }



}

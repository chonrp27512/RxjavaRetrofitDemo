package com.itbird.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.itbird.R;
import com.itbird.retrofit.entity.PatientList;
import com.itbird.retrofit.http.RetrofitWrapper;
import com.itbird.retrofit.subscribers.ProgressSubscriber;
import com.itbird.retrofit.subscribers.SubscriberOnNextListener;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SubscriberOnNextListener getPatientListOnNext;
    TextView testTextView;
    private RetrofitWrapper mRetrofitWrapper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testTextView = (TextView) findViewById(R.id.result_TV);

        mRetrofitWrapper = new RetrofitWrapper(this, true, true);

        findViewById(R.id.click_me_BN).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRetrofitWrapper.getPatientList(new ProgressSubscriber(getPatientListOnNext, MainActivity.this), 39);
            }
        });
        getPatientListOnNext = new SubscriberOnNextListener<List<PatientList>>() {
            @Override
            public void onNext(List<PatientList> patientLists) {
                if (patientLists == null || patientLists.size() <=0 ) {
                }
            }
        };
    }
}

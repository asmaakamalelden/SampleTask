package com.etisalat.sampletask.Meals;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.etisalat.sampletask.ImagePickerActivity;
import com.etisalat.sampletask.Meals.models.Item;
import com.etisalat.sampletask.bases.ApplicationClass;
import com.etisalat.sampletask.bases.BaseActivity;
import com.etisalat.sampletask.bases.BasePresenter;
import com.etisalat.sampletask.bases.recivers.NetworkStateChangeReciver;
import com.example.sampletask.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.etisalat.sampletask.bases.recivers.NetworkStateChangeReciver.IS_NETWORK_AVAILABLE;

public class MenuActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.titleText)
    TextView TV_Title;
    @BindView(R.id.menu_activity_layout)
    ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        getLastUpdateTime();

        getConnectionLostNotification();

        IntentFilter intentFilter = new IntentFilter(NetworkStateChangeReciver.NETWORK_AVAILABLE_ACTION);
        LocalBroadcastManager.getInstance(this).registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                boolean isNetworkAvailable = intent.getBooleanExtra(IS_NETWORK_AVAILABLE, false);
                String networkStatus = isNetworkAvailable ? "connected" : "disconnected";
                showSnackbar("Network Status: " + networkStatus, layout);
                Log.d("connection",networkStatus);
            }
        }, intentFilter);
    }

    private void getLastUpdateTime() {
        SharedPreferences pref = ApplicationClass.getInstance().getSharedPreferences("MyPref", 0);
        TV_Title.setText("last Update " + pref.getString("lastUpdatedTime", null));
    }

    private void getConnectionLostNotification() {
        if (!ApplicationClass.hasNetwork()) {
            showSnackbar("Network Status: connection Lost", layout);
        }
    }

    @Override
    protected BasePresenter setupPresenter() {
        return null;
    }

    @Override
    public void addItems(ArrayList<Item> items) {

    }

    @OnClick(R.id.floatingActionBtn)
    void onClickPickButton() {
        startActivity(new Intent(this, ImagePickerActivity.class));

    }

}

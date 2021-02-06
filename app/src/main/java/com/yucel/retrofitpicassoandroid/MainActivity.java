package com.yucel.retrofitpicassoandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.yucel.retrofitpicassoandroid.model.User;
import com.yucel.retrofitpicassoandroid.services.Api;
import com.yucel.retrofitpicassoandroid.services.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<User> userList=new ArrayList<>();
    private RecyclerView recyclerView;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerView);
        userAdapter=new UserAdapter(userList);
        RecyclerView.LayoutManager userLayoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(userLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(userAdapter);

        getUsers();

    }


    public void getUsers() {
        Api api = ApiClient.getClient().create(Api.class);
        Call<List<User>> users = api.getAllUsers();

        users.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                userList.addAll(response.body());
                userAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                t.printStackTrace();
            }
        });


    }
}
package ntt.thuy.practice.framgia.githubapi.userlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ntt.thuy.practice.framgia.githubapi.R;
import ntt.thuy.practice.framgia.githubapi.entity.User;

public class MainActivity extends AppCompatActivity implements UserListContract.View {

    private List<User> mList;
    private RecyclerView recyclerUsers;
    private UsersAdapter mAdapter;
    private UserListPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializationViews();

//        APIUtils.getApiInterface().getUsers().enqueue(new Callback<List<User>>() {
//
//            @Override
//            public void onResponse(@NonNull Call<List<User>> call, @NonNull Response<List<User>> response) {
//                if(response.body()!=null && !response.body().isEmpty()) {
//                    mList.addAll(response.body());
//                    mAdapter.setList(mList);
//                } else Toast.makeText(MainActivity.this, R.string.null_response_message, Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call<List<User>> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), R.string.failure_message, Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    private void initializationViews() {
        mList = new ArrayList<>();
        recyclerUsers = (RecyclerView) findViewById(R.id.recycler_users);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerUsers.setLayoutManager(llm);
        mAdapter = new UsersAdapter(this, mList);
        recyclerUsers.setAdapter(mAdapter);

        mPresenter = new UserListPresenter(this);
        mPresenter.getUsers();
    }

    @Override
    public void showUsers(List<User> users) {
        mList.addAll(users);
        mAdapter.setList(mList);
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(getApplicationContext(), R.string.failure_message + message, Toast.LENGTH_SHORT).show();
    }
}

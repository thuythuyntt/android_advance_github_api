package ntt.thuy.practice.framgia.githubapi.model;

import java.util.List;

import ntt.thuy.practice.framgia.githubapi.R;
import ntt.thuy.practice.framgia.githubapi.data.API;
import ntt.thuy.practice.framgia.githubapi.data.APIUtils;
import ntt.thuy.practice.framgia.githubapi.entity.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by thuy on 31/07/2018.
 */
public class UserListInteractorImplement implements UserListInteractor {

    API service = APIUtils.getApiInterface();

    @Override
    public void getUsers(final OnGetUserListener listener) {
        service.getUsers().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if(response.body()!=null && !response.body().isEmpty()) listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                listener.onFail(call.toString());
            }
        });
    }
}

package ntt.thuy.practice.framgia.githubapi.data;

import java.util.List;

import ntt.thuy.practice.framgia.githubapi.entity.User;
import retrofit2.Call;
import retrofit2.http.GET;

import static ntt.thuy.practice.framgia.githubapi.Constants.SUB_URL;

/**
 * Created by thuy on 30/07/2018.
 */
public interface API {
    @GET(SUB_URL)
    Call<List<User>> getUsers ();
}

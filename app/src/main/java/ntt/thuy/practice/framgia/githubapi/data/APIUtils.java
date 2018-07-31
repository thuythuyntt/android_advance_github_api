package ntt.thuy.practice.framgia.githubapi.data;

import static ntt.thuy.practice.framgia.githubapi.Constants.BASE_URL;

/**
 * Created by thuy on 30/07/2018.
 */
public class APIUtils {
    public static API getApiInterface(){
        return RetrofitClient.getClient(BASE_URL).create(API.class);
    }
}

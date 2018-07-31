package ntt.thuy.practice.framgia.githubapi.model;

import java.util.List;

import ntt.thuy.practice.framgia.githubapi.entity.User;

/**
 * Created by thuy on 31/07/2018.
 */
public interface UserListInteractor {

    interface OnGetUserListener {
        void onSuccess(List<User> list);
        void onFail(String message);
    }

    void getUsers(OnGetUserListener listener);

}

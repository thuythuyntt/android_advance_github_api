package ntt.thuy.practice.framgia.githubapi.userlist;

import java.util.List;

import ntt.thuy.practice.framgia.githubapi.entity.User;

/**
 * Created by thuy on 31/07/2018.
 */
public interface UserListContract {

    interface View {
        void showUsers(List<User> users);
        void showErrorMessage(String message);
    }

    interface Presenter {
        void getUsers();
    }
}

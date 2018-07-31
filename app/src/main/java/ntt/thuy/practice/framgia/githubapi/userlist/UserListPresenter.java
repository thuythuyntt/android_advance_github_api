package ntt.thuy.practice.framgia.githubapi.userlist;

import java.util.List;

import ntt.thuy.practice.framgia.githubapi.entity.User;
import ntt.thuy.practice.framgia.githubapi.model.UserListInteractor;
import ntt.thuy.practice.framgia.githubapi.model.UserListInteractorImplement;

/**
 * Created by thuy on 31/07/2018.
 */
public class UserListPresenter implements UserListContract.Presenter {

    private UserListContract.View mView;
    private UserListInteractor mModel;

    public UserListPresenter(UserListContract.View view) {
        this.mView = view;
        this.mModel = new UserListInteractorImplement();
    }

    @Override
    public void getUsers() {
        mModel.getUsers(new UserListInteractor.OnGetUserListener() {
            @Override
            public void onSuccess(List<User> list) {
                mView.showUsers(list);
            }

            @Override
            public void onFail(String message) {
                mView.showErrorMessage(message);
            }
        });
    }
}

package ntt.thuy.practice.framgia.githubapi.userlist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import ntt.thuy.practice.framgia.githubapi.R;
import ntt.thuy.practice.framgia.githubapi.entity.User;

/**
 * Created by thuy on 30/07/2018.
 */
public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.MyHolder> {

    List<User> mList;
    Context mContext;

    public UsersAdapter(Context context, List<User> list) {
        this.mContext = context;
        this.mList = list;
    }

    public void setList(List<User> list) {
        this.mList.addAll(list);

        notifyDataSetChanged();
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false));
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.bindData(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        private ImageView imageAvatar;
        private TextView textName;

        public MyHolder(View itemView) {
            super(itemView);
            imageAvatar = itemView.findViewById(R.id.image_user);
            textName = itemView.findViewById(R.id.text_name);
        }

        void bindData(User user) {
            textName.setText(user.getLogin());
            Glide.with(mContext)
                    .load(user.getAvatarUrl())
                    .error(R.mipmap.user)
                    .into(imageAvatar);
        }
    }
}

package com.yucel.retrofitpicassoandroid;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.yucel.retrofitpicassoandroid.model.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private List<User> userList;

    public class UserViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTV, surnameTV;
        public ImageView profileIV;

        public UserViewHolder(View view) {
            super(view);
            nameTV = view.findViewById(R.id.nameTV);
            surnameTV = view.findViewById(R.id.surnameTV);
            profileIV = view.findViewById(R.id.profileIV);
        }

    }

    public UserAdapter(List<User> userList) {
        this.userList = userList;
    }


    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_row, parent, false);
        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = userList.get(position);
        holder.nameTV.setText(user.getName());
        holder.surnameTV.setText(user.getSurname());
        String imageUrl="http://www.yourdomain.com/webservice/"+user.getPhoto();
        Log.d("imageUrl ",imageUrl);
        Picasso.get().load(imageUrl).into(holder.profileIV);

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

}

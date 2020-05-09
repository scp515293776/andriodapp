package com.example.mine.page;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mine.Database.UserDatabase;
import com.example.mine.Entity.User;
import com.example.mine.R;
import com.example.mine.dao.UserDao;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {

    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false);
    }
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        UserDatabase userDatabase;
        final UserDao userDao;

        userDatabase= Room.databaseBuilder(this.getActivity(),UserDatabase.class,"user_database").build();
        userDao=userDatabase.getUserDao();

        super.onActivityCreated(savedInstanceState);
        Button button;
        button = getView().findViewById(R.id.register_button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user1=new User("zhangsan","123","212@qq.com");
                User user2=new User("lisi","456","343@qq.com");
                new InsertAsyncTask(userDao).execute(user1,user2);
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_registerFragment_to_loginFragment);
            }
        });
    }

    static class InsertAsyncTask extends AsyncTask<User,Void,Void>{
        private UserDao userdao;

        public InsertAsyncTask(UserDao userdao) {
            this.userdao = userdao;
        }

        @Override
        protected Void doInBackground(User... users) {
            userdao.insertUsers(users);
            return null;
        }
    }
}

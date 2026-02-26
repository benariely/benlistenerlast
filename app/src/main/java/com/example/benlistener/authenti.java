package com.example.benlistener;

import static java.lang.String.valueOf;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class authenti extends AppCompatActivity {

    FirebaseAuth auth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_authenti);

        if(auth.getCurrentUser()!=null){
            startTheApp();
            return;
        }

    }

    private void addUserToFireStore() {
        // fb user is permanently stored on APP -= email,uid
        FirebaseUser user = auth.getCurrentUser();
        EditText name = findViewById(R.id.etNickname);
        User user1 = new User(100, name.getText().toString());
        // user profile : nickname, profile image, num of coins,
        FirebaseFirestore fb = FirebaseFirestore.getInstance();
        fb.collection("Users").document(user.getUid()).set(user1).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Log.d("Add User", "onComplete: success");

                    startTheApp();
                }
            }
        });

    }

    private void startTheApp() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }


    public void onBtnClick(View view) {EditText etEmail = findViewById(R.id.etEmail);
        String email = valueOf(etEmail.getText().toString());
        EditText etPass =  findViewById(R.id.etPass);
        String password = valueOf(etPass.toString());

        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>()
        {
            //callback functoion from fb
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                if (task.isSuccessful()){
                    Log.d("AUTH", "onComplete: success");

                    addUserToFireStore();
                }
                // if we failed
            }
        });
    }
}
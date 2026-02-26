package com.example.benlistener;

import static android.widget.Toast.LENGTH_SHORT;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Toolbar toolbar=findViewById(R.id.mytoolbar);
        setSupportActionBar(toolbar);

        getOnBackPressedDispatcher().addCallback(this,new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                // this method will be called when back button is pressed
                if(getSupportFragmentManager().getBackStackEntryCount() >0) {
                    getSupportFragmentManager().popBackStack();
                    setDefaultFragment();
                }
                else getOnBackPressedDispatcher().onBackPressed();

            }
        });

        setDefaultFragment();
    }

    private void setDefaultFragment() {

        getSupportFragmentManager().beginTransaction().
                replace(R.id.fragment_container,new MainFragment()).addToBackStack(null).commit();
    }

    public void listenForChanges(){
        FirebaseFirestore fb = FirebaseFirestore.getInstance();

        String docRef = "wqXWjAzK4TUs62S9brcD";
        fb.collection("Users").document(docRef).addSnapshotListener(new EventListener<DocumentSnapshot>()
        {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                Log.d("TAG", "onEvent: CHANGE");
            }
        });
    }


    public void onBtnClick(View view) {
        FirebaseFirestore fb = FirebaseFirestore.getInstance();

     //   EditText et = findViewById(R.id.et);
     //   int etValue = Integer.valueOf(et.getText().toString());
        //User user = new User(etValue);
      //  fb.collection("Users").document("wqXWjAzK4TUs62S9brcD").set(user);
    }

    // show the 3 dot menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        Fragment selectedFragment =  new SettingsFragment();
        int id = item.getItemId();
        if(id==R.id.SettingsFrag) {
            selectedFragment = new SettingsFragment();
            Toast.makeText(this, "FRAG1 SELECTED", LENGTH_SHORT).show();
        }
        else if(id==R.id.LeaderFrag) {
            Toast.makeText(this, "FRAG2 SELECTED", LENGTH_SHORT).show();
            selectedFragment = new LeaderboardFragment();
        }



        getSupportFragmentManager().beginTransaction().
                replace(R.id.fragment_container,selectedFragment).commit();
        return super.onOptionsItemSelected(item);
    }

}
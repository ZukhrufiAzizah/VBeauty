package com.zukhrufi.vbeauty;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.zukhrufi.vbeauty.Common.Common;
import com.zukhrufi.vbeauty.Model.User;

public class SignIn extends AppCompatActivity {
    EditText edtPhone, edtPassword;
    Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        edtPassword = (MaterialEditText)findViewById(R.id.edtPassword);
        edtPhone = (MaterialEditText)findViewById(R.id.edtPhone);
        btnSignIn = (Button)findViewById(R.id.btnSignIn);


        //Init Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference tableUser = database.getReference("User");

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog mDialog = new ProgressDialog(SignIn.this);
                mDialog.setMessage("Please waiting....");
                mDialog.show();
                Log.d("SignIn","this");
                tableUser.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Log.d("SignIn","Change");
                        //check if user not exits in database
                        if (dataSnapshot.child(edtPhone.getText().toString()).exists()) {

                            //Get user information
                            mDialog.dismiss();
                            User user = dataSnapshot.child(edtPhone.getText().toString()).getValue(User.class);
                            user.setPhone(edtPhone.getText().toString()); //set phone
                            if (user.getPassword().equals(edtPassword.getText().toString())) {
                                {
                                    Intent homeIntent = new Intent(SignIn.this, Home.class);
                                    Log.d("SignIn","Home");
                                    Common.currentUser = user;
                                    startActivity(homeIntent);
                                    //startActivity(homeIntent);
                                    Toast.makeText(SignIn.this, "Sign In Successfully !", Toast.LENGTH_SHORT).show();
                                    Log.d("SignIn","Home");
                                    //finish();
                                }
                            } else {
                                Toast.makeText(SignIn.this, "Sign In failed !", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else if (!dataSnapshot.child(edtPhone.getText().toString()).exists()){
                            Toast.makeText(SignIn.this, "User not exits in database !", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });

    }
}

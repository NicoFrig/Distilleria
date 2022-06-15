package com.example.distilleria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {

    private lateinit var db:  FirebaseFirestore
    private lateinit var signIn: Button
    private lateinit var auth: FirebaseAuth
    private lateinit var nome:EditText
    private lateinit var cognome:EditText
    private lateinit var email:EditText
    private lateinit var username:EditText
    private lateinit var pwd:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        nome=findViewById(R.id.nome)
        cognome=findViewById(R.id.cognome)
        email=findViewById(R.id.email)
        username=findViewById(R.id.username)
        pwd=findViewById(R.id.password)
        signIn = findViewById(R.id.signIn)
        auth = Firebase.auth
        db = FirebaseFirestore.getInstance()

        signIn.setOnClickListener {
            auth.createUserWithEmailAndPassword(email.text.toString(), pwd.text.toString())
                .addOnCompleteListener {
                    val currentUser=auth.currentUser
                    val userHashMap = hashMapOf(
                        "nome" to nome.text.toString(),
                        "cognome" to cognome.text.toString(),
                        "username" to username.text.toString()
                    )

                    if (currentUser != null) {
                        db.collection("users").document(currentUser.uid).set(userHashMap)
                            .addOnCompleteListener {

                                Toast.makeText(this, "User Created", Toast.LENGTH_SHORT).show()
                                val intent = Intent(this, MainActivity::class.java)
                                startActivity(intent)
                                finish()
                            }
                            .addOnFailureListener {
                                Toast.makeText(this, "Failed Creating", Toast.LENGTH_SHORT)
                                    .show()
                            }
                    }
            }

            auth.signInWithEmailAndPassword("email", "password")
                .addOnCompleteListener {

                }
                .addOnFailureListener {

                }
        }

        val backButton = findViewById<ImageButton>(R.id.backArrow)
        backButton.setOnClickListener{
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
    }
}
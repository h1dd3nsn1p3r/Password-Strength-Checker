package edu.suresh.passwordstrengthchecker;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    /*
     * TODO: Check if the password is weak:
     *       - Length is less than 4
     *       - Does not contain a combination of capital and small letters, special characters, and numbers
     *
     * TODO: Check if the password is medium:
     *       - Length is between 4 and 6 (exclusive)
     *       - Contains both capital and small letters and numbers
     *       - Does not include special characters
     *
     * TODO: Check if the password is strong:
     *       - Length is more than 6
     *       - Contains a combination of capital and small letters, special characters, and numbers
     *
     * TODO: Implement regex checks:
     *       - To check if a word contains a capital letter: words.matches(".*[A-Z].*");
     *       - To check if a word contains a small letter: words.matches(".*[a-z].*");
     *       - To check if a word contains a number: words.matches(".*[0-9].*");
     *       - To check if a word contains a special character: words.matches(".*[!@#$%^&*()\\-+={}\\[\\]|;:'\",.<>/?].*");
     */

EditText userInput;
Button btn;
TextView resultView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        userInput = findViewById(R.id.editTextPassword);
        btn = findViewById(R.id.buttonCheckStrength);
        resultView = findViewById(R.id.textViewResult);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO

                String password = userInput.getText().toString();
                if (TextUtils.isEmpty(password)){
                    userInput.setError("empty user input");
                }
                if (password.length()>6 && password.matches(".*[A-Z].*")
                    && password.matches(".*[a-z].*")
                    && password.matches(".*[0-9].*")
                    && password.matches(".*[!@#$%^&*()\\-+={}\\[\\]|;:'\",.<>/?].*")
                )
                {
                    resultView.setText("Strong Password");
                    resultView.setTextColor(getResources().getColor(R.color.green));
                }
                else if (password.length()<6 && password.matches(".*[A-Z].*")
                    && password.matches(".*[a-z].*")
                        && password.matches(".*[0-9].*")
                        ){
                    resultView.setText("Medium Password");
                    resultView.setTextColor(getResources().getColor(R.color.yellow));
                }
                else {
                    resultView.setText("Weak Password");
                    resultView.setTextColor(getResources().getColor(R.color.red));
                }
            }
        });
    }
}
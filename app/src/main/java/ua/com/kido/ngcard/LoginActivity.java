package ua.com.kido.ngcard;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;


public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.emailEditText)
    EditText emailEditText;
    @BindView(R.id.layout_emailEditText)
    TextInputLayout emailTextInput;
    @BindView(R.id.remember)
    Button rememberButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        rememberButton.setOnClickListener(view -> {
            if (chekData()) {
                LayoutInflater layoutInflaterAndroid = LayoutInflater.from(this);
                View mView = layoutInflaterAndroid.inflate(R.layout.user_input_dialog_box, null);
                AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(this);
                alertDialogBuilderUserInput.setView(mView);

                final EditText userInputDialogEditText = (EditText) mView.findViewById(R.id.userInputDialog);
                alertDialogBuilderUserInput
                        .setCancelable(false)
                        .setPositiveButton("Подтвердить", (dialogBox, id) -> {
                            this.finish();
                        })

                        .setNegativeButton("Отменить",
                                (dialogBox, id) -> {
                                    dialogBox.cancel();
                                });

                AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();
                alertDialogAndroid.show();
            }
        });

    }

    private Boolean chekData() {
        Boolean chk = true;
        emailTextInput.setErrorEnabled(false);
        emailTextInput.setError(null);
        if (emailEditText.getText().toString().length() == 0) {
            chk = false;
            emailTextInput.setErrorEnabled(true);
            emailTextInput.setError("Это поле необходимое для заполнения");
        }

        return chk;
    }


}

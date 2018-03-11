package us.mifeng.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import us.mifeng.login.person.IUserPerson;
import us.mifeng.login.person.Personer;
import us.mifeng.login.view.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView,View.OnClickListener{

    private EditText edName;
    private EditText edPass;
    private Button login;
    private Button cancel;
    private ProgressBar progress;
    private IUserPerson person;

    /**
     * https://github.com/kaedea/Android-MVP-Pattern
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        person = new Personer(this);
        edName = (EditText) findViewById(R.id.userName);
        edPass = (EditText) findViewById(R.id.userPass);
        login = (Button) findViewById(R.id.login);
        cancel = (Button) findViewById(R.id.cancle);
        progress = (ProgressBar) findViewById(R.id.progressBar);
        login.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }

    @Override
    public void clear() {
        edName.setText("");
        edPass.setText("");
    }

    @Override
    public void setProgressVisible(int visible) {
        progress.setVisibility(visible);
    }

    @Override
    public void onLoginResult(boolean result, int code) {
        if (result&&code==0){
            Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"登录失败",Toast.LENGTH_SHORT).show();
        }
        person.progressVisible(View.INVISIBLE);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.login){
            person.doLogin(edName.getText().toString(),edPass.getText().toString());
            person.progressVisible(0);
        }else{
            person.clear();
        }
    }
}

package fsouza.studio.com.githubusermobilesearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import api.GitHubClientProfile;
import api.GitHubProfile;
import api.GitHubProfileAdapter;
import api.GitHubProfileItemsResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.studio.fsouza.githubusermobilesearch.MESSAGE";
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.tb_main);
        setSupportActionBar(myToolbar);

        listView = (ListView) findViewById(R.id.pagination_list);
        Gson gson = new GsonBuilder()
                        .create();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.github.com/")
                .build();

        GitHubClientProfile client = retrofit.create(GitHubClientProfile.class);
        Call<List<GitHubProfileItemsResponse>> call = client.users("souzace", "login");

        call.enqueue(new Callback<List<GitHubProfileItemsResponse>>() {
            @Override
            public void onResponse(Call<List<GitHubProfileItemsResponse>> call, Response<List<GitHubProfileItemsResponse>> response) {
                List<GitHubProfileItemsResponse> profiles = response.body();

                //JSONObject object = new JSONObject(profiles);
                listView.setAdapter(new GitHubProfileAdapter(MainActivity.this, profiles));
            }

            @Override
            public void onFailure(Call<List<GitHubProfileItemsResponse>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error: " + t, Toast.LENGTH_SHORT).show();
            }
        });


    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, UserProfileDetailsActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
        
    }
}

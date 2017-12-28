package fsouza.studio.com.githubusermobilesearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.SimpleArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import api.GitHubClientProfile;
import api.GitHubClientRepo;
import api.GitHubProfile;
import api.GitHubProfileAdapter;
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

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://api.github.com/search/")
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();

        GitHubClientProfile client = retrofit.create(GitHubClientProfile.class);
        Call<List<GitHubProfile>> call = client.users("q=souzace", "in=login");

        call.enqueue(new Callback<List<GitHubProfile>>() {
            @Override
            public void onResponse(Call<List<GitHubProfile>> call, Response<List<GitHubProfile>> response) {

                List<GitHubProfile> repos = response.body();

                listView.setAdapter(new GitHubProfileAdapter(MainActivity.this, repos));
            }

            @Override
            public void onFailure(Call<List<GitHubProfile>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error: ", Toast.LENGTH_SHORT).show();
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

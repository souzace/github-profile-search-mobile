package api;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import fsouza.studio.com.githubusermobilesearch.R;

/**
 * Created by fsouza on 27/12/17.
 */

public class GitHubProfileAdapter extends ArrayAdapter<GitHubProfile> {

    private Context context;
    private List<GitHubProfile> values;

    public GitHubProfileAdapter(Context context, List<GitHubProfile> values) {
        super(context, R.layout.list_item_pagination, values);

        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if (row == null){
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.list_item_pagination, parent, false);
        }

        TextView textView = (TextView) row.findViewById(R.id.list_item_pagination_text);

        GitHubProfile item = values.get(position);
        String message = item.getName();
        textView.setText(message);

        return row;
    }
}
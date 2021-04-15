package com.androiddev.blogger;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import java.util.ArrayList;

public class PostsAdapter  extends ArrayAdapter<Posts> {
        Context context;
        int resource;

    public PostsAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Posts> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        {
            String date = getItem(position).getDate();
            String mainTitle = getItem(position).getMainTitle();
            String  tags = getItem(position).getTags();
            String author = getItem(position).getAuthor();
            String MainText = getItem(position).getMainText();


            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.list_constructor,parent,false);


            TextView title = convertView.findViewById(R.id.MainTitle);
            TextView text = convertView.findViewById(R.id.MainText);
            CardView cardView = convertView.findViewById(R.id.cardView);

            title.setText(mainTitle);
            text.setText(MainText);


            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,DetailedView.class);
                    intent.putExtra("post",String.valueOf(position));
                    context.startActivity(intent);

                }
            });

            return convertView;
        }
    }
    private void notifyData(){
        notifyDataSetChanged();
    }
}

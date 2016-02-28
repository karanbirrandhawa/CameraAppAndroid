package com.karanandfriends.cameraapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.karanandfriends.cameraapp.R;
import com.karanandfriends.cameraapp.models.Group;

import java.util.Collections;
import java.util.List;

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.ViewHolder>{
    private List<Group> groups = Collections.emptyList();

    public GroupAdapter(List<Group> groups) {
        this.groups = groups;
    }


    // Create new views (invoked by the layout manager)
    @Override
    public GroupAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.group_item_view, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }


    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.groupName.setText(groups.get(position).getName());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return groups.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView groupName;
        public ViewHolder(View v) {
            super(v);
            groupName = (TextView) v.findViewById(R.id.groupName);
        }
    }
}

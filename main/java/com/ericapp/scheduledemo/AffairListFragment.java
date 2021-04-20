package com.ericapp.scheduledemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AffairListFragment extends Fragment {
    private RecyclerView mAffairRecyclerView;
    private AffairAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // layout file
        View view = inflater.inflate(R.layout.fragment_affair_list, container, false);
        // use resource from xml file
        mAffairRecyclerView = (RecyclerView) view.findViewById(R.id.crime_recycler_view);
        // Layout Manager
        mAffairRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    private void updateUI() {
        AffairLab affairLab = AffairLab.get(getActivity());
        List<Affair> affairs = affairLab.getAffairs();

        mAdapter = new AffairAdapter(affairs);
        mAffairRecyclerView.setAdapter(mAdapter);
    }

    private class AffairHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        // widgets
        private TextView mTitleTextView;
        private TextView mDateTextView;
        // item
        private Affair mAffair;

        public AffairHolder(LayoutInflater inflater, ViewGroup parent) {
            // list item layout
            super(inflater.inflate(R.layout.list_item_affair, parent, false));
            itemView.setOnClickListener(this);
            // resource
            mTitleTextView = (TextView) itemView.findViewById(R.id.crime_title);
            mDateTextView = (TextView) itemView.findViewById(R.id.crime_date);
        }

        public void bind(Affair affair) {
            mAffair = affair;
            mTitleTextView.setText(mAffair.getTitle());
            mDateTextView.setText(mAffair.getDeadline().toString());
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(getActivity(), mAffair.getTitle() + " clicked!", Toast.LENGTH_SHORT).show();
        }
    }

    private class AffairAdapter extends RecyclerView.Adapter<AffairHolder>{
        // data list prepared
        private List<Affair> mAffairs;

        public AffairAdapter(List<Affair> affairs) {
            mAffairs = affairs;
        }

        @NonNull
        @Override
        public AffairHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new AffairHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull AffairHolder holder, int position) {
            Affair affair = mAffairs.get(position);
            holder.bind(affair);
        }

        @Override
        public int getItemCount() {
            return mAffairs.size();
        }
    }
}

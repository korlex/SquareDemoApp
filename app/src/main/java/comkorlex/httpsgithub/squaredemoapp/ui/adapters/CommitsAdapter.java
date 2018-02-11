package comkorlex.httpsgithub.squaredemoapp.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import comkorlex.httpsgithub.squaredemoapp.R;
import comkorlex.httpsgithub.squaredemoapp.data.entities.commit.CommitResponse;

import static android.support.v7.widget.RecyclerView.NO_POSITION;


public class CommitsAdapter extends RecyclerView.Adapter<CommitsAdapter.CommitViewHolder> {

    private CommitsClickListener commitsClickListener;
    private List<CommitResponse> commits;

    public CommitsAdapter(CommitsClickListener commitsClickListener) {
        this.commitsClickListener = commitsClickListener;
        commits = new ArrayList<>();
    }

    public void setCommits(List<CommitResponse> commits) {
        this.commits = commits;
        notifyDataSetChanged();
    }

    @Override
    public CommitViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_commit, parent, false);
        final CommitViewHolder commitViewHolder = new CommitViewHolder(v);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = commitViewHolder.getAdapterPosition();
                if (pos != NO_POSITION) commitsClickListener.onCommitClick(commits.get(pos).getSha());
            }
        });
        return commitViewHolder;
    }

    @Override
    public void onBindViewHolder(CommitViewHolder holder, int position) {
        holder.commitAuthor.setText(commits.get(position).getCommit().getAuthor().getName());
        holder.commitDesc.setText(commits.get(position).getCommit().getMessage());
        holder.commitDate.setText(commits.get(position).getCommit().getAuthor().getDate());
    }

    @Override
    public int getItemCount() {
        return commits.size();
    }

    public class CommitViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.item_commit_author) TextView commitAuthor;
        @BindView(R.id.item_commit_desc) TextView commitDesc;
        @BindView(R.id.item_commit_date) TextView commitDate;

        public CommitViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}

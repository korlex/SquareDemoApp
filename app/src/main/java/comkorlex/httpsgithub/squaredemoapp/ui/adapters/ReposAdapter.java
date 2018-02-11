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
import comkorlex.httpsgithub.squaredemoapp.data.entities.repo.Repo;

import static android.support.v7.widget.RecyclerView.NO_POSITION;

public class ReposAdapter extends RecyclerView.Adapter<ReposAdapter.RepoViewHolder> {

    private ReposClickListener reposClickListener;
    private List<Repo> repos;

    public ReposAdapter(ReposClickListener reposClickListener) {
        repos = new ArrayList<>();
        this.reposClickListener = reposClickListener;
    }

    public void setRepos(List<Repo> repos) {
        this.repos.addAll(repos);
        notifyDataSetChanged();
    }


    @Override
    public RepoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_repo, parent, false);
        final RepoViewHolder repoViewHolder = new RepoViewHolder(v);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = repoViewHolder.getAdapterPosition();
                if (pos != NO_POSITION) reposClickListener.onRepoClick(repos.get(pos).getName());
            }
        });
        return repoViewHolder;
    }

    @Override
    public void onBindViewHolder(RepoViewHolder holder, int position) {
        holder.repoName.setText(repos.get(position).getName());
        holder.repoLanguage.setText(repos.get(position).getLanguage());
        holder.repoStars.setText(repos.get(position).getStargazersCount().toString());
        holder.repoUpdated.setText(repos.get(position).getUpdatedAt());
    }

    @Override
    public int getItemCount() {
        return repos.size();
    }

    public class RepoViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.item_repo_name) TextView repoName;
        @BindView(R.id.item_repo_language) TextView repoLanguage;
        @BindView(R.id.item_repo_stars) TextView repoStars;
        @BindView(R.id.item_repo_updated) TextView repoUpdated;

        public RepoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}

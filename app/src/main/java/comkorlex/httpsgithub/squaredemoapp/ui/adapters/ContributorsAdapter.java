package comkorlex.httpsgithub.squaredemoapp.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import comkorlex.httpsgithub.squaredemoapp.R;
import comkorlex.httpsgithub.squaredemoapp.data.entities.contributor.Contributor;

import static android.support.v7.widget.RecyclerView.NO_POSITION;

public class ContributorsAdapter extends RecyclerView.Adapter<ContributorsAdapter.ContributorViewHolder> {

    private Context context;
    private ContributorsClickListener contributorsClickListener;
    private List<Contributor> contributors;

    public ContributorsAdapter(Context context, ContributorsClickListener contributorsClickListener) {
        this.context = context;
        this.contributorsClickListener = contributorsClickListener;
        contributors = new ArrayList<>();
    }

    public void setContributors(List<Contributor> contributors) {
        this.contributors = contributors;
        notifyDataSetChanged();
    }

    @Override
    public ContributorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contributor, parent, false);
        final ContributorViewHolder contributorViewHolder = new ContributorViewHolder(v);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = contributorViewHolder.getAdapterPosition();
                if (pos != NO_POSITION) contributorsClickListener.onContributorClick(contributors.get(pos).getLogin());
            }
        });
        return contributorViewHolder;
    }

    @Override
    public void onBindViewHolder(ContributorViewHolder holder, int position) {
        Picasso.with(context).load(contributors.get(position).getAvatarUrl()).into(holder.contributorImg);
        holder.contributorName.setText(contributors.get(position).getLogin());
        holder.contributorCommits.append(contributors.get(position).getContributions().toString());
    }

    @Override
    public int getItemCount() {
        return contributors.size();
    }

    public class ContributorViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.item_contributor_img) ImageView contributorImg;
        @BindView(R.id.item_contributor_name) TextView contributorName;
        @BindView(R.id.item_contributor_commits) TextView contributorCommits;

        public ContributorViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}

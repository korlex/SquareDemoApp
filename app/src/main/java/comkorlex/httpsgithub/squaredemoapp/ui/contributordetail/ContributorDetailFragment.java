package comkorlex.httpsgithub.squaredemoapp.ui.contributordetail;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import comkorlex.httpsgithub.squaredemoapp.R;
import comkorlex.httpsgithub.squaredemoapp.data.entities.contributor.Contributor;
import comkorlex.httpsgithub.squaredemoapp.data.entities.user.User;
import comkorlex.httpsgithub.squaredemoapp.ui.common.BaseFragment;

public class ContributorDetailFragment extends BaseFragment implements ContributorDetailContract.View {

    @BindView(R.id.contributor_img) ImageView contributorImg;
    @BindView(R.id.contributor_name) TextView contributorName;
    @BindView(R.id.contributor_repos) TextView contributorRepos;
    @BindView(R.id.contributor_gists) TextView contributorGists;
    @BindView(R.id.contributor_followers) TextView contributorFollowers;
    @BindView(R.id.contributor_following) TextView contributorFollowing;
    @Inject ContributorDetailContract.Presenter presenter;
    private static final String CONTRIBUTOR_NAME = "contributor name";

    public static ContributorDetailFragment newInstance(String contributor){
        ContributorDetailFragment fragment = new ContributorDetailFragment();
        Bundle args = new Bundle();
        args.putString(CONTRIBUTOR_NAME, contributor);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contributor_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.setContributorDetails(getArguments().getString(CONTRIBUTOR_NAME));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void showContributorDetails(User user) {
        Picasso.with(getActivity()).load(user.getAvatarUrl()).into(contributorImg);
        contributorName.setText(user.getName());
        contributorRepos.append(user.getPublicRepos().toString());
        contributorGists.append(user.getPublicGists().toString());
        contributorFollowers.append(user.getFollowers().toString());
        contributorFollowing.append(user.getFollowing().toString());
    }

    @Override
    public void showErrorMsg(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
    }
}

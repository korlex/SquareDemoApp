package comkorlex.httpsgithub.squaredemoapp.ui.repodetail;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;
import butterknife.BindView;
import butterknife.OnClick;
import comkorlex.httpsgithub.squaredemoapp.R;
import comkorlex.httpsgithub.squaredemoapp.data.entities.repo.Repo;
import comkorlex.httpsgithub.squaredemoapp.ui.common.BaseFragment;
import comkorlex.httpsgithub.squaredemoapp.ui.common.NavigationController;


public class RepoDetailFragment extends BaseFragment implements RepoDetailContract.View {

    @Inject NavigationController navigationController;
    @Inject RepoDetailContract.Presenter presenter;
    @BindView(R.id.repo_detail_name) TextView repoName;
    @BindView(R.id.repo_detail_desc) TextView repoDesc;

    private static final String REPO_NAME = "repo name";

    public static RepoDetailFragment newInstance(String repoName) {
        RepoDetailFragment fragment = new RepoDetailFragment();
        Bundle args = new Bundle();
        args.putString(REPO_NAME, repoName);
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
        return inflater.inflate(R.layout.fragment_repo_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.setDetails(getArguments().getString(REPO_NAME));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void showDetails(Repo repo) {
        repoName.setText(repo.getName());
        repoDesc.setText(repo.getDescription());
    }

    @Override
    public void showErrorMsg(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.repo_detail_commits_btn)
    public void onCommitsBtnClick(){
        navigationController.navigateToCommits(getArguments().getString(REPO_NAME));
    }

    @OnClick(R.id.repo_detail_contributors_btn)
    public void onContributorsBtnClick(){
        navigationController.navigateToContributors(getArguments().getString(REPO_NAME));
    }

}

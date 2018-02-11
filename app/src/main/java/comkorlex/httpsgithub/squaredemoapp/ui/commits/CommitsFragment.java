package comkorlex.httpsgithub.squaredemoapp.ui.commits;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import comkorlex.httpsgithub.squaredemoapp.R;
import comkorlex.httpsgithub.squaredemoapp.data.entities.commit.CommitResponse;
import comkorlex.httpsgithub.squaredemoapp.ui.adapters.CommitsAdapter;
import comkorlex.httpsgithub.squaredemoapp.ui.adapters.CommitsClickListener;
import comkorlex.httpsgithub.squaredemoapp.ui.common.BaseFragment;
import comkorlex.httpsgithub.squaredemoapp.ui.common.NavigationController;

public class CommitsFragment extends BaseFragment implements CommitsContract.View, CommitsClickListener {

    @Inject CommitsContract.Presenter presenter;
    @Inject NavigationController navigationController;
    @BindView(R.id.commits_list) RecyclerView commitsList;
    private CommitsAdapter commitsAdapter;
    private static final String REPO_NAME = "repo name";

    public static CommitsFragment newInstance(String repoName){
        CommitsFragment fragment = new CommitsFragment();
        Bundle args = new Bundle();
        args.putString(REPO_NAME, repoName);
        fragment.setArguments(args);
        return fragment;
    }

    private void initList(){
        commitsAdapter = new CommitsAdapter(this);
        commitsList.setLayoutManager(new LinearLayoutManager(getActivity()));
        commitsList.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        commitsList.setAdapter(commitsAdapter);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_commits, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initList();
        presenter.setCommits(getArguments().getString(REPO_NAME));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void showCommits(List<CommitResponse> commits) {
        commitsAdapter.setCommits(commits);
    }

    @Override
    public void showErrorMsg(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCommitClick(String commitSha) {
        navigationController.navigateToCommitDetail(getArguments().getString(REPO_NAME), commitSha);
    }
}

package comkorlex.httpsgithub.squaredemoapp.ui.contributors;


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
import comkorlex.httpsgithub.squaredemoapp.data.entities.contributor.Contributor;
import comkorlex.httpsgithub.squaredemoapp.ui.adapters.ContributorsAdapter;
import comkorlex.httpsgithub.squaredemoapp.ui.adapters.ContributorsClickListener;
import comkorlex.httpsgithub.squaredemoapp.ui.adapters.ReposClickListener;
import comkorlex.httpsgithub.squaredemoapp.ui.common.BaseFragment;
import comkorlex.httpsgithub.squaredemoapp.ui.common.NavigationController;

public class ContributorsFragment extends BaseFragment implements ContributorsContract.View, ContributorsClickListener{

    @Inject ContributorsContract.Presenter presenter;
    @Inject NavigationController navigationController;
    @BindView(R.id.contributors_list) RecyclerView contributorsList;
    private ContributorsAdapter contributorsAdapter;


    private static final String REPO_NAME = "repo name";

    public static ContributorsFragment newInstance(String repoName){
        ContributorsFragment fragment = new ContributorsFragment();
        Bundle args = new Bundle();
        args.putString(REPO_NAME, repoName);
        fragment.setArguments(args);
        return fragment;
    }

    private void initList(){
        contributorsAdapter = new ContributorsAdapter(getActivity(), this);
        contributorsList.setLayoutManager(new LinearLayoutManager(getActivity()));
        contributorsList.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        contributorsList.setAdapter(contributorsAdapter);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contributors, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initList();
        presenter.setContributors(getArguments().getString(REPO_NAME));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void showContributors(List<Contributor> contributors) {
        contributorsAdapter.setContributors(contributors);
    }

    @Override
    public void showErrorMsg(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onContributorClick(String contributorName) {
        navigationController.navigateToContributorDetail(contributorName);
    }
}

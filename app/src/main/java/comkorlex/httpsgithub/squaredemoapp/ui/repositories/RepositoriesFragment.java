package comkorlex.httpsgithub.squaredemoapp.ui.repositories;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;
import javax.inject.Inject;
import butterknife.BindView;
import comkorlex.httpsgithub.squaredemoapp.R;
import comkorlex.httpsgithub.squaredemoapp.data.entities.repo.Repo;
import comkorlex.httpsgithub.squaredemoapp.ui.adapters.ReposClickListener;
import comkorlex.httpsgithub.squaredemoapp.ui.adapters.ReposAdapter;
import comkorlex.httpsgithub.squaredemoapp.ui.common.BaseFragment;
import comkorlex.httpsgithub.squaredemoapp.ui.common.NavigationController;

public class RepositoriesFragment extends BaseFragment implements RepositoriesContract.View, ReposClickListener {

    @Inject NavigationController navigationController;
    @Inject RepositoriesContract.Presenter presenter;
    @BindView(R.id.repos_list) RecyclerView reposList;
    private ReposAdapter reposAdapter;


    public static RepositoriesFragment newInstance(){
        return new RepositoriesFragment();
    }


    private void initList(){
        reposAdapter = new ReposAdapter(this);
        reposList.setLayoutManager(new LinearLayoutManager(getActivity()));
        reposList.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        reposList.setAdapter(reposAdapter);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_repositories, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initList();
        presenter.setRepos();
    }

    @Override
    public void showRepositories(List<Repo> repos) {
        reposAdapter.setRepos(repos);
    }

    @Override
    public void showErrorMsg(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRepoClick(String repo) {
        navigationController.navigateToRepoDetail(repo);
    }
}

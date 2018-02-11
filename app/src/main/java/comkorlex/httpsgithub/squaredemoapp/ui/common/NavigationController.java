package comkorlex.httpsgithub.squaredemoapp.ui.common;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import javax.inject.Inject;

import comkorlex.httpsgithub.squaredemoapp.R;
import comkorlex.httpsgithub.squaredemoapp.ui.MainActivity;
import comkorlex.httpsgithub.squaredemoapp.ui.commitdetail.CommitDetailFragment;
import comkorlex.httpsgithub.squaredemoapp.ui.commits.CommitsFragment;
import comkorlex.httpsgithub.squaredemoapp.ui.contributordetail.ContributorDetailFragment;
import comkorlex.httpsgithub.squaredemoapp.ui.contributors.ContributorsFragment;
import comkorlex.httpsgithub.squaredemoapp.ui.repodetail.RepoDetailFragment;
import comkorlex.httpsgithub.squaredemoapp.ui.repositories.RepositoriesFragment;

public class NavigationController {

    private final int containerId;
    private final FragmentManager fragmentManager;

    @Inject
    public NavigationController(MainActivity mainActivity) {
        this.containerId = R.id.main_frag_container;
        this.fragmentManager = mainActivity.getSupportFragmentManager();
    }


    public void navigateToRepositories(){
        RepositoriesFragment reposFragment = RepositoriesFragment.newInstance();
        addFragment(reposFragment, true);
    }

    public void navigateToRepoDetail(String repoName){
        RepoDetailFragment repoDetailFragment = RepoDetailFragment.newInstance(repoName);
        addFragment(repoDetailFragment, false);
    }

    public void navigateToCommits(String repoName){
        CommitsFragment commitsFragment = CommitsFragment.newInstance(repoName);
        addFragment(commitsFragment, false);
    }

    public void navigateToContributors(String repoName){
        ContributorsFragment contributorsFragment = ContributorsFragment.newInstance(repoName);
        addFragment(contributorsFragment, false);
    }

    public void navigateToCommitDetail(String repoName, String commitSha){
        CommitDetailFragment commitDetailFragment = CommitDetailFragment.newInstance(repoName, commitSha);
        addFragment(commitDetailFragment, false);
    }

    public void navigateToContributorDetail(String contributor){
        ContributorDetailFragment contributorDetailFragment = ContributorDetailFragment.newInstance(contributor);
        addFragment(contributorDetailFragment, false);
    }

    private void addFragment(Fragment frag, boolean isFirst){
        FragmentTransaction ft = fragmentManager.beginTransaction();
        if(!isFirst){
            ft.hide(fragmentManager.findFragmentById(R.id.main_frag_container));
            ft.addToBackStack(null);
        }
        ft.add(containerId, frag).commit();
    }




}

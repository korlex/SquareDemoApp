package comkorlex.httpsgithub.squaredemoapp.di;

import comkorlex.httpsgithub.squaredemoapp.di.scopes.FragmentScope;
import comkorlex.httpsgithub.squaredemoapp.ui.commitdetail.CommitDetailContract;
import comkorlex.httpsgithub.squaredemoapp.ui.commitdetail.CommitDetailPresenter;
import comkorlex.httpsgithub.squaredemoapp.ui.commits.CommitsContract;
import comkorlex.httpsgithub.squaredemoapp.ui.commits.CommitsPresenter;
import comkorlex.httpsgithub.squaredemoapp.ui.contributordetail.ContributorDetailContract;
import comkorlex.httpsgithub.squaredemoapp.ui.contributordetail.ContributorDetailPresenter;
import comkorlex.httpsgithub.squaredemoapp.ui.contributors.ContributorsContract;
import comkorlex.httpsgithub.squaredemoapp.ui.contributors.ContributorsPresenter;
import comkorlex.httpsgithub.squaredemoapp.ui.repodetail.RepoDetailContract;
import comkorlex.httpsgithub.squaredemoapp.ui.repodetail.RepoDetailPresenter;
import comkorlex.httpsgithub.squaredemoapp.ui.repositories.RepositoriesContract;
import comkorlex.httpsgithub.squaredemoapp.ui.repositories.RepositoriesPresenter;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class PresenterBuilderModule {

    @Binds
    @FragmentScope
    public abstract RepositoriesContract.Presenter provideReposPresenter(RepositoriesPresenter repositoriesPresenter);

    @Binds
    @FragmentScope
    public abstract RepoDetailContract.Presenter provideRepoDetailPresenter(RepoDetailPresenter repoDetailPresenter);

    @Binds
    @FragmentScope
    public abstract CommitsContract.Presenter provideCommitsPresenter(CommitsPresenter commitsPresenter);

    @Binds
    @FragmentScope
    public abstract ContributorsContract.Presenter provideContributorsPresenter(ContributorsPresenter contributorsPresenter);


    @Binds
    @FragmentScope
    public abstract CommitDetailContract.Presenter provideCommitDetailPresenter(CommitDetailPresenter commitDetailPresenter);

    @Binds
    @FragmentScope
    public abstract ContributorDetailContract.Presenter provideContributorDetailPresenter(ContributorDetailPresenter contributorDetailPresenter);



}

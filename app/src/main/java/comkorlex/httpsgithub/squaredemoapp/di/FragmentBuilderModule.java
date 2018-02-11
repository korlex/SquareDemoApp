package comkorlex.httpsgithub.squaredemoapp.di;

import comkorlex.httpsgithub.squaredemoapp.di.scopes.FragmentScope;
import comkorlex.httpsgithub.squaredemoapp.ui.commitdetail.CommitDetailFragment;
import comkorlex.httpsgithub.squaredemoapp.ui.commits.CommitsFragment;
import comkorlex.httpsgithub.squaredemoapp.ui.contributordetail.ContributorDetailFragment;
import comkorlex.httpsgithub.squaredemoapp.ui.contributors.ContributorsFragment;
import comkorlex.httpsgithub.squaredemoapp.ui.repodetail.RepoDetailFragment;
import comkorlex.httpsgithub.squaredemoapp.ui.repositories.RepositoriesFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuilderModule {

//    @Binds
//    @IntoMap
//    @FragmentKey(RepositoriesFragment.class)
//    abstract AndroidInjector.Factory<? extends Fragment> bindRepositoriesFragment(RepositoriesComponent.Builder builder);

    @ContributesAndroidInjector(modules = PresenterBuilderModule.class)
    @FragmentScope
    abstract RepositoriesFragment contributeRepositoriesFragment();

    @ContributesAndroidInjector(modules = PresenterBuilderModule.class)
    @FragmentScope
    abstract RepoDetailFragment contributeRepoDetailFragment();

    @ContributesAndroidInjector(modules = PresenterBuilderModule.class)
    @FragmentScope
    abstract CommitsFragment contributeCommitsFragment();

    @ContributesAndroidInjector(modules = PresenterBuilderModule.class)
    @FragmentScope
    abstract ContributorsFragment contributeContributorsFragment();

    @ContributesAndroidInjector(modules = PresenterBuilderModule.class)
    @FragmentScope
    abstract CommitDetailFragment contributeCommitDetailFragment();

    @ContributesAndroidInjector(modules = PresenterBuilderModule.class)
    @FragmentScope
    abstract ContributorDetailFragment contributeContributorDetailFragment();


}

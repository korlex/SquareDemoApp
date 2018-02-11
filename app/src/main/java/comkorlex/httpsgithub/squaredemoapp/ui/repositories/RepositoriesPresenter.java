package comkorlex.httpsgithub.squaredemoapp.ui.repositories;

import java.util.List;

import javax.inject.Inject;

import comkorlex.httpsgithub.squaredemoapp.data.entities.repo.Repo;
import comkorlex.httpsgithub.squaredemoapp.repository.Repository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class RepositoriesPresenter implements RepositoriesContract.Presenter {

    private RepositoriesContract.View repositoriesView;
    private Repository repository;

    @Inject
    public RepositoriesPresenter(RepositoriesFragment repoFragment, Repository repository) {
        repositoriesView = repoFragment;
        this.repository = repository;
    }

    @Override
    public void setRepos() {
        repository.fetchRepositories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Repo>>() {
                    @Override
                    public void accept(List<Repo> repos) throws Exception {
                        repositoriesView.showRepositories(repos);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        repositoriesView.showErrorMsg(throwable.getMessage());
                    }
                });
    }
}

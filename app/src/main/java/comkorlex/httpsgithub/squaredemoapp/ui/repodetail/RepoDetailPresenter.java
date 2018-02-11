package comkorlex.httpsgithub.squaredemoapp.ui.repodetail;

import javax.inject.Inject;

import comkorlex.httpsgithub.squaredemoapp.data.entities.repo.Repo;
import comkorlex.httpsgithub.squaredemoapp.repository.Repository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class RepoDetailPresenter implements RepoDetailContract.Presenter {

    private RepoDetailContract.View repoDetailView;
    private Repository repository;

    @Inject
    public RepoDetailPresenter(RepoDetailFragment repoDetailFragment, Repository repository) {
        this.repoDetailView = repoDetailFragment;
        this.repository = repository;
    }

    @Override
    public void setDetails(String repoName) {
        repository.fetchRepoDetail(repoName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Repo>() {
                    @Override
                    public void accept(Repo repo) throws Exception {
                        repoDetailView.showDetails(repo);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        repoDetailView.showErrorMsg(throwable.getMessage());
                    }
                });
    }
}

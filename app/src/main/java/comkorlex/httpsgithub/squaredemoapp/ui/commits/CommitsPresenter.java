package comkorlex.httpsgithub.squaredemoapp.ui.commits;

import java.util.List;

import javax.inject.Inject;

import comkorlex.httpsgithub.squaredemoapp.data.entities.commit.CommitResponse;
import comkorlex.httpsgithub.squaredemoapp.repository.Repository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class CommitsPresenter implements CommitsContract.Presenter {

    private CommitsContract.View commitsView;
    private Repository repository;

    @Inject
    public CommitsPresenter(CommitsFragment commitsFragment, Repository repository) {
        commitsView = commitsFragment;
        this.repository = repository;
    }

    @Override
    public void setCommits(String repoName) {
        repository.fetchCommits(repoName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<CommitResponse>>() {
                    @Override
                    public void accept(List<CommitResponse> commitRespons) throws Exception {
                        commitsView.showCommits(commitRespons);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        commitsView.showErrorMsg(throwable.getMessage());
                    }
                });
    }

}

package comkorlex.httpsgithub.squaredemoapp.ui.commitdetail;

import javax.inject.Inject;

import comkorlex.httpsgithub.squaredemoapp.data.entities.commit.CommitResponse;
import comkorlex.httpsgithub.squaredemoapp.repository.Repository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class CommitDetailPresenter implements CommitDetailContract.Presenter {

    private CommitDetailContract.View commitDetailView;
    private Repository repository;

    @Inject
    public CommitDetailPresenter(CommitDetailFragment commitDetailFragment, Repository repository) {
        commitDetailView = commitDetailFragment;
        this.repository = repository;
    }


    @Override
    public void setCommitDetails(String repoName, String commitSha) {
        repository.fetchCommitDetail(repoName, commitSha)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CommitResponse>() {
                    @Override
                    public void accept(CommitResponse commitResponse) throws Exception {
                        commitDetailView.showCommitDetails(commitResponse);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        commitDetailView.showErrorMsg(throwable.getMessage());
                    }
                });
    }
}

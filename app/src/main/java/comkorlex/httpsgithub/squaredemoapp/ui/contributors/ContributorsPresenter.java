package comkorlex.httpsgithub.squaredemoapp.ui.contributors;

import java.util.List;

import javax.inject.Inject;

import comkorlex.httpsgithub.squaredemoapp.data.entities.contributor.Contributor;
import comkorlex.httpsgithub.squaredemoapp.repository.Repository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ContributorsPresenter implements ContributorsContract.Presenter {

    private ContributorsContract.View contributorsView;
    private Repository repository;


    @Inject
    public ContributorsPresenter(ContributorsFragment contributorsFragment, Repository repository) {
        this.contributorsView = contributorsFragment;
        this.repository = repository;
    }

    @Override
    public void setContributors(String repoName) {
        repository.fetchContributors(repoName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Contributor>>() {
                    @Override
                    public void accept(List<Contributor> contributors) throws Exception {
                        contributorsView.showContributors(contributors);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        contributorsView.showErrorMsg(throwable.getMessage());
                    }
                });
    }
}

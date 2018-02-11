package comkorlex.httpsgithub.squaredemoapp.ui.contributordetail;

import javax.inject.Inject;

import comkorlex.httpsgithub.squaredemoapp.data.entities.contributor.Contributor;
import comkorlex.httpsgithub.squaredemoapp.data.entities.user.User;
import comkorlex.httpsgithub.squaredemoapp.repository.Repository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ContributorDetailPresenter implements ContributorDetailContract.Presenter {

    private ContributorDetailContract.View contributorView;
    private Repository repository;

    @Inject
    public ContributorDetailPresenter(ContributorDetailFragment contributorDetailFragment, Repository repository) {
        contributorView = contributorDetailFragment;
        this.repository = repository;
    }

    @Override
    public void setContributorDetails(final String contriutorName) {
        repository.fetchContributorDetail(contriutorName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<User>() {
                    @Override
                    public void accept(User user) throws Exception {
                        contributorView.showContributorDetails(user);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        contributorView.showErrorMsg(throwable.getMessage());
                    }
                });
    }
}

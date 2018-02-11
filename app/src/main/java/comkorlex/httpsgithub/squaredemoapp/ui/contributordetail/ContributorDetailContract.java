package comkorlex.httpsgithub.squaredemoapp.ui.contributordetail;

import comkorlex.httpsgithub.squaredemoapp.data.entities.contributor.Contributor;
import comkorlex.httpsgithub.squaredemoapp.data.entities.user.User;

public interface ContributorDetailContract {

    public interface View{
        void showContributorDetails(User user);
        void showErrorMsg(String msg);

    }

    public interface Presenter{
        void setContributorDetails(String contriutorName);
    }

}

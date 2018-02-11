package comkorlex.httpsgithub.squaredemoapp.ui.contributors;

import java.util.List;

import comkorlex.httpsgithub.squaredemoapp.data.entities.contributor.Contributor;

public interface ContributorsContract {

    public interface View{
        void showContributors(List<Contributor> contributors);
        void showErrorMsg(String msg);

    }

    public interface Presenter{
        void setContributors(String repoName);
    }

}

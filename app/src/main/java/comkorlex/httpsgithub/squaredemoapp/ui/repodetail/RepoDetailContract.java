package comkorlex.httpsgithub.squaredemoapp.ui.repodetail;

import comkorlex.httpsgithub.squaredemoapp.data.entities.repo.Repo;

public interface RepoDetailContract {

    public interface View{
        void showDetails(Repo repo);
        void showErrorMsg(String msg);

    }

    public interface Presenter{
        void setDetails(String repoName);
    }

}

package comkorlex.httpsgithub.squaredemoapp.ui.repositories;

import java.util.List;

import comkorlex.httpsgithub.squaredemoapp.data.entities.repo.Repo;

public interface RepositoriesContract {

    public interface View{
        void showRepositories(List<Repo> repos);
        void showErrorMsg(String msg);
    }

    public interface Presenter{
        void setRepos();
    }

}

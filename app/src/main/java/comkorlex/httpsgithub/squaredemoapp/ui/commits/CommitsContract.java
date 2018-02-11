package comkorlex.httpsgithub.squaredemoapp.ui.commits;

import java.util.List;

import comkorlex.httpsgithub.squaredemoapp.data.entities.commit.CommitResponse;

public interface CommitsContract {

    public interface View{
        void showCommits(List<CommitResponse> commits);
        void showErrorMsg(String msg);

    }

    public interface Presenter{
        void setCommits(String repoName);
    }

}

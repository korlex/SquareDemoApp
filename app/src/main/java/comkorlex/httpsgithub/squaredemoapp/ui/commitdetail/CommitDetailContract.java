package comkorlex.httpsgithub.squaredemoapp.ui.commitdetail;

import comkorlex.httpsgithub.squaredemoapp.data.entities.commit.CommitResponse;

public interface CommitDetailContract {

    public interface View{
        void showCommitDetails(CommitResponse commitResponse);
        void showErrorMsg(String msg);
    }

    public interface Presenter{
        void setCommitDetails(String repoName, String commitSha);
    }

}

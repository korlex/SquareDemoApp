package comkorlex.httpsgithub.squaredemoapp.repository;

import java.util.List;

import comkorlex.httpsgithub.squaredemoapp.data.entities.commit.CommitResponse;
import comkorlex.httpsgithub.squaredemoapp.data.entities.contributor.Contributor;
import comkorlex.httpsgithub.squaredemoapp.data.entities.repo.Repo;
import comkorlex.httpsgithub.squaredemoapp.data.entities.user.User;
import io.reactivex.Flowable;

public interface Repository {
    Flowable<List<Repo>> fetchRepositories();
    Flowable<Repo> fetchRepoDetail(String repoName);
    Flowable<List<CommitResponse>> fetchCommits(String repoName);
    Flowable<List<Contributor>> fetchContributors(String repoName);
    Flowable<CommitResponse> fetchCommitDetail(String repoName, String commitSha);
    Flowable<User> fetchContributorDetail(String contributor);

}

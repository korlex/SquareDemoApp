package comkorlex.httpsgithub.squaredemoapp.repository;

import java.util.List;

import comkorlex.httpsgithub.squaredemoapp.data.entities.commit.CommitResponse;
import comkorlex.httpsgithub.squaredemoapp.data.entities.contributor.Contributor;
import comkorlex.httpsgithub.squaredemoapp.data.entities.repo.Repo;
import comkorlex.httpsgithub.squaredemoapp.data.entities.user.User;
import comkorlex.httpsgithub.squaredemoapp.data.retrofit.GithubService;
import io.reactivex.Flowable;

public class RemoteRepository implements Repository {

    private GithubService githubService;

    public RemoteRepository(GithubService githubService) {
        this.githubService = githubService;
    }

    @Override
    public Flowable<List<Repo>> fetchRepositories() {
        return githubService.loadRepositories();
    }

    @Override
    public Flowable<Repo> fetchRepoDetail(String repoName) {
        return githubService.loadRepo(repoName);
    }

    @Override
    public Flowable<List<CommitResponse>> fetchCommits(String repoName) {
        return githubService.loadCommits(repoName);
    }

    @Override
    public Flowable<List<Contributor>> fetchContributors(String repoName) {
        return githubService.loadContributors(repoName);
    }

    @Override
    public Flowable<CommitResponse> fetchCommitDetail(String repoName, String commitSha) {
        return githubService.loadCommit(repoName, commitSha);
    }

    @Override
    public Flowable<User> fetchContributorDetail(String contributor) {
        return githubService.loadContributor(contributor);
    }
}

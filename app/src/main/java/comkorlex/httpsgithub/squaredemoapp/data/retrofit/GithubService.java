package comkorlex.httpsgithub.squaredemoapp.data.retrofit;

import java.util.List;

import comkorlex.httpsgithub.squaredemoapp.data.entities.commit.CommitResponse;
import comkorlex.httpsgithub.squaredemoapp.data.entities.contributor.Contributor;
import comkorlex.httpsgithub.squaredemoapp.data.entities.repo.Repo;
import comkorlex.httpsgithub.squaredemoapp.data.entities.user.User;
import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubService {

    static final String API_URL = "https://api.github.com/";

    @GET("/users/square/repos?sort=updated")
    Flowable<List<Repo>> loadRepositories();

    @GET("/repos/square/{repoName}")
    Flowable<Repo> loadRepo(@Path("repoName") String repoName);

    @GET("/repos/square/{repoName}/commits")
    Flowable<List<CommitResponse>> loadCommits(@Path("repoName") String repoName);

    @GET("/repos/square/{repoName}/contributors")
    Flowable<List<Contributor>> loadContributors(@Path("repoName") String repoName);

    @GET("/repos/square/{repoName}/commits/{commitSha}")
    Flowable<CommitResponse> loadCommit(@Path("repoName") String repoName,
                                        @Path("commitSha") String commitSha);

    @GET("/users/{user}")
    Flowable<User> loadContributor(@Path("user") String user);


}

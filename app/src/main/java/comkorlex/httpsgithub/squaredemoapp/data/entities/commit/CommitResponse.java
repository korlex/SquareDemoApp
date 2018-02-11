
package comkorlex.httpsgithub.squaredemoapp.data.entities.commit;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import comkorlex.httpsgithub.squaredemoapp.data.entities.Commit;
import comkorlex.httpsgithub.squaredemoapp.data.entities.DetailAuthor;
import comkorlex.httpsgithub.squaredemoapp.data.entities.DetailCommitter;

public class CommitResponse {

    @SerializedName("sha")
    @Expose
    private String sha;
    @SerializedName("commit")
    @Expose
    private Commit commit;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("html_url")
    @Expose
    private String htmlUrl;
    @SerializedName("comments_url")
    @Expose
    private String commentsUrl;
    @SerializedName("author")
    @Expose
    private DetailAuthor author;
    @SerializedName("committer")
    @Expose
    private DetailCommitter committer;
    @SerializedName("parents")
    @Expose
    private List<Object> parents = null;

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    public Commit getCommit() {
        return commit;
    }

    public void setCommit(Commit commit) {
        this.commit = commit;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public String getCommentsUrl() {
        return commentsUrl;
    }

    public void setCommentsUrl(String commentsUrl) {
        this.commentsUrl = commentsUrl;
    }

    public DetailAuthor getAuthor() {
        return author;
    }

    public void setAuthor(DetailAuthor author) {
        this.author = author;
    }

    public DetailCommitter getCommitter() {
        return committer;
    }

    public void setCommitter(DetailCommitter committer) {
        this.committer = committer;
    }

    public List<Object> getParents() {
        return parents;
    }

    public void setParents(List<Object> parents) {
        this.parents = parents;
    }

}

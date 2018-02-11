package comkorlex.httpsgithub.squaredemoapp.ui.commitdetail;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import comkorlex.httpsgithub.squaredemoapp.R;
import comkorlex.httpsgithub.squaredemoapp.data.entities.commit.CommitResponse;
import comkorlex.httpsgithub.squaredemoapp.ui.common.BaseFragment;
import comkorlex.httpsgithub.squaredemoapp.ui.common.NavigationController;

public class CommitDetailFragment extends BaseFragment implements CommitDetailContract.View {

    @BindView(R.id.commit_author) TextView commitAuthor;
    @BindView(R.id.commit_desc) TextView commitDesc;
    @Inject CommitDetailContract.Presenter presenter;
    private static final String REPO_NAME = "repo name";
    private static final String COMMIT_SHA = "commit sha";

    public static CommitDetailFragment newInstance(String repoName, String commitSha){
        CommitDetailFragment fragment = new CommitDetailFragment();
        Bundle args = new Bundle();
        args.putString(REPO_NAME, repoName);
        args.putString(COMMIT_SHA, commitSha);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_commit_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.setCommitDetails(getArguments().getString(REPO_NAME),
                                   getArguments().getString(COMMIT_SHA));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void showCommitDetails(CommitResponse commitResponse) {
        commitAuthor.setText(commitResponse.getCommit().getAuthor().getName());
        commitDesc.setText(commitResponse.getCommit().getMessage());
    }

    @Override
    public void showErrorMsg(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
    }
}

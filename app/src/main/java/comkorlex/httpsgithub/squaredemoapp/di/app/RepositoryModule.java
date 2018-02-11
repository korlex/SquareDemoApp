package comkorlex.httpsgithub.squaredemoapp.di.app;

import javax.inject.Singleton;

import comkorlex.httpsgithub.squaredemoapp.data.retrofit.GithubService;
import comkorlex.httpsgithub.squaredemoapp.repository.RemoteRepository;
import comkorlex.httpsgithub.squaredemoapp.repository.Repository;
import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    public Repository provideRepository(GithubService githubService){
        return new RemoteRepository(githubService);
    }

}

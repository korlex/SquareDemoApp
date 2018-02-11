package comkorlex.httpsgithub.squaredemoapp.di.app;

import javax.inject.Singleton;

import comkorlex.httpsgithub.squaredemoapp.data.retrofit.GithubService;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import static comkorlex.httpsgithub.squaredemoapp.data.retrofit.GithubService.API_URL;

@Module
public class RemoteModule {

    @Provides
    @Singleton
    public GithubService provideGithubService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(GithubService.class);
    }

}

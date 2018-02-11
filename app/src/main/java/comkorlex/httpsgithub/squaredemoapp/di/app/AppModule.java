package comkorlex.httpsgithub.squaredemoapp.di.app;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    @Singleton
    public Context provideContext(Application application){
        return application;
    }

}

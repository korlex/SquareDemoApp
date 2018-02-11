package comkorlex.httpsgithub.squaredemoapp.di.app;

import android.app.Application;

import javax.inject.Singleton;

import comkorlex.httpsgithub.squaredemoapp.App;
import comkorlex.httpsgithub.squaredemoapp.di.MainActivityBuilderModule;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Component(modules = {
        AppModule.class,
        RemoteModule.class,
        RepositoryModule.class,
        MainActivityBuilderModule.class,
        AndroidInjectionModule.class})
@Singleton
public interface AppComponent {

    @Component.Builder
    interface Builder{
        @BindsInstance
        Builder application (Application application);
        AppComponent build();
    }

    void inject(App app);

}

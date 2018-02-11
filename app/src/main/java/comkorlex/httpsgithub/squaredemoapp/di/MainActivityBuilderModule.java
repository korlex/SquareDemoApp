package comkorlex.httpsgithub.squaredemoapp.di;

import comkorlex.httpsgithub.squaredemoapp.di.scopes.ActivityScope;
import comkorlex.httpsgithub.squaredemoapp.ui.MainActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainActivityBuilderModule {

    @ContributesAndroidInjector(modules = FragmentBuilderModule.class)
    @ActivityScope
    abstract MainActivity contributeMainActivity();
}

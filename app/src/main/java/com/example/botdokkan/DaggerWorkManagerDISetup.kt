/*
package com.example.botdokkan

import androidx.work.ListenableWorker
import dagger.Binds
import dagger.Component
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@MapKey
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class WorkerKey(val value: KClass<out ListenableWorker>)

@Module
interface WorkerBindingModule {
    @Binds
    @IntoMap
    @WorkerKey(ImageCaptureWorker::class)
    fun bindHelloWorldWorker(factory: ImageCaptureWorker.Factory): ChildWorkerFactory
}


@Module(includes = [AssistedInject_SampleAssistedInjectModule::class])
@AssistedModule
interface SampleAssistedInjectModule

@Component(
    modules = [
        SampleAssistedInjectModule::class,
        WorkerBindingModule::class
    ]
)
interface SampleComponent {
    // other method
}*/

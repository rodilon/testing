package com.rodilon.unittesting.di;

import android.app.Application;

import androidx.room.Room;

import com.rodilon.unittesting.persistence.NoteDao;
import com.rodilon.unittesting.persistence.NoteDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static com.rodilon.unittesting.persistence.NoteDatabase.DATABASE_NAME;

@Module
class AppModule {

    @Singleton
    @Provides
    static NoteDatabase provideNoteDatabase(Application application) {
        return Room.databaseBuilder(
                application,
                NoteDatabase.class,
                DATABASE_NAME
        ).build();
    }

    @Singleton
    @Provides
    static NoteDao provideNoteDao(NoteDatabase noteDatabase) {
        return noteDatabase.getNoteDao();
    }
}

package me.chandler.java8._stream;

import java.time.Duration;

public class Progress {

    private Duration studyDuration; // 얼마나 수업을 오래 했는지

    private boolean finished;

    public Duration getStudyDuration() {
        return studyDuration;
    }

    public void setStudyDuration(Duration studyDuration) {
        this.studyDuration = studyDuration;
    }
}

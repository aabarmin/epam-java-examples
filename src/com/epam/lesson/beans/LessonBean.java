package com.epam.lesson.beans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

public class LessonBean {
    private String title;
    private Date lessonDate;
    private boolean passed;
    private final Collection<String> parts = new ArrayList<>();

    protected LessonBean() {
    }

    public Collection<String> getParts() {
        // return new ArrayList<>(parts);
        return Collections.unmodifiableCollection(parts);
    }

    public void addPart(String part) {
        parts.add(part);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getLessonDate() {
        return new Date(lessonDate.getTime());
    }

    public void setLessonDate(Date lessonDate) {
        this.lessonDate = new Date(lessonDate.getTime());
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public static Builder builder() {
        return new LessonBean().new Builder();
    }

    public class Builder {
        public Builder setTitle(String title) {
            LessonBean.this.setTitle(title);
            return this;
        }

        public Builder passed() {
            LessonBean.this.setPassed(true);
            return this;
        }

        public LessonBean build() {
            return LessonBean.this;
        }
    }
}

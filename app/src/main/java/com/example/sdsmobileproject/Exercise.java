package com.example.sdsmobileproject;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Exercise implements Parcelable {
    String name;
    Integer sets;
    String reps;
    String weight;

    public Exercise(String name, Integer sets, String reps, String weight) {
        this.name = name;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
    }

    protected Exercise(@NonNull Parcel in) {
        name = in.readString();
        if (in.readByte() == 0) {
            sets = null;
        } else {
            sets = in.readInt();
        }
        reps = in.readString();
        weight = in.readString();
    }

    public static final Creator<Exercise> CREATOR = new Creator<Exercise>() {
        @Override
        public Exercise createFromParcel(Parcel in) {
            return new Exercise(in);
        }

        @Override
        public Exercise[] newArray(int size) {
            return new Exercise[size];
        }
    };

    public String getName() { return name; }
    public Integer getSets() { return sets; }
    public String getReps() { return reps; }
    public String getWeight() { return weight; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(name);
        if (sets == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(sets);
        }
        dest.writeString(reps);
        dest.writeString(weight);
    }
}

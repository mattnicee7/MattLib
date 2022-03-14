package com.github.mattnicee7.time;

import com.github.mattnicee7.singlemap.Pair;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TimeFormat {

    private long timeInSecond;
    private String singular;
    private String plural;

    public static TimeFormat of(long time, @NotNull String singular, @NotNull String plural) {
        return new TimeFormat(time, singular, plural);
    }

    public void setSingularAndPlural(Pair<String, String> singularAndPlural) {
        this.singular = singularAndPlural.getFirst();
        this.plural = singularAndPlural.getSecond();
    }

}

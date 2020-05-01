package com.github.timeline.util;

import com.github.timeline.entity.Commit;
import com.github.timeline.entity.Repository;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Service
public class SorterServiceImplement implements SorterService {
    @Override
    public List<Repository> sortRepos(List<Repository> repositories) {

        Comparator<Repository> comparator = (r1, r2) -> {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = null;
            Date date2 = null;
            try {
                date1 = dateFormat.parse(r1.getCreatedAt());
                date2 = dateFormat.parse(r2.getCreatedAt());
            } catch (ParseException e) {}
            return date1.compareTo(date2);
        };

        repositories.sort(comparator);
        Collections.reverse(repositories);
        return repositories;
    }

    @Override
    public List<Commit> sortCommits(List<Commit> commits) {
        return null;
    }
}

package com.github.timeline.util;

import com.github.timeline.entity.Commit;
import com.github.timeline.entity.Repository;

import java.util.List;

public interface SorterService {
    List<Repository> sortRepos(List<Repository> repositories);
    List<Commit> sortCommits(List<Commit> commits);
}

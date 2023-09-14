package loanSystem.repository;

import loanSystem.base.repository.BaseRepository;
import loanSystem.entity.NoPardakhtShodeGhest;
import loanSystem.entity.Student;

public interface NoPardakhtShodeGhestRepository extends BaseRepository<NoPardakhtShodeGhest,Long> {
    NoPardakhtShodeGhest getAndDeleteFirstNoPardakhtShodeGhest();
    void deleteGhestByNumber(int number);
}

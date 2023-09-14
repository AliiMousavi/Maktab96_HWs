package loanSystem.service;

import loanSystem.base.service.BaseService;
import loanSystem.entity.NoPardakhtShodeGhest;
import loanSystem.entity.Student;

public interface NoPardakhtShodeGhestService extends BaseService<NoPardakhtShodeGhest,Long> {
    public NoPardakhtShodeGhest getAndDeleteFirstNoPardakhtShodeGhest();
    void deleteGhestByNumber(int number);
}

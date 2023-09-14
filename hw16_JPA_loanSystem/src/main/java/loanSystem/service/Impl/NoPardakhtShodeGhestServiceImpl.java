package loanSystem.service.Impl;

import loanSystem.base.service.BaseServiceImpl;
import loanSystem.entity.NoPardakhtShodeGhest;
import loanSystem.repository.NoPardakhtShodeGhestRepository;
import loanSystem.service.NoPardakhtShodeGhestService;

public class NoPardakhtShodeGhestServiceImpl extends BaseServiceImpl<NoPardakhtShodeGhest,Long, NoPardakhtShodeGhestRepository> implements NoPardakhtShodeGhestService {
    public NoPardakhtShodeGhestServiceImpl(NoPardakhtShodeGhestRepository repository) {
        super(repository);
    }

    @Override
    public NoPardakhtShodeGhest getAndDeleteFirstNoPardakhtShodeGhest() {
        beginTransaction();
        NoPardakhtShodeGhest firstGhest = repository.getAndDeleteFirstNoPardakhtShodeGhest();
        if(firstGhest != null)
            repository.deleteGhestByNumber(firstGhest.getNumber());

        return firstGhest;
    }

    @Override
    public void deleteGhestByNumber(int number) {
        beginTransaction();
        try {
            repository.deleteGhestByNumber(number);
            commitTransaction();
        }catch (Exception e){
            rollBack();
        }
    }
}

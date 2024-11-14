package ma.youcode.wrm.services.implementations;

import ma.youcode.wrm.common.GenericService;
import ma.youcode.wrm.entities.Visitor;
import ma.youcode.wrm.services.interfaces.VisitorService;
import org.springframework.stereotype.Service;

@Service
public class VisitorServiceImpl extends GenericService<Visitor> implements VisitorService {

    public VisitorServiceImpl() {
        super(Visitor.class);
    }

}

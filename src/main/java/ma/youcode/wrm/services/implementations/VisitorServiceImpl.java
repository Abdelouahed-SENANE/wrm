package ma.youcode.wrm.services.implementations;

import ma.youcode.wrm.common.GenericServiceImpl;
import ma.youcode.wrm.entities.Visitor;
import ma.youcode.wrm.services.interfaces.VisitorService;
import org.springframework.stereotype.Service;

@Service
public class VisitorServiceImpl extends GenericServiceImpl<Visitor> implements VisitorService {

    public VisitorServiceImpl() {
        super(Visitor.class);
    }

}

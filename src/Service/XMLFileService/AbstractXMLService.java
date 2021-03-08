package Service.XMLFileService;

import Domain.*;
import Exceptions.ValidatorException;
import Repository.XMLFileRepository.AbstractXMLRepo;

public abstract class AbstractXMLService<ID, E extends HasId<ID>> {
    private final AbstractXMLRepo xmlrepo;

    public AbstractXMLService(AbstractXMLRepo xmlrepo) {
        this.xmlrepo = xmlrepo;
    }

    protected abstract E extractEntity(String[] params);

    public void add(String[] params) throws ValidatorException {
        E e = extractEntity(params);
        xmlrepo.save(e);
    }

    public void remove(ID id) {
        xmlrepo.delete(id);
    }

    public void update(String[] params) {
        E s = extractEntity(params);
        xmlrepo.update(s);
    }

    public E findOne(ID id) {
        return (E) xmlrepo.findOne(id);
    }

    public Iterable<E> findAll() {
        return xmlrepo.findAll();
    }

    public int getSize() {
        return xmlrepo.getSize();
    }
}
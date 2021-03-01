package com.adomas.repository;

import com.adomas.domain.Contact;
import com.adomas.service.list.AbstractListService;

import java.util.List;

public class ContactRepoListImpl extends AbstractListService<Contact> implements ContactRepository {



    @Override
    public List<Contact> findAll() {
        return super.findAll();
    }

    @Override
    public Contact save(Contact object) {
        return super.save(object);
    }

    @Override
    public void delete(Contact object) {
        super.delete(object);
    }


}

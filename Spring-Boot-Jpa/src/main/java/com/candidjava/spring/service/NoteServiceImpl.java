/**
 * 
 */
package com.candidjava.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.candidjava.spring.bean.Note;
import com.candidjava.spring.repository.NotesRepository;

/**
 * @author Admin
 *
 */

@Service
@Transactional
public class NoteServiceImpl implements NoteService {
	
	@Autowired
	NotesRepository noterepo;

	/* (non-Javadoc)
	 * @see com.candidjava.spring.service.NoteService#createNote(com.candidjava.spring.bean.Note)
	 */
	@Override
	public Note createNote(Note n1) {
		// TODO Auto-generated method stub
        return noterepo.save(n1);
       
	}
	

	/* (non-Javadoc)
	 * @see com.candidjava.spring.service.NoteService#findById(long)
	 */
	@Override
	public Note findById(long id) {
		// TODO Auto-generated method stub
		return noterepo.findOne(id);
	}

	/* (non-Javadoc)
	 * @see com.candidjava.spring.service.NoteService#deleteNote(long)
	 */
	@Override
	public void deleteNote(long id) {
		// TODO Auto-generated method stub
       noterepo.delete(id);

	}

	/* (non-Javadoc)
	 * @see com.candidjava.spring.service.NoteService#updateNote(com.candidjava.spring.bean.Note, long)
	 */
	@Override
	public Note updateNote(Note n1, long l1) {
		// TODO Auto-generated method stub
		//return false;
		 Note ns = noterepo.findOne(l1);
		 ns.setDescription(n1.getDescription());
		 ns.setHeading(n1.getDescription());
		// ns.setHeading(n1.getHeading());
		 return noterepo.save(ns);
		
		 
		 
	}

	/* (non-Javadoc)
	 * @see com.candidjava.spring.service.NoteService#getNotes()
	 */
	@Override
	public List<Note> getNotes() {
		// TODO Auto-generated method stub
		return (List<Note>) noterepo.findAll();
	}

	

}

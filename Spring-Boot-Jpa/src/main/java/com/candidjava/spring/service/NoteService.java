/**
 * 
 */
package com.candidjava.spring.service;

import java.util.List;

import com.candidjava.spring.bean.Note;

/**
 * @author Admin
 *
 */
public interface NoteService {
	
	public Note createNote(Note n1);
	public void deleteNote(long id);
	public Note updateNote(Note n1 , long l1);
	public List<Note> getNotes();
	public Note findById(long id);

}

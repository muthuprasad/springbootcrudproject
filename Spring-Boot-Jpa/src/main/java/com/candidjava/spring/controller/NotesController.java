/**
 * 
 */
package com.candidjava.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.candidjava.spring.bean.Note;
import com.candidjava.spring.exception.ResourceNotFoundException;
import com.candidjava.spring.service.NoteService;

/**
 * @author Admin
 *
 */
@RestController
@RequestMapping(value= {"/notereq"})
public class NotesController {
	@Autowired
	NoteService  noteser;
	
	 @PostMapping("/notes") 
	 public Note createNote(@Valid @RequestBody Note note ) {
		 if(null == note) {throw  new ResourceNotFoundException("Note", "id",null);};
	        return noteser.createNote(note);
	    }
	 
	 @PostMapping("/notes/{id}") 
	 public Note updateNote(@PathVariable(value="id") Long id, @Valid @RequestBody Note note ) {
		 if(null == note || null == id) {throw  new ResourceNotFoundException("Note", "id",id);};
		// Note notupd = noteser.findById(id);
		// notupd.setDescription(note.getDescription());
		 //notupd.setHeading(note.getDescription());
		 
	        return noteser.updateNote(note,id);
	    }
	 @DeleteMapping("/notes/{id}") 
	 public ResponseEntity<?> deleteNote(@PathVariable(value="id") Long id) {
		
		 Note notedel = noteser.findById(id);
		 if(null == notedel) {throw  new ResourceNotFoundException("Note", "id",id);};
		 noteser.deleteNote(id);
		 return ResponseEntity.ok().build();
		 
	    }
	 
	 @GetMapping("/notes/{id}") 
	 public Note getNote(@PathVariable(value="id") Long id ) {
		 if(null == id) {throw  new ResourceNotFoundException("Note", "id",id);};
	        return noteser.findById(id);
	    }
	 
	 
	 

}

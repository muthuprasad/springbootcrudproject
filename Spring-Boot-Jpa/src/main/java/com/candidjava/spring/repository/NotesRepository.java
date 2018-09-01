/**
 * 
 */
package com.candidjava.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.candidjava.spring.bean.Note;

/**
 * @author Muthu Manickam
 *
 */
public interface NotesRepository extends JpaRepository<Note, Long>{

}

package br.com.noctua.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.noctua.entity.DiaryEntity;

public interface DiaryDao extends JpaRepository<DiaryEntity, Long>{

	public DiaryEntity save(DiaryEntity diary);
	
	public List<DiaryEntity> findAllByUser(long id);

	public List<DiaryEntity> findAll();
}

package br.com.noctua.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.noctua.entity.VitalEntity;

public interface VitalDao extends JpaRepository<VitalEntity, Long> {

	public VitalEntity findByIdUsuario(long id);

	@Query("SELECT V FROM VitalEntity V WHERE V.idUsuario = id AND V.day = day AND V.month = month ORDER BY V.day ASC, V.month DESC, V.year DESC")
	public List<VitalEntity> retrieveByDay(@Param("id") long id, @Param("day") int day, @Param("month") int month);

	@Query("SELECT V FROM VitalEntity V WHERE V.idUsuario = id AND V.week = week AND V.month = month ORDER BY V.day ASC, V.month DESC, V.year DESC")
	public List<VitalEntity> retrieveByWeek(@Param("id") long id, @Param("week") int week, @Param("month") int month);

	@Query("SELECT V FROM VitalEntity V WHERE V.idUsuario = id AND V.month = month + ORDER BY V.day ASC, V.month DESC, V.year DESC")
	public List<VitalEntity> retrieveByMonth(@Param("id") long id, @Param("month") int month);

	public VitalEntity save(VitalEntity vital);
}

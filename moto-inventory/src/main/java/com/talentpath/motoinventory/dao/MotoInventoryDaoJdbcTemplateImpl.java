package com.talentpath.motoinventory.dao;

import com.talentpath.motoinventory.models.Motorcycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.dao.EmptyResultDataAccessException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MotoInventoryDaoJdbcTemplateImpl implements MotoInventoryDao {
    private static final String INSERT_MOTO_SQL =
            "insert into motorcycle (vin, make, model, type, year, color, sold) values (?, ?, ?, ?, ?)";

    private static final String SELECT_MOTO_SQL =
            "select * from motorcycle where id = ?";

    private static final String SELECT_ALL_MOTOS_SQL =
            "select * from motorcycle";

    private static final String DELETE_MOTO_SQL =
            "delete from motorcycle where id = ?";

    private static final String UPDATE_MOTO_SQL =
            "update motorcycle set vin = ?, make = ?, model = ?, type = ?, year = ?, color = ? where id = ?";

    private static final String SELECT_MOTOS_BY_MAKE_SQL =
            "select * from motorcycle where make = ?";

    private static final String SELECT_MOTOS_BY_TYPE_SQL =
            "select * from motorcycle where type = ?";

    private static final String SELECT_MOTOS_BY_VIN_SQL =
            "select * from motorcycle where type = ?";


    @Autowired
    JdbcTemplate jdbcTemplate;

    public MotoInventoryDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Motorcycle getMotorcycle(int id) {

        try {

            return jdbcTemplate.queryForObject(SELECT_MOTO_SQL, this::mapRowToMotorcycle, id);

        } catch (EmptyResultDataAccessException e) {
            return null;
        }

    }
    @Override
    public List<Motorcycle> getAllMotorcycles() {
        return jdbcTemplate.query(SELECT_ALL_MOTOS_SQL, this::mapRowToMotorcycle);
    }

    @Override
    @Transactional
    public Motorcycle addMotorcycle(Motorcycle motorcycle) {

        jdbcTemplate.update(INSERT_MOTO_SQL,
                motorcycle.getVin(),
                motorcycle.getMake(),
                motorcycle.getType(),
                motorcycle.getModel(),
                motorcycle.getYear(),
                motorcycle.getColor(),
                motorcycle.getSold()
                );

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        motorcycle.setId(id);

        return motorcycle;
    }

    @Override
    public void deleteMotorcycle(int id) {
        jdbcTemplate.update(DELETE_MOTO_SQL, id);
    }

    @Override
    public void updateMotorcycle(Motorcycle motorcycle) {

        jdbcTemplate.update(UPDATE_MOTO_SQL,
                motorcycle.getVin(),
                motorcycle.getMake(),
                motorcycle.getType(),
                motorcycle.getModel(),
                motorcycle.getYear(),
                motorcycle.getColor(),
                motorcycle.getSold(),
                motorcycle.getId());
    }
    @Override
    public List<Motorcycle> getMotorcyclesByMake(String make) {
        return jdbcTemplate.query(SELECT_MOTOS_BY_MAKE_SQL, this::mapRowToMotorcycle, make);
    }

    @Override
    public List<Motorcycle> getMotorcyclesByType(String type) {
        return jdbcTemplate.query(SELECT_MOTOS_BY_TYPE_SQL, this::mapRowToMotorcycle, type);
    }

    @Override
    public List<Motorcycle> getMotorcyclesByVin(String vin) {
        return jdbcTemplate.query(SELECT_MOTOS_BY_VIN_SQL, this::mapRowToMotorcycle, vin);
    }


    private Motorcycle mapRowToMotorcycle(ResultSet rs, int theNumberOfTheRow) throws SQLException {
        Motorcycle moto = new Motorcycle();
        moto.setId(rs.getInt("id"));
        moto.setMake(rs.getString("make"));
        moto.setType(rs.getString("type"));
        moto.setModel(rs.getString("model"));
        moto.setVin(rs.getString("vin"));
        moto.setYear(rs.getString("year"));
        moto.setColor(rs.getString("color"));

        return moto;
    }


}

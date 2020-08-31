
/**
 * Author:  steven
 * Created: Aug 30, 2020
 *
 * localización padre vendría dada por el campo 'parent_id'
 * mientras que las localizaciones internas serían todas esas que tuvieran como padre a cierta localización
 */
CREATE TABLE location (
    id UUID NOT NULL PRIMARY KEY,
    name VARCHAR(128) NOT NULL,
    area_m2 NUMERIC(20,3) NOT NULL,
    parent_id UUID DEFAULT NULL,
    CONSTRAINT fk_location FOREIGN KEY (parent_id) REFERENCES location(id) ON DELETE SET NULL
);

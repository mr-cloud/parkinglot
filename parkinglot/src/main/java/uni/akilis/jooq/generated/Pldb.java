/*
 * This file is generated by jOOQ.
*/
package uni.akilis.jooq.generated;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;

import uni.akilis.jooq.generated.tables.Author;
import uni.akilis.jooq.generated.tables.Plblacklist;
import uni.akilis.jooq.generated.tables.Pldealrecord;
import uni.akilis.jooq.generated.tables.Plmalfunctionrecord;
import uni.akilis.jooq.generated.tables.Plparkingcar;
import uni.akilis.jooq.generated.tables.Plparkingrecord;
import uni.akilis.jooq.generated.tables.Plparkingsensor;
import uni.akilis.jooq.generated.tables.Plparkingspace;
import uni.akilis.jooq.generated.tables.Plreserveparkinguser;
import uni.akilis.jooq.generated.tables.Plrunrecord;
import uni.akilis.jooq.generated.tables.Plsysuser;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Pldb extends SchemaImpl {

    private static final long serialVersionUID = -207238580;

    /**
     * The reference instance of <code>pldb</code>
     */
    public static final Pldb PLDB = new Pldb();

    /**
     * The table <code>pldb.author</code>.
     */
    public final Author AUTHOR = uni.akilis.jooq.generated.tables.Author.AUTHOR;

    /**
     * The table <code>pldb.plblacklist</code>.
     */
    public final Plblacklist PLBLACKLIST = uni.akilis.jooq.generated.tables.Plblacklist.PLBLACKLIST;

    /**
     * The table <code>pldb.pldealrecord</code>.
     */
    public final Pldealrecord PLDEALRECORD = uni.akilis.jooq.generated.tables.Pldealrecord.PLDEALRECORD;

    /**
     * The table <code>pldb.plmalfunctionrecord</code>.
     */
    public final Plmalfunctionrecord PLMALFUNCTIONRECORD = uni.akilis.jooq.generated.tables.Plmalfunctionrecord.PLMALFUNCTIONRECORD;

    /**
     * The table <code>pldb.plparkingcar</code>.
     */
    public final Plparkingcar PLPARKINGCAR = uni.akilis.jooq.generated.tables.Plparkingcar.PLPARKINGCAR;

    /**
     * The table <code>pldb.plparkingrecord</code>.
     */
    public final Plparkingrecord PLPARKINGRECORD = uni.akilis.jooq.generated.tables.Plparkingrecord.PLPARKINGRECORD;

    /**
     * The table <code>pldb.plparkingsensor</code>.
     */
    public final Plparkingsensor PLPARKINGSENSOR = uni.akilis.jooq.generated.tables.Plparkingsensor.PLPARKINGSENSOR;

    /**
     * The table <code>pldb.plparkingspace</code>.
     */
    public final Plparkingspace PLPARKINGSPACE = uni.akilis.jooq.generated.tables.Plparkingspace.PLPARKINGSPACE;

    /**
     * The table <code>pldb.plreserveparkinguser</code>.
     */
    public final Plreserveparkinguser PLRESERVEPARKINGUSER = uni.akilis.jooq.generated.tables.Plreserveparkinguser.PLRESERVEPARKINGUSER;

    /**
     * The table <code>pldb.plrunrecord</code>.
     */
    public final Plrunrecord PLRUNRECORD = uni.akilis.jooq.generated.tables.Plrunrecord.PLRUNRECORD;

    /**
     * The table <code>pldb.plsysuser</code>.
     */
    public final Plsysuser PLSYSUSER = uni.akilis.jooq.generated.tables.Plsysuser.PLSYSUSER;

    /**
     * No further instances allowed
     */
    private Pldb() {
        super("pldb", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            Author.AUTHOR,
            Plblacklist.PLBLACKLIST,
            Pldealrecord.PLDEALRECORD,
            Plmalfunctionrecord.PLMALFUNCTIONRECORD,
            Plparkingcar.PLPARKINGCAR,
            Plparkingrecord.PLPARKINGRECORD,
            Plparkingsensor.PLPARKINGSENSOR,
            Plparkingspace.PLPARKINGSPACE,
            Plreserveparkinguser.PLRESERVEPARKINGUSER,
            Plrunrecord.PLRUNRECORD,
            Plsysuser.PLSYSUSER);
    }
}
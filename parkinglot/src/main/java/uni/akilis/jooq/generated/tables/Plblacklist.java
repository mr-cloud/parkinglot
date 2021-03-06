/*
 * This file is generated by jOOQ.
*/
package uni.akilis.jooq.generated.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;

import uni.akilis.jooq.generated.Keys;
import uni.akilis.jooq.generated.Pldb;
import uni.akilis.jooq.generated.tables.records.PlblacklistRecord;


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
public class Plblacklist extends TableImpl<PlblacklistRecord> {

    private static final long serialVersionUID = 1110899703;

    /**
     * The reference instance of <code>pldb.plblacklist</code>
     */
    public static final Plblacklist PLBLACKLIST = new Plblacklist();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PlblacklistRecord> getRecordType() {
        return PlblacklistRecord.class;
    }

    /**
     * The column <code>pldb.plblacklist.blId</code>.
     */
    public final TableField<PlblacklistRecord, Integer> BLID = createField("blId", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>pldb.plblacklist.carLicence</code>. 车牌号
     */
    public final TableField<PlblacklistRecord, String> CARLICENCE = createField("carLicence", org.jooq.impl.SQLDataType.VARCHAR.length(20).nullable(false), this, "车牌号");

    /**
     * The column <code>pldb.plblacklist.reason</code>. 原因
     */
    public final TableField<PlblacklistRecord, String> REASON = createField("reason", org.jooq.impl.SQLDataType.VARCHAR.length(45), this, "原因");

    /**
     * The column <code>pldb.plblacklist.type</code>. 受限制的类别，比如欠费，超过有效期等
     */
    public final TableField<PlblacklistRecord, String> TYPE = createField("type", org.jooq.impl.SQLDataType.VARCHAR.length(10), this, "受限制的类别，比如欠费，超过有效期等");

    /**
     * Create a <code>pldb.plblacklist</code> table reference
     */
    public Plblacklist() {
        this("plblacklist", null);
    }

    /**
     * Create an aliased <code>pldb.plblacklist</code> table reference
     */
    public Plblacklist(String alias) {
        this(alias, PLBLACKLIST);
    }

    private Plblacklist(String alias, Table<PlblacklistRecord> aliased) {
        this(alias, aliased, null);
    }

    private Plblacklist(String alias, Table<PlblacklistRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Pldb.PLDB;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<PlblacklistRecord, Integer> getIdentity() {
        return Keys.IDENTITY_PLBLACKLIST;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<PlblacklistRecord> getPrimaryKey() {
        return Keys.KEY_PLBLACKLIST_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<PlblacklistRecord>> getKeys() {
        return Arrays.<UniqueKey<PlblacklistRecord>>asList(Keys.KEY_PLBLACKLIST_PRIMARY, Keys.KEY_PLBLACKLIST_CARLICENCE_UNIQUE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Plblacklist as(String alias) {
        return new Plblacklist(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Plblacklist rename(String name) {
        return new Plblacklist(name, null);
    }
}

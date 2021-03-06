/*
 * This file is generated by jOOQ.
*/
package uni.akilis.jooq.generated.tables.records;


import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;

import uni.akilis.jooq.generated.tables.Plmalfunctionrecord;


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
public class PlmalfunctionrecordRecord extends UpdatableRecordImpl<PlmalfunctionrecordRecord> implements Record4<Integer, Timestamp, String, String> {

    private static final long serialVersionUID = 1725954916;

    /**
     * Setter for <code>pldb.plmalfunctionrecord.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>pldb.plmalfunctionrecord.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>pldb.plmalfunctionrecord.time</code>. 故障出现的时间
     */
    public void setTime(Timestamp value) {
        set(1, value);
    }

    /**
     * Getter for <code>pldb.plmalfunctionrecord.time</code>. 故障出现的时间
     */
    public Timestamp getTime() {
        return (Timestamp) get(1);
    }

    /**
     * Setter for <code>pldb.plmalfunctionrecord.type</code>. 故障类型，如传感器、相机等出现故障的设备名称
     */
    public void setType(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>pldb.plmalfunctionrecord.type</code>. 故障类型，如传感器、相机等出现故障的设备名称
     */
    public String getType() {
        return (String) get(2);
    }

    /**
     * Setter for <code>pldb.plmalfunctionrecord.description</code>. 故障的简单描述
     */
    public void setDescription(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>pldb.plmalfunctionrecord.description</code>. 故障的简单描述
     */
    public String getDescription() {
        return (String) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, Timestamp, String, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, Timestamp, String, String> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Plmalfunctionrecord.PLMALFUNCTIONRECORD.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field2() {
        return Plmalfunctionrecord.PLMALFUNCTIONRECORD.TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Plmalfunctionrecord.PLMALFUNCTIONRECORD.TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Plmalfunctionrecord.PLMALFUNCTIONRECORD.DESCRIPTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value2() {
        return getTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PlmalfunctionrecordRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PlmalfunctionrecordRecord value2(Timestamp value) {
        setTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PlmalfunctionrecordRecord value3(String value) {
        setType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PlmalfunctionrecordRecord value4(String value) {
        setDescription(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PlmalfunctionrecordRecord values(Integer value1, Timestamp value2, String value3, String value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PlmalfunctionrecordRecord
     */
    public PlmalfunctionrecordRecord() {
        super(Plmalfunctionrecord.PLMALFUNCTIONRECORD);
    }

    /**
     * Create a detached, initialised PlmalfunctionrecordRecord
     */
    public PlmalfunctionrecordRecord(Integer id, Timestamp time, String type, String description) {
        super(Plmalfunctionrecord.PLMALFUNCTIONRECORD);

        set(0, id);
        set(1, time);
        set(2, type);
        set(3, description);
    }
}

/*
 * This file is generated by jOOQ.
*/
package uni.akilis.jooq.generated.tables.records;


import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;

import uni.akilis.jooq.generated.tables.Plrunrecord;


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
public class PlrunrecordRecord extends UpdatableRecordImpl<PlrunrecordRecord> implements Record5<Integer, Timestamp, Integer, Byte, Byte> {

    private static final long serialVersionUID = -618680767;

    /**
     * Setter for <code>pldb.plrunrecord.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>pldb.plrunrecord.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>pldb.plrunrecord.time</code>. 运行指令的开始时间
     */
    public void setTime(Timestamp value) {
        set(1, value);
    }

    /**
     * Getter for <code>pldb.plrunrecord.time</code>. 运行指令的开始时间
     */
    public Timestamp getTime() {
        return (Timestamp) get(1);
    }

    /**
     * Setter for <code>pldb.plrunrecord.spaceId</code>. 车位编号
     */
    public void setSpaceid(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>pldb.plrunrecord.spaceId</code>. 车位编号
     */
    public Integer getSpaceid() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>pldb.plrunrecord.status</code>. 运行到断电时刻的状态

     */
    public void setStatus(Byte value) {
        set(3, value);
    }

    /**
     * Getter for <code>pldb.plrunrecord.status</code>. 运行到断电时刻的状态

     */
    public Byte getStatus() {
        return (Byte) get(3);
    }

    /**
     * Setter for <code>pldb.plrunrecord.step</code>. 运行到断电时刻的步骤，可结合状态恢复
     */
    public void setStep(Byte value) {
        set(4, value);
    }

    /**
     * Getter for <code>pldb.plrunrecord.step</code>. 运行到断电时刻的步骤，可结合状态恢复
     */
    public Byte getStep() {
        return (Byte) get(4);
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
    // Record5 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<Integer, Timestamp, Integer, Byte, Byte> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<Integer, Timestamp, Integer, Byte, Byte> valuesRow() {
        return (Row5) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Plrunrecord.PLRUNRECORD.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field2() {
        return Plrunrecord.PLRUNRECORD.TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return Plrunrecord.PLRUNRECORD.SPACEID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Byte> field4() {
        return Plrunrecord.PLRUNRECORD.STATUS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Byte> field5() {
        return Plrunrecord.PLRUNRECORD.STEP;
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
    public Integer value3() {
        return getSpaceid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte value4() {
        return getStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte value5() {
        return getStep();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PlrunrecordRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PlrunrecordRecord value2(Timestamp value) {
        setTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PlrunrecordRecord value3(Integer value) {
        setSpaceid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PlrunrecordRecord value4(Byte value) {
        setStatus(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PlrunrecordRecord value5(Byte value) {
        setStep(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PlrunrecordRecord values(Integer value1, Timestamp value2, Integer value3, Byte value4, Byte value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PlrunrecordRecord
     */
    public PlrunrecordRecord() {
        super(Plrunrecord.PLRUNRECORD);
    }

    /**
     * Create a detached, initialised PlrunrecordRecord
     */
    public PlrunrecordRecord(Integer id, Timestamp time, Integer spaceid, Byte status, Byte step) {
        super(Plrunrecord.PLRUNRECORD);

        set(0, id);
        set(1, time);
        set(2, spaceid);
        set(3, status);
        set(4, step);
    }
}

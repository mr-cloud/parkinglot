/*
 * This file is generated by jOOQ.
*/
package uni.akilis.jooq.generated;


import javax.annotation.Generated;

import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.AbstractKeys;

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
import uni.akilis.jooq.generated.tables.records.AuthorRecord;
import uni.akilis.jooq.generated.tables.records.PlblacklistRecord;
import uni.akilis.jooq.generated.tables.records.PldealrecordRecord;
import uni.akilis.jooq.generated.tables.records.PlmalfunctionrecordRecord;
import uni.akilis.jooq.generated.tables.records.PlparkingcarRecord;
import uni.akilis.jooq.generated.tables.records.PlparkingrecordRecord;
import uni.akilis.jooq.generated.tables.records.PlparkingsensorRecord;
import uni.akilis.jooq.generated.tables.records.PlparkingspaceRecord;
import uni.akilis.jooq.generated.tables.records.PlreserveparkinguserRecord;
import uni.akilis.jooq.generated.tables.records.PlrunrecordRecord;
import uni.akilis.jooq.generated.tables.records.PlsysuserRecord;


/**
 * A class modelling foreign key relationships between tables of the <code>pldb</code> 
 * schema
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<PlblacklistRecord, Integer> IDENTITY_PLBLACKLIST = Identities0.IDENTITY_PLBLACKLIST;
    public static final Identity<PldealrecordRecord, Integer> IDENTITY_PLDEALRECORD = Identities0.IDENTITY_PLDEALRECORD;
    public static final Identity<PlmalfunctionrecordRecord, Integer> IDENTITY_PLMALFUNCTIONRECORD = Identities0.IDENTITY_PLMALFUNCTIONRECORD;
    public static final Identity<PlparkingcarRecord, Long> IDENTITY_PLPARKINGCAR = Identities0.IDENTITY_PLPARKINGCAR;
    public static final Identity<PlparkingrecordRecord, Integer> IDENTITY_PLPARKINGRECORD = Identities0.IDENTITY_PLPARKINGRECORD;
    public static final Identity<PlparkingsensorRecord, Integer> IDENTITY_PLPARKINGSENSOR = Identities0.IDENTITY_PLPARKINGSENSOR;
    public static final Identity<PlreserveparkinguserRecord, Integer> IDENTITY_PLRESERVEPARKINGUSER = Identities0.IDENTITY_PLRESERVEPARKINGUSER;
    public static final Identity<PlrunrecordRecord, Integer> IDENTITY_PLRUNRECORD = Identities0.IDENTITY_PLRUNRECORD;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AuthorRecord> KEY_AUTHOR_PRIMARY = UniqueKeys0.KEY_AUTHOR_PRIMARY;
    public static final UniqueKey<PlblacklistRecord> KEY_PLBLACKLIST_PRIMARY = UniqueKeys0.KEY_PLBLACKLIST_PRIMARY;
    public static final UniqueKey<PlblacklistRecord> KEY_PLBLACKLIST_CARLICENCE_UNIQUE = UniqueKeys0.KEY_PLBLACKLIST_CARLICENCE_UNIQUE;
    public static final UniqueKey<PldealrecordRecord> KEY_PLDEALRECORD_PRIMARY = UniqueKeys0.KEY_PLDEALRECORD_PRIMARY;
    public static final UniqueKey<PlmalfunctionrecordRecord> KEY_PLMALFUNCTIONRECORD_PRIMARY = UniqueKeys0.KEY_PLMALFUNCTIONRECORD_PRIMARY;
    public static final UniqueKey<PlparkingcarRecord> KEY_PLPARKINGCAR_PRIMARY = UniqueKeys0.KEY_PLPARKINGCAR_PRIMARY;
    public static final UniqueKey<PlparkingcarRecord> KEY_PLPARKINGCAR_CARLICENCE_UNIQUE = UniqueKeys0.KEY_PLPARKINGCAR_CARLICENCE_UNIQUE;
    public static final UniqueKey<PlparkingrecordRecord> KEY_PLPARKINGRECORD_PRIMARY = UniqueKeys0.KEY_PLPARKINGRECORD_PRIMARY;
    public static final UniqueKey<PlparkingsensorRecord> KEY_PLPARKINGSENSOR_PRIMARY = UniqueKeys0.KEY_PLPARKINGSENSOR_PRIMARY;
    public static final UniqueKey<PlparkingspaceRecord> KEY_PLPARKINGSPACE_PRIMARY = UniqueKeys0.KEY_PLPARKINGSPACE_PRIMARY;
    public static final UniqueKey<PlreserveparkinguserRecord> KEY_PLRESERVEPARKINGUSER_PRIMARY = UniqueKeys0.KEY_PLRESERVEPARKINGUSER_PRIMARY;
    public static final UniqueKey<PlreserveparkinguserRecord> KEY_PLRESERVEPARKINGUSER_CARLICENCE_UNIQUE = UniqueKeys0.KEY_PLRESERVEPARKINGUSER_CARLICENCE_UNIQUE;
    public static final UniqueKey<PlrunrecordRecord> KEY_PLRUNRECORD_PRIMARY = UniqueKeys0.KEY_PLRUNRECORD_PRIMARY;
    public static final UniqueKey<PlsysuserRecord> KEY_PLSYSUSER_PRIMARY = UniqueKeys0.KEY_PLSYSUSER_PRIMARY;
    public static final UniqueKey<PlsysuserRecord> KEY_PLSYSUSER_ACCT_UNIQUE = UniqueKeys0.KEY_PLSYSUSER_ACCT_UNIQUE;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<PlparkingspaceRecord, PlparkingsensorRecord> FK_PLPARKINGSPACE_PLPARKINGSENSOR1 = ForeignKeys0.FK_PLPARKINGSPACE_PLPARKINGSENSOR1;
    public static final ForeignKey<PlparkingspaceRecord, PlparkingcarRecord> FK_PLPARKINGSPACE_PLPARKINGCAR1 = ForeignKeys0.FK_PLPARKINGSPACE_PLPARKINGCAR1;
    public static final ForeignKey<PlreserveparkinguserRecord, PlparkingspaceRecord> FK_PLRESERVEPARKINGUSER_PLPARKINGSPACE1 = ForeignKeys0.FK_PLRESERVEPARKINGUSER_PLPARKINGSPACE1;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 extends AbstractKeys {
        public static Identity<PlblacklistRecord, Integer> IDENTITY_PLBLACKLIST = createIdentity(Plblacklist.PLBLACKLIST, Plblacklist.PLBLACKLIST.BLID);
        public static Identity<PldealrecordRecord, Integer> IDENTITY_PLDEALRECORD = createIdentity(Pldealrecord.PLDEALRECORD, Pldealrecord.PLDEALRECORD.ID);
        public static Identity<PlmalfunctionrecordRecord, Integer> IDENTITY_PLMALFUNCTIONRECORD = createIdentity(Plmalfunctionrecord.PLMALFUNCTIONRECORD, Plmalfunctionrecord.PLMALFUNCTIONRECORD.ID);
        public static Identity<PlparkingcarRecord, Long> IDENTITY_PLPARKINGCAR = createIdentity(Plparkingcar.PLPARKINGCAR, Plparkingcar.PLPARKINGCAR.TID);
        public static Identity<PlparkingrecordRecord, Integer> IDENTITY_PLPARKINGRECORD = createIdentity(Plparkingrecord.PLPARKINGRECORD, Plparkingrecord.PLPARKINGRECORD.ID);
        public static Identity<PlparkingsensorRecord, Integer> IDENTITY_PLPARKINGSENSOR = createIdentity(Plparkingsensor.PLPARKINGSENSOR, Plparkingsensor.PLPARKINGSENSOR.SID);
        public static Identity<PlreserveparkinguserRecord, Integer> IDENTITY_PLRESERVEPARKINGUSER = createIdentity(Plreserveparkinguser.PLRESERVEPARKINGUSER, Plreserveparkinguser.PLRESERVEPARKINGUSER.USERID);
        public static Identity<PlrunrecordRecord, Integer> IDENTITY_PLRUNRECORD = createIdentity(Plrunrecord.PLRUNRECORD, Plrunrecord.PLRUNRECORD.ID);
    }

    private static class UniqueKeys0 extends AbstractKeys {
        public static final UniqueKey<AuthorRecord> KEY_AUTHOR_PRIMARY = createUniqueKey(Author.AUTHOR, "KEY_author_PRIMARY", Author.AUTHOR.ID);
        public static final UniqueKey<PlblacklistRecord> KEY_PLBLACKLIST_PRIMARY = createUniqueKey(Plblacklist.PLBLACKLIST, "KEY_plblacklist_PRIMARY", Plblacklist.PLBLACKLIST.BLID);
        public static final UniqueKey<PlblacklistRecord> KEY_PLBLACKLIST_CARLICENCE_UNIQUE = createUniqueKey(Plblacklist.PLBLACKLIST, "KEY_plblacklist_carLicence_UNIQUE", Plblacklist.PLBLACKLIST.CARLICENCE);
        public static final UniqueKey<PldealrecordRecord> KEY_PLDEALRECORD_PRIMARY = createUniqueKey(Pldealrecord.PLDEALRECORD, "KEY_pldealrecord_PRIMARY", Pldealrecord.PLDEALRECORD.ID);
        public static final UniqueKey<PlmalfunctionrecordRecord> KEY_PLMALFUNCTIONRECORD_PRIMARY = createUniqueKey(Plmalfunctionrecord.PLMALFUNCTIONRECORD, "KEY_plmalfunctionrecord_PRIMARY", Plmalfunctionrecord.PLMALFUNCTIONRECORD.ID);
        public static final UniqueKey<PlparkingcarRecord> KEY_PLPARKINGCAR_PRIMARY = createUniqueKey(Plparkingcar.PLPARKINGCAR, "KEY_plparkingcar_PRIMARY", Plparkingcar.PLPARKINGCAR.TID);
        public static final UniqueKey<PlparkingcarRecord> KEY_PLPARKINGCAR_CARLICENCE_UNIQUE = createUniqueKey(Plparkingcar.PLPARKINGCAR, "KEY_plparkingcar_carLicence_UNIQUE", Plparkingcar.PLPARKINGCAR.CARLICENCE);
        public static final UniqueKey<PlparkingrecordRecord> KEY_PLPARKINGRECORD_PRIMARY = createUniqueKey(Plparkingrecord.PLPARKINGRECORD, "KEY_plparkingrecord_PRIMARY", Plparkingrecord.PLPARKINGRECORD.ID);
        public static final UniqueKey<PlparkingsensorRecord> KEY_PLPARKINGSENSOR_PRIMARY = createUniqueKey(Plparkingsensor.PLPARKINGSENSOR, "KEY_plparkingsensor_PRIMARY", Plparkingsensor.PLPARKINGSENSOR.SID);
        public static final UniqueKey<PlparkingspaceRecord> KEY_PLPARKINGSPACE_PRIMARY = createUniqueKey(Plparkingspace.PLPARKINGSPACE, "KEY_plparkingspace_PRIMARY", Plparkingspace.PLPARKINGSPACE.PSPACEID);
        public static final UniqueKey<PlreserveparkinguserRecord> KEY_PLRESERVEPARKINGUSER_PRIMARY = createUniqueKey(Plreserveparkinguser.PLRESERVEPARKINGUSER, "KEY_plreserveparkinguser_PRIMARY", Plreserveparkinguser.PLRESERVEPARKINGUSER.USERID);
        public static final UniqueKey<PlreserveparkinguserRecord> KEY_PLRESERVEPARKINGUSER_CARLICENCE_UNIQUE = createUniqueKey(Plreserveparkinguser.PLRESERVEPARKINGUSER, "KEY_plreserveparkinguser_carLicence_UNIQUE", Plreserveparkinguser.PLRESERVEPARKINGUSER.CARLICENCE);
        public static final UniqueKey<PlrunrecordRecord> KEY_PLRUNRECORD_PRIMARY = createUniqueKey(Plrunrecord.PLRUNRECORD, "KEY_plrunrecord_PRIMARY", Plrunrecord.PLRUNRECORD.ID);
        public static final UniqueKey<PlsysuserRecord> KEY_PLSYSUSER_PRIMARY = createUniqueKey(Plsysuser.PLSYSUSER, "KEY_plsysuser_PRIMARY", Plsysuser.PLSYSUSER.ACCT);
        public static final UniqueKey<PlsysuserRecord> KEY_PLSYSUSER_ACCT_UNIQUE = createUniqueKey(Plsysuser.PLSYSUSER, "KEY_plsysuser_acct_UNIQUE", Plsysuser.PLSYSUSER.ACCT);
    }

    private static class ForeignKeys0 extends AbstractKeys {
        public static final ForeignKey<PlparkingspaceRecord, PlparkingsensorRecord> FK_PLPARKINGSPACE_PLPARKINGSENSOR1 = createForeignKey(uni.akilis.jooq.generated.Keys.KEY_PLPARKINGSENSOR_PRIMARY, Plparkingspace.PLPARKINGSPACE, "fk_PlParkingSpace_PlParkingSensor1", Plparkingspace.PLPARKINGSPACE.PS_SID);
        public static final ForeignKey<PlparkingspaceRecord, PlparkingcarRecord> FK_PLPARKINGSPACE_PLPARKINGCAR1 = createForeignKey(uni.akilis.jooq.generated.Keys.KEY_PLPARKINGCAR_PRIMARY, Plparkingspace.PLPARKINGSPACE, "fk_PlParkingSpace_PlParkingCar1", Plparkingspace.PLPARKINGSPACE.PC_TID);
        public static final ForeignKey<PlreserveparkinguserRecord, PlparkingspaceRecord> FK_PLRESERVEPARKINGUSER_PLPARKINGSPACE1 = createForeignKey(uni.akilis.jooq.generated.Keys.KEY_PLPARKINGSPACE_PRIMARY, Plreserveparkinguser.PLRESERVEPARKINGUSER, "fk_PlReserveParkingUser_PlParkingSpace1", Plreserveparkinguser.PLRESERVEPARKINGUSER.PLPARKINGSPACE_PSPACEID);
    }
}

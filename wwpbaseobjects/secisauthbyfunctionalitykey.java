package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class secisauthbyfunctionalitykey extends GXProcedure
{
   public secisauthbyfunctionalitykey( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( secisauthbyfunctionalitykey.class ), "" );
   }

   public secisauthbyfunctionalitykey( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 )
   {
      secisauthbyfunctionalitykey.this.aP1 = new boolean[] {false};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        boolean[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             boolean[] aP1 )
   {
      secisauthbyfunctionalitykey.this.AV9SecFunctionalityKey = aP0;
      secisauthbyfunctionalitykey.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8IsAuthorized = false ;
      AV12GXLvl3 = (byte)(0) ;
      /* Using cursor P001Q2 */
      pr_default.execute(0, new Object[] {AV9SecFunctionalityKey});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3SecFunctionalityKey = P001Q2_A3SecFunctionalityKey[0] ;
         A1SecFunctionalityId = P001Q2_A1SecFunctionalityId[0] ;
         AV12GXLvl3 = (byte)(1) ;
         GXt_boolean1 = AV8IsAuthorized ;
         GXv_boolean2[0] = GXt_boolean1 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalityid(remoteHandle, context).execute( A1SecFunctionalityId, GXv_boolean2) ;
         secisauthbyfunctionalitykey.this.GXt_boolean1 = GXv_boolean2[0] ;
         AV8IsAuthorized = GXt_boolean1 ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV12GXLvl3 == 0 )
      {
         AV8IsAuthorized = false ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = secisauthbyfunctionalitykey.this.AV8IsAuthorized;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      P001Q2_A3SecFunctionalityKey = new String[] {""} ;
      P001Q2_A1SecFunctionalityId = new long[1] ;
      A3SecFunctionalityKey = "" ;
      GXv_boolean2 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey__default(),
         new Object[] {
             new Object[] {
            P001Q2_A3SecFunctionalityKey, P001Q2_A1SecFunctionalityId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV12GXLvl3 ;
   private short Gx_err ;
   private long A1SecFunctionalityId ;
   private String scmdbuf ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private String AV9SecFunctionalityKey ;
   private String A3SecFunctionalityKey ;
   private boolean[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P001Q2_A3SecFunctionalityKey ;
   private long[] P001Q2_A1SecFunctionalityId ;
}

final  class secisauthbyfunctionalitykey__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P001Q2", "SELECT TOP 1 [SecFunctionalityKey], [SecFunctionalityId] FROM [SecFunctionality] WHERE [SecFunctionalityKey] = ? ORDER BY [SecFunctionalityKey] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setVarchar(1, (String)parms[0], 100);
               return;
      }
   }

}


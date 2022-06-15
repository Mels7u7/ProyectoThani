package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class secgrantallaccesstoadminrole extends GXProcedure
{
   public secgrantallaccesstoadminrole( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( secgrantallaccesstoadminrole.class ), "" );
   }

   public secgrantallaccesstoadminrole( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( String aP0 ,
                        boolean aP1 ,
                        String aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( String aP0 ,
                             boolean aP1 ,
                             String aP2 )
   {
      secgrantallaccesstoadminrole.this.AV12SecRoleName = aP0;
      secgrantallaccesstoadminrole.this.AV8AssignRoleToUser = aP1;
      secgrantallaccesstoadminrole.this.AV11SecUserName = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV15GXLvl3 = (byte)(0) ;
      /* Using cursor P00222 */
      pr_default.execute(0, new Object[] {AV12SecRoleName});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A13SecRoleName = P00222_A13SecRoleName[0] ;
         A4SecRoleId = P00222_A4SecRoleId[0] ;
         AV15GXLvl3 = (byte)(1) ;
         AV9SecRoleId = A4SecRoleId ;
         /* Execute user subroutine: 'GRANTACCESS' */
         S111 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV15GXLvl3 == 0 )
      {
         System.out.println( GXutil.format( "Creating role '%1'...", AV12SecRoleName, "", "", "", "", "", "", "", "") );
         /*
            INSERT RECORD ON TABLE SecRole

         */
         A13SecRoleName = AV12SecRoleName ;
         A12SecRoleDescription = AV12SecRoleName ;
         /* Using cursor P00223 */
         pr_default.execute(1, new Object[] {A13SecRoleName, A12SecRoleDescription});
         A4SecRoleId = P00223_A4SecRoleId[0] ;
         Application.getSmartCacheProvider(remoteHandle).setUpdated("SecRole");
         if ( (pr_default.getStatus(1) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
         /* Using cursor P00224 */
         pr_default.execute(2, new Object[] {AV12SecRoleName});
         while ( (pr_default.getStatus(2) != 101) )
         {
            A13SecRoleName = P00224_A13SecRoleName[0] ;
            A4SecRoleId = P00224_A4SecRoleId[0] ;
            AV9SecRoleId = A4SecRoleId ;
            /* Execute user subroutine: 'GRANTACCESS' */
            S111 ();
            if ( returnInSub )
            {
               pr_default.close(2);
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            pr_default.readNext(2);
         }
         pr_default.close(2);
      }
      if ( AV8AssignRoleToUser )
      {
         AV17GXLvl23 = (byte)(0) ;
         /* Using cursor P00225 */
         pr_default.execute(3, new Object[] {AV11SecUserName});
         while ( (pr_default.getStatus(3) != 101) )
         {
            A14SecUserName = P00225_A14SecUserName[0] ;
            A6SecUserId = P00225_A6SecUserId[0] ;
            AV17GXLvl23 = (byte)(1) ;
            AV10SecUserId = A6SecUserId ;
            /* Execute user subroutine: 'ASSIGNROLE' */
            S121 ();
            if ( returnInSub )
            {
               pr_default.close(3);
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            pr_default.readNext(3);
         }
         pr_default.close(3);
         if ( AV17GXLvl23 == 0 )
         {
            System.out.println( GXutil.format( "Creating user '%1'...", AV11SecUserName, "", "", "", "", "", "", "", "") );
            /*
               INSERT RECORD ON TABLE SecUser

            */
            A14SecUserName = AV11SecUserName ;
            A15SecUserPassword = AV11SecUserName ;
            A211SecUserEstadoR = "A" ;
            /* Using cursor P00226 */
            pr_default.execute(4, new Object[] {A14SecUserName, A15SecUserPassword, A211SecUserEstadoR});
            A6SecUserId = P00226_A6SecUserId[0] ;
            Application.getSmartCacheProvider(remoteHandle).setUpdated("SecUser");
            if ( (pr_default.getStatus(4) == 1) )
            {
               Gx_err = (short)(1) ;
               Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
            }
            else
            {
               Gx_err = (short)(0) ;
               Gx_emsg = "" ;
            }
            /* End Insert */
            /* Using cursor P00227 */
            pr_default.execute(5, new Object[] {AV11SecUserName});
            while ( (pr_default.getStatus(5) != 101) )
            {
               A14SecUserName = P00227_A14SecUserName[0] ;
               A6SecUserId = P00227_A6SecUserId[0] ;
               AV10SecUserId = A6SecUserId ;
               /* Execute user subroutine: 'ASSIGNROLE' */
               S121 ();
               if ( returnInSub )
               {
                  pr_default.close(5);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
               pr_default.readNext(5);
            }
            pr_default.close(5);
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'GRANTACCESS' Routine */
      returnInSub = false ;
      /* Using cursor P00228 */
      pr_default.execute(6);
      while ( (pr_default.getStatus(6) != 101) )
      {
         A1SecFunctionalityId = P00228_A1SecFunctionalityId[0] ;
         A8SecFunctionalityDescription = P00228_A8SecFunctionalityDescription[0] ;
         A3SecFunctionalityKey = P00228_A3SecFunctionalityKey[0] ;
         AV20GXLvl47 = (byte)(0) ;
         /* Using cursor P00229 */
         pr_default.execute(7, new Object[] {Long.valueOf(A1SecFunctionalityId), Short.valueOf(AV9SecRoleId)});
         while ( (pr_default.getStatus(7) != 101) )
         {
            A4SecRoleId = P00229_A4SecRoleId[0] ;
            AV20GXLvl47 = (byte)(1) ;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(7);
         if ( AV20GXLvl47 == 0 )
         {
            System.out.println( GXutil.format( "Adding functionality '%1' to role '%2'...", A3SecFunctionalityKey, AV12SecRoleName, "", "", "", "", "", "", "") );
            /*
               INSERT RECORD ON TABLE SecFunctionalityRole

            */
            W1SecFunctionalityId = A1SecFunctionalityId ;
            A4SecRoleId = AV9SecRoleId ;
            /* Using cursor P002210 */
            pr_default.execute(8, new Object[] {Long.valueOf(A1SecFunctionalityId), Short.valueOf(A4SecRoleId)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("SecFunctionalityRole");
            if ( (pr_default.getStatus(8) == 1) )
            {
               Gx_err = (short)(1) ;
               Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
            }
            else
            {
               Gx_err = (short)(0) ;
               Gx_emsg = "" ;
            }
            A1SecFunctionalityId = W1SecFunctionalityId ;
            /* End Insert */
         }
         pr_default.readNext(6);
      }
      pr_default.close(6);
      Application.commitDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.secgrantallaccesstoadminrole");
   }

   public void S121( )
   {
      /* 'ASSIGNROLE' Routine */
      returnInSub = false ;
      AV21GXLvl63 = (byte)(0) ;
      /* Using cursor P002211 */
      pr_default.execute(9, new Object[] {Short.valueOf(AV10SecUserId), Short.valueOf(AV9SecRoleId)});
      while ( (pr_default.getStatus(9) != 101) )
      {
         A6SecUserId = P002211_A6SecUserId[0] ;
         A4SecRoleId = P002211_A4SecRoleId[0] ;
         AV21GXLvl63 = (byte)(1) ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(9);
      if ( AV21GXLvl63 == 0 )
      {
         System.out.println( GXutil.format( "Adding role '%1' to user '%2'...", AV12SecRoleName, AV11SecUserName, "", "", "", "", "", "", "") );
         /*
            INSERT RECORD ON TABLE SecUserRole

         */
         A4SecRoleId = AV9SecRoleId ;
         A6SecUserId = AV10SecUserId ;
         /* Using cursor P002212 */
         pr_default.execute(10, new Object[] {Short.valueOf(A6SecUserId), Short.valueOf(A4SecRoleId)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("SecUserRole");
         if ( (pr_default.getStatus(10) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
      }
      Application.commitDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.secgrantallaccesstoadminrole");
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.secgrantallaccesstoadminrole");
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
      P00222_A13SecRoleName = new String[] {""} ;
      P00222_A4SecRoleId = new short[1] ;
      A13SecRoleName = "" ;
      A12SecRoleDescription = "" ;
      P00223_A4SecRoleId = new short[1] ;
      Gx_emsg = "" ;
      P00224_A13SecRoleName = new String[] {""} ;
      P00224_A4SecRoleId = new short[1] ;
      P00225_A14SecUserName = new String[] {""} ;
      P00225_A6SecUserId = new short[1] ;
      A14SecUserName = "" ;
      A15SecUserPassword = "" ;
      A211SecUserEstadoR = "" ;
      P00226_A6SecUserId = new short[1] ;
      P00227_A14SecUserName = new String[] {""} ;
      P00227_A6SecUserId = new short[1] ;
      P00228_A1SecFunctionalityId = new long[1] ;
      P00228_A8SecFunctionalityDescription = new String[] {""} ;
      P00228_A3SecFunctionalityKey = new String[] {""} ;
      A8SecFunctionalityDescription = "" ;
      A3SecFunctionalityKey = "" ;
      P00229_A1SecFunctionalityId = new long[1] ;
      P00229_A4SecRoleId = new short[1] ;
      P002211_A6SecUserId = new short[1] ;
      P002211_A4SecRoleId = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wwpbaseobjects.secgrantallaccesstoadminrole__default(),
         new Object[] {
             new Object[] {
            P00222_A13SecRoleName, P00222_A4SecRoleId
            }
            , new Object[] {
            P00223_A4SecRoleId
            }
            , new Object[] {
            P00224_A13SecRoleName, P00224_A4SecRoleId
            }
            , new Object[] {
            P00225_A14SecUserName, P00225_A6SecUserId
            }
            , new Object[] {
            P00226_A6SecUserId
            }
            , new Object[] {
            P00227_A14SecUserName, P00227_A6SecUserId
            }
            , new Object[] {
            P00228_A1SecFunctionalityId, P00228_A8SecFunctionalityDescription, P00228_A3SecFunctionalityKey
            }
            , new Object[] {
            P00229_A1SecFunctionalityId, P00229_A4SecRoleId
            }
            , new Object[] {
            }
            , new Object[] {
            P002211_A6SecUserId, P002211_A4SecRoleId
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV15GXLvl3 ;
   private byte AV17GXLvl23 ;
   private byte AV20GXLvl47 ;
   private byte AV21GXLvl63 ;
   private short A4SecRoleId ;
   private short AV9SecRoleId ;
   private short Gx_err ;
   private short A6SecUserId ;
   private short AV10SecUserId ;
   private int GX_INS5 ;
   private int GX_INS6 ;
   private int GX_INS2 ;
   private int GX_INS7 ;
   private long A1SecFunctionalityId ;
   private long W1SecFunctionalityId ;
   private String scmdbuf ;
   private String Gx_emsg ;
   private String A211SecUserEstadoR ;
   private boolean AV8AssignRoleToUser ;
   private boolean returnInSub ;
   private String AV12SecRoleName ;
   private String AV11SecUserName ;
   private String A13SecRoleName ;
   private String A12SecRoleDescription ;
   private String A14SecUserName ;
   private String A15SecUserPassword ;
   private String A8SecFunctionalityDescription ;
   private String A3SecFunctionalityKey ;
   private IDataStoreProvider pr_default ;
   private String[] P00222_A13SecRoleName ;
   private short[] P00222_A4SecRoleId ;
   private short[] P00223_A4SecRoleId ;
   private String[] P00224_A13SecRoleName ;
   private short[] P00224_A4SecRoleId ;
   private String[] P00225_A14SecUserName ;
   private short[] P00225_A6SecUserId ;
   private short[] P00226_A6SecUserId ;
   private String[] P00227_A14SecUserName ;
   private short[] P00227_A6SecUserId ;
   private long[] P00228_A1SecFunctionalityId ;
   private String[] P00228_A8SecFunctionalityDescription ;
   private String[] P00228_A3SecFunctionalityKey ;
   private long[] P00229_A1SecFunctionalityId ;
   private short[] P00229_A4SecRoleId ;
   private short[] P002211_A6SecUserId ;
   private short[] P002211_A4SecRoleId ;
}

final  class secgrantallaccesstoadminrole__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00222", "SELECT TOP 1 [SecRoleName], [SecRoleId] FROM [SecRole] WHERE [SecRoleName] = ? ORDER BY [SecRoleId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P00223", "INSERT INTO [SecRole]([SecRoleName], [SecRoleDescription]) VALUES(?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P00224", "SELECT TOP 1 [SecRoleName], [SecRoleId] FROM [SecRole] WHERE [SecRoleName] = ? ORDER BY [SecRoleId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P00225", "SELECT TOP 1 [SecUserName], [SecUserId] FROM [SecUser] WHERE [SecUserName] = ? ORDER BY [SecUserId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P00226", "INSERT INTO [SecUser]([SecUserName], [SecUserPassword], [SecUserEstadoR], [SecUserEmail]) VALUES(?, ?, ?, ''); SELECT SCOPE_IDENTITY()", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P00227", "SELECT TOP 1 [SecUserName], [SecUserId] FROM [SecUser] WHERE [SecUserName] = ? ORDER BY [SecUserId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P00228", "SELECT [SecFunctionalityId], [SecFunctionalityDescription], [SecFunctionalityKey] FROM [SecFunctionality] ORDER BY [SecFunctionalityId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00229", "SELECT [SecFunctionalityId], [SecRoleId] FROM [SecFunctionalityRole] WHERE [SecFunctionalityId] = ? and [SecRoleId] = ? ORDER BY [SecFunctionalityId], [SecRoleId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P002210", "INSERT INTO [SecFunctionalityRole]([SecFunctionalityId], [SecRoleId]) VALUES(?, ?)", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P002211", "SELECT TOP 1 [SecUserId], [SecRoleId] FROM [SecUserRole] WHERE [SecUserId] = ? and [SecRoleId] = ? ORDER BY [SecUserId], [SecRoleId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P002212", "INSERT INTO [SecUserRole]([SecUserId], [SecRoleId]) VALUES(?, ?)", GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 6 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 7 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 9 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
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
               stmt.setVarchar(1, (String)parms[0], 40);
               return;
            case 1 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setVarchar(2, (String)parms[1], 120, false);
               return;
            case 2 :
               stmt.setVarchar(1, (String)parms[0], 40);
               return;
            case 3 :
               stmt.setVarchar(1, (String)parms[0], 100);
               return;
            case 4 :
               stmt.setVarchar(1, (String)parms[0], 100, false);
               stmt.setVarchar(2, (String)parms[1], 100, false);
               stmt.setString(3, (String)parms[2], 1);
               return;
            case 5 :
               stmt.setVarchar(1, (String)parms[0], 100);
               return;
            case 7 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 8 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 9 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 10 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}


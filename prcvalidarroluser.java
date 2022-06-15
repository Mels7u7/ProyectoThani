package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcvalidarroluser extends GXProcedure
{
   public prcvalidarroluser( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcvalidarroluser.class ), "" );
   }

   public prcvalidarroluser( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( String aP0 )
   {
      prcvalidarroluser.this.aP1 = new short[] {0};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        short[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             short[] aP1 )
   {
      prcvalidarroluser.this.AV10SecUserDniEmail = aP0;
      prcvalidarroluser.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P008J2 */
      pr_default.execute(0, new Object[] {AV10SecUserDniEmail, AV10SecUserDniEmail});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A14SecUserName = P008J2_A14SecUserName[0] ;
         A122SecUserEmail = P008J2_A122SecUserEmail[0] ;
         A6SecUserId = P008J2_A6SecUserId[0] ;
         AV11SecUserId = A6SecUserId ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      /* Using cursor P008J3 */
      pr_default.execute(1, new Object[] {Short.valueOf(AV11SecUserId)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A6SecUserId = P008J3_A6SecUserId[0] ;
         A4SecRoleId = P008J3_A4SecRoleId[0] ;
         AV8SecRoleId = A4SecRoleId ;
         pr_default.readNext(1);
      }
      pr_default.close(1);
      /* Using cursor P008J4 */
      pr_default.execute(2, new Object[] {Short.valueOf(AV8SecRoleId)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A4SecRoleId = P008J4_A4SecRoleId[0] ;
         A13SecRoleName = P008J4_A13SecRoleName[0] ;
         AV9SecRoleName = A13SecRoleName ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(2);
      if ( GXutil.strcmp(AV9SecRoleName, "Administrator") == 0 )
      {
         AV12Respuesta = (short)(1) ;
      }
      else if ( GXutil.strcmp(AV9SecRoleName, "Doctor") == 0 )
      {
         AV12Respuesta = (short)(2) ;
      }
      else if ( GXutil.strcmp(AV9SecRoleName, "Paciente") == 0 )
      {
         AV12Respuesta = (short)(3) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = prcvalidarroluser.this.AV12Respuesta;
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
      P008J2_A14SecUserName = new String[] {""} ;
      P008J2_A122SecUserEmail = new String[] {""} ;
      P008J2_A6SecUserId = new short[1] ;
      A14SecUserName = "" ;
      A122SecUserEmail = "" ;
      P008J3_A6SecUserId = new short[1] ;
      P008J3_A4SecRoleId = new short[1] ;
      P008J4_A4SecRoleId = new short[1] ;
      P008J4_A13SecRoleName = new String[] {""} ;
      A13SecRoleName = "" ;
      AV9SecRoleName = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcvalidarroluser__default(),
         new Object[] {
             new Object[] {
            P008J2_A14SecUserName, P008J2_A122SecUserEmail, P008J2_A6SecUserId
            }
            , new Object[] {
            P008J3_A6SecUserId, P008J3_A4SecRoleId
            }
            , new Object[] {
            P008J4_A4SecRoleId, P008J4_A13SecRoleName
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV12Respuesta ;
   private short A6SecUserId ;
   private short AV11SecUserId ;
   private short A4SecRoleId ;
   private short AV8SecRoleId ;
   private short Gx_err ;
   private String scmdbuf ;
   private String AV10SecUserDniEmail ;
   private String A14SecUserName ;
   private String A122SecUserEmail ;
   private String A13SecRoleName ;
   private String AV9SecRoleName ;
   private short[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P008J2_A14SecUserName ;
   private String[] P008J2_A122SecUserEmail ;
   private short[] P008J2_A6SecUserId ;
   private short[] P008J3_A6SecUserId ;
   private short[] P008J3_A4SecRoleId ;
   private short[] P008J4_A4SecRoleId ;
   private String[] P008J4_A13SecRoleName ;
}

final  class prcvalidarroluser__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P008J2", "SELECT [SecUserName], [SecUserEmail], [SecUserId] FROM [SecUser] WHERE [SecUserEmail] = ? or [SecUserName] = ? ORDER BY [SecUserId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P008J3", "SELECT [SecUserId], [SecRoleId] FROM [SecUserRole] WHERE [SecUserId] = ? ORDER BY [SecUserId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P008J4", "SELECT [SecRoleId], [SecRoleName] FROM [SecRole] WHERE [SecRoleId] = ? ORDER BY [SecRoleId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
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
               stmt.setVarchar(1, (String)parms[0], 200);
               stmt.setVarchar(2, (String)parms[1], 200);
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}


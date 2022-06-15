package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcvalidarexisteuserandprofesional extends GXProcedure
{
   public prcvalidarexisteuserandprofesional( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcvalidarexisteuserandprofesional.class ), "" );
   }

   public prcvalidarexisteuserandprofesional( int remoteHandle ,
                                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 ,
                              String aP1 ,
                              boolean[] aP2 )
   {
      prcvalidarexisteuserandprofesional.this.aP3 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        boolean[] aP2 ,
                        boolean[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             boolean[] aP2 ,
                             boolean[] aP3 )
   {
      prcvalidarexisteuserandprofesional.this.AV9ProfesionalNroDocumento = aP0;
      prcvalidarexisteuserandprofesional.this.AV8ProfesionalCorreo = aP1;
      prcvalidarexisteuserandprofesional.this.aP2 = aP2;
      prcvalidarexisteuserandprofesional.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P008F3 */
      pr_default.execute(0, new Object[] {AV9ProfesionalNroDocumento, AV8ProfesionalCorreo});
      if ( (pr_default.getStatus(0) != 101) )
      {
         A40000ProfesionalId = P008F3_A40000ProfesionalId[0] ;
         n40000ProfesionalId = P008F3_n40000ProfesionalId[0] ;
      }
      else
      {
         A40000ProfesionalId = 0 ;
         n40000ProfesionalId = false ;
      }
      pr_default.close(0);
      /* Using cursor P008F5 */
      pr_default.execute(1, new Object[] {AV9ProfesionalNroDocumento, AV8ProfesionalCorreo});
      if ( (pr_default.getStatus(1) != 101) )
      {
         A40001SecUserId = P008F5_A40001SecUserId[0] ;
         n40001SecUserId = P008F5_n40001SecUserId[0] ;
      }
      else
      {
         A40001SecUserId = (short)(0) ;
         n40001SecUserId = false ;
      }
      pr_default.close(1);
      AV11ValId = A40000ProfesionalId ;
      if ( AV11ValId > 0 )
      {
         AV12ValProf = true ;
      }
      else
      {
         AV12ValProf = false ;
      }
      AV14ValIdUser = A40001SecUserId ;
      if ( AV14ValIdUser > 0 )
      {
         AV13ValUser = true ;
      }
      else
      {
         AV13ValUser = false ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = prcvalidarexisteuserandprofesional.this.AV12ValProf;
      this.aP3[0] = prcvalidarexisteuserandprofesional.this.AV13ValUser;
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
      P008F3_A40000ProfesionalId = new int[1] ;
      P008F3_n40000ProfesionalId = new boolean[] {false} ;
      P008F5_A40001SecUserId = new short[1] ;
      P008F5_n40001SecUserId = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcvalidarexisteuserandprofesional__default(),
         new Object[] {
             new Object[] {
            P008F3_A40000ProfesionalId, P008F3_n40000ProfesionalId
            }
            , new Object[] {
            P008F5_A40001SecUserId, P008F5_n40001SecUserId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short A40001SecUserId ;
   private short Gx_err ;
   private int A40000ProfesionalId ;
   private int AV11ValId ;
   private int AV14ValIdUser ;
   private String scmdbuf ;
   private boolean AV12ValProf ;
   private boolean AV13ValUser ;
   private boolean n40000ProfesionalId ;
   private boolean n40001SecUserId ;
   private String AV9ProfesionalNroDocumento ;
   private String AV8ProfesionalCorreo ;
   private boolean[] aP3 ;
   private boolean[] aP2 ;
   private IDataStoreProvider pr_default ;
   private int[] P008F3_A40000ProfesionalId ;
   private boolean[] P008F3_n40000ProfesionalId ;
   private short[] P008F5_A40001SecUserId ;
   private boolean[] P008F5_n40001SecUserId ;
}

final  class prcvalidarexisteuserandprofesional__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P008F3", "SELECT COALESCE( T1.[ProfesionalId], 0) AS ProfesionalId FROM (SELECT MIN([ProfesionalId]) AS ProfesionalId FROM [Profesional] WHERE [ProfesionalNroDocumento] = RTRIM(LTRIM(?)) or [ProfesionalCorreo] = RTRIM(LTRIM(?)) ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P008F5", "SELECT COALESCE( T1.[SecUserId], 0) AS SecUserId FROM (SELECT MIN([SecUserId]) AS SecUserId FROM [SecUser] WHERE [SecUserName] = RTRIM(LTRIM(?)) or [SecUserEmail] = RTRIM(LTRIM(?)) ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
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
               stmt.setVarchar(1, (String)parms[0], 15);
               stmt.setVarchar(2, (String)parms[1], 100);
               return;
            case 1 :
               stmt.setVarchar(1, (String)parms[0], 15);
               stmt.setVarchar(2, (String)parms[1], 100);
               return;
      }
   }

}


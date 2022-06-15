package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prccambiarpassword extends GXProcedure
{
   public prccambiarpassword( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prccambiarpassword.class ), "" );
   }

   public prccambiarpassword( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( short aP0 ,
                              String aP1 )
   {
      prccambiarpassword.this.aP2 = new boolean[] {false};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( short aP0 ,
                        String aP1 ,
                        boolean[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( short aP0 ,
                             String aP1 ,
                             boolean[] aP2 )
   {
      prccambiarpassword.this.AV13SecUserId = aP0;
      prccambiarpassword.this.AV10NewPassword = aP1;
      prccambiarpassword.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8Estado = false ;
      if ( AV13SecUserId > 0 )
      {
         AV12SecUser.Load(AV13SecUserId);
         AV12SecUser.setgxTv_SdtSecUser_Secuserpassword( AV10NewPassword );
         AV12SecUser.Update();
         if ( AV12SecUser.Success() )
         {
            /* Using cursor P00742 */
            pr_default.execute(0, new Object[] {Short.valueOf(AV13SecUserId)});
            while ( (pr_default.getStatus(0) != 101) )
            {
               A6SecUserId = P00742_A6SecUserId[0] ;
               n6SecUserId = P00742_n6SecUserId[0] ;
               A20PacienteId = P00742_A20PacienteId[0] ;
               AV14PacienteId = A20PacienteId ;
               pr_default.readNext(0);
            }
            pr_default.close(0);
            new com.projectthani.prccambiodepasswordpaciente(remoteHandle, context).execute( AV14PacienteId) ;
            Application.commitDataStores(context, remoteHandle, pr_default, "prccambiarpassword");
            AV8Estado = true ;
         }
         else
         {
            AV8Estado = false ;
         }
      }
      else
      {
         AV8Estado = false ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = prccambiarpassword.this.AV8Estado;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12SecUser = new com.projectthani.wwpbaseobjects.SdtSecUser(remoteHandle);
      scmdbuf = "" ;
      P00742_A6SecUserId = new short[1] ;
      P00742_n6SecUserId = new boolean[] {false} ;
      P00742_A20PacienteId = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prccambiarpassword__default(),
         new Object[] {
             new Object[] {
            P00742_A6SecUserId, P00742_n6SecUserId, P00742_A20PacienteId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV13SecUserId ;
   private short A6SecUserId ;
   private short Gx_err ;
   private int A20PacienteId ;
   private int AV14PacienteId ;
   private String scmdbuf ;
   private boolean AV8Estado ;
   private boolean n6SecUserId ;
   private String AV10NewPassword ;
   private boolean[] aP2 ;
   private IDataStoreProvider pr_default ;
   private short[] P00742_A6SecUserId ;
   private boolean[] P00742_n6SecUserId ;
   private int[] P00742_A20PacienteId ;
   private com.projectthani.wwpbaseobjects.SdtSecUser AV12SecUser ;
}

final  class prccambiarpassword__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00742", "SELECT [SecUserId], [PacienteId] FROM [Paciente] WHERE [SecUserId] = ? ORDER BY [SecUserId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((int[]) buf[2])[0] = rslt.getInt(2);
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}


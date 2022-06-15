package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcverificarusuariodeacceso extends GXProcedure
{
   public prcverificarusuariodeacceso( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcverificarusuariodeacceso.class ), "" );
   }

   public prcverificarusuariodeacceso( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              short[] aP2 )
   {
      prcverificarusuariodeacceso.this.aP3 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        short[] aP2 ,
                        boolean[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             short[] aP2 ,
                             boolean[] aP3 )
   {
      prcverificarusuariodeacceso.this.AV10PacienteId = aP0;
      prcverificarusuariodeacceso.this.AV11Password = aP1;
      prcverificarusuariodeacceso.this.aP2 = aP2;
      prcverificarusuariodeacceso.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV12Resultado = false ;
      /* Using cursor P00762 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10PacienteId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A20PacienteId = P00762_A20PacienteId[0] ;
         A6SecUserId = P00762_A6SecUserId[0] ;
         n6SecUserId = P00762_n6SecUserId[0] ;
         AV10PacienteId = A20PacienteId ;
         AV8IdSecUser = A6SecUserId ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV10PacienteId > 0 )
      {
         /* Using cursor P00763 */
         pr_default.execute(1, new Object[] {Short.valueOf(AV8IdSecUser)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A6SecUserId = P00763_A6SecUserId[0] ;
            n6SecUserId = P00763_n6SecUserId[0] ;
            A15SecUserPassword = P00763_A15SecUserPassword[0] ;
            if ( GXutil.strcmp(A15SecUserPassword, AV11Password) == 0 )
            {
               AV12Resultado = true ;
               AV13SecUserId = A6SecUserId ;
            }
            else
            {
               AV12Resultado = false ;
            }
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(1);
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = prcverificarusuariodeacceso.this.AV13SecUserId;
      this.aP3[0] = prcverificarusuariodeacceso.this.AV12Resultado;
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
      P00762_A20PacienteId = new int[1] ;
      P00762_A6SecUserId = new short[1] ;
      P00762_n6SecUserId = new boolean[] {false} ;
      P00763_A6SecUserId = new short[1] ;
      P00763_n6SecUserId = new boolean[] {false} ;
      P00763_A15SecUserPassword = new String[] {""} ;
      A15SecUserPassword = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcverificarusuariodeacceso__default(),
         new Object[] {
             new Object[] {
            P00762_A20PacienteId, P00762_A6SecUserId, P00762_n6SecUserId
            }
            , new Object[] {
            P00763_A6SecUserId, P00763_A15SecUserPassword
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV13SecUserId ;
   private short A6SecUserId ;
   private short AV8IdSecUser ;
   private short Gx_err ;
   private int AV10PacienteId ;
   private int A20PacienteId ;
   private String scmdbuf ;
   private boolean AV12Resultado ;
   private boolean n6SecUserId ;
   private String AV11Password ;
   private String A15SecUserPassword ;
   private boolean[] aP3 ;
   private short[] aP2 ;
   private IDataStoreProvider pr_default ;
   private int[] P00762_A20PacienteId ;
   private short[] P00762_A6SecUserId ;
   private boolean[] P00762_n6SecUserId ;
   private short[] P00763_A6SecUserId ;
   private boolean[] P00763_n6SecUserId ;
   private String[] P00763_A15SecUserPassword ;
}

final  class prcverificarusuariodeacceso__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00762", "SELECT [PacienteId], [SecUserId] FROM [Paciente] WHERE [PacienteId] = ? ORDER BY [PacienteId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P00763", "SELECT [SecUserId], [SecUserPassword] FROM [SecUser] WHERE [SecUserId] = ? ORDER BY [SecUserId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               return;
            case 1 :
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}


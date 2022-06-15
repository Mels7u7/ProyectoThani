package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcgetespecialidadbydisponibilidad extends GXProcedure
{
   public prcgetespecialidadbydisponibilidad( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcgetespecialidadbydisponibilidad.class ), "" );
   }

   public prcgetespecialidadbydisponibilidad( int remoteHandle ,
                                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 )
   {
      prcgetespecialidadbydisponibilidad.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             String[] aP1 )
   {
      prcgetespecialidadbydisponibilidad.this.AV8DisponibilidadId = aP0;
      prcgetespecialidadbydisponibilidad.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P006Y2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8DisponibilidadId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A34DisponibilidadId = P006Y2_A34DisponibilidadId[0] ;
         A32EspecialidadId = P006Y2_A32EspecialidadId[0] ;
         AV10EspecialidadId = A32EspecialidadId ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      /* Using cursor P006Y3 */
      pr_default.execute(1, new Object[] {Short.valueOf(AV10EspecialidadId)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A32EspecialidadId = P006Y3_A32EspecialidadId[0] ;
         A71EspecialidadNombre = P006Y3_A71EspecialidadNombre[0] ;
         AV9EspecialidadNombre = A71EspecialidadNombre ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(1);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = prcgetespecialidadbydisponibilidad.this.AV9EspecialidadNombre;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9EspecialidadNombre = "" ;
      scmdbuf = "" ;
      P006Y2_A34DisponibilidadId = new int[1] ;
      P006Y2_A32EspecialidadId = new short[1] ;
      P006Y3_A32EspecialidadId = new short[1] ;
      P006Y3_A71EspecialidadNombre = new String[] {""} ;
      A71EspecialidadNombre = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcgetespecialidadbydisponibilidad__default(),
         new Object[] {
             new Object[] {
            P006Y2_A34DisponibilidadId, P006Y2_A32EspecialidadId
            }
            , new Object[] {
            P006Y3_A32EspecialidadId, P006Y3_A71EspecialidadNombre
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short A32EspecialidadId ;
   private short AV10EspecialidadId ;
   private short Gx_err ;
   private int AV8DisponibilidadId ;
   private int A34DisponibilidadId ;
   private String scmdbuf ;
   private String AV9EspecialidadNombre ;
   private String A71EspecialidadNombre ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private int[] P006Y2_A34DisponibilidadId ;
   private short[] P006Y2_A32EspecialidadId ;
   private short[] P006Y3_A32EspecialidadId ;
   private String[] P006Y3_A71EspecialidadNombre ;
}

final  class prcgetespecialidadbydisponibilidad__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P006Y2", "SELECT TOP 1 [DisponibilidadId], [EspecialidadId] FROM [Disponibilidad] WHERE [DisponibilidadId] = ? ORDER BY [DisponibilidadId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P006Y3", "SELECT TOP 1 [EspecialidadId], [EspecialidadNombre] FROM [Especialidad] WHERE [EspecialidadId] = ? ORDER BY [EspecialidadId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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


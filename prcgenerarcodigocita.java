package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcgenerarcodigocita extends GXProcedure
{
   public prcgenerarcodigocita( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcgenerarcodigocita.class ), "" );
   }

   public prcgenerarcodigocita( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 )
   {
      prcgenerarcodigocita.this.aP1 = new String[] {""};
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
      prcgenerarcodigocita.this.AV9DisponibilidadId = aP0;
      prcgenerarcodigocita.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P007T2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9DisponibilidadId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A34DisponibilidadId = P007T2_A34DisponibilidadId[0] ;
         A32EspecialidadId = P007T2_A32EspecialidadId[0] ;
         AV11EspecialidadId = A32EspecialidadId ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      AV10Especialidad.Load(AV11EspecialidadId);
      AV13Password = GXutil.upper( AV10Especialidad.getgxTv_SdtEspecialidad_Especialidadcodigo()) ;
      /* Using cursor P007T4 */
      pr_default.execute(1, new Object[] {AV13Password});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A19CitaId = P007T4_A19CitaId[0] ;
         A21SGCitaDisponibilidadId = P007T4_A21SGCitaDisponibilidadId[0] ;
         n21SGCitaDisponibilidadId = P007T4_n21SGCitaDisponibilidadId[0] ;
         A64CitaCode = P007T4_A64CitaCode[0] ;
         A40000GXC1 = P007T4_A40000GXC1[0] ;
         n40000GXC1 = P007T4_n40000GXC1[0] ;
         A40000GXC1 = P007T4_A40000GXC1[0] ;
         n40000GXC1 = P007T4_n40000GXC1[0] ;
         AV8CodCita = A40000GXC1 ;
         pr_default.readNext(1);
      }
      pr_default.close(1);
      /* Using cursor P007T6 */
      pr_default.execute(2, new Object[] {AV13Password});
      if ( (pr_default.getStatus(2) != 101) )
      {
         A40001CitaId = P007T6_A40001CitaId[0] ;
         n40001CitaId = P007T6_n40001CitaId[0] ;
      }
      else
      {
         A40001CitaId = 0 ;
         n40001CitaId = false ;
      }
      pr_default.close(2);
      if ( GXutil.len( AV8CodCita) == 0 )
      {
         AV12NroCita = 1 ;
      }
      else
      {
         AV12NroCita = (int)(GXutil.lval( GXutil.substring( AV8CodCita, GXutil.len( AV8CodCita)-4, 5))) ;
         AV12NroCita = (int)(AV12NroCita+1) ;
      }
      AV13Password += GXutil.padl( GXutil.str( AV12NroCita, 8, 0), (short)(5), "0") ;
      AV14Val = A40001CitaId ;
      if ( AV14Val > 0 )
      {
         GXt_char1 = AV13Password ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgenerarcodigocita(remoteHandle, context).execute( AV11EspecialidadId, GXv_char2) ;
         prcgenerarcodigocita.this.GXt_char1 = GXv_char2[0] ;
         AV13Password = GXt_char1 ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = prcgenerarcodigocita.this.AV13Password;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13Password = "" ;
      scmdbuf = "" ;
      P007T2_A34DisponibilidadId = new int[1] ;
      P007T2_A32EspecialidadId = new short[1] ;
      AV10Especialidad = new com.projectthani.SdtEspecialidad(remoteHandle);
      P007T4_A19CitaId = new int[1] ;
      P007T4_A21SGCitaDisponibilidadId = new int[1] ;
      P007T4_n21SGCitaDisponibilidadId = new boolean[] {false} ;
      P007T4_A64CitaCode = new String[] {""} ;
      P007T4_A40000GXC1 = new String[] {""} ;
      P007T4_n40000GXC1 = new boolean[] {false} ;
      A64CitaCode = "" ;
      A40000GXC1 = "" ;
      AV8CodCita = "" ;
      P007T6_A40001CitaId = new int[1] ;
      P007T6_n40001CitaId = new boolean[] {false} ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcgenerarcodigocita__default(),
         new Object[] {
             new Object[] {
            P007T2_A34DisponibilidadId, P007T2_A32EspecialidadId
            }
            , new Object[] {
            P007T4_A19CitaId, P007T4_A21SGCitaDisponibilidadId, P007T4_n21SGCitaDisponibilidadId, P007T4_A64CitaCode, P007T4_A40000GXC1, P007T4_n40000GXC1
            }
            , new Object[] {
            P007T6_A40001CitaId, P007T6_n40001CitaId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short A32EspecialidadId ;
   private short AV11EspecialidadId ;
   private short Gx_err ;
   private int AV9DisponibilidadId ;
   private int A34DisponibilidadId ;
   private int A19CitaId ;
   private int A21SGCitaDisponibilidadId ;
   private int A40001CitaId ;
   private int AV12NroCita ;
   private int AV14Val ;
   private String scmdbuf ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private boolean n21SGCitaDisponibilidadId ;
   private boolean n40000GXC1 ;
   private boolean n40001CitaId ;
   private String AV13Password ;
   private String A64CitaCode ;
   private String A40000GXC1 ;
   private String AV8CodCita ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private int[] P007T2_A34DisponibilidadId ;
   private short[] P007T2_A32EspecialidadId ;
   private int[] P007T4_A19CitaId ;
   private int[] P007T4_A21SGCitaDisponibilidadId ;
   private boolean[] P007T4_n21SGCitaDisponibilidadId ;
   private String[] P007T4_A64CitaCode ;
   private String[] P007T4_A40000GXC1 ;
   private boolean[] P007T4_n40000GXC1 ;
   private int[] P007T6_A40001CitaId ;
   private boolean[] P007T6_n40001CitaId ;
   private com.projectthani.SdtEspecialidad AV10Especialidad ;
}

final  class prcgenerarcodigocita__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P007T2", "SELECT TOP 1 [DisponibilidadId], [EspecialidadId] FROM [Disponibilidad] WHERE [DisponibilidadId] = ? ORDER BY [DisponibilidadId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P007T4", "SELECT T1.[CitaId], T1.[SGCitaDisponibilidadId], T1.[CitaCode], COALESCE( T2.[GXC1], '') AS GXC1 FROM ([Cita] T1 LEFT JOIN (SELECT MAX([CitaCode]) AS GXC1, [CitaId], [SGCitaDisponibilidadId] FROM [Cita] GROUP BY [CitaId], [SGCitaDisponibilidadId] ) T2 ON T2.[CitaId] = T1.[CitaId] AND T2.[SGCitaDisponibilidadId] = T1.[SGCitaDisponibilidadId]) WHERE (CHARINDEX(RTRIM(?), T1.[CitaCode])) = 1 ORDER BY T1.[CitaId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P007T6", "SELECT COALESCE( T1.[CitaId], 0) AS CitaId FROM (SELECT MIN([CitaId]) AS CitaId FROM [Cita] WHERE [CitaCode] = ? ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 1 :
               stmt.setVarchar(1, (String)parms[0], 100);
               return;
            case 2 :
               stmt.setVarchar(1, (String)parms[0], 100);
               return;
      }
   }

}

